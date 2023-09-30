package backend.repositories;

import backend.models.ProductPrice;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

//@ApplicationScoped
public class ProductPriceRepository {
    private EntityManager em;
    private EntityTransaction transaction;
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    public ProductPriceRepository() {
        em = ConnectDB.getInstance().getEntityManagerFactory().createEntityManager();
        transaction = em.getTransaction();
    }

    public void insertProductPrice(ProductPrice productPrice){
        try {
            transaction.begin();
            em.persist(productPrice);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
            logger.error(e.getMessage());
        }
    }

    public List<ProductPrice> getAll(long productId){
        return em.createNamedQuery("ProductPrice.findAllByProductId",ProductPrice.class)
                .setParameter("id",productId)
                .getResultList();
    }
}
