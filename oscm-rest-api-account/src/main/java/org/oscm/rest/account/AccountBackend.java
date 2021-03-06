/**
 * *****************************************************************************
 *
 * <p>Copyright FUJITSU LIMITED 2019
 *
 * <p>Creation Date: 10-04-2019
 *
 * <p>*****************************************************************************
 */
package org.oscm.rest.account;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import org.oscm.internal.intf.AccountService;
import org.oscm.internal.intf.OperatorService;
import org.oscm.internal.types.exception.DomainObjectException.ClassEnum;
import org.oscm.internal.types.exception.ObjectNotFoundException;
import org.oscm.internal.vo.VOBillingContact;
import org.oscm.internal.vo.VOOrganization;
import org.oscm.internal.vo.VOPaymentInfo;
import org.oscm.rest.common.PostResponseBody;
import org.oscm.rest.common.RestBackend;
import org.oscm.rest.common.representation.*;
import org.oscm.rest.common.requestparameters.AccountParameters;

@Stateless
public class AccountBackend {

  @EJB AccountService as;

  @EJB OperatorService os;

  public RestBackend.Post<BillingContactRepresentation, AccountParameters> postBillingContact() {
    return (content, params) -> {
      VOBillingContact vo = content.getVO();
      VOBillingContact responseVO = as.saveBillingContact(vo);
      return PostResponseBody.of()
          .createdObjectName(responseVO.getId())
          .createdObjectId(String.valueOf(responseVO.getKey()))
          .build();
    };
  }

  public RestBackend.GetCollection<BillingContactRepresentation, AccountParameters>
      getBillingContactCollection() {
    return params -> {
      Collection<BillingContactRepresentation> list =
          BillingContactRepresentation.convert(as.getBillingContacts());
      return new RepresentationCollection<BillingContactRepresentation>(list);
    };
  }

  public RestBackend.Get<BillingContactRepresentation, AccountParameters> getBillingContact() {
    return params -> {
      BillingContactRepresentation item = null;
      List<VOBillingContact> list = as.getBillingContacts();
      for (VOBillingContact bc : list) {
        if (bc.getKey() == params.getId().longValue()) {
          item = new BillingContactRepresentation(bc);
          break;
        }
      }
      if (item == null) {
        throw new ObjectNotFoundException(
            ClassEnum.BILLING_CONTACT, String.valueOf(params.getId().longValue()));
      }
      return item;
    };
  }

  public RestBackend.Put<BillingContactRepresentation, AccountParameters> putBillingContact() {
    return (content, params) -> {
      List<VOBillingContact> list = as.getBillingContacts();
      Optional<VOBillingContact> foundContact =
          list.stream().filter(contact -> contact.getKey() == params.getId()).findAny();
      if (!foundContact.isPresent()) {
        throw new ObjectNotFoundException(
            ClassEnum.BILLING_CONTACT, String.valueOf(params.getId().longValue()));
      }
      as.saveBillingContact(content.getVO());
      return true;
    };
  }

  public RestBackend.Delete<AccountParameters> deleteBillingContact() {
    return params -> {
      VOBillingContact bc = new VOBillingContact();
      bc.setKey(params.getId().longValue());
      bc.setVersion(Integer.MAX_VALUE);
      as.deleteBillingContact(bc);
      return true;
    };
  }

  public RestBackend.GetCollection<PaymentInfoRepresentation, AccountParameters>
      getPaymentInfoCollection() {
    return params -> {
      Collection<PaymentInfoRepresentation> list =
          PaymentInfoRepresentation.convert(as.getPaymentInfos());
      return new RepresentationCollection<PaymentInfoRepresentation>(list);
    };
  }

  public RestBackend.Put<PaymentInfoRepresentation, AccountParameters> putPaymentInfo() {
    return (content, params) -> {
      as.savePaymentInfo(content.getVO());
      return true;
    };
  }

  public RestBackend.Get<PaymentInfoRepresentation, AccountParameters> getPaymentInfo() {
    return params -> {
      PaymentInfoRepresentation item = null;
      List<VOPaymentInfo> list = as.getPaymentInfos();
      for (VOPaymentInfo pi : list) {
        if (pi.getKey() == params.getId().longValue()) {
          item = new PaymentInfoRepresentation(pi);
          break;
        }
      }
      if (item == null) {
        throw new ObjectNotFoundException(
            ClassEnum.PAYMENT_INFO, String.valueOf(params.getId().longValue()));
      }
      return item;
    };
  }

  public RestBackend.Delete<AccountParameters> deletePaymentInfo() {
    return params -> {
      VOPaymentInfo pi = new VOPaymentInfo();
      pi.setKey(params.getId().longValue());
      pi.setVersion(Integer.MAX_VALUE);
      as.deletePaymentInfo(pi);
      return true;
    };
  }

  public RestBackend.Post<CreateOrganizationRepresentation, AccountParameters> postOrganization() {
    return (content, params) -> {
      VOOrganization org =
          os.registerOrganization(
              content.getOrganization().getVO(),
              null,
              content.getUser().getVO(),
              content.toProperties(),
              content.getMarketplaceId(),
              content.getOrganizationRoles());

      return PostResponseBody.of()
          .createdObjectName(org.getOrganizationId())
          .createdObjectId(String.valueOf(org.getKey()))
          .build();
    };
  }

  public RestBackend.Post<CreateCustomerOrganizationRepresentation, AccountParameters>
      postCustomer() {
    return (content, params) -> {
      VOOrganization org =
          as.registerKnownCustomer(
              content.getOrganization().getVO(),
              content.getUser().getVO(),
              content.toProperties(),
              content.getMarketplaceId());

      if (org == null) {
        // registration of a known customer has a suspending trigger active
        return null;
      }
      return PostResponseBody.of()
          .createdObjectName(org.getOrganizationId())
          .createdObjectId(String.valueOf(org.getKey()))
          .build();
    };
  }

  public RestBackend.Put<AccountRepresentation, AccountParameters> putOrganization() {
    return (content, params) -> {
      as.updateAccountInformation(
          content.getOrganization().getVO(), null, params.getMarketplaceId(), null);
      return true;
    };
  }

  public RestBackend.Get<OrganizationRepresentation, AccountParameters> getOrganization() {
    return params -> {
      VOOrganization org = as.getOrganizationData();
      OrganizationRepresentation item;
      if (org.getOrganizationId().equals(params.getOrgId())) {
        item = new OrganizationRepresentation(org);
      } else {
        item = new OrganizationRepresentation(os.getOrganization(params.getOrgId()));
      }
      return item;
    };
  }
}
