package backend.test;

import backend.services.ProductService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class TestMapping {
    public static void main(String[] args) {
        ProductService productService = new ProductService();
        productService.getProducts().forEach(
                System.out::println
        );

    }
}
