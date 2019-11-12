package com.example.publishapi;

import com.example.publishapi.services.AzureRestApiService;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RunWith(MockitoJUnitRunner.class)
public class AzureRestApiServiceTest {

    @Mock
    private RestTemplate restTemplate;
    @InjectMocks
    private AzureRestApiService azureRestApiService=new AzureRestApiService();
    Map<String,String> params;
    String body;
    private String uri="https://management.azure.com/subscriptions/{subscriptionId}/resourceGroups/" +
            "{resourceGroupName}/providers/Microsoft.ApiManagement/service/{serviceName}/apis/" +
            "{apiId}?api-version={releaseId}";
    private HttpHeaders httpHeaders=new HttpHeaders();
    @Before
    public void setup(){
        params=new HashMap<String, String>();
        params.put("subscriptionId","a54ab36e-86ad-4c34-a08d-9b43d1b04719");
        params.put("resourceGroupName","cloud-shell-storage-centralindia");
        params.put("serviceName","myapp12345");
        params.put("releaseId","2019-01-01");
        params.put("apiId","pvapp");

        httpHeaders.add("Content-Type", "application/json");
        httpHeaders.add("Authorization","token");
         body="{\n" +
                "  \"properties\": {\n" +
                "    \"format\": \"swagger-link-json\",\n" +
                "    \"value\": \"https://poc-skoda-191108111227.azurewebsites.net/v2/api-docs\",\n" +
                "    \"path\": \"\"\n" +
                "  }\n" +
                "}";
    }
    @Test
    public void publishApiTest_return202() throws Exception {
        HttpEntity<String> entity=new HttpEntity<>(body,httpHeaders);
        Mockito.when(restTemplate.exchange(uri, HttpMethod.PUT, entity, Object.class, params)).thenReturn(new ResponseEntity<>(HttpStatus.ACCEPTED));
        Assertions.assertThat(azureRestApiService.publishApi(params,"token")).isEqualTo(new ResponseEntity<Object>(HttpStatus.ACCEPTED));
    }
    @Test
    public void publishApiTest_invalidParams_return400() throws Exception {
        HttpEntity<String> entity=new HttpEntity<>(body,httpHeaders);
        Mockito.when(restTemplate.exchange(uri, HttpMethod.PUT, entity, Object.class, params)).thenThrow(HttpClientErrorException.BadRequest.class);
        Assertions.assertThat(azureRestApiService.publishApi(params,"token")).isEqualTo(new ResponseEntity<Object>(HttpStatus.BAD_REQUEST));
    }
    @Test
    public void publishApiTest_invalidheader_return401() throws Exception {
        HttpEntity<String> entity=new HttpEntity<>(body,httpHeaders);
        Mockito.when(restTemplate.exchange(uri, HttpMethod.PUT, entity, Object.class, params)).thenThrow(HttpClientErrorException.Unauthorized.class);
        Assertions.assertThat(azureRestApiService.publishApi(params,"token")).isEqualTo(new ResponseEntity<Object>(HttpStatus.UNAUTHORIZED));
    }
}
