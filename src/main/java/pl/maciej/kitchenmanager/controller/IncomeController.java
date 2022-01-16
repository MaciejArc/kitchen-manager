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

    @GetMapping("/income/add")
    public String incomeAdd(Model model, @RequestParam(value = "type") String type){
        model.addAttribute("income",new Income());
        model.addAttribute("products", productService.findByType(type));
        model.addAttribute("incomeToday", incomeService.incomesToday());

        return "income/addIncome";

    }
    @PostMapping("/income/add")
    public String incomeAddPost(Income income, HttpServletResponse response,HttpServletRequest request){
        Product product = income.getProduct();
        double price = product.getPrice();
        income.setValue(Math.round(price*income.getQuantity() *100.0)/100.0);
        product.setStock(product.getStock()+income.getQuantity());
        incomeRepository.save(income);
        productRepository.save(product);
        String type = income.getProduct().getType();
        String productId = String.valueOf(product.getId());
        Cookie[] cookies = request.getCookies();
        for (Cookie cookieProduct:
             cookies) {
            if(cookieProduct.getName().equals("product")){
                cookieProduct.setValue(productId);
            }else {
                Cookie cookie = new Cookie("product",productId);
                cookie.setMaxAge(3600*5);
                cookie.setPath("/");
                response.addCookie(cookie);
            }
        }



return "redirect:/expenditure/addV2";
       // return "redirect:/income/add?type="+type;

    }
    @GetMapping("/income/selectType")
    public String incomeSelectType(){
        return "income/selectType";

    }

    @GetMapping("/income/delete")
    public String incomeDelete(@RequestParam(value = "id") String id){
        incomeService.deleteIncome(id);
        return "redirect:/income/selectType";
    }

}
