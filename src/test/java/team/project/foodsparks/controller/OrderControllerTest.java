package team.project.foodsparks.controller;

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
import team.project.foodsparks.model.Order;
import team.project.foodsparks.model.Product;
import team.project.foodsparks.model.ShoppingCart;
import team.project.foodsparks.model.User;
import team.project.foodsparks.service.OrderService;
import team.project.foodsparks.service.ShoppingCartService;
import team.project.foodsparks.service.UserService;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.entry;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class OrderControllerTest {

    @MockBean
    private OrderService orderService;

    @MockBean
    private UserService userService;
    @MockBean
    private ShoppingCartService shoppingCartService;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        RestAssuredMockMvc.mockMvc(mockMvc);
    }

    @Test
    @WithMockUser(username = "alice@user.com", roles = {"ADMIN"})
    void shouldReturnCompleteOrder() throws Exception {
        String email = "alice@user.com";
        User alice = new User();
        alice.setId(11L);
        alice.setEmail(email);
        alice.setFirstName("Alice");
        Order aliceOrder = new Order();
        aliceOrder.setId(23L);
        aliceOrder.setUser(alice);
        aliceOrder.setOrderTime(LocalDateTime.of(2023, 4, 12, 15, 45));
        Product cheeseProduct = new Product();
        cheeseProduct.setId(1L);
        cheeseProduct.setName("Cheese");
        cheeseProduct.setPrice(BigDecimal.valueOf(25));
        Map<Product, Integer> products = Map.ofEntries(entry(cheeseProduct, 100));
        aliceOrder.setProductAmount(products);
        ShoppingCart aliceShoppingCard = new ShoppingCart();
        aliceShoppingCard.setUser(alice);
        aliceShoppingCard.setProductAmount(products);
        aliceShoppingCard.setId(22L);

        Mockito.when(userService.findByEmail(email)).thenReturn(Optional.of(alice));
        Mockito.when(orderService.completeOrder(aliceShoppingCard)).thenReturn(aliceOrder);
        Mockito.when(shoppingCartService.getByUser(alice)).thenReturn(aliceShoppingCard);

        UserPrincipal userPrincipal = new UserPrincipal(alice.getEmail());
        Authentication authentication = Mockito.mock(Authentication.class);
        Mockito.when(authentication.getPrincipal()).thenReturn(userPrincipal);

        mockMvc.perform(MockMvcRequestBuilders.post("/orders/complete?email=" + email)
                        .principal(authentication))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(23))
                .andExpect(MockMvcResultMatchers.jsonPath("$.userId").value(11))
                .andExpect(MockMvcResultMatchers.jsonPath("$.orderTime")
                        .value("2023-04-12T15:45:00"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.productAmount.Cheese").value(100));
    }

    @Test
    @WithMockUser(username = "alice@user.com", roles = {"ADMIN"})
    void shouldReturnAllOrdersByUser() throws Exception {
        String email = "alice@user.com";
        User alice = new User();
        alice.setId(22L);
        alice.setEmail(email);
        alice.setFirstName("Alice");
        Order aliceOrder = new Order();
        aliceOrder.setId(11L);
        aliceOrder.setUser(alice);
        aliceOrder.setOrderTime(LocalDateTime.of(2023, 5, 9, 9, 5));
        Product coffeeProduct = new Product();
        coffeeProduct.setId(1L);
        coffeeProduct.setName("Coffee");
        coffeeProduct.setPrice(BigDecimal.valueOf(125));
        Map<Product, Integer> products = Map.ofEntries(entry(coffeeProduct, 20));
        aliceOrder.setProductAmount(products);

        List<Order> mockOrders = new ArrayList<>();
        mockOrders.add(aliceOrder);

        Mockito.when(userService.findByEmail(email)).thenReturn(Optional.of(alice));
        Mockito.when(orderService.getOrders(alice)).thenReturn(mockOrders);

        UserPrincipal userPrincipal = new UserPrincipal(alice.getEmail());
        Authentication authentication = Mockito.mock(Authentication.class);
        Mockito.when(authentication.getPrincipal()).thenReturn(userPrincipal);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/orders?email=" + email)
                        .principal(authentication))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(11))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].userId").value(22))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].orderTime").value("2023-05-09T09:05:00"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].productAmount.Coffee").value(20));

    }
}
