package org.j2os.common;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPA {
    private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("J2OS");
    private JPA(){

    }
    public static EntityManager getEntityManager(){
        return FACTORY.createEntityManager();
    }
}
