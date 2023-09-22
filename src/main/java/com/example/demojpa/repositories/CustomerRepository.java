package com.example.demojpa.repositories;

import com.example.demojpa.models.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;

public class CustomerRepository {
    private EntityManager em;
    private EntityTransaction transaction;
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    public CustomerRepository() {
        em = ConnectDB.getInstance().getEntityManagerFactory().createEntityManager();
        transaction = em.getTransaction();
    }

    public void insertCustomer(Customer employee) {
        try {
            transaction.begin();
            em.persist(employee);
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
            logger.error(ex.getMessage());
        }
    }

    public boolean deleteCustomer(long id){
        try {
            transaction.begin();
            em.remove(em.find(Customer.class,id));
            transaction.commit();
            return  true;
        }catch (Exception e){
            transaction.rollback();;
        }
        return false;
    }

    public void update(Customer employee) {
        try {
            transaction.begin();
            em.merge(employee);
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
            logger.error(ex.getMessage());
        }
    }

    public Optional<Customer> findById(long id) {
        Customer rs = em.find(Customer.class, id);
        return rs == null ? Optional.empty() : Optional.of(rs);
    }

    public List<Customer> getCustomers() {
        return em.createNamedQuery("Customer.findAll", Customer.class)
                .getResultList();
    }
}
