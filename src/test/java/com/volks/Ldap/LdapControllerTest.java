package com.volks.Ldap;

import com.jayway.jsonpath.JsonPath;
import com.volks.Ldap.controller.LdapController;
import com.volks.Ldap.domain.User;
import com.volks.Ldap.service.LdapService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringRunner.class)
@WebMvcTest(LdapController.class)
public class LdapControllerTest {

    @Autowired
    private MockMvc  mockMvc;

    @MockBean
    private LdapService ldapService;

    @Test
    public void validateUser_returnUser() throws Exception {
        given(ldapService.authenticate(anyString(),anyString())).willReturn(new User("prateek","test"));
        mockMvc.perform(MockMvcRequestBuilders.get("/validateUser/prateek/test"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("username").value("prateek"))
                .andExpect(jsonPath("password").value("test"));
    }
}
