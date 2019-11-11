package com.example.publishapi.controllers;

import com.example.publishapi.services.AzureRestApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PublishApi {
    @Autowired
    private AzureRestApiService restApiService;

    @PutMapping("/publish/{subscriptionId}/{resourceGroupName}/{serviceName}/{apiId}/{releaseId}")
    public ResponseEntity<Object> publishMyApi(@RequestHeader("Authorization") String token, @PathVariable("subscriptionId") String subscriptionId
            ,@PathVariable("resourceGroupName") String resourceGroupName,@PathVariable("serviceName") String serviceName
            ,@PathVariable("apiId") String apiId,@PathVariable("releaseId") String releaseId) throws Exception{
        ResponseEntity<String> response=restApiService.publishApi(token);
        if(response.getStatusCode()==HttpStatus.ACCEPTED)
            return new ResponseEntity<Object>(HttpStatus.OK);
        if(response.getStatusCode()==HttpStatus.UNAUTHORIZED){
            return new ResponseEntity<Object>(HttpStatus.UNAUTHORIZED);
        }
        return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
    }
}
