package com.volks.Ldap.controller;

import com.volks.Ldap.domain.User;
import com.volks.Ldap.service.LdapService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LdapController {

    private LdapService ldapService;

    public LdapController(LdapService ldapService) {
        this.ldapService = ldapService;
    }

    @GetMapping("/validateUser/{username}/{password}")
    public User validateUser(@PathVariable String username, @PathVariable String password){
        return ldapService.authenticate(username,password);
    }

}
