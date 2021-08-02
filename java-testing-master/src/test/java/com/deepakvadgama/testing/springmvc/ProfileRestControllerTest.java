package com.deepakvadgama.testing.springmvc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest
public class ProfileRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    private void testGetMapping() throws Exception {

        mockMvc.perform(get("/get").param("name", "John Wick"))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"name\":\"John Wick\",\"age\":35,\"address\":{\"street\":\"Spring street\",\"city\":\"L.A.\",\"pincode\":\"000992\"}}"));
    }
}