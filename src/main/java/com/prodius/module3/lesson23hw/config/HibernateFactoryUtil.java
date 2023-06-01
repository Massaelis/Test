package com.prodius.module3.lesson23hw.config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateFactoryUtil {
    private static EntityManagerFactory entityManagerFactory;

    public static EntityManager getEntityManager() {
        if (entityManagerFactory == null) {
            entityManagerFactory = Persistence.createEntityManagerFactory("settings");
        }
        return entityManagerFactory.createEntityManager();
    }
}