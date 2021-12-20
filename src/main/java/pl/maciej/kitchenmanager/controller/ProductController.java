package pl.maciej.kitchenmanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.maciej.kitchenmanager.entity.Product;
import pl.maciej.kitchenmanager.repository.ProductRepository;

@Controller
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/product/add")
    public String addProduct(Model model){
        model.addAttribute("product",new Product());

        return "product/addProduct";
    }
    @PostMapping("/product/add")
    public String addProductPost(Product product){
        productRepository.save(product);
        return "product/addProduct";
    }
}
