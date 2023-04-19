//package team.project.foodsparks.controller;
//
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//import java.util.Set;
//import com.sun.security.auth.UserPrincipal;
//import io.restassured.module.mockmvc.RestAssuredMockMvc;
//import org.hamcrest.Matchers;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.test.context.support.WithMockUser;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//import team.project.foodsparks.model.Gender;
//import team.project.foodsparks.model.Role;
//import team.project.foodsparks.model.User;
//import team.project.foodsparks.service.UserService;
//
//import static io.restassured.module.mockmvc.RestAssuredMockMvc.when;
//
//@ExtendWith(SpringExtension.class)
//@SpringBootTest
//@AutoConfigureMockMvc
//class UserControllerTest {
//
//    @MockBean
//    private UserService userService;
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @BeforeEach
//    void setUp() {
//        RestAssuredMockMvc.mockMvc(mockMvc);
//    }
//
//    @Test
//    @WithMockUser(username = "user", roles = {"ADMIN"})
//    void shouldReturnAllUsers() {
//        Role bobRole = new Role();
//        bobRole.setRoleName(Role.RoleName.ADMIN);
//        bobRole.setId(1L);
//        User bob = new User();
//        bob.setId(22L);
//        bob.setFirstName("Bob");
//        bob.setLastName("Rock");
//        bob.setEmail("bob.rock@gmail.com");
//        bob.setEmailConfirmed(true);
//        bob.setBirthdate(LocalDate.of(1970, 11, 14));
//        bob.setRoles(Set.of(bobRole));
//
//        List<User> mockUsers = new ArrayList<>();
//        mockUsers.add(bob);
//
//        Mockito.when(userService.findAll()).thenReturn(mockUsers);
//        when()
//                .get("/user/all")
//                .then()
//                .statusCode(200).body("size()", Matchers.equalTo(1))
//                .body("[0].id", Matchers.equalTo(22))
//                .body("[0].firstName", Matchers.equalTo("Bob"));
//    }
//
//    @Test
//    @WithMockUser(username = "test@test.com", roles = {"ADMIN"})
//    void shouldReturnUserByEmail() throws Exception {
//        String email = "test@test.com";
//        Role role = new Role();
//        role.setRoleName(Role.RoleName.ADMIN);
//        role.setId(1L);
//        User user = new User();
//        user.setEmail(email);
//        user.setRoles(Set.of(role));
//        Mockito.when(userService.findByEmail(email)).thenReturn(Optional.of(user));
//
//        UserPrincipal userPrincipal = new UserPrincipal(user.getEmail());
//        Authentication authentication = Mockito.mock(Authentication.class);
//        Mockito.when(authentication.getPrincipal()).thenReturn(userPrincipal);
//
//        mockMvc.perform(MockMvcRequestBuilders.get("/user/by-email?email=" + email)
//                        .principal(authentication))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.email").value(email));
//    }
//
//    @Test
//    @WithMockUser(username = "update@test.com", roles = {"ADMIN"})
//    void shouldReturnUpdateUserByEmail() throws Exception {
//        String email = "update@test.com";
//        Role role = new Role();
//        role.setRoleName(Role.RoleName.ADMIN);
//        role.setId(2L);
//        User user = new User();
//        user.setId(1L);
//        user.setEmail(email);
//        user.setRoles(Set.of(role));
//        Gender gender = new Gender();
//        gender.setId(1L);
//        gender.setGenderName(Gender.GenderName.MALE);
//        user.setGender(gender);
//        Mockito.when(userService.findByEmail(email)).thenReturn(Optional.of(user));
//
//        UserPrincipal userPrincipal = new UserPrincipal(user.getEmail());
//        Authentication authentication = Mockito.mock(Authentication.class);
//        Mockito.when(authentication.getPrincipal()).thenReturn(userPrincipal);
//
//        String requestBody = "{ \"id\":1,\"email\": \"update@test.com\", \"firstName\": \"John\", \"lastName\": \"Doe\", \"genderId\":1}";
//
//        mockMvc.perform(MockMvcRequestBuilders.put("/user/update?email=" + email)
//                        .contentType("application/json")
//                        .content(requestBody)
//                        .principal(authentication))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.email").value("update@test.com"))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.firstName").value("John"))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.lastName").value("Doe"));
//    }
//
//    @Test
//    @WithMockUser(username = "test@test.com", roles = {"ADMIN"})
//    void shouldDeleteUserByEmail() throws Exception {
//        String email = "test@test.com";
//        User user = new User();
//        user.setId(1L);
//        user.setEmail(email);
//        Mockito.when(userService.findByEmail(email)).thenReturn(Optional.of(user));
//
//        UserPrincipal userPrincipal = new UserPrincipal("test@test.com");
//        Authentication authentication = Mockito.mock(Authentication.class);
//        Mockito.when(authentication.getPrincipal()).thenReturn(userPrincipal);
//
//        mockMvc.perform(MockMvcRequestBuilders.delete("/user/delete?email=" + email)
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .principal(authentication))
//                .andExpect(MockMvcResultMatchers.status().isOk());
//
//        Mockito.verify(userService, Mockito.times(1)).deleteByEmail(email);
//    }
//}