package com.example.docker.controller;

import com.example.docker.common.BaseTestConfiguration;
import com.example.docker.dto.Member;
import com.example.docker.dto.Result;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders;

import static com.epages.restdocs.apispec.MockMvcRestDocumentationWrapper.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


class MemberControllerTest extends BaseTestConfiguration {

    @Test
    @DisplayName("멤버 조회 API")
    public void getMemberTest() throws Exception {

        int testMember = 1113456;
        Mockito.when(memberController.getMember(testMember))
                .thenReturn(ResponseEntity.ok(Member.builder()
                        .name("홍길동")
                        .age(35)
                        .dept("개발팀")
                        .build()));

        this.mockMvc.perform(RestDocumentationRequestBuilders.get("/api/v1.0/member/{memberNo}", testMember))
                .andDo(print())
                .andExpect(status().isOk())
                .andDo(document(
                                "사용자 조회",
                                pathParameters(
                                        parameterWithName("memberNo").description("사용자 고유 번호")
                                ),
                                responseFields(
                                        fieldWithPath("name").description("사용자 이름"),
                                        fieldWithPath("age").description("사용자 나이"),
                                        fieldWithPath("dept").description("사용자 소속 부서")
                                )
                        )
                );
    }

    @Test
    @DisplayName("멤버 저장 API")
    public void setMemberTest() throws Exception {

        Member mockMember = Member.builder()
                .name("홍길동")
                .age(35)
                .dept("개발팀")
                .build();

        Mockito.when(memberController.setMember(mockMember))
                .thenReturn(ResponseEntity.ok(Result.builder()
                        .code(0)
                        .description("success")
                        .build()));

        this.mockMvc.perform(RestDocumentationRequestBuilders.post("/api/v1.0/member")
                        .content(mapper.writeValueAsString(mockMember))
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andDo(document(
                                "사용자 저장",
                                requestFields(
                                        fieldWithPath("name").description("사용자 이름"),
                                        fieldWithPath("age").description("사용자 나이"),
                                        fieldWithPath("dept").description("사용자 소속 부서")
                                ),
                                responseFields(
                                        fieldWithPath("code").description("결과코드"),
                                        fieldWithPath("description").description("코드 결과 설명")
                                )
                        )
                );
    }
}