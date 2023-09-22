package com.example.demojpa.test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class TestMapping {
    public static void main(String[] args) {
        try (EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("bai02")) {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            EntityTransaction entityTransaction  = entityManager.getTransaction();
            entityTransaction.begin();
            entityTransaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
