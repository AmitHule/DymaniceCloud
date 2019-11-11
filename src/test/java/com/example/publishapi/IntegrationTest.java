package com.example.publishapi;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
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

    @Autowired
    RestTemplate restTemplate;

    @Before
    public void setup(){
        params.put("subscriptionId","a54ab36e-86ad-4c34-a08d-9b43d1b04719");
        params.put("resourceGroupName","cloud-shell-storage-centralindia");
        params.put("serviceName","myapp12345");
        params.put("releaseId","2019-01-01");
        params.put("apiId","pvapp");
    }
    @Test
    public void testPublishMyApi_success_shouldReturn200(){
        httpHeaders.add("Authorization","Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsIng1dCI6IkJCOENlRlZxeWFHckdOdWVoSklpTDRkZmp6dyIsImtpZCI6IkJCOENlRlZxeWFHckdOdWVoSklpTDRkZmp6dyJ9.eyJhdWQiOiJodHRwczovL21hbmFnZW1lbnQuYXp1cmUuY29tLyIsImlzcyI6Imh0dHBzOi8vc3RzLndpbmRvd3MubmV0L2M4NWUxZDk5LWFhNjgtNDZiYS05YjcyLTYwYTk0YmM1NTFkOC8iLCJpYXQiOjE1NzM0MDQ5NzUsIm5iZiI6MTU3MzQwNDk3NSwiZXhwIjoxNTczNDA4ODc1LCJhaW8iOiI0MlZnWU5pZm43TGdvdG5lQkt2TkoyOUtMMWh3QmdBPSIsImFwcGlkIjoiOTcyYzkxMTQtZDgxMS00NTBmLWIzM2UtM2RjMjUzN2ZkMzRhIiwiYXBwaWRhY3IiOiIxIiwiaWRwIjoiaHR0cHM6Ly9zdHMud2luZG93cy5uZXQvYzg1ZTFkOTktYWE2OC00NmJhLTliNzItNjBhOTRiYzU1MWQ4LyIsIm9pZCI6Ijg1NjAwOTczLTM5ZjgtNDZhYS1hYTE5LThjZjE4ZThhODg2OCIsInN1YiI6Ijg1NjAwOTczLTM5ZjgtNDZhYS1hYTE5LThjZjE4ZThhODg2OCIsInRpZCI6ImM4NWUxZDk5LWFhNjgtNDZiYS05YjcyLTYwYTk0YmM1NTFkOCIsInV0aSI6Inl2Qnc4YjFnd0VhT2JqRF9UeDI4QUEiLCJ2ZXIiOiIxLjAifQ.g5JCN_hYWz7pYOcJhSBURag0eZnYIHxsN0Olw3vTayiRiAn03mubeCycOktlbUEKhRA21vrUlLW7hsDCBozQoOFCdwmy7GRlzGTn2jtrxls6OrR7HdwsZZdy8XSghyjjo0unNSw0KvO7SY3DQdX7nkDe53_-g2XGjX_oEhhWgknU7_VfQHJ8W3uVfvBMlPhCOb22OedoHvTJMvuGts-RIvKgKCLjVDjgn8Xe4hv6JTiwnCWpGQORUx_q2ynhPIZ3NWuEz8JJiM69BILwEIiQGXB_IqtnMkeztKXzUScRtV5BfXMBgFB80xOaJvMCuFd7bUSTtmPrKnrOuOza4m7gjg");
        HttpEntity<String> entity=new HttpEntity<>("body",httpHeaders);

        ResponseEntity<Object> response= restTemplate.exchange(uri, HttpMethod.PUT,entity,Object.class,params);
        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }


}
