/**
 * *****************************************************************************
 *
 * <p>Copyright FUJITSU LIMITED 2019
 *
 * <p>Creation Date: 10-04-2019
 *
 * <p>*****************************************************************************
 */
package org.oscm.rest.subscription;

import java.util.Collections;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import org.oscm.internal.intf.SubscriptionService;
import org.oscm.internal.vo.VOSubscriptionDetails;
import org.oscm.internal.vo.VOUsageLicense;
import org.oscm.rest.common.PostResponseBody;
import org.oscm.rest.common.RestBackend;
import org.oscm.rest.common.representation.RepresentationCollection;
import org.oscm.rest.common.representation.UsageLicenseRepresentation;
import org.oscm.rest.common.requestparameters.SubscriptionParameters;

@Stateless
public class UsageLicenseBackend {

  @EJB SubscriptionService ss;

  public RestBackend.Post<UsageLicenseRepresentation, SubscriptionParameters> post() {
    return (content, params) -> {
      content.update();

      VOSubscriptionDetails sub = ss.getSubscriptionDetails(params.getId().longValue());
      boolean added =
          ss.addRevokeUser(
              sub.getSubscriptionId(), Collections.singletonList(content.getVO()), null);
      Long licKey = null;
      if (added) {
        List<VOUsageLicense> lics =
            ss.getSubscriptionDetails(params.getId().longValue()).getUsageLicenses();
        for (VOUsageLicense lic : lics) {
          if (lic.getUser().getUserId().equals(content.getUser().getUserId())) {
            licKey = Long.valueOf(lic.getKey());
            break;
          }
        }
      }
      return PostResponseBody.of().createdObjectId(String.valueOf(licKey)).build();
    };
  }

  public RestBackend.GetCollection<UsageLicenseRepresentation, SubscriptionParameters>
      getCollection() {
    return params -> {
      VOSubscriptionDetails sub = ss.getSubscriptionDetails(params.getId().longValue());
      List<UsageLicenseRepresentation> lics =
          UsageLicenseRepresentation.convert(sub.getUsageLicenses());
      return new RepresentationCollection<UsageLicenseRepresentation>(lics);
    };
  }

  public RestBackend.Put<UsageLicenseRepresentation, SubscriptionParameters> put() {
    return (content, params) -> {
      content.update();

      VOSubscriptionDetails sub = ss.getSubscriptionDetails(params.getId().longValue());
      VOUsageLicense vo = content.getVO();
      vo.setKey(params.getLicKey().longValue());
      return ss.addRevokeUser(sub.getSubscriptionId(), Collections.singletonList(vo), null);
    };
  }

  public RestBackend.Delete<SubscriptionParameters> delete() {
    return params -> {
      VOSubscriptionDetails sub = ss.getSubscriptionDetails(params.getId().longValue());
      List<VOUsageLicense> lics = sub.getUsageLicenses();
      long licKey = params.getLicKey().longValue();
      boolean result = true;
      for (VOUsageLicense lic : lics) {
        if (lic.getKey() == licKey) {
          result =
              ss.addRevokeUser(
                  sub.getSubscriptionId(), null, Collections.singletonList(lic.getUser()));
          break;
        }
      }
      return result;
    };
  }
}
