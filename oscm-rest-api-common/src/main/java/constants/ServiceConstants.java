/**
 * *****************************************************************************
 *
 * <p>Copyright FUJITSU LIMITED 2019
 *
 * <p>Creation Date: Aug 1, 2019
 *
 * <p>*****************************************************************************
 */
package constants;

/** Class for account api module constants */
public class ServiceConstants {

  public static final String COMPATIBLE_SERVICE_MAXIMUM_BODY =
      "{\n"
          + "\"items\": [\n"
          + "{\n"
          + "\"parameters\": [],\n"
          + "\"imageDefined\": false,\n"
          + "\"description\": \"\",\n"
          + "\"name\": \"TSForRest\",\n"
          + "\"serviceId\": \"NotUsedMarketableService\",\n"
          + "\"technicalId\": \"TSForRest\",\n"
          + "\"status\": \"ACTIVE\",\n"
          + "\"accessType\": \"EXTERNAL\",\n"
          + "\"shortDescription\": \"\",\n"
          + "\"offeringType\": \"DIRECT\",\n"
          + "\"configuratorUrl\": \"\",\n"
          + "\"billingIdentifier\": \"NATIVE_BILLING\",\n"
          + "\"serviceType\": \"TEMPLATE\",\n"
          + "\"etag\": 1,\n"
          + "\"id\": 12000\n"
          + "}\n"
          + "],\n"
          + "\"etag\": 7\n"
          + "}\n";

