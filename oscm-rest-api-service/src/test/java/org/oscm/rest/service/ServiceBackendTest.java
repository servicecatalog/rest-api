package org.oscm.rest.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.oscm.internal.intf.SearchService;
import org.oscm.internal.intf.ServiceProvisioningService;
import org.oscm.internal.types.exception.InvalidPhraseException;
import org.oscm.internal.types.exception.ObjectNotFoundException;
import org.oscm.internal.vo.VOService;
import org.oscm.internal.vo.VOServiceDetails;
import org.oscm.internal.vo.VOServiceListResult;
import org.oscm.rest.common.SampleTestDataUtility;
import org.oscm.rest.common.ServiceStatus;
import org.oscm.rest.common.representation.RepresentationCollection;
import org.oscm.rest.common.representation.ServiceDetailsRepresentation;
import org.oscm.rest.common.representation.ServiceRepresentation;
import org.oscm.rest.common.representation.StatusRepresentation;
import org.oscm.rest.common.requestparameters.ServiceParameters;

import com.google.common.collect.Lists;

import lombok.SneakyThrows;

@ExtendWith(MockitoExtension.class)
public class ServiceBackendTest {

  @Mock private ServiceProvisioningService service;
  @Mock private SearchService searchService;
  @InjectMocks private ServiceBackend backend;
  private ServiceResource resource;
  private CompatibleServiceResource compatiblesResource;
  private UriInfo uriInfo;
  private ServiceParameters parameters;
  private ServiceDetailsRepresentation representation;
  private StatusRepresentation statusRepresentation;
  private VOServiceDetails vo;
  private RepresentationCollection<ServiceRepresentation> compatiblesCollection;

  @BeforeEach
  public void setUp() {
    resource = new ServiceResource();
    compatiblesResource = new CompatibleServiceResource();
    uriInfo = SampleTestDataUtility.createUriInfo();
    parameters = SampleTestDataUtility.createServiceParameters();
    representation = SampleTestDataUtility.createServiceDetailsRepresentation(null);
    statusRepresentation = SampleTestDataUtility.createStatusRepresentation();
    compatiblesCollection = createCompatiblesCollection();
    vo = SampleTestDataUtility.createVOServiceDetails();
    resource.setSb(backend);
    compatiblesResource.setSb(backend);
  }

  @Test
  @SneakyThrows
  public void shouldGetService() {
    when(service.getServiceDetails(any())).thenReturn(vo);

    Response response = resource.getService(uriInfo, parameters);

    assertThat(response).isNotNull();
    assertThat(response)
        .extracting(Response::getStatus)
        .isEqualTo(Response.Status.OK.getStatusCode());
  }

  @Test
  @SneakyThrows
  public void shouldGetServices() {
    when(service.getSuppliedServices()).thenReturn(Lists.newArrayList(vo));

    Response response = resource.getServices(uriInfo, parameters);

    assertThat(response).isNotNull();
    assertThat(response)
        .extracting(Response::getStatus)
        .isEqualTo(Response.Status.OK.getStatusCode());
    assertThat(response)
        .extracting(
            r -> {
              return ((RepresentationCollection) r.getEntity()).getItems().size();
            })
        .isEqualTo(1);
  }

  @Test
  @SneakyThrows
  public void shouldGetServicesForPhrase() {

    // given
    mockSearchService();
    parameters.setLanguage("en");
    parameters.setServiceName("testService");
    parameters.setMarketPlaceId("123456789");

    Response response = resource.getServices(uriInfo, parameters);

    assertThat(response).isNotNull();
    assertThat(response)
        .extracting(Response::getStatus)
        .isEqualTo(Response.Status.OK.getStatusCode());
    assertThat(response)
        .extracting(
            r -> {
              return ((RepresentationCollection) r.getEntity()).getItems().size();
            })
        .isEqualTo(1);
  }

  @Test
  @SneakyThrows
  public void shouldCreateService() {
    when(service.createService(any(), any(), any())).thenReturn(vo);

    Response response = resource.createService(uriInfo, representation, parameters);

    assertThat(response).isNotNull();
    assertThat(response)
        .extracting(Response::getStatus)
        .isEqualTo(Response.Status.CREATED.getStatusCode());
  }

