package gov.nih.niehs.ods.ga4gh.services.impl;

import java.util.Properties;

import org.irods.jargon.core.connection.IRODSAccount;
import org.irods.jargon.core.pub.DataTransferOperations;
import org.irods.jargon.core.pub.IRODSFileSystem;
import org.irods.jargon.extensions.datatyper.DataTyperSettings;
import org.irods.jargon.ga4gh.dos.configuration.DosConfiguration;
import org.irods.jargon.ga4gh.dos.model.Ga4ghDataObject;
import org.irods.jargon.ga4gh.dos.services.DataObjectService;
import org.irods.jargon.ga4gh.dos.services.impl.GuidService;
import org.irods.jargon.ga4gh.dos.services.impl.GuidServiceImpl;
import org.irods.jargon.ga4gh.dos.services.impl.IrodsDataObjectServiceFactory;
import org.irods.jargon.testutils.IRODSTestSetupUtilities;
import org.irods.jargon.testutils.TestingPropertiesHelper;
import org.irods.jargon.testutils.filemanip.FileGenerator;
import org.irods.jargon.testutils.filemanip.ScratchFileUtils;
import org.irodsext.datatyper.IrodsextDataTypeResolutionServiceFactoryImpl;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class IrodsDataObjectServiceTest {

	private static Properties testingProperties = new Properties();
	private static TestingPropertiesHelper testingPropertiesHelper = new TestingPropertiesHelper();
	private static ScratchFileUtils scratchFileUtils = null;
	public static final String IRODS_TEST_SUBDIR_PATH = "IrodsDataObjectServiceTest";
	private static IRODSTestSetupUtilities irodsTestSetupUtilities = null;
	private static IRODSFileSystem irodsFileSystem;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		TestingPropertiesHelper testingPropertiesLoader = new TestingPropertiesHelper();
		testingProperties = testingPropertiesLoader.getTestProperties();
		scratchFileUtils = new ScratchFileUtils(testingProperties);
		scratchFileUtils.clearAndReinitializeScratchDirectory(IRODS_TEST_SUBDIR_PATH);
		irodsTestSetupUtilities = new IRODSTestSetupUtilities();
		irodsTestSetupUtilities.initializeIrodsScratchDirectory();
		irodsTestSetupUtilities.initializeDirectoryForTest(IRODS_TEST_SUBDIR_PATH);
		irodsFileSystem = IRODSFileSystem.instance();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		irodsFileSystem.closeAndEatExceptions();
	}

	@After
	public void afterEach() throws Exception {
		irodsFileSystem.closeAndEatExceptions();
	}

	@Test
	public void testGa4ghDataObjectFromIrodsDataObject() throws Exception {
		// generate a local scratch file
		String testFileName = "testGa4ghDataObjectFromIrodsDataObject.txt";
		String absPath = scratchFileUtils.createAndReturnAbsoluteScratchPath(IRODS_TEST_SUBDIR_PATH);
		String localFileName = FileGenerator.generateFileOfFixedLengthGivenName(absPath, testFileName, 1);

		String targetIrodsFile = testingPropertiesHelper.buildIRODSCollectionAbsolutePathFromTestProperties(
				testingProperties, IRODS_TEST_SUBDIR_PATH + '/' + testFileName);
		// now put the file
		IRODSAccount irodsAccount = testingPropertiesHelper.buildIRODSAccountFromTestProperties(testingProperties);
		DataTransferOperations dto = irodsFileSystem.getIRODSAccessObjectFactory()
				.getDataTransferOperations(irodsAccount);

		dto.putOperation(localFileName, targetIrodsFile, "", null, null);

		GuidService guidService = new GuidServiceImpl(irodsFileSystem.getIRODSAccessObjectFactory(), irodsAccount);
		String guid = guidService.createGuidOnDataObject(targetIrodsFile);

		DataTyperSettings dataTyperSettings = new DataTyperSettings();
		DosConfiguration dosConfig = new DosConfiguration();
		dosConfig.setUrlPrefix("https://localhost/emc-metalnx-irods/collectionInfo");

		IrodsextDataTypeResolutionServiceFactoryImpl dataTypeResolutionServiceFactory = new IrodsextDataTypeResolutionServiceFactoryImpl();
		dataTypeResolutionServiceFactory.setIrodsAccessObjectFactory(irodsFileSystem.getIRODSAccessObjectFactory());
		dataTypeResolutionServiceFactory.setDataTyperSettings(dataTyperSettings);

		IrodsDataObjectServiceFactory dataObjectServiceFactory = new IrodsDataObjectServiceFactory();
		dataObjectServiceFactory.setDosConfiguration(dosConfig);
		dataObjectServiceFactory.setIrodsAccessObjectFactory(irodsFileSystem.getIRODSAccessObjectFactory());
		dataObjectServiceFactory.setDataTypeResolutionServiceFactory(dataTypeResolutionServiceFactory);

		DataObjectService dos = dataObjectServiceFactory.instance(irodsAccount);
		Ga4ghDataObject actual = dos.retrieveDataObjectFromId(guid);
		Assert.assertNotNull("no data object retrieved", actual);
		Assert.assertEquals(targetIrodsFile, actual.getName());
		Assert.assertNotNull(actual.getSize());
		Assert.assertFalse(actual.getChecksums().isEmpty());
		Assert.assertFalse(actual.getUrls().isEmpty());

	}

}
