/**
 * *****************************************************************************
 *
 * <p>Copyright FUJITSU LIMITED 2019
 *
 * <p>Creation Date: 26-04-2019
 *
 * <p>*****************************************************************************
 */
package org.oscm.rest.service;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.oscm.internal.intf.ServiceProvisioningService;
import org.oscm.rest.common.SampleTestDataUtility;
import org.oscm.rest.common.representation.RepresentationCollection;
import org.oscm.rest.common.representation.ServiceRepresentation;
import org.oscm.rest.common.representation.TechnicalServiceRepresentation;
import org.oscm.rest.common.requestparameters.ServiceParameters;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TechnicalServiceResourceTest {

  @Mock private TechnicalServiceBackend technicalServiceBackend;

  @Mock private ServiceProvisioningService serviceProvisioningService;

  @InjectMocks @Spy TechnicalServiceResource technicalServiceResource;

  private Response response;
  private TechnicalServiceRepresentation technicalServiceRepresentation;
  private UriInfo uriInfo;
  private ServiceParameters serviceParameters;

  @BeforeEach
  public void setUp() {
    technicalServiceRepresentation = SampleTestDataUtility.createTSRepresentation();
    uriInfo = SampleTestDataUtility.createUriInfo();
    serviceParameters = SampleTestDataUtility.createServiceParameters();
  }

  @AfterEach
  public void cleanUp() {
    response = null;
  }

  @Test
  public void shouldGetTechnicalServices() {
    when(technicalServiceBackend.getCollection())
        .thenReturn(
            serviceParameters1 ->
                new RepresentationCollection<>(Lists.newArrayList(technicalServiceRepresentation)));

    try {
      response =
          technicalServiceResource.getTechnicalServices(
              uriInfo, serviceParameters.getEndpointVersion());
    } catch (Exception e) {
      fail(e);
    }

    assertThat(response).isNotNull();
    assertThat(response)
        .extracting(Response::getStatus)
        .isEqualTo(Response.Status.OK.getStatusCode());
    assertThat(response).extracting(Response::hasEntity).isEqualTo(true);
    assertThat(response)
        .extracting(
            r -> {
              RepresentationCollection<ServiceRepresentation> representationCollection =
                  (RepresentationCollection<ServiceRepresentation>) r.getEntity();
              return representationCollection.getItems().toArray()[0];
            })
        .isEqualTo(technicalServiceRepresentation);
  }

  @Test
  public void shouldCreateTechnicalService() {
    when(technicalServiceBackend.post())
        .thenReturn((serviceDetailsRepresentation1, serviceParameters1) -> true);

    try {
      response =
          technicalServiceResource.createTechnicalService(
              uriInfo, serviceParameters.getEndpointVersion(), technicalServiceRepresentation);
    } catch (Exception e) {
      fail(e);
    }

    assertThat(response).isNotNull();
    assertThat(response)
        .extracting(Response::getStatus)
        .isEqualTo(Response.Status.CREATED.getStatusCode());
    assertThat(response).extracting(Response::hasEntity).isEqualTo(true);
  }

  @Test
  public void shouldDeleteTechnicalService() {
    when(technicalServiceBackend.delete()).thenReturn(serviceParameters1 -> true);

    try {
      response =
          technicalServiceResource.deleteTechnicalService(
              uriInfo,
              serviceParameters.getEndpointVersion(),
              serviceParameters.getId().toString());
    } catch (Exception e) {
      fail(e);
    }

    assertThat(response).isNotNull();
    assertThat(response)
        .extracting(Response::getStatus)
        .isEqualTo(Response.Status.NO_CONTENT.getStatusCode());
    assertThat(response).extracting(Response::hasEntity).isEqualTo(false);
  }
}
