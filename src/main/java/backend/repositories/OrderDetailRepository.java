package backend.repositories;

import backend.models.Order;
import backend.models.OrderDetail;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

public class OrderDetailRepository {
    private EntityManager em;
    private EntityTransaction transaction;
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    public OrderDetailRepository() {
        em = ConnectDB.getInstance().getEntityManagerFactory().createEntityManager();
        transaction = em.getTransaction();
    }
    public void insertOrderDetail(OrderDetail orderDetail){
        try {
            transaction.begin();
            em.persist(orderDetail);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
            logger.error(e.getMessage());
        }
    }
    public void update(OrderDetail orderDetailUpdate){
        try {
            transaction.begin();
            em.merge(orderDetailUpdate);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
            logger.error(e.getMessage());
        }
    }

    public double getTotalPrice(long orderId){
        return em.createNamedQuery("OrderDetail.getTotalPrice",Double.class)
                .setParameter("id",orderId)
                .getSingleResult();
    }

}
