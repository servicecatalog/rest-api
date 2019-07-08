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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AccessLevel;
import lombok.Setter;
import org.oscm.rest.account.data.BillingContactRepresentation;
import org.oscm.rest.common.CommonParams;
import org.oscm.rest.common.RestResource;
import org.oscm.rest.common.Since;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path(CommonParams.PATH_VERSION + "/billingcontacts")
@Produces(MediaType.APPLICATION_JSON)
@Since(CommonParams.VERSION_1)
@Stateless
public class BillingContactResource extends RestResource {

  @EJB
  @Setter(value = AccessLevel.PROTECTED)
  AccountBackend ab;

  @GET
  @Operation(summary = "Get all billing contacts for the organizations.",
          tags = {"billingcontacts"},
          description = "Returns all billing contacts for the organizations.",
          responses = {
                  @ApiResponse(responseCode = "200", description = "Billing contacts list", content = @Content(
                                  schema = @Schema(implementation = BillingContactRepresentation.class)
                  ))
          })
  public Response getBillingContacts(@Context UriInfo uriInfo, @BeanParam AccountParameters params)
      throws Exception {
    return getCollection(uriInfo, ab.getBillingContactCollection(), params);
  }

  @POST
  @Operation(summary = "Create a billing contact.",
          tags = {"billingcontacts"},
          description = "Creates a billing contact.",
          responses = {
                  @ApiResponse(responseCode = "201", description = "Billing contact created successfully.")
          })
  public Response createBillingContact(
      @Context UriInfo uriInfo,
      @RequestBody(description = "BillingContactRepresentation object that needs to be added.", required = true,
              content = @Content(
                      schema = @Schema(implementation = BillingContactRepresentation.class))) BillingContactRepresentation content,
      @BeanParam AccountParameters params)
      throws Exception {
    return post(uriInfo, ab.postBillingContact(), content, params);
  }

  @GET
  @Path(CommonParams.PATH_ID)
  @Operation(summary = "Get a single billing contact.",
          tags = {"billingcontacts"},
          description = "Returns a single billing contact.",
          responses = {
                  @ApiResponse(responseCode = "200", description = "A single billing contact", content = @Content(
                          schema = @Schema(implementation = BillingContactRepresentation.class)
                  ))
          })
  public Response getBillingContact(@Context UriInfo uriInfo, @BeanParam AccountParameters params)
          throws Exception {
    return get(uriInfo, ab.getBillingContact(), params, true);
  }

  @PUT
  @Path(CommonParams.PATH_ID)
  @Operation(summary = "Update a single billing contact.",
          tags = {"billingcontacts"},
          description = "Updates a single billing contact.",
          responses = {
                  @ApiResponse(responseCode = "204", description = "Billing contact updated successfully.")
          })
  public Response updateBillingContact(
      @Context UriInfo uriInfo,
      @RequestBody(description = "BillingContactRepresentation object that needs to be updated.", required = true,
              content = @Content(
                      schema = @Schema(implementation = BillingContactRepresentation.class))) BillingContactRepresentation content,
      @BeanParam AccountParameters params)
      throws Exception {
    // FIXME: Move investigate why the same command doesn't work from RestResource#128
    content.setId(params.getId());
    return put(uriInfo, ab.putBillingContact(), content, params);
  }

  @DELETE
  @Path(CommonParams.PATH_ID)
  @Operation(summary = "Delete a single billing contact.",
          tags = {"billingcontacts"},
          description = "Deletes a single billing contact.",
          responses = {
                  @ApiResponse(responseCode = "204", description = "Billing contact deleted successfully.")
          })
  public Response deleteBillingContact(
      @Context UriInfo uriInfo, @BeanParam AccountParameters params)
          throws Exception {
    return delete(uriInfo, ab.deleteBillingContact(), params);
  }
}
