package pl.maciej.kitchenmanager.service;

import org.springframework.context.annotation.Configuration;
import pl.maciej.kitchenmanager.entity.Expenditure;
import pl.maciej.kitchenmanager.entity.Income;
import pl.maciej.kitchenmanager.entity.Product;
import pl.maciej.kitchenmanager.repository.ExpenditureRepository;
import pl.maciej.kitchenmanager.repository.IncomeRepository;
import pl.maciej.kitchenmanager.repository.ProductRepository;

import java.util.List;

@Configuration
public class ProductService {

    private final ProductRepository productRepository;
    private final IncomeRepository incomeRepository;
    private final ExpenditureRepository expenditureRepository;

    public ProductService(ProductRepository productRepository, IncomeRepository incomeRepository, ExpenditureRepository expenditureRepository) {
        this.productRepository = productRepository;
        this.incomeRepository = incomeRepository;
        this.expenditureRepository = expenditureRepository;
    }

    public Product findById(Long id) {
        return productRepository.findById(id).get();
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public List<Product> findByType(String type) {
        return productRepository.findAllByType(type);
    }

    public void addProduct(Product product) {
        productRepository.save(product);
    }

    public void editPrice(String id, String price) {
        Long productId = Long.parseLong(id);
        double productPrice = Double.parseDouble(price);

        Product product = productRepository.getById(productId);
        product.setPrice(productPrice);
        productRepository.save(product);

        List<Income> incomeList = incomeRepository.findAllByProduct_Id(productId);
        for (Income income :
                incomeList) {
            income.setValue(Math.round(productPrice * income.getQuantity() * 100d) / 100d);
            incomeRepository.save(income);
        }
        List<Expenditure> expenditureList = expenditureRepository.findAllByProduct_Id(productId);

        for (Expenditure expenditure :
                expenditureList) {
            expenditure.setValue(Math.round(productPrice * expenditure.getQuantity() * 100d) / 100d);
            expenditureRepository.save(expenditure);
        }

    }


}
