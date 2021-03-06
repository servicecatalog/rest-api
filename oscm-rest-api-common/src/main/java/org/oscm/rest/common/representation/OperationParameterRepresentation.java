/**
 * *****************************************************************************
 *
 * <p>Copyright FUJITSU LIMITED 2019
 *
 * <p>Creation Date: 10-04-2019
 *
 * <p>*****************************************************************************
 */
package org.oscm.rest.common.representation;

import org.oscm.internal.types.enumtypes.OperationParameterType;
import org.oscm.internal.vo.VOServiceOperationParameter;

import javax.ws.rs.WebApplicationException;

public class OperationParameterRepresentation extends Representation {

  private String parameterId;
  private String parameterName;
  private boolean mandatory;
  private OperationParameterType type;
  private String parameterValue;

  private transient VOServiceOperationParameter vo;

  public OperationParameterRepresentation() {
    this(new VOServiceOperationParameter());
  }

  public OperationParameterRepresentation(VOServiceOperationParameter op) {
    vo = op;
  }

  @Override
  public void validateContent() throws WebApplicationException {}

  @Override
  public void update() {
    if (getId() != null) {
      vo.setKey(convertIdToKey());
    }
    if (getETag() != null) {
      vo.setVersion(convertETagToVersion());
    }
    vo.setMandatory(isMandatory());
    vo.setParameterId(getParameterId());
    vo.setParameterName(getParameterName());
    vo.setParameterValue(getParameterValue());
    vo.setType(getType());
  }

  @Override
  public void convert() {
    setId(Long.valueOf(vo.getKey()));
    setMandatory(vo.isMandatory());
    setParameterId(vo.getParameterId());
    setParameterName(vo.getParameterName());
    setParameterValue(vo.getParameterValue());
    setETag(Long.valueOf(vo.getVersion()));
    setType(vo.getType());
  }

  public VOServiceOperationParameter getVO() {
    return vo;
  }

  public String getParameterId() {
    return parameterId;
  }

  public void setParameterId(String parameterId) {
    this.parameterId = parameterId;
  }

  public String getParameterName() {
    return parameterName;
  }

  public void setParameterName(String parameterName) {
    this.parameterName = parameterName;
  }

  public boolean isMandatory() {
    return mandatory;
  }

  public void setMandatory(boolean mandatory) {
    this.mandatory = mandatory;
  }

  public OperationParameterType getType() {
    return type;
  }

  public void setType(OperationParameterType type) {
    this.type = type;
  }

  public String getParameterValue() {
    return parameterValue;
  }

  public void setParameterValue(String parameterValue) {
    this.parameterValue = parameterValue;
  }
}
