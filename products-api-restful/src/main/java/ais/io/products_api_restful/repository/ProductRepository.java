package ais.io.products_api_restful.repository;

import ais.io.products_api_restful.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository <Product, UUID> {
}
