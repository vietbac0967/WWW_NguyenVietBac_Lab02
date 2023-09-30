package backend.repositories;

import backend.enums.EmployeeStatus;
import backend.enums.ProductStatus;
import backend.models.Employee;
import backend.models.Product;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;

public class ProductRepository {
    private final EntityManager em;
    private final EntityTransaction transaction;
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    public ProductRepository() {
        em = ConnectDB.getInstance().getEntityManagerFactory().createEntityManager();
        transaction = em.getTransaction();
    }

    public void insertProduct(Product product) {
        try {
            transaction.begin();
            em.persist(product);
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
            logger.error(ex.getMessage());
        }
    }

    public void setStatus(Product product, ProductStatus status) {
        product.setProductStatus(status);
    }

    public void update(Product product) {
        try {
            transaction.begin();
            em.merge(product);
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
            logger.error(ex.getMessage());
        }
    }

    public Optional<Product> findById(long id) {
        Product rs = em.find(Product.class, id);
        return rs == null ? Optional.empty() : Optional.of(rs);
    }

    public List<Product> getProducts() {
        return em.createNamedQuery("Product.findAll", Product.class)
                .setParameter("status", ProductStatus.ACTIVE)
                .getResultList();
    }
}
