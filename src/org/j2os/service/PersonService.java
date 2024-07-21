package org.j2os.service;

import org.j2os.common.JPA;
import org.j2os.entity.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class PersonService {
    public static void save() {
        EntityManager entityManager = JPA.getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Person person1 = new Person().setName("Amirsam").setFamily("Bahador");
        Person person2 = new Person().setName("Mohammad").setFamily("Ghaderi");
        Person person3 = new Person().setName("Ali").setFamily("Ghaderi");


        entityManager.persist(person1);
        entityManager.persist(person2);
        entityManager.persist(person3);


        entityTransaction.commit();
        entityManager.close();
    }
    public static void findAllByJPQL(){
        EntityManager entityManager = JPA.getEntityManager();
        Query query = entityManager.createQuery("select entity from person entity");
        List<Person> list = query.getResultList();
        for(Person person : list){
            System.out.println(person.getId());
            System.out.println(person.getName());
            System.out.println(person.getFamily());
        }
    }
    public static void findByJPQLWithParameters(){
        EntityManager entityManager = JPA.getEntityManager();
        Query query = entityManager.createQuery("select entity from person entity where entity.name=:firstName or entity.family=:lastName");
        query.setParameter("firstName" , "Ali");
        query.setParameter("lastName" , "Ali");
        List<Person> list = query.getResultList();
        entityManager.close();
        for (Person person : list){
            System.out.println(person.getId());
            System.out.println(person.getName());
            System.out.println(person.getFamily());
        }


    }
    public static void main(String[] args) {
        findAllByJPQL();
    }
}
