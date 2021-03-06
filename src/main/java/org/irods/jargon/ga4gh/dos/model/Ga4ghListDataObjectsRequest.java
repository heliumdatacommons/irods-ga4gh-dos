package org.irods.jargon.ga4gh.dos.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.*;

import org.irods.jargon.ga4gh.dos.model.Ga4ghChecksumRequest;

/**
 * Ga4ghListDataObjectsRequest
 */
@javax.annotation.Generated(value = "org.irods.jargon.ga4gh.dos.codegen.languages.SpringCodegen", date = "2018-02-03T00:47:18.655Z")

public class Ga4ghListDataObjectsRequest   {
  @JsonProperty("alias")
  private String alias = null;

  @JsonProperty("url")
  private String url = null;

  @JsonProperty("checksum")
  private Ga4ghChecksumRequest checksum = null;

  @JsonProperty("page_size")
  private Integer pageSize = null;

  @JsonProperty("page_token")
  private String pageToken = null;

  public Ga4ghListDataObjectsRequest alias(String alias) {
    this.alias = alias;
    return this;
  }

   /**
   * OPTIONAL If provided will only return Data Objects with the given alias.
   * @return alias
  **/
  @ApiModelProperty(value = "OPTIONAL If provided will only return Data Objects with the given alias.")


  public String getAlias() {
    return alias;
  }

  public void setAlias(String alias) {
    this.alias = alias;
  }

  public Ga4ghListDataObjectsRequest url(String url) {
    this.url = url;
    return this;
  }

   /**
   * OPTIONAL If provided will return only Data Objects with a that URL matches this string.
   * @return url
  **/
  @ApiModelProperty(value = "OPTIONAL If provided will return only Data Objects with a that URL matches this string.")


  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public Ga4ghListDataObjectsRequest checksum(Ga4ghChecksumRequest checksum) {
    this.checksum = checksum;
    return this;
  }

   /**
   * Get checksum
   * @return checksum
  **/
  @ApiModelProperty(value = "")

  @Valid

  public Ga4ghChecksumRequest getChecksum() {
    return checksum;
  }

  public void setChecksum(Ga4ghChecksumRequest checksum) {
    this.checksum = checksum;
  }

  public Ga4ghListDataObjectsRequest pageSize(Integer pageSize) {
    this.pageSize = pageSize;
    return this;
  }

   /**
   * OPTIONAL Specifies the maximum number of results to return in a single page. If unspecified, a system default will be used.
   * @return pageSize
  **/
  @ApiModelProperty(value = "OPTIONAL Specifies the maximum number of results to return in a single page. If unspecified, a system default will be used.")


  public Integer getPageSize() {
    return pageSize;
  }

  public void setPageSize(Integer pageSize) {
    this.pageSize = pageSize;
  }

  public Ga4ghListDataObjectsRequest pageToken(String pageToken) {
    this.pageToken = pageToken;
    return this;
  }

   /**
   * OPTIONAL The continuation token, which is used to page through large result sets. To get the next page of results, set this parameter to the value of `next_page_token` from the previous response.
   * @return pageToken
  **/
  @ApiModelProperty(value = "OPTIONAL The continuation token, which is used to page through large result sets. To get the next page of results, set this parameter to the value of `next_page_token` from the previous response.")


  public String getPageToken() {
    return pageToken;
  }

  public void setPageToken(String pageToken) {
    this.pageToken = pageToken;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Ga4ghListDataObjectsRequest ga4ghListDataObjectsRequest = (Ga4ghListDataObjectsRequest) o;
    return Objects.equals(this.alias, ga4ghListDataObjectsRequest.alias) &&
        Objects.equals(this.url, ga4ghListDataObjectsRequest.url) &&
        Objects.equals(this.checksum, ga4ghListDataObjectsRequest.checksum) &&
        Objects.equals(this.pageSize, ga4ghListDataObjectsRequest.pageSize) &&
        Objects.equals(this.pageToken, ga4ghListDataObjectsRequest.pageToken);
  }

  @Override
  public int hashCode() {
    return Objects.hash(alias, url, checksum, pageSize, pageToken);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Ga4ghListDataObjectsRequest {\n");
    
    sb.append("    alias: ").append(toIndentedString(alias)).append("\n");
    sb.append("    url: ").append(toIndentedString(url)).append("\n");
    sb.append("    checksum: ").append(toIndentedString(checksum)).append("\n");
    sb.append("    pageSize: ").append(toIndentedString(pageSize)).append("\n");
    sb.append("    pageToken: ").append(toIndentedString(pageToken)).append("\n");
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

