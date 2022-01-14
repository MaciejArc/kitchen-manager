package pl.maciej.kitchenmanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.maciej.kitchenmanager.entity.Expenditure;
import pl.maciej.kitchenmanager.entity.Product;
import pl.maciej.kitchenmanager.repository.ExpenditureRepository;
import pl.maciej.kitchenmanager.repository.ProductRepository;
import pl.maciej.kitchenmanager.service.ExpenditureService;
import pl.maciej.kitchenmanager.service.ProductService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ExpenditureController {

    private final ExpenditureRepository expenditureRepository;
    private final ProductRepository productRepository;
    private final ExpenditureService expenditureService;
    private final ProductService productService;

    public ExpenditureController(ExpenditureRepository expenditureRepository, ProductRepository productRepository, ExpenditureService expenditureService, ProductService productService) {
        this.expenditureRepository = expenditureRepository;
        this.productRepository = productRepository;
        this.expenditureService = expenditureService;
        this.productService = productService;
    }

    @GetMapping("/expenditure/addV2")
    public String expenditureAddV2(Model model, HttpServletRequest request) {

        Cookie[] cookies = request.getCookies();
        Long cookieId = 0L;
        for (Cookie cookie :
                cookies) {
            if (cookie.getName().equals("product")) {
                cookieId = Long.parseLong(cookie.getValue());
            }
        }
        model.addAttribute("expenditure", new Expenditure());
        model.addAttribute("productName", productService.findById(cookieId).getName());
        model.addAttribute("expToday", expenditureService.ExpenditureToday());

        Product product = productService.findById(cookieId);
        model.addAttribute("type", product.getType());
        return "expenditure/addExpenditureV2";
    }

    @PostMapping("/expenditure/addV2")
    public String expenditureAddV2(Expenditure expenditure, Model model, HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        Long cookieId = 0L;
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("product")) {
                cookieId = Long.parseLong(cookie.getValue());
            }
        }

        Product product = productService.findById(cookieId);
        expenditureService.addExpenditure(expenditure, product);

        model.addAttribute("expToday", expenditureService.ExpenditureToday());

        return "redirect:/expenditure/addV2";
    }

//    @GetMapping("/expenditure/add")
//    public String expenditureAdd(Model model, HttpServletRequest request) {
//        model.addAttribute("expenditure", new Expenditure());
//        model.addAttribute("products", productRepository.findAll());
//        model.addAttribute("expToday", expenditureService.ExpenditureToday());
//
//
//        return "expenditure/addExpenditure";
//
//    }
//
//    @PostMapping("/expenditure/add")
//    public String expenditureAddPost(Expenditure expenditure, Model model) {
//        //   model.addAttribute("products", productRepository.findAll());
//        Product product = expenditure.getProduct();
//        double price = product.getPrice();
//        expenditure.setValue(Math.round(price * expenditure.getQuantity() * 100.0) / 100.0);
//        product.setStock(product.getStock() - expenditure.getQuantity());
//        expenditureRepository.save(expenditure);
//        productRepository.save(product);
////        List<Expenditure> expenditureList = new ArrayList<>();
//        model.addAttribute("expToday", expenditureService.ExpenditureToday());
//
//
//        return "redirect:/expenditure/add";
//
//    }

    @GetMapping("/expenditure/edit")
    public String expenditureEdit(Model model, @RequestParam(value = "id") String id){

        model.addAttribute("expenditure",expenditureService.getExpenditure(id));
        Product product = expenditureService.getExpenditure(id).getProduct();
        model.addAttribute("type", product.getType());
        model.addAttribute("productName", expenditureService.getExpenditure(id).getProduct().getName());
        return "expenditure/editExpenditure";
    }
    @PostMapping("/expenditure/edit")
    public String expenditureEditPost(Expenditure expenditure){

        String purpose = expenditure.getPurpose();
        double quantity = expenditure.getQuantity();
        expenditureService.editExpenditure(expenditure,purpose,quantity);

        return "redirect:/expenditure/addV2";
    }
}
