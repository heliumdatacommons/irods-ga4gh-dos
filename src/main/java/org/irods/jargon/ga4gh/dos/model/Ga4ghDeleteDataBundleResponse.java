package org.irods.jargon.ga4gh.dos.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Ga4ghDeleteDataBundleResponse
 */
@javax.annotation.Generated(value = "org.irods.jargon.ga4gh.dos.codegen.languages.SpringCodegen", date = "2018-02-03T00:47:18.655Z")

public class Ga4ghDeleteDataBundleResponse   {
  @JsonProperty("data_bundle_id")
  private String dataBundleId = null;

  public Ga4ghDeleteDataBundleResponse dataBundleId(String dataBundleId) {
    this.dataBundleId = dataBundleId;
    return this;
  }

   /**
   * Get dataBundleId
   * @return dataBundleId
  **/
  @ApiModelProperty(value = "")


  public String getDataBundleId() {
    return dataBundleId;
  }

  public void setDataBundleId(String dataBundleId) {
    this.dataBundleId = dataBundleId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Ga4ghDeleteDataBundleResponse ga4ghDeleteDataBundleResponse = (Ga4ghDeleteDataBundleResponse) o;
    return Objects.equals(this.dataBundleId, ga4ghDeleteDataBundleResponse.dataBundleId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(dataBundleId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Ga4ghDeleteDataBundleResponse {\n");
    
    sb.append("    dataBundleId: ").append(toIndentedString(dataBundleId)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

