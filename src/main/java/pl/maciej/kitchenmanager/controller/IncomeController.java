package pl.maciej.kitchenmanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.maciej.kitchenmanager.entity.Income;
import pl.maciej.kitchenmanager.entity.Product;
import pl.maciej.kitchenmanager.repository.IncomeRepository;
import pl.maciej.kitchenmanager.repository.ProductRepository;

@Controller
public class IncomeController {
    private final ProductRepository productRepository;
    private final IncomeRepository incomeRepository;

    public IncomeController(ProductRepository productRepository, IncomeRepository incomeRepository) {
        this.productRepository = productRepository;
        this.incomeRepository = incomeRepository;
    }

    @GetMapping("/income/add")
    public String incomeAdd(Model model){
        model.addAttribute("income",new Income());
        model.addAttribute("products", productRepository.findAll());

        return "income/addIncome";

    }
    @PostMapping("/income/add")
    public String incomeAddPost(Income income){
        Product product = income.getProduct();
        double price = product.getPrice();
        income.setValue(Math.round(price*income.getQuantity() *100.0)/100.0);
        product.setStock(product.getStock()+income.getQuantity());
        incomeRepository.save(income);
        productRepository.save(product);


        return "income/addIncome";

    }

}
