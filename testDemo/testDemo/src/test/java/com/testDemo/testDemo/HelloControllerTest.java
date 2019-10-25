package com.testDemo.testDemo;

import com.testDemo.service.PocService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@WebMvcTest
@RunWith(SpringRunner.class)
public class HelloControllerTest {


    @MockBean
    PocService pocService;

    @Autowired
    MockMvc mockmvc;


    @Test
    public void testaddDetailsfornull() throws Exception {

        this.mockmvc.perform(post("/subscriptions")
                .contentType(MediaType.APPLICATION_JSON).content("{null,\"apiName\":\"/donename\"}"))
               .andExpect(status().isBadRequest());

    }
    @Test
    public void testaddDetailsForCorrect() throws Exception {

        this.mockmvc.perform(post("/subscriptions")
                .contentType(MediaType.APPLICATION_JSON).content("{\"apiUrl\":\"/donetest\",\"apiName\":\"/donename\"}"))
                .andExpect(content().string("{\"apiUrl\":\"/donetest\",\"apiName\":\"/donename\"}"));


    }


}
