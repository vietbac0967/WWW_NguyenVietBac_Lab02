package backend.test;

import backend.models.Product;
import backend.models.ProductImage;
import backend.services.ProductImageService;
import backend.services.ProductService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.Optional;

public class TestMapping {
    public static void main(String[] args) {
        ProductService productService = new ProductService();
        final var productById = productService.getProductById(4L);
        if(productById.isPresent()){
            System.out.println(productById.get());
        }else{
            System.out.println("Not found");
        }

    }
}
