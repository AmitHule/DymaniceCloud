package com.example.publishapi;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
public class IntegrationTest {
    String uri="http://localhost:8080/api/publish/{subscriptionId}/{resourceGroupName}/{serviceName}/{apiId}/{releaseId}";
    Map<String,String> params=new HashMap<String, String>();;
    HttpHeaders httpHeaders=new HttpHeaders();
    String accessToken;
    @Autowired
    RestTemplate restTemplate;

    @Before
    public void setup(){
        accessToken="eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsIng1dCI6IkJCOENlRlZxeWFHckdOdWVoSklpTDRkZmp6dyIsImtpZCI6IkJCOENlRlZxeWFHckdOdWVoSklpTDRkZmp6dyJ9.eyJhdWQiOiJodHRwczovL21hbmFnZW1lbnQuYXp1cmUuY29tLyIsImlzcyI6Imh0dHBzOi8vc3RzLndpbmRvd3MubmV0L2M4NWUxZDk5LWFhNjgtNDZiYS05YjcyLTYwYTk0YmM1NTFkOC8iLCJpYXQiOjE1NzM1NDMxMTEsIm5iZiI6MTU3MzU0MzExMSwiZXhwIjoxNTczNTQ3MDExLCJhaW8iOiI0MlZnWU5oZlZ1cWRPdWZLQ3prMUxTT3ZoWDBiQUE9PSIsImFwcGlkIjoiOTcyYzkxMTQtZDgxMS00NTBmLWIzM2UtM2RjMjUzN2ZkMzRhIiwiYXBwaWRhY3IiOiIxIiwiaWRwIjoiaHR0cHM6Ly9zdHMud2luZG93cy5uZXQvYzg1ZTFkOTktYWE2OC00NmJhLTliNzItNjBhOTRiYzU1MWQ4LyIsIm9pZCI6Ijg1NjAwOTczLTM5ZjgtNDZhYS1hYTE5LThjZjE4ZThhODg2OCIsInN1YiI6Ijg1NjAwOTczLTM5ZjgtNDZhYS1hYTE5LThjZjE4ZThhODg2OCIsInRpZCI6ImM4NWUxZDk5LWFhNjgtNDZiYS05YjcyLTYwYTk0YmM1NTFkOCIsInV0aSI6IlJEQnZfT2sxdmtLbjEwTy1qb2toQVEiLCJ2ZXIiOiIxLjAifQ.RIy3xqMEu9TrFe70tsZFnZ8vpBjwh7zl8M2ve-4GowyxI3n5IUzhbowIMtur2tsi0fbvn6-ZOYijassnDem0iadGnJsgJJFC1dISIAFn5hvwXV06RuU79hSEACQwi9apWn9yNk9Yx6QJyw9093aLuqZdv6a8MTbzNAkUIcSNNDAXR2AfdrnWYTuppRthMPc4bCeAtfdIdt6fQI3rMfYbkUjDZwYeEdsEJX0FGAoaKgv1IopO72npLJAHSHCsCO-fpWzbSHLK9nMgokMDKcckOU1v0HDmBka_0SG3kgGn2hgfUM7b4EqN_akwwp9zVHad6MxhxZeNrB8Hd5frVBjd-g";
        params.put("subscriptionId","a54ab36e-86ad-4c34-a08d-9b43d1b04719");
        params.put("resourceGroupName","cloud-shell-storage-centralindia");
        params.put("serviceName","myapp12345");
        params.put("releaseId","2019-01-01");
        params.put("apiId","pvapp");
    }
    @Test
    public void testPublishMyApi_success_shouldReturn200(){
        httpHeaders.add("Authorization","Bearer "+accessToken);
        HttpEntity<String> entity=new HttpEntity<>("body",httpHeaders);

        ResponseEntity<Object> response= restTemplate.exchange(uri, HttpMethod.PUT,entity,Object.class,params);
        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
   @Test(expected = HttpClientErrorException.NotFound.class)
    public void testPublishMyApi_invalidParams_shouldReturn404(){
        httpHeaders.add("Authorization","Bearer "+accessToken);
        HttpEntity<String> entity=new HttpEntity<>("body",httpHeaders);
        params.put("subscriptionId","invalid");
        ResponseEntity<Object> response= restTemplate.exchange(uri, HttpMethod.PUT,entity,Object.class,params);
    }
    @Test(expected = HttpClientErrorException.BadRequest.class)
    public void testPublishMyApi_noHeaders_shouldReturn400(){
        HttpEntity<String> entity=new HttpEntity<>("body",null);
        ResponseEntity<Object> response= restTemplate.exchange(uri, HttpMethod.PUT,entity,Object.class,params);
    }
    @Test(expected = HttpClientErrorException.Unauthorized.class)
    public void testPublishMyApi_invalidAccessCode_shouldReturn401(){
        httpHeaders.add("Authorization","Bearer invalid");
        HttpEntity<String> entity=new HttpEntity<>("body",httpHeaders);
        ResponseEntity<Object> response= restTemplate.exchange(uri, HttpMethod.PUT,entity,Object.class,params);

    }


}
