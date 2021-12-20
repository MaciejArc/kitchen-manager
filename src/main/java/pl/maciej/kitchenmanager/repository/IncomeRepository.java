package pl.maciej.kitchenmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.maciej.kitchenmanager.entity.Income;

public interface IncomeRepository extends JpaRepository<Income,Long> {
}
