package team.project.foodsparks.controller;

import java.util.ArrayList;
import java.util.List;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import team.project.foodsparks.model.Gender;
import team.project.foodsparks.service.GenderService;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class GenderControllerTest {

    @MockBean
    private GenderService genderService;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        RestAssuredMockMvc.mockMvc(mockMvc);
    }

    @Test
    @WithMockUser(username = "user", roles = {"ADMIN"})
    void shouldReturnThreeGenders() throws Exception {
        Gender maleGender = new Gender();
        maleGender.setId(1L);
        maleGender.setGenderName(Gender.GenderName.MALE);
        Gender femaleGender = new Gender();
        femaleGender.setId(2L);
        femaleGender.setGenderName(Gender.GenderName.FEMALE);
        Gender otherGender = new Gender();
        otherGender.setId(3L);
        otherGender.setGenderName(Gender.GenderName.OTHER);

        List<Gender> mockGenders = new ArrayList<>();
        mockGenders.add(maleGender);
        mockGenders.add(femaleGender);
        mockGenders.add(otherGender);

        Mockito.when(genderService.getAll()).thenReturn(mockGenders);
        when()
                .get("/gender")
                .then()
                .statusCode(200).body("size()", Matchers.equalTo(3))
                .body("[0].id", Matchers.equalTo(1))
                .body("[0].gender", Matchers.equalTo("MALE"))
                .body("[1].id", Matchers.equalTo(2))
                .body("[1].gender", Matchers.equalTo("FEMALE"))
                .body("[2].id", Matchers.equalTo(3))
                .body("[2].gender", Matchers.equalTo("OTHER"));
    }
}