  public static final String TECHNICAL_SERVICE_EXAMPLE_RESPONSE =
      "{\n"
          + "      \"eventDefinitions\": [],\n"
          + "      \"technicalServiceId\": \"AppSampleService\",\n"
          + "      \"technicalServiceBuildId\": \"2019.12.13\",\n"
          + "      \"accessType\": \"DIRECT\",\n"
          + "      \"technicalServiceDescription\": \"Sample APP implementation.\",\n"
          + "      \"baseUrl\": \"\",\n"
          + "      \"provisioningUrl\": \"http://oscm-app:8880/oscm-app/webservices/oscm-app/oscm-app/org.oscm.app.v2_0.service.AsynchronousProvisioningProxy?wsdl\",\n"
          + "      \"loginPath\": \"/Dynamically provided.\",\n"
          + "      \"provisioningVersion\": \"1.0\",\n"
          + "      \"parameterDefinitions\": [\n"
          + "        {\n"
          + "          \"parameterOptions\": [],\n"
          + "          \"minValue\": 0,\n"
          + "          \"mandatory\": false,\n"
          + "          \"configurable\": true,\n"
          + "          \"parameterType\": \"PLATFORM_PARAMETER\",\n"
          + "          \"parameterId\": \"PERIOD\",\n"
          + "          \"valueType\": \"DURATION\",\n"
          + "          \"modificationType\": \"STANDARD\",\n"
          + "          \"description\": \"Number of days after which the subscription will be deactivated.\",\n"
          + "          \"etag\": 0,\n"
          + "          \"id\": 1002\n"
          + "        },\n"
          + "        {\n"
          + "          \"parameterOptions\": [],\n"
          + "          \"defaultValue\": \"ess.sample\",\n"
          + "          \"mandatory\": true,\n"
          + "          \"configurable\": false,\n"
          + "          \"parameterType\": \"SERVICE_PARAMETER\",\n"
          + "          \"parameterId\": \"APP_CONTROLLER_ID\",\n"
          + "          \"valueType\": \"STRING\",\n"
          + "          \"modificationType\": \"STANDARD\",\n"
          + "          \"description\": \"The ID of the sample controller implementation.\",\n"
          + "          \"etag\": 0,\n"
          + "          \"id\": 10000\n"
          + "        },\n"
          + "        {\n"
          + "          \"parameterOptions\": [],\n"
          + "          \"defaultValue\": \"Some message.\",\n"
          + "          \"mandatory\": true,\n"
          + "          \"configurable\": true,\n"
          + "          \"parameterType\": \"SERVICE_PARAMETER\",\n"
          + "          \"parameterId\": \"PARAM_MESSAGETEXT\",\n"
          + "          \"valueType\": \"STRING\",\n"
          + "          \"modificationType\": \"STANDARD\",\n"
          + "          \"description\": \"The message text for emails.\",\n"
          + "          \"etag\": 0,\n"
          + "          \"id\": 10001\n"
          + "        },\n"
          + "        {\n"
          + "          \"parameterOptions\": [],\n"
          + "          \"defaultValue\": \"user@myorg.com\",\n"
          + "          \"mandatory\": true,\n"
          + "          \"configurable\": true,\n"
          + "          \"parameterType\": \"SERVICE_PARAMETER\",\n"
          + "          \"parameterId\": \"PARAM_EMAIL\",\n"
          + "          \"valueType\": \"STRING\",\n"
          + "          \"modificationType\": \"STANDARD\",\n"
          + "          \"description\": \"The receiver of emails.\",\n"
          + "          \"etag\": 0,\n"
          + "          \"id\": 10002\n"
          + "        },\n"
          + "        {\n"
          + "          \"parameterOptions\": [],\n"
          + "          \"defaultValue\": \"defaultuser\",\n"
          + "          \"mandatory\": true,\n"
          + "          \"configurable\": true,\n"
          + "          \"parameterType\": \"SERVICE_PARAMETER\",\n"
          + "          \"parameterId\": \"PARAM_USER\",\n"
          + "          \"valueType\": \"STRING\",\n"
          + "          \"modificationType\": \"STANDARD\",\n"
          + "          \"description\": \"IAAS user\",\n"
          + "          \"etag\": 0,\n"
          + "          \"id\": 10003\n"
          + "        },\n"
          + "        {\n"
          + "          \"parameterOptions\": [],\n"
          + "          \"mandatory\": true,\n"
          + "          \"configurable\": true,\n"
          + "          \"parameterType\": \"SERVICE_PARAMETER\",\n"
          + "          \"parameterId\": \"PARAM_PWD\",\n"
          + "          \"valueType\": \"PWD\",\n"
          + "          \"modificationType\": \"STANDARD\",\n"
          + "          \"description\": \"IAAS password\",\n"
          + "          \"etag\": 0,\n"
          + "          \"id\": 10004\n"
          + "        },\n"
          + "        {\n"
          + "          \"parameterOptions\": [],\n"
          + "          \"mandatory\": false,\n"
          + "          \"configurable\": true,\n"
          + "          \"parameterType\": \"SERVICE_PARAMETER\",\n"
          + "          \"parameterId\": \"APP_BASE_URL_FOR_NOTIFICATION\",\n"
          + "          \"valueType\": \"STRING\",\n"
          + "          \"modificationType\": \"STANDARD\",\n"
          + "          \"description\": \"The APP base URL for notification. The URL is only required if manual provisioning is used\",\n"
          + "          \"etag\": 0,\n"
          + "          \"id\": 10005\n"
          + "        },\n"
          + "        {\n"
          + "          \"parameterOptions\": [],\n"
          + "          \"mandatory\": false,\n"
          + "          \"configurable\": true,\n"
          + "          \"parameterType\": \"SERVICE_PARAMETER\",\n"
          + "          \"parameterId\": \"EMAIL_SUBJECT\",\n"
          + "          \"valueType\": \"STRING\",\n"
          + "          \"modificationType\": \"STANDARD\",\n"
          + "          \"description\": \"The Email subject\",\n"
          + "          \"etag\": 0,\n"
          + "          \"id\": 10006\n"
          + "        },\n"
          + "        {\n"
          + "          \"parameterOptions\": [],\n"
          + "          \"mandatory\": false,\n"
          + "          \"configurable\": true,\n"
          + "          \"parameterType\": \"SERVICE_PARAMETER\",\n"
          + "          \"parameterId\": \"CSSSTYLE\",\n"
          + "          \"valueType\": \"STRING\",\n"
          + "          \"modificationType\": \"STANDARD\",\n"
          + "          \"description\": \"Inline CSS for Email Notification\",\n"
          + "          \"etag\": 0,\n"
          + "          \"id\": 10007\n"
          + "        }\n"
          + "      ],\n"
          + "      \"roleDefinitions\": [],\n"
          + "      \"tags\": [],\n"
          + "      \"license\": \"\",\n"
          + "      \"accessInfo\": \"Description of how to access the application.\",\n"
          + "      \"billingIdentifier\": \"NATIVE_BILLING\",\n"
          + "      \"technicalServiceOperations\": [],\n"
          + "      \"externalBilling\": false,\n"
          + "      \"etag\": 1,\n"
          + "      \"id\": 10000\n"
          + "    }";

  public static final String TECHNICAL_SERVICE_LIST_EXAMPLE_RESPONSE =
      "{\"items\":[" + TECHNICAL_SERVICE_EXAMPLE_RESPONSE + "]}";

  public static final String TECHNICAL_SERVICE_CREATE_EXAMPLE_BODY =
      "{\n"
          + "\"technicalServiceId\": \"newTSRESTID\",\n"
          + "\"technicalServiceBuildId\": \"tsBuildIdRest\",\n"
          + "\"accessType\": \"EXTERNAL\",\n"
          + "\"technicalServiceDescription\": \"TSREST Desc\",\n"
          + "\"baseUrl\": \"http://some-random-url-from-rest-api.com\",\n"
          + "\"provisioningUrl\": \"http://prov-url-from-rest-api.com\",\n"
          + "\"loginPath\": \"/login\",\n"
          + "\"provisioningVersion\": \"1.0\",\n"
          + "\"license\": \"REST License\",\n"
          + "\"accessInfo\": \"REST Access Info\",\n"
          + "\"billingIdentifier\": \"billing id\",\n"
          + "\"externalBilling\": false\n"
          + "}\n";

  public static final String TECHNICAL_SERVICE_IMPORT_EXAMPLE_BODY =
      "{\n"
          + "\"technicalServiceXml\": \"<?xml version='1.0' encoding='UTF-8'?>\n"
          + "<tns:TechnicalServices xmlns:tns='oscm.serviceprovisioning/1.9/TechnicalService.xsd' xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance'\n"
          + "  xsi:schemaLocation='oscm.serviceprovisioning/1.9/TechnicalService.xsd ../../oscm-serviceprovisioning/javares/TechnicalServices.xsd'>\n"
          + "  <tns:TechnicalService id='SampleServiceFromImport' build='Sample-Build.1.0' provisioningType='ASYNCHRONOUS'\n"
          + "    provisioningUrl='http://oscm-app:8880/oscm-app/webservices/oscm-app/oscm-app/org.oscm.app.v2_0.service.AsynchronousProvisioningProxy?wsdl' provisioningVersion='1.0'\n"
          + "    accessType='DIRECT' loginPath='Dynamically provided.' baseUrl=''>\n"
          + "    <AccessInfo locale='en'>Description of how to access the application.</AccessInfo>\n"
          + "    <LocalizedDescription locale='en'>Sample APP implementation.</LocalizedDescription>\n"
          + "    <LocalizedDescription locale='de'>Sample APP Implementierung.</LocalizedDescription>\n"
          + "    <LocalizedLicense locale='en' />\n"
          + "    <ParameterDefinition id='PARAM_MESSAGETEXT' configurable='true' mandatory='true' valueType='STRING'\n"
          + "      default=''>\n"
          + "      <LocalizedDescription locale='en'>The message text for emails.</LocalizedDescription>\n"
          + "    </ParameterDefinition>\n"
          + "    <ParameterDefinition id='PARAM_EMAIL' configurable='true' mandatory='true' valueType='STRING'\n"
          + "      default='user@myorg.com'>\n"
          + "      <LocalizedDescription locale='en'>The receiver of emails.</LocalizedDescription>\n"
          + "    </ParameterDefinition>\n"
          + "    <ParameterDefinition id='PARAM_USER' configurable='true' mandatory='true' valueType='STRING'\n"
          + "      default='defaultuser'>\n"
          + "      <LocalizedDescription locale='en'>IAAS user</LocalizedDescription>\n"
          + "    </ParameterDefinition>\n"
          + "    <ParameterDefinition id='PARAM_PWD' configurable='true' mandatory='true' valueType='PWD'\n"
          + "      default=''>\n"
          + "      <LocalizedDescription locale='en'>IAAS password</LocalizedDescription>\n"
          + "    </ParameterDefinition>\n"
          + "    <ParameterDefinition configurable='true' default='t1.micro'\n"
          + "\t\t\tid='INSTANCE_TYPE' mandatory='true' modificationType='ONE_TIME'\n"
          + "\t\t\tvalueType='ENUMERATION'>\n"
          + "\t\t\t<Options>\n"
          + "\t\t\t\t<Option id='t1.micro'>\n"
          + "\t\t\t\t\t<LocalizedOption locale='en'>t1.micro</LocalizedOption>\n"
          + "\t\t\t\t</Option>\n"
          + "\t\t\t\t<Option id='t2.micro'>\n"
          + "\t\t\t\t\t<LocalizedOption locale='en'>t2.micro</LocalizedOption>\n"
          + "\t\t\t\t</Option>\n"
          + "\t\t\t\t<Option id='m1.small'>\n"
          + "\t\t\t\t\t<LocalizedOption locale='en'>m1.small</LocalizedOption>\n"
          + "\t\t\t\t</Option>\n"
          + "\t\t\t\t<Option id='m1.medium'>\n"
          + "\t\t\t\t\t<LocalizedOption locale='en'>m3.medium</LocalizedOption>\n"
          + "\t\t\t\t</Option>\n"
          + "\t\t\t</Options>\n"
          + "\t\t\t<LocalizedDescription locale='de'>Instance-Typ</LocalizedDescription>\n"
          + "\t\t\t<LocalizedDescription locale='en'>Instance Type</LocalizedDescription>\n"
          + "\t\t</ParameterDefinition>\n"
          + "    <ParameterDefinition configurable='true' default='true'\n"
          + "\t\t\tid='PUBLIC_IP' mandatory='true' modificationType='ONE_TIME'\n"
          + "\t\t\tvalueType='BOOLEAN'>\n"
          + "\t\t\t<LocalizedDescription locale='en'>Public Ip</LocalizedDescription>\n"
          + "\t\t\t<LocalizedDescription locale='de' />\n"
          + "\t\t\t<LocalizedDescription locale='ja' />\n"
          + "\t\t</ParameterDefinition>\n"
          + "  </tns:TechnicalService>\n"
          + "</tns:TechnicalServices>\n\"\n"
          + "}\n";

