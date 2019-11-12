package com.example.publishapi;

import com.example.publishapi.controllers.PublishApi;
import com.example.publishapi.services.AzureRestApiService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(PublishApi.class)
public class PublishApiControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private AzureRestApiService restApiService;
    String subscriptionId,resourceGroupName,serviceName,apiId,releaseId;
    @Before
    public void setup(){
        subscriptionId="a54ab36e-86ad-4c34-a08d-9b43d1b04719";
        resourceGroupName="cloud-shell-storage-centralindia";
        serviceName="myapp12345";
        apiId="pvrock1";
        releaseId="2019-01-01";
    }

    @Test
    public void publishMyApi_success_shouldReturn200() throws Exception {
        given(restApiService.publishApi(any(),anyString())).willReturn(new ResponseEntity<Object>(HttpStatus.ACCEPTED));
        MvcResult result=mockMvc.perform(MockMvcRequestBuilders.put("/api/publish/{subscriptionId}/{resourceGroupName}/{serviceName}/{apiId}/{releaseId}"
        ,subscriptionId,resourceGroupName,serviceName,apiId,releaseId).header("Authorization","access token"))
                .andExpect(status().isOk())
                .andReturn();
    }
    @Test
    public void publishMyApi_invalidParameters_shouldReturn404() throws Exception {
        given(restApiService.publishApi(any(),anyString())).willReturn(new ResponseEntity<Object>(HttpStatus.NOT_FOUND));
        mockMvc.perform(MockMvcRequestBuilders.put("/api/publish/{subscriptionId}/{resourceGroupName}/{serviceName}/{apiId}/{releaseId}"
        ,"invalid",resourceGroupName,serviceName,apiId,releaseId).header("Authorization","access token"))
                .andExpect(status().isNotFound());
    }
    @Test
    public void publishMyApi_invalidHeader_shouldReturn401() throws Exception {
        given(restApiService.publishApi(any(),anyString())).willReturn(new ResponseEntity<Object>(HttpStatus.UNAUTHORIZED));
        mockMvc.perform(MockMvcRequestBuilders.put("/api/publish/{subscriptionId}/{resourceGroupName}/{serviceName}/{apiId}/{releaseId}"
        ,subscriptionId,resourceGroupName,serviceName,apiId,releaseId))
                .andExpect(status().isUnauthorized());
    }

}
