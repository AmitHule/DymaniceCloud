package com.example.publishapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
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
    public ResponseEntity<Object> publishApi(Map<String,String> params,String token){
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
        try {
            ResponseEntity<Object> response = restTemplate.exchange(uri, HttpMethod.PUT, entity, Object.class, params);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }
        catch (HttpClientErrorException.Unauthorized exception){
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        catch (HttpClientErrorException.NotFound exception){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
