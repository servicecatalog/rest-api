/**
 * *****************************************************************************
 *
 * <p>Copyright FUJITSU LIMITED 2019
 *
 * <p>Creation Date: 10-04-2019
 *
 * <p>*****************************************************************************
 */
package org.oscm.rest.operation;

import org.oscm.rest.common.requestparameters.RequestParameters;

import javax.ws.rs.WebApplicationException;

public class OperationParameters extends RequestParameters {

  @Override
  public void validateParameters() throws WebApplicationException {}

  @Override
  public void update() {}
}
