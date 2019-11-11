package com.example.publishapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
@Service
public class AzureRestApiService {
    @Autowired
    private RestTemplate restTemplate;
    Map<String,String> params;
    private String uri="https://management.azure.com/subscriptions/{subscriptionId}/resourceGroups/" +
            "{resourceGroupName}/providers/Microsoft.ApiManagement/service/{serviceName}/apis/" +
            "{apiId}?api-version={releaseId}";
    public ResponseEntity<String> publishApi(String token) throws Exception{
        params=new HashMap<String, String>();
        params.put("subscriptionId","a54ab36e-86ad-4c34-a08d-9b43d1b04719");
        params.put("resourceGroupName","cloud-shell-storage-centralindia");
        params.put("serviceName","myapp12345");
        params.put("releaseId","2019-01-01");
        params.put("apiId","pvapp");
        HttpHeaders httpHeaders =new HttpHeaders();
        httpHeaders.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);
        httpHeaders.add("Authorization",token);
        String body="{\n" +
                "  \"properties\": {\n" +
                "    \"format\": \"swagger-link-json\",\n" +
                "    \"value\": \"https://poc-skoda-191108111227.azurewebsites.net/v2/api-docs\",\n" +
                "    \"path\": \"\"\n" +
                "  }\n" +
                "}";
        HttpEntity<String> entity=new HttpEntity<>(body,httpHeaders);
        ResponseEntity<Object> response=restTemplate.exchange(uri, HttpMethod.PUT,entity,Object.class,params);
        if(response.getStatusCode()==HttpStatus.ACCEPTED){
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
