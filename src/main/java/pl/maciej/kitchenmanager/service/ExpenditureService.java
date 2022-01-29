package pl.maciej.kitchenmanager.service;

import org.springframework.context.annotation.Configuration;
import pl.maciej.kitchenmanager.entity.Expenditure;
import pl.maciej.kitchenmanager.entity.Income;
import pl.maciej.kitchenmanager.entity.Product;
import pl.maciej.kitchenmanager.repository.ExpenditureRepository;
import pl.maciej.kitchenmanager.repository.IncomeRepository;
import pl.maciej.kitchenmanager.repository.ProductRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Configuration
public class ExpenditureService {
    private final ProductRepository productRepository;
    private final IncomeRepository incomeRepository;
    private final ExpenditureRepository expenditureRepository;

    public ExpenditureService(ProductRepository productRepository, IncomeRepository incomeRepository, ExpenditureRepository expenditureRepository) {
        this.productRepository = productRepository;
        this.incomeRepository = incomeRepository;
        this.expenditureRepository = expenditureRepository;
    }

    public List<Expenditure> findAllByProductId(Long id) {
        return expenditureRepository.findAllByProduct_Id(id);
    }

    public List<Double> SumOfQuantityAndValue(List<Expenditure> list) {
        List<Double> sumOfQuantityAndValue = new ArrayList<>();
        double expenditureQuantity = 0d;
        double expenditureValue = 0d;
        for (Expenditure expenditure : list) {
            expenditureQuantity = expenditureQuantity + expenditure.getQuantity();
            expenditureValue = expenditureValue + expenditure.getValue();

        }
        expenditureValue = Math.round(expenditureValue * 100.0) / 100.0;
        sumOfQuantityAndValue.add(expenditureQuantity);
        sumOfQuantityAndValue.add(expenditureValue);
        return sumOfQuantityAndValue;
    }

    public List<Expenditure> ExpenditureToday() {
        return expenditureRepository.findAllByPickUpDate(LocalDate.now());
    }

    public void addExpenditure(Expenditure expenditure, Product product) {

        expenditure.setProduct(product);
        double price = product.getPrice();
        expenditure.setValue(Math.round(price * expenditure.getQuantity() * 100d) / 100d);
        product.setStock(product.getStock() - expenditure.getQuantity());
        expenditureRepository.save(expenditure);
        productRepository.save(product);
    }
//public Expenditure getExpenditure(String id){
//    Expenditure expenditure = expenditureRepository.getById(Long.parseLong(id));
//    Expenditure expenditureNew = new Expenditure();
//        expenditureNew.setProduct(expenditure.getProduct());
//        expenditureNew.setValue(expenditure.getValue());
//        expenditureNew.setQuantity(expenditure.getQuantity());
//        expenditureNew.setPurpose(expenditure.getPurpose());
//        expenditureNew.setId(expenditure.getId());
//
//    return expenditureNew;
//
//}

    public void deleteExpenditure(String id) {
        Expenditure expenditure = expenditureRepository.getById(Long.parseLong(id));

        Product product = expenditure.getProduct();
        product.setStock(product.getStock() + expenditure.getQuantity());
        productRepository.save(product);
        expenditureRepository.deleteById(Long.parseLong(id));
    }

}


