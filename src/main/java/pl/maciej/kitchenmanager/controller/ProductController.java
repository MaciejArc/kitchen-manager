package pl.maciej.kitchenmanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.maciej.kitchenmanager.entity.Expenditure;
import pl.maciej.kitchenmanager.entity.Income;
import pl.maciej.kitchenmanager.entity.Product;
import pl.maciej.kitchenmanager.repository.ExpenditureRepository;
import pl.maciej.kitchenmanager.repository.IncomeRepository;
import pl.maciej.kitchenmanager.repository.ProductRepository;
import pl.maciej.kitchenmanager.service.ExpenditureService;
import pl.maciej.kitchenmanager.service.IncomeService;
import pl.maciej.kitchenmanager.service.ProductService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductController {

    private final ProductRepository productRepository;
    private final IncomeRepository incomeRepository;
    private final ExpenditureRepository expenditureRepository;

    private final ProductService productService;
    private final IncomeService incomeService;
    private final ExpenditureService expenditureService;

    public ProductController(ProductRepository productRepository, IncomeRepository incomeRepository, ExpenditureRepository expenditureRepository, ProductService productService, IncomeService incomeService, ExpenditureService expenditureService) {
        this.productRepository = productRepository;
        this.incomeRepository = incomeRepository;
        this.expenditureRepository = expenditureRepository;
        this.productService = productService;
        this.incomeService = incomeService;
        this.expenditureService = expenditureService;
    }

    @GetMapping("/product/add")
    public String addProduct(Model model) {
        model.addAttribute("product", new Product());

        return "product/addProduct";
    }

    @PostMapping("/product/add")
    public String addProductPost(Product product) {
        productRepository.save(product);
        return "product/addProduct";
    }

    @GetMapping("/product/card")
    public String productCard(Model model, @RequestParam(value = "id") String request) {

        if (request.isEmpty()) {
            model.addAttribute("products", productRepository.findAll());
            return "product/selectProduct";
        } else {
            Long id = Long.parseLong(request);
            List<Expenditure> expenditureList = expenditureService.findAllByProductId(id);
            List<Income> incomeList = incomeService.findAllByProductId(id);
            model.addAttribute("product", productService.findById(id));

            model.addAttribute("incomeQuantityAndValue", incomeService.SumOfQuantityAndValue(incomeList));
            model.addAttribute("expenditureQuantityAndValue", expenditureService.SumOfQuantityAndValue(expenditureList));

            model.addAttribute("incomeList", incomeList);
            model.addAttribute("expenditureList", expenditureList);
            return "product/productCard";
        }


    }

    @GetMapping("/test")
    public String test(Model model) {


        List<Expenditure> expenditureList = expenditureService.findAllByProductId(3L);
        List<Income> incomeList = incomeService.findAllByProductId(3L);

        model.addAttribute("incomeQuantityAndValue", incomeService.SumOfQuantityAndValue(incomeList));


        model.addAttribute("expenditureQuantityAndValue", expenditureService.SumOfQuantityAndValue(expenditureList));

        model.addAttribute("incomeList", incomeList);
        model.addAttribute("expenditureList", expenditureList);
        return "product/test";
    }

}
