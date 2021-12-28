package pl.maciej.kitchenmanager.service;

import org.springframework.context.annotation.Configuration;
import pl.maciej.kitchenmanager.entity.Expenditure;
import pl.maciej.kitchenmanager.entity.Income;
import pl.maciej.kitchenmanager.repository.ExpenditureRepository;
import pl.maciej.kitchenmanager.repository.IncomeRepository;
import pl.maciej.kitchenmanager.repository.ProductRepository;

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

    public List<Expenditure> findAllByProductId(Long id){
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
       expenditureValue= Math.round(expenditureValue *100.0)/100.0;
        sumOfQuantityAndValue.add(expenditureQuantity);
        sumOfQuantityAndValue.add(expenditureValue);
        return sumOfQuantityAndValue;
    }

}
