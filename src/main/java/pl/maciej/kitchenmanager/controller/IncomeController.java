package pl.maciej.kitchenmanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.maciej.kitchenmanager.entity.Income;
import pl.maciej.kitchenmanager.entity.Product;
import pl.maciej.kitchenmanager.repository.IncomeRepository;
import pl.maciej.kitchenmanager.repository.ProductRepository;
import pl.maciej.kitchenmanager.service.IncomeService;
import pl.maciej.kitchenmanager.service.ProductService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class IncomeController {
    private final ProductRepository productRepository;
    private final IncomeRepository incomeRepository;
    private final ProductService productService;
    private final IncomeService incomeService;

    public IncomeController(ProductRepository productRepository, IncomeRepository incomeRepository, ProductService productService, IncomeService incomeService) {
        this.productRepository = productRepository;
        this.incomeRepository = incomeRepository;
        this.productService = productService;
        this.incomeService = incomeService;
    }

    @GetMapping("/income/selectType")
    public String incomeSelectType() {
        return "income/selectType";

    }

    @GetMapping("/income/add")
    public String incomeAdd(Model model, @RequestParam(value = "type") String type, HttpServletResponse response) {
        model.addAttribute("income", new Income());
        model.addAttribute("products", productService.findByType(type));
        model.addAttribute("incomeToday", incomeService.incomesToday());

        Cookie cookie = new Cookie("product", "0");
        cookie.setPath("/");
        cookie.setMaxAge(3600);
        response.addCookie(cookie);

        return "income/addIncome";

    }

    @PostMapping("/income/add")
    public String incomeAddPost(Income income, HttpServletRequest request,HttpServletResponse response) {
        incomeService.addIncome(income);

        Product product = income.getProduct();
        String productId = String.valueOf(product.getId());

        Cookie[] cookies = request.getCookies();
        for (Cookie cookieProduct :
                cookies) {
            if (cookieProduct.getName().equals("product")) {
                cookieProduct.setValue(productId);
                cookieProduct.setPath("/");
                response.addCookie(cookieProduct);
            }
        }


        return "redirect:/expenditure/add";

    }


    @GetMapping("/income/delete")
    public String incomeDelete(@RequestParam(value = "id") String id) {
        incomeService.deleteIncome(id);
        return "redirect:/income/selectType";
    }

}
