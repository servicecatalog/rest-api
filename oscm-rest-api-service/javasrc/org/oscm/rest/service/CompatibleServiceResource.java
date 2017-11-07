package org.oscm.rest.service;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.oscm.rest.common.CommonParams;
import org.oscm.rest.common.RepresentationCollection;
import org.oscm.rest.common.RestResource;
import org.oscm.rest.common.Since;
import org.oscm.rest.service.data.ServiceRepresentation;

@Path(CommonParams.PATH_VERSION + "/services" + CommonParams.PATH_ID
        + "/compatibleservices")
@Stateless
public class CompatibleServiceResource extends RestResource {

    @EJB
    ServiceBackend sb;

    @Since(CommonParams.VERSION_1)
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCompatibleServices(@Context UriInfo uriInfo,
            @BeanParam ServiceParameters params) throws Exception {
        return getCollection(uriInfo, sb.getCompatibles(), params);
    }

    @Since(CommonParams.VERSION_1)
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Response setCompatibleServices(@Context UriInfo uriInfo,
            RepresentationCollection<ServiceRepresentation> content,
            @BeanParam ServiceParameters params) throws Exception {

        return put(uriInfo, sb.putCompatibles(), content, params);
    }

}
