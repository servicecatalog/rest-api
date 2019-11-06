/**
 * *****************************************************************************
 *
 * <p>Copyright FUJITSU LIMITED 2019
 *
 * <p>Creation Date: 10-04-2019
 *
 * <p>*****************************************************************************
 */
package org.oscm.rest.service;

import org.oscm.internal.intf.ServiceProvisioningService;
import org.oscm.internal.types.exception.DomainObjectException.ClassEnum;
import org.oscm.internal.types.exception.ObjectNotFoundException;
import org.oscm.internal.vo.VOOrganization;
import org.oscm.internal.vo.VOService;
import org.oscm.internal.vo.VOServiceDetails;
import org.oscm.rest.common.RestBackend;
import org.oscm.rest.common.requestparameters.IdentifiableServiceParameters;
import org.oscm.rest.common.requestparameters.ServiceParameters;
import org.oscm.rest.common.representation.PriceModelRepresentation;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class PriceModelBackend {

  @EJB ServiceProvisioningService sps;

  public RestBackend.Put<PriceModelRepresentation, IdentifiableServiceParameters> put() {
    return (content, params) -> {
      VOServiceDetails svc = new VOServiceDetails();
      svc.setKey(params.getId().longValue());
      sps.savePriceModel(svc, content.getVO());
      return true;
    };
  }

  public RestBackend.Put<PriceModelRepresentation, IdentifiableServiceParameters> putForCustomer() {
    return (content, params) -> {
      VOServiceDetails svc = new VOServiceDetails();
      svc.setKey(params.getId().longValue());
      VOOrganization cust = new VOOrganization();
      cust.setKey(params.getOrgKey().longValue());
      sps.savePriceModelForCustomer(svc, content.getVO(), cust);
      return true;
    };
  }

  public RestBackend.Get<PriceModelRepresentation, IdentifiableServiceParameters> get() {
    return params -> {
      VOService vo = new VOService();
      vo.setKey(params.getId().longValue());
      VOServiceDetails sd = sps.getServiceDetails(vo);
      if (sd == null) {
        throw new ObjectNotFoundException(ClassEnum.SERVICE, String.valueOf(vo.getKey()));
      }
      return new PriceModelRepresentation(sd.getPriceModel());
    };
  }

  public RestBackend.Get<PriceModelRepresentation, IdentifiableServiceParameters> getForCustomer() {
    return params -> {
      VOService svc = new VOService();
      svc.setKey(params.getId().longValue());
      VOOrganization cust = new VOOrganization();
      cust.setKey(params.getOrgKey().longValue());
      VOServiceDetails sd = sps.getServiceForCustomer(cust, svc);
      if (sd == null) {
        throw new ObjectNotFoundException(ClassEnum.SERVICE, String.valueOf(svc.getKey()));
      }
      return new PriceModelRepresentation(sd.getPriceModel());
    };
  }
}
