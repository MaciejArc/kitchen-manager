package pl.maciej.kitchenmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.maciej.kitchenmanager.entity.Product;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
