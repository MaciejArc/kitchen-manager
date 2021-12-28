package pl.maciej.kitchenmanager.service;

import org.springframework.context.annotation.Configuration;
import pl.maciej.kitchenmanager.entity.Income;
import pl.maciej.kitchenmanager.repository.ExpenditureRepository;
import pl.maciej.kitchenmanager.repository.IncomeRepository;
import pl.maciej.kitchenmanager.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;


@Configuration
public class IncomeService {

    private final ProductRepository productRepository;
    private final IncomeRepository incomeRepository;
    private final ExpenditureRepository expenditureRepository;

    public IncomeService(ProductRepository productRepository, IncomeRepository incomeRepository, ExpenditureRepository expenditureRepository) {
        this.productRepository = productRepository;
        this.incomeRepository = incomeRepository;
        this.expenditureRepository = expenditureRepository;
    }

    public List<Income> findAllByProductId(Long id) {
        return incomeRepository.findAllByProduct_Id(id);
    }

    public List<Double> SumOfQuantityAndValue(List<Income> list) {
        List<Double> sumOfQuantityAndValue = new ArrayList<>();
        double incomeQuantity = 0d;
        double incomeValue = 0d;
        for (Income income : list) {
            incomeQuantity = incomeQuantity + income.getQuantity();
            incomeValue = incomeValue + income.getValue();

        }
        incomeValue= Math.round(incomeValue*100.0)/100.0;
        sumOfQuantityAndValue.add(incomeQuantity);
        sumOfQuantityAndValue.add(incomeValue);
        return sumOfQuantityAndValue;
    }
}
