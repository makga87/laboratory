package com.example.docker.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.HashMap;
import java.util.Map;

import static com.epages.restdocs.apispec.MockMvcRestDocumentationWrapper.document;
import static com.epages.restdocs.apispec.MockMvcRestDocumentationWrapper.resourceDetails;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(HelloWorldController.class)
@AutoConfigureRestDocs(outputDir = "target/restdoc/snippets")
class HelloWorldControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private HelloWorldController helloWorldController;

    @Test
    public void helloWorldTest() throws Exception {

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("data", "Hello World");

        Mockito.when(helloWorldController.helloWorld())
                .thenReturn(ResponseEntity.ok(resultMap));

        this.mockMvc.perform(RestDocumentationRequestBuilders.get("/"))
                .andDo(print())
                .andExpect(status().isOk())
                .andDo(document(
                                "helloWorld",
                                resourceDetails().description("hello world description"),
                                responseFields(
                                        fieldWithPath("data").description("hello world string")
                                )
                        )
                );
    }
}