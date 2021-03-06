package pl.maciej.kitchenmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.maciej.kitchenmanager.entity.Expenditure;
import pl.maciej.kitchenmanager.entity.Product;

import java.time.LocalDate;
import java.util.List;

public interface ExpenditureRepository extends JpaRepository<Expenditure,Long> {

    List<Expenditure> findAllByProduct_Id(Long id);

    List<Expenditure> findAllByPickUpDate(LocalDate localDate);

    List<Expenditure> findAllByPickUpDateAndPurpose(LocalDate localDate,String purpose);

    void deleteById(Long id);
}
