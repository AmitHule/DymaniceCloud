package com.testDemo.controller;

import com.testDemo.entity.Poc;

import com.testDemo.service.PocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class PocController {

    @Autowired
    PocService pocService;

    @PostMapping("/subscriptions")
    public Poc postPocDetails(@RequestBody @Valid Poc poc){

        pocService.saveData(poc);

        return poc;
    }




}