  @Test
  @SneakyThrows
  public void shouldUpdateService() {
    when(service.updateService(any(), any())).thenReturn(vo);

    Response response = resource.updateService(uriInfo, representation, parameters);

    assertThat(response).isNotNull();
    assertThat(response)
        .extracting(Response::getStatus)
        .isEqualTo(Response.Status.NO_CONTENT.getStatusCode());
  }

  @Test
  @SneakyThrows
  public void shouldDeleteService() {
    doNothing().when(service).deleteService(any(Long.class));

    Response response = resource.deleteService(uriInfo, parameters);

    assertThat(response).isNotNull();
    assertThat(response)
        .extracting(Response::getStatus)
        .isEqualTo(Response.Status.NO_CONTENT.getStatusCode());
  }

  @ParameterizedTest
  @EnumSource(ServiceStatus.class)
  @SneakyThrows
  public void shouldSetServiceStatus(ServiceStatus serviceStatus) {
    lenient().when(service.activateService(any())).thenReturn(vo);
    lenient().when(service.deactivateService(any())).thenReturn(vo);
    lenient().when(service.resumeService(any())).thenReturn(vo);
    lenient().when(service.suspendService(any(), any())).thenReturn(vo);
    statusRepresentation.setStatus(serviceStatus);

    Response response = resource.setServiceState(uriInfo, statusRepresentation, parameters);

    assertThat(response).isNotNull();
    assertThat(response)
        .extracting(Response::getStatus)
        .isEqualTo(Response.Status.NO_CONTENT.getStatusCode());
  }

  @Test
  @SneakyThrows
  public void shouldGetCompatibleServices() {
    when(service.getCompatibleServices(any())).thenReturn(Lists.newArrayList(vo));

    Response response = compatiblesResource.getCompatibleServices(uriInfo, parameters);

    assertThat(response).isNotNull();
    assertThat(response)
        .extracting(Response::getStatus)
        .isEqualTo(Response.Status.OK.getStatusCode());
  }

  @Test
  @SneakyThrows
  public void shouldUpdateCompatibleServices() {
    doNothing().when(service).setCompatibleServices(any(), any());

    Response response =
        compatiblesResource.setCompatibleServices(uriInfo, compatiblesCollection, parameters);

    assertThat(response).isNotNull();
    assertThat(response)
        .extracting(Response::getStatus)
        .isEqualTo(Response.Status.NO_CONTENT.getStatusCode());
  }

  @Test
  public void shouldGetdefaultLocal() {
    // given
    String expected = "en";

    // when
    String result = backend.getLocale("");

    // then
    assertThat(expected).isEqualTo(result);
  }

  @Test
  public void shouldReturnGivenLocal() {
    // given
    String expected = "de";

    // when
    String result = backend.getLocale("de");

    // then
    assertThat(expected).isEqualTo(result);
  }

  public void shouldReturnService() throws ObjectNotFoundException, InvalidPhraseException {
    // given
    mockSearchService();

    // when
    List<VOService> slr = backend.getServices("12345678", "en", "test");

    // then
    assertThat(slr.get(0).getServiceId()).isEqualTo("testId");
  }

  private void mockSearchService() throws ObjectNotFoundException, InvalidPhraseException {
    List<VOService> slr = new ArrayList<VOService>();
    VOServiceListResult VOslr = new VOServiceListResult();
    VOService s = new VOService();

    s.setServiceId("testId");
    slr.add(s);
    VOslr.setServices(slr);

    when(searchService.searchServices(any(), any(), any())).thenReturn(VOslr);
  }

  private RepresentationCollection<ServiceRepresentation> createCompatiblesCollection() {
    ServiceRepresentation serviceRepresentation =
        SampleTestDataUtility.createServiceRepresentation();

    RepresentationCollection<ServiceRepresentation> collection =
        new RepresentationCollection<>(Lists.newArrayList(serviceRepresentation));
    collection.setETag(1234L);
    return collection;
  }
}
