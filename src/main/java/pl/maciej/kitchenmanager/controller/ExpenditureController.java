package pl.maciej.kitchenmanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.maciej.kitchenmanager.entity.Expenditure;
import pl.maciej.kitchenmanager.entity.Product;
import pl.maciej.kitchenmanager.service.ExpenditureService;
import pl.maciej.kitchenmanager.service.ProductService;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class ExpenditureController {

    private final ExpenditureService expenditureService;
    private final ProductService productService;

    public ExpenditureController(ExpenditureService expenditureService, ProductService productService) {
        this.expenditureService = expenditureService;
        this.productService = productService;
    }

    @GetMapping("/expenditure/add")
    public String expenditureAddV2(Model model, HttpServletRequest request) {

        Cookie[] cookies = request.getCookies();
        Long productId = 0L;
        for (Cookie cookie :
                cookies) {
            if (cookie.getName().equals("product")) {
                productId = Long.parseLong(cookie.getValue());
            }
        }
        model.addAttribute("expenditure", new Expenditure());
        model.addAttribute("productName", productService.findById(productId).getName());
        model.addAttribute("expToday", expenditureService.ExpenditureToday());

        Product product = productService.findById(productId);
        model.addAttribute("type", product.getType());
        return "expenditure/addExpenditure";
    }

    @PostMapping("/expenditure/add")
    public String expenditureAddV2(Expenditure expenditure, Model model, HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        Long productId = 0L;
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("product")) {
                productId = Long.parseLong(cookie.getValue());
            }
        }

        Product product = productService.findById(productId);
        expenditureService.addExpenditure(expenditure, product);

        model.addAttribute("expToday", expenditureService.ExpenditureToday());

        return "redirect:/expenditure/add";
    }

    @GetMapping("/expenditure/delete")
    public String expenditureDelete(@RequestParam(value = "id") String id){
        expenditureService.deleteExpenditure(id);
        return "redirect:/expenditure/addV2";



    }
}
