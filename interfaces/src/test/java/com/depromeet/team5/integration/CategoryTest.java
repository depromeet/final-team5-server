package com.depromeet.team5.integration;

import com.depromeet.team5.Team5InterfacesApplication;
import com.depromeet.team5.dto.StoresGroupByDistanceDto;
import com.depromeet.team5.dto.LoginResponse;
import com.depromeet.team5.integration.api.CategoryTestController;
import com.depromeet.team5.integration.api.UserTestController;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("NonAsciiCharacters")
@Transactional
@SpringBootTest(classes = Team5InterfacesApplication.class)
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
class CategoryTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    private UserTestController userTestController;
    private CategoryTestController categoryTestController;

    @BeforeEach
    void setUp() {
        userTestController = new UserTestController(mockMvc, objectMapper);
        categoryTestController = new CategoryTestController(mockMvc, objectMapper);
    }

    @Test
    void enum_소문자로_입력해도_성공() throws Exception {
        // given
        LoginResponse loginResponse = userTestController.createTestUser();
        String accessToken = loginResponse.getToken();
        Long userId = loginResponse.getUserId();
        // when
        StoresGroupByDistanceDto storesGroupByDistanceDto =
                categoryTestController.getDistanceAll(accessToken, 37.0, 127.0, "bungeoppang");
        // then
        assertThat(storesGroupByDistanceDto).isNotNull();
    }
}
