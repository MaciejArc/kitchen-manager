package pl.maciej.kitchenmanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.maciej.kitchenmanager.entity.Expenditure;
import pl.maciej.kitchenmanager.entity.Product;
import pl.maciej.kitchenmanager.repository.ExpenditureRepository;
import pl.maciej.kitchenmanager.repository.ProductRepository;
import pl.maciej.kitchenmanager.service.ExpenditureService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ExpenditureController {

    private final ExpenditureRepository expenditureRepository;
    private final ProductRepository productRepository;
    private final ExpenditureService expenditureService;

    public ExpenditureController(ExpenditureRepository expenditureRepository, ProductRepository productRepository, ExpenditureService expenditureService) {
        this.expenditureRepository = expenditureRepository;
        this.productRepository = productRepository;
        this.expenditureService = expenditureService;
    }

    @GetMapping("/expenditure/add")
    public String expenditureAdd(Model model){
        model.addAttribute("expenditure",new Expenditure());
        model.addAttribute("products", productRepository.findAll());
model.addAttribute("expToday",expenditureService.ExpenditureToday());

        return "expenditure/addExpenditure";

    }
    @PostMapping("/expenditure/add")
    public String expenditureAddPost(Expenditure expenditure,Model model){
     //   model.addAttribute("products", productRepository.findAll());
        Product product = expenditure.getProduct();
        double price = product.getPrice();
        expenditure.setValue(Math.round(price*expenditure.getQuantity() *100.0)/100.0);
        product.setStock(product.getStock()-expenditure.getQuantity());
        expenditureRepository.save(expenditure);
        productRepository.save(product);
//        List<Expenditure> expenditureList = new ArrayList<>();
model.addAttribute("expToday",expenditureService.ExpenditureToday());


        return "redirect:/expenditure/add";

    }
}
