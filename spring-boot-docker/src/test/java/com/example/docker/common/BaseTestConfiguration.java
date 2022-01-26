package com.example.docker.common;

import com.example.docker.controller.MemberController;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = {
        MemberController.class
})
@AutoConfigureRestDocs
public class BaseTestConfiguration {
    @Autowired
    protected MockMvc mockMvc;

    @MockBean
    protected MemberController memberController;

    protected ObjectMapper mapper = new ObjectMapper();
}
