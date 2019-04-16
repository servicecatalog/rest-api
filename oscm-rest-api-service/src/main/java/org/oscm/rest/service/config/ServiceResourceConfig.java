/**
 * *****************************************************************************
 *
 * <p>Copyright FUJITSU LIMITED 2016
 *
 * <p>Creation Date: May 2, 2016
 *
 * <p>*****************************************************************************
 */
package org.oscm.rest.service.config;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import org.oscm.rest.common.GsonMessageProvider;
import org.oscm.rest.common.OSCMExceptionMapper;
import org.oscm.rest.common.VersionFilter;
import org.oscm.rest.service.*;

/**
 * Registers resources and providers of the operation component to the application.
 *
 * @author Weiser
 */
@ApplicationPath("")
public class ServiceResourceConfig extends Application {

  @Override
  public Set<Class<?>> getClasses() {
    final Set<Class<?>> classes = new HashSet<Class<?>>();

    classes.add(CompatibleServiceResource.class);
    classes.add(PriceModelResource.class);
    classes.add(ServiceImageResource.class);
    classes.add(TechnicalServiceResource.class);
    classes.add(TSSupplierResource.class);
    classes.add(OSCMExceptionMapper.class);
    classes.add(GsonMessageProvider.class);
    classes.add(VersionFilter.class);

    return classes;
  }
}