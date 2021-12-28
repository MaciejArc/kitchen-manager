package pl.maciej.kitchenmanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.maciej.kitchenmanager.entity.Expenditure;
import pl.maciej.kitchenmanager.entity.Income;
import pl.maciej.kitchenmanager.entity.Product;
import pl.maciej.kitchenmanager.repository.ExpenditureRepository;
import pl.maciej.kitchenmanager.repository.ProductRepository;

@Controller
public class ExpenditureController {

    private final ExpenditureRepository expenditureRepository;
    private final ProductRepository productRepository;

    public ExpenditureController(ExpenditureRepository expenditureRepository, ProductRepository productRepository) {
        this.expenditureRepository = expenditureRepository;
        this.productRepository = productRepository;
    }

    @GetMapping("/expenditure/add")
    public String expenditureAdd(Model model){
        model.addAttribute("expenditure",new Expenditure());
        model.addAttribute("products", productRepository.findAll());

        return "expenditure/addExpenditure";

    }
    @PostMapping("/expenditure/add")
    public String expenditureAddPost(Expenditure expenditure){
        Product product = expenditure.getProduct();
        double price = product.getPrice();
        expenditure.setValue(Math.round(price*expenditure.getQuantity() *100.0)/100.0);
        product.setStock(product.getStock()-expenditure.getQuantity());
        expenditureRepository.save(expenditure);
        productRepository.save(product);


        return "expenditure/addExpenditure";

    }
}
