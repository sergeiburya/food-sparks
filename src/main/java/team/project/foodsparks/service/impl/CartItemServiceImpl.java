package team.project.foodsparks.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.project.foodsparks.model.CartItem;
import team.project.foodsparks.repository.CartItemRepository;
import team.project.foodsparks.service.CartItemService;

@Service
public class CartItemServiceImpl implements CartItemService {
    private final CartItemRepository cartItemRepository;

    @Autowired
    public CartItemServiceImpl(CartItemRepository cartItemRepository) {
        this.cartItemRepository = cartItemRepository;
    }

    @Override
    public void delete(CartItem cartItem) {
        cartItemRepository.delete(cartItem);
    }
}
