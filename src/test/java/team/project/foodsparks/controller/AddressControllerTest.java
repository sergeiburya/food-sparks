//package team.project.foodsparks.controller;
//
//import java.util.Optional;
//import java.util.Set;
//import com.sun.security.auth.UserPrincipal;
//import io.restassured.module.mockmvc.RestAssuredMockMvc;
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
//import team.project.foodsparks.model.Address;
//import team.project.foodsparks.model.Role;
//import team.project.foodsparks.model.User;
//import team.project.foodsparks.service.AddressService;
//import team.project.foodsparks.service.UserService;
//
//@ExtendWith(SpringExtension.class)
//@SpringBootTest
//@AutoConfigureMockMvc
//class AddressControllerTest {
//
//    @MockBean
//    private AddressService addressService;
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
//    @WithMockUser(username = "bob@user.com", roles = {"ADMIN"})
//    void shouldReturnAddUserAddress() throws Exception {
//        String email = "bob@user.com";
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
//        String requestBody = "{ \"id\":1,\"region\": \"Poltava\", \"town\": \"Poltava\", \"street\": \"Soborna\", \"build\":\"25\", \"apartment\":2}";
//
//        mockMvc.perform(MockMvcRequestBuilders.post("/address/add?email=" + email)
//                        .contentType("application/json")
//                        .content(requestBody)
//                        .principal(authentication))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.region").value("Poltava"))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.town").value("Poltava"))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.street").value("Soborna"));
//    }
//
//    @Test
//    @WithMockUser(username = "alice@user.com", roles = {"ADMIN"})
//    void shouldReturnUpdateUserAddress() throws Exception {
//        String email = "alice@user.com";
//        Role role = new Role();
//        role.setRoleName(Role.RoleName.ADMIN);
//        role.setId(1L);
//        User user = new User();
//        user.setId(1L);
//        user.setEmail(email);
//        user.setRoles(Set.of(role));
//        Address aliceAddress = new Address();
//        aliceAddress.setRegion("Lviv");
//        aliceAddress.setTown("Lviv");
//        aliceAddress.setUser(user);
//        Mockito.when(userService.findByEmail(email)).thenReturn(Optional.of(user));
//        Mockito.when(addressService.findByUser(user)).thenReturn(Optional.of(aliceAddress));
//
//        UserPrincipal userPrincipal = new UserPrincipal(user.getEmail());
//        Authentication authentication = Mockito.mock(Authentication.class);
//        Mockito.when(authentication.getPrincipal()).thenReturn(userPrincipal);
//
//        String requestBody = "{ \"id\":1,\"region\": \"Poltava\", \"town\": \"Poltava\", \"street\": \"Soborna\", \"build\":\"25\", \"apartment\":2}";
//
//        mockMvc.perform(MockMvcRequestBuilders.put("/address/update-address-user?email=" + email)
//                        .contentType("application/json")
//                        .content(requestBody)
//                        .principal(authentication))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.region").value("Poltava"))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.town").value("Poltava"))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.street").value("Soborna"));
//
//    }
//
//    @Test
//    @WithMockUser(username = "bob@user.com", roles = {"ADMIN"})
//    void shouldReturnAddressByUser() throws Exception {
//        String email = "bob@user.com";
//        User bob = new User();
//        bob.setId(22L);
//        bob.setFirstName("Bob");
//        bob.setLastName("Rock");
//        bob.setEmail(email);
//        Address bobAddress = new Address();
//        bobAddress.setId(11L);
//        bobAddress.setRegion("Lviv");
//        bobAddress.setTown("Dubno");
//        bobAddress.setUser(bob);
//
//        Mockito.when(userService.findByEmail(email)).thenReturn(Optional.of(bob));
//        Mockito.when(addressService.findByUser(bob)).thenReturn(Optional.of(bobAddress));
//
//        UserPrincipal userPrincipal = new UserPrincipal(bob.getEmail());
//        Authentication authentication = Mockito.mock(Authentication.class);
//        Mockito.when(authentication.getPrincipal()).thenReturn(userPrincipal);
//
//
//        mockMvc.perform(MockMvcRequestBuilders
//                        .get("/address/by-user?email=" + email)
//                        .principal(authentication))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.region").value("Lviv"))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.town").value("Dubno"));
//    }
//
//    @Test
//    @WithMockUser(username = "bob@user.com", roles = {"ADMIN"})
//    void shouldDeleteUserByEmail() throws Exception {
//        String email = "bob@user.com";
//        User bob = new User();
//        bob.setId(22L);
//        bob.setFirstName("Bob");
//        bob.setLastName("Rock");
//        bob.setEmail(email);
//        Address bobAddress = new Address();
//        bobAddress.setId(33L);
//        bobAddress.setRegion("Zhitomyr");
//        bobAddress.setTown("Berdychiv");
//        bobAddress.setUser(bob);
//
//        Mockito.when(userService.findByEmail(email)).thenReturn(Optional.of(bob));
//        Mockito.when(addressService.findByUser(bob)).thenReturn(Optional.of(bobAddress));
//
//        UserPrincipal userPrincipal = new UserPrincipal(bob.getEmail());
//        Authentication authentication = Mockito.mock(Authentication.class);
//        Mockito.when(authentication.getPrincipal()).thenReturn(userPrincipal);
//
//        mockMvc.perform(MockMvcRequestBuilders.delete("/address/delete?email=" + email)
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .principal(authentication))
//                .andExpect(MockMvcResultMatchers.status().isOk());
//
//        Mockito.verify(addressService, Mockito.times(1)).deleteByEmail(email);
//    }
//}
