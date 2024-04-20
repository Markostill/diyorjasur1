package org.example.project_1.config;

import jakarta.persistence.Persistence;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class MyListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        DB.entityManagerFactory = Persistence.createEntityManagerFactory("ORM_EXAMPLE");
        DB.entityManager = DB.entityManagerFactory.createEntityManager();
        ServletContextListener.super.contextInitialized(sce);
    }

}
