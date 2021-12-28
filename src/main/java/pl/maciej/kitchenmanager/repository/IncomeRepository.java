package pl.maciej.kitchenmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.maciej.kitchenmanager.entity.Income;
import pl.maciej.kitchenmanager.entity.Product;

import java.util.List;

public interface IncomeRepository extends JpaRepository<Income,Long> {

    List<Income> findAllByProduct_Id(Long id);

}