  public static final String SUPPLIER_EXAMPLE_RESPONSE =
      "{\n"
          + "      \"organizationId\": \"a4140b27\",\n"
          + "      \"address\": \"qwerty123456\",\n"
          + "      \"email\": \"supplier@company.com\",\n"
          + "      \"locale\": \"en\",\n"
          + "      \"name\": \"Supplier INC\",\n"
          + "      \"phone\": \"123454321\",\n"
          + "      \"url\": \"http://test.com\",\n"
          + "      \"description\": \"\",\n"
          + "      \"domicileCountry\": \"PF\",\n"
          + "      \"etag\": 1,\n"
          + "      \"id\": 11000\n"
          + "    }";

  public static final String SUPPLIER_LIST_EXAMPLE_RESPONSE =
      "{\"items\":[" + SUPPLIER_EXAMPLE_RESPONSE + "]}";

  public static final String SUPPLIER_ADD_EXAMPLE_REQUEST =
      "{\n" + "\"organizationId\": \"dummyorgid\"\n" + "}\n";

  public static final String SERVICE_EXAMPLE_RESPONSE =
      " {\n"
          + "      \"parameters\": [\n"
          + "        {\n"
          + "          \"parameterDefinition\": {\n"
          + "            \"parameterOptions\": [],\n"
          + "            \"defaultValue\": \"Some message.\",\n"
          + "            \"mandatory\": true,\n"
          + "            \"configurable\": true,\n"
          + "            \"parameterType\": \"SERVICE_PARAMETER\",\n"
          + "            \"parameterId\": \"PARAM_MESSAGETEXT\",\n"
          + "            \"valueType\": \"STRING\",\n"
          + "            \"modificationType\": \"STANDARD\",\n"
          + "            \"description\": \"The message text for emails.\",\n"
          + "            \"etag\": 0,\n"
          + "            \"id\": 10001\n"
          + "          },\n"
          + "          \"value\": \"Some message.\",\n"
          + "          \"configurable\": false,\n"
          + "          \"etag\": 0,\n"
          + "          \"id\": 10000\n"
          + "        },\n"
          + "        {\n"
          + "          \"parameterDefinition\": {\n"
          + "            \"parameterOptions\": [],\n"
          + "            \"defaultValue\": \"user@myorg.com\",\n"
          + "            \"mandatory\": true,\n"
          + "            \"configurable\": true,\n"
          + "            \"parameterType\": \"SERVICE_PARAMETER\",\n"
          + "            \"parameterId\": \"PARAM_EMAIL\",\n"
          + "            \"valueType\": \"STRING\",\n"
          + "            \"modificationType\": \"STANDARD\",\n"
          + "            \"description\": \"The receiver of emails.\",\n"
          + "            \"etag\": 0,\n"
          + "            \"id\": 10002\n"
          + "          },\n"
          + "          \"value\": \"user@myorg.com\",\n"
          + "          \"configurable\": false,\n"
          + "          \"etag\": 0,\n"
          + "          \"id\": 10001\n"
          + "        },\n"
          + "        {\n"
          + "          \"parameterDefinition\": {\n"
          + "            \"parameterOptions\": [],\n"
          + "            \"defaultValue\": \"defaultuser\",\n"
          + "            \"mandatory\": true,\n"
          + "            \"configurable\": true,\n"
          + "            \"parameterType\": \"SERVICE_PARAMETER\",\n"
          + "            \"parameterId\": \"PARAM_USER\",\n"
          + "            \"valueType\": \"STRING\",\n"
          + "            \"modificationType\": \"STANDARD\",\n"
          + "            \"description\": \"IAAS user\",\n"
          + "            \"etag\": 0,\n"
          + "            \"id\": 10003\n"
          + "          },\n"
          + "          \"value\": \"defaultuser\",\n"
          + "          \"configurable\": false,\n"
          + "          \"etag\": 0,\n"
          + "          \"id\": 10002\n"
          + "        },\n"
          + "        {\n"
          + "          \"parameterDefinition\": {\n"
          + "            \"parameterOptions\": [],\n"
          + "            \"mandatory\": true,\n"
          + "            \"configurable\": true,\n"
          + "            \"parameterType\": \"SERVICE_PARAMETER\",\n"
          + "            \"parameterId\": \"PARAM_PWD\",\n"
          + "            \"valueType\": \"PWD\",\n"
          + "            \"modificationType\": \"STANDARD\",\n"
          + "            \"description\": \"IAAS password\",\n"
          + "            \"etag\": 0,\n"
          + "            \"id\": 10004\n"
          + "          },\n"
          + "          \"value\": \"secret\",\n"
          + "          \"configurable\": false,\n"
          + "          \"etag\": 0,\n"
          + "          \"id\": 10003\n"
          + "        }\n"
          + "      ],\n"
          + "      \"description\": \"Sample APP implementation.\",\n"
          + "      \"name\": \"AppSampleService\",\n"
          + "      \"serviceId\": \"Sample 111111\",\n"
          + "      \"technicalId\": \"AppSampleService\",\n"
          + "      \"status\": \"INACTIVE\",\n"
          + "      \"accessType\": \"DIRECT\",\n"
          + "      \"shortDescription\": \"\",\n"
          + "      \"offeringType\": \"DIRECT\",\n"
          + "      \"configuratorUrl\": \"\",\n"
          + "      \"billingIdentifier\": \"NATIVE_BILLING\",\n"
          + "      \"serviceType\": \"TEMPLATE\",\n"
          + "      \"tags\": [],\n"
          + "      \"averageRating\": 0,\n"
          + "      \"numberOfReviews\": 0,\n"
          + "      \"etag\": 0,\n"
          + "      \"id\": 10000\n"
          + "    }";

