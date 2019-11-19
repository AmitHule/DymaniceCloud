package com.vwits.skoda.skodademo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ArrayList;


@RestController

public class NameController
{
    @Autowired
    ModelService modelservice;

    @GetMapping("/basicname")
    private List<Model> getAlldata() {
        return modelservice.getAllPublishdata();
    }

    @GetMapping("/basicname/{backend_url}")
    private Model getdetails(@PathVariable("backend_url") String backend_url) {
        return modelservice.searchByurl(backend_url);
    }

    @DeleteMapping("/basicname/{backend_url}")
    private void deletedetails(@PathVariable("backend_url") String backend_url) {
        modelservice.delete(backend_url);
    }

    @PostMapping("/basicname")
    public Model savedetails(@RequestBody Model model) {
        modelservice.saveOrUpdate(model);
        return model;

    }


}
