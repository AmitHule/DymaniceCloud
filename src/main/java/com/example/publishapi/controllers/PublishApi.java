package com.example.publishapi.controllers;

import com.example.publishapi.services.AzureRestApiService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class PublishApi {
    @Autowired
    private AzureRestApiService restApiService;

    @PutMapping("/publish/{subscriptionId}/{resourceGroupName}/{serviceName}/{apiId}/{releaseId}")
    public ResponseEntity<Object> publishMyApi(@RequestHeader("Authorization") String token, @PathVariable("subscriptionId") String subscriptionId
            ,@PathVariable("resourceGroupName") String resourceGroupName,@PathVariable("serviceName") String serviceName
            ,@PathVariable("apiId") String apiId,@PathVariable("releaseId") String releaseId){
        Map<String,String> data=new HashMap<>();
        data.put("subscriptionId",subscriptionId);
        data.put("resourceGroupName",resourceGroupName);
        data.put("serviceName",serviceName);
        data.put("apiId",apiId);
        data.put("releaseId",releaseId);

        ResponseEntity<Object> response=restApiService.publishApi(data,token);
        if(response.getStatusCode()==HttpStatus.ACCEPTED)
            return new ResponseEntity<>(HttpStatus.OK);
        if(response.getStatusCode()==HttpStatus.UNAUTHORIZED){
            return new ResponseEntity<>("Authorization error",HttpStatus.UNAUTHORIZED);
        }
        if(response.getStatusCode()== HttpStatus.NOT_FOUND){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
