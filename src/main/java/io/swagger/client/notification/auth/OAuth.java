/*
 * Gosocket Payment API
 * Synchronize payments API
 *
 * OpenAPI spec version: v1
 * Contact: developerteam@gosocket.net
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package io.swagger.client.notification.auth;

import java.util.Map;

import io.swagger.client.notification.Pair;

import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-03-13T18:41:34.367Z")
public class OAuth implements Authentication {
  private String accessToken;

  public String getAccessToken() {
    return accessToken;
  }

  public void setAccessToken(String accessToken) {
    this.accessToken = accessToken;
  }

  @Override
  public void applyToParams(List<Pair> queryParams, Map<String, String> headerParams) {
    if (accessToken != null) {
      headerParams.put("Authorization", "Bearer " + accessToken);
    }
  }
}