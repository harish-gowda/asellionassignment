package nl.asellion.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import nl.asellion.product.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
