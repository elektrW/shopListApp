package pl.wojciechdomagala.shoplistapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.wojciechdomagala.shoplistapp.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
