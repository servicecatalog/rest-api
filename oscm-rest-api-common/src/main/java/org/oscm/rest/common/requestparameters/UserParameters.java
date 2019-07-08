/**
 * *****************************************************************************
 *
 * <p>Copyright FUJITSU LIMITED 2019
 *
 * <p>Creation Date: 10-04-2019
 *
 * <p>*****************************************************************************
 */
package org.oscm.rest.common.requestparameters;

import org.oscm.rest.common.CommonParams;
import org.oscm.rest.common.WebException;

import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;

public class UserParameters extends RequestParameters {

  @PathParam("userId")
  private String userId;

  @QueryParam("mId")
  private String marketplaceId;

  @QueryParam("pattern")
  private String pattern;
  private boolean isUserIdRequired;

  @Override
  public void validateParameters() throws WebApplicationException {}

  @Override
  public void update() {}

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getMarketplaceId() {
    return marketplaceId;
  }

  public void setMarketplaceId(String marketplaceId) {
    this.marketplaceId = marketplaceId;
  }

  public String getPattern() {
    return pattern;
  }

  public void setPattern(String pattern) {
    this.pattern = pattern;
  }

  @Override
  public void validateId() throws WebApplicationException {
    if (isUserIdRequired && userId == null) {
      throw WebException.notFound().message(CommonParams.ERROR_INVALID_ID).build();
    }
  }

  public void setUserIdRequired(boolean userIdRequired) {
    this.isUserIdRequired = userIdRequired;
  }

  public boolean getUserIdRequired() {
    return isUserIdRequired;
  }
}
