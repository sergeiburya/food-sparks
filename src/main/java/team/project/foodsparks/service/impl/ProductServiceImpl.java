package team.project.foodsparks.service.impl;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.project.foodsparks.model.Ingredient;
import team.project.foodsparks.model.Product;
import team.project.foodsparks.model.Warehouse;
import team.project.foodsparks.repository.ProductRepository;
import team.project.foodsparks.service.ProductService;
import team.project.foodsparks.service.WarehouseService;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final WarehouseService warehouseService;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository,
                              WarehouseService warehouseService) {
        this.productRepository = productRepository;
        this.warehouseService = warehouseService;
    }

    @Transactional
    @Override
    public Product add(Product product) {
        Product savedProduct = productRepository.save(product);
        Warehouse warehouse = new Warehouse();
        warehouse.setProduct(savedProduct);
        warehouse.setAmount(0);
        warehouseService.add(warehouse);
        return savedProduct;
    }

    @Override
    public Optional<Product> getById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> getByIngredientTag(Ingredient ingredient) {
        return productRepository.findProductByIngredientTagContains(ingredient);
    }
}
