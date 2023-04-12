package team.project.foodsparks.controller;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import com.sun.security.auth.UserPrincipal;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.Authentication;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import team.project.foodsparks.model.Product;
import team.project.foodsparks.model.Role;
import team.project.foodsparks.model.ShoppingCart;
import team.project.foodsparks.model.User;
import team.project.foodsparks.service.ShoppingCartService;
import team.project.foodsparks.service.UserService;

import static org.assertj.core.api.AssertionsForClassTypes.entry;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class ShoppingCartControllerTest {

    @MockBean
    private ShoppingCartService shoppingCartService;

    @MockBean
    private UserService userService;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        RestAssuredMockMvc.mockMvc(mockMvc);
    }

    @Test
    @WithMockUser(username = "bob@user.com", roles = {"ADMIN"})
    void shouldReturnShoppingCardByUser() throws Exception {
        String email = "bob@user.com";
        Role bobRole = new Role();
        bobRole.setRoleName(Role.RoleName.ADMIN);
        bobRole.setId(1L);
        User bob = new User();
        bob.setId(5L);
        bob.setFirstName("Bob");
        bob.setLastName("Rock");
        bob.setEmail(email);
        bob.setRoles(Set.of(bobRole));
        ShoppingCart bobShopCard = new ShoppingCart();
        bobShopCard.setId(2L);
        bobShopCard.setUser(bob);
        Product product1 = new Product();
        product1.setId(22L);
        product1.setName("Wood");
        product1.setPrice(BigDecimal.valueOf(45));
        Map<Product, Integer> bobProduct = Map.ofEntries(entry(product1, 5));
        bobShopCard.setProductAmount(bobProduct);

        Mockito.when(userService.findByEmail(email)).thenReturn(Optional.of(bob));
        Mockito.when(shoppingCartService.getByUser(bob)).thenReturn(bobShopCard);

        UserPrincipal userPrincipal = new UserPrincipal(bob.getEmail());
        Authentication authentication = Mockito.mock(Authentication.class);
        Mockito.when(authentication.getPrincipal()).thenReturn(userPrincipal);

        mockMvc.perform(MockMvcRequestBuilders.get("/shopping-cart?email=" + email)
                        .principal(authentication))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.userId").value(5))
                .andExpect(MockMvcResultMatchers.jsonPath("$.productAmount.Wood").value(5))
                .andExpect(MockMvcResultMatchers.jsonPath("$.sum").value(225));
    }

    @Test
    @WithMockUser(username = "bob@user.com", roles = {"ADMIN"})
    void shouldReturnShoppingCardWithProduct() throws Exception {
        String email = "bob@user.com";
        Role bobRole = new Role();
        bobRole.setRoleName(Role.RoleName.ADMIN);
        bobRole.setId(2L);
        User bob = new User();
        bob.setId(7L);
        bob.setFirstName("Bob");
        bob.setLastName("Rock");
        bob.setEmail(email);
        bob.setRoles(Set.of(bobRole));
        ShoppingCart bobShopCard = new ShoppingCart();
        bobShopCard.setId(5L);
        bobShopCard.setUser(bob);
        Product bread = new Product();
        bread.setId(58L);
        bread.setName("Bread");
        bread.setPrice(BigDecimal.valueOf(24));
        Map<Product, Integer> bobProduct = Map.ofEntries(entry(bread, 2));
        bobShopCard.setProductAmount(bobProduct);

        Mockito.when(userService.findByEmail(email)).thenReturn(Optional.of(bob));
        Mockito.when(shoppingCartService.addProduct(bread.getId(), 2, bob)).thenReturn(bobShopCard);

        UserPrincipal userPrincipal = new UserPrincipal(bob.getEmail());
        Authentication authentication = Mockito.mock(Authentication.class);
        Mockito.when(authentication.getPrincipal()).thenReturn(userPrincipal);

        mockMvc.perform(MockMvcRequestBuilders.put("/shopping-cart/add?email=" + email)
                        .contentType("application/json")
                        .param("productId", "58")
                        .param("quantity", "2")
                        .principal(authentication))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.userId").value(7))
                .andExpect(MockMvcResultMatchers.jsonPath("$.productAmount.Bread").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$.sum").value(48));
    }
}