  public static final String SERVICE_LIST_EXAMPLE_RESPONSE =
      "{\"items\":[" + SERVICE_EXAMPLE_RESPONSE + "]}";;

  public static final String SERVICE_STATUS_UPDATE_EXAMPLE_REQUEST = "{\"status\": \"ACTIVE\"}";

  public static final String SERVICE_CREATE_EXAMPLE_REQUEST =
      "{\n"
          + "  \"technicalServiceId\": \"REST_technical_service\",\n"
          + "  \"serviceId\": \"REST_example_service\",\n"
          + "  \"description\": \"REST example service\",\n"
          + "  \"name\": \"REST example created service\",\n"
          + "  \"shortDescription\": \"REST short desc\",\n"
          + "  \"description\": \"REST normal description\",\n"
          + "  \"configuratorUrl\": \"http://somerandom-url.com\",\n"
          + "  \"customTabName\": \"Tab Name\",\n"
          + "  \"customTabUrl\": \"http://somerandom-tab-url.com\",\n"
          + "  \"parameters\": [\n"
          + "        {\n"
          + "          \"parameterId\": \"PARAMETER1_ID\",\n"
          + "          \"value\": \"value1\",\n"
          + "          \"configurable\": false\n"
          + "        },\n"
          + "        {\n"
          + "          \"parameterId\": \"PARAMETER2_ID\",\n"
          + "          \"value\": \"value1\",\n"
          + "          \"configurable\": false\n"
          + "        },\n"
          + "        {\n"
          + "          \"parameterId\": \"PARAMETER2_ID\",\n"
          + "          \"value\": \"value1\",\n"
          + "          \"configurable\": false\n"
          + "        }\n"
          + "      ]\n"
          + "}";

  public static final String SERVICE_UPDATE_EXAMPLE_REQUEST =
      "{\n"
          + "  \"serviceId\": \"REST_example_service\",\n"
          + "  \"description\": \"REST example service\",\n"
          + "  \"name\": \"REST example created service\",\n"
          + "  \"shortDescription\": \"REST short desc\",\n"
          + "  \"description\": \"REST normal description\",\n"
          + "  \"configuratorUrl\": \"http://somerandom-url.com\",\n"
          + "  \"customTabName\": \"Tab Name\",\n"
          + "  \"customTabUrl\": \"http://somerandom-tab-url.com\",\n"
          + "  \"parameters\": [\n"
          + "        {\n"
          + "          \"parameterId\": \"PARAMETER1_ID\",\n"
          + "          \"value\": \"value1\",\n"
          + "          \"configurable\": false\n"
          + "        },\n"
          + "        {\n"
          + "          \"parameterId\": \"PARAMETER2_ID\",\n"
          + "          \"value\": \"value1\",\n"
          + "          \"configurable\": false\n"
          + "        },\n"
          + "        {\n"
          + "          \"parameterId\": \"PARAMETER2_ID\",\n"
          + "          \"value\": \"value1\",\n"
          + "          \"configurable\": false\n"
          + "        }\n"
          + "      ]\n"
          + "}";

  public static final String PRICE_MODEL_EXAMPLE_RESPONSE =
      "{\n"
          + "  \"description\": \"test price\",\n"
          + "  \"period\": \"MONTH\",\n"
          + "  \"pricePerPeriod\": 2,\n"
          + "  \"pricePerUserAssignment\": 0,\n"
          + "  \"currencyISOCode\": \"EUR\",\n"
          + "  \"oneTimeFee\": 10,\n"
          + "  \"type\": \"PRO_RATA\",\n"
          + "  \"etag\": 1,\n"
          + "  \"id\": 10003\n"
          + "}";

  public static final String PRICE_MODEL_UPDATE_EXAMPLE_REQUEST =
      "{\n"
          + "    \"type\": \"PRO_RATA\",\n"
          + "    \"period\": \"MONTH\",\n"
          + "    \"pricePerPeriod\": 10,\n"
          + "    \"pricePerUserAssignment\": 0,\n"
          + "    \"currencyISOCode\": \"EUR\",\n"
          + "    \"oneTimeFee\": 10,\n"
          + "    \"etag\": 1\n"
          + "}";
}
