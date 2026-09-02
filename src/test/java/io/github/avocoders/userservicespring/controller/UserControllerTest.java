package io.github.avocoders.userservicespring.controller;

import io.github.avocoders.userservicespring.dto.UserResponse;
import io.github.avocoders.userservicespring.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


@WebMvcTest(UserController.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private UserService userService;

    @Test
    void getById_shouldReturnUser_whenUserExists() throws Exception {
        LocalDateTime createdAt = LocalDateTime.of(2026, 9, 2, 12, 0);
        UserResponse response = new UserResponse(
                1L,
                "Anna",
                "anna@ya.ru",
                20,
                createdAt
        );

        when(userService.getById(1L)).thenReturn(response);
        mockMvc.perform(get("/api/users/{id}", 1L))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("Anna"))
                .andExpect(jsonPath("$.email").value("anna@ya.ru"))
                .andExpect(jsonPath("$.age").value(20))
                .andExpect(jsonPath("$.createdAt").exists());

    }

}