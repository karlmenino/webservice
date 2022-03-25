package com.ajc.demo.utils;


import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;



public class JpaDaoManager {
    private static JpaDaoManager instance=null;
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo");
    private JpaDaoManager() {}

    public static JpaDaoManager getInstance() {
        if (instance == null)instance = new JpaDaoManager();
        return instance;
    }
    public static void stop() {
        instance.emf.close();
    }

    public EntityManagerFactory getEmf() {
        return emf;
    }
}
