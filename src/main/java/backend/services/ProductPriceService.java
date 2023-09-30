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

    public List<ProductPrice> getAll(long productId){
        return productPriceRepository.getAll(productId);
    }
}
