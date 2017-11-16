/*******************************************************************************
 *                                                                              
 *  Copyright FUJITSU LIMITED 2016                                           
 *                                                                                                                                 
 *  Creation Date: May 2, 2016                                                      
 *                                                                              
 *******************************************************************************/

package org.oscm.rest.event.config;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;
import org.oscm.rest.common.GsonMessageProvider;
import org.oscm.rest.common.OSCMExceptionMapper;
import org.oscm.rest.common.VersionFilter;
import org.oscm.rest.event.EventResource;

/**
 * Registers resources and providers of the event component to the application.
 * 
 * @author Weiser
 */
@ApplicationPath("")
public class EventResourceConfig extends ResourceConfig {

    public EventResourceConfig() {
        register(EventResource.class);
        register(OSCMExceptionMapper.class);
        register(GsonMessageProvider.class);
        register(VersionFilter.class);
        register(RolesAllowedDynamicFeature.class);
    }

}