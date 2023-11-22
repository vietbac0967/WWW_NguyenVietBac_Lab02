package backend.services;

import backend.models.ProductPrice;
import backend.repositories.ProductPriceRepository;
import jakarta.inject.Inject;

import java.util.List;

public class ProductPriceService {
    private final ProductPriceRepository productPriceRepository;

    public ProductPriceService() {
        productPriceRepository = new ProductPriceRepository();
    }

    public Double getPriceOfProduct(long productId){
        return productPriceRepository.getPrice(productId);
    }
}
