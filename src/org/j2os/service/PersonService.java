package org.j2os.service;

import org.j2os.common.JPA;
import org.j2os.entity.Car;
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
    public static void findAllByJPQLWithParametersAndNamedQuery(){
        EntityManager entityManager = JPA.getEntityManager();
        Query query = entityManager.createNamedQuery("x1");
        query.setParameter("firstName" , "Ali");
        query.setParameter("lastName" , "Bahador");
        List<Person> list = query.getResultList();
        entityManager.close();
        for(Person person : list){
            System.out.println(person.getId());
            System.out.println(person.getName());
            System.out.println(person.getFamily());
        }
    }
    public static void findALLBYSQL(){
        EntityManager entityManager = JPA.getEntityManager();
        Query query = entityManager.createNativeQuery("select  * from PERSON" , Person.class);
        List<Person> list = query.getResultList();
        entityManager.close();
        for(Person person : list){
            System.out.println(person.getId());
            System.out.println(person.getName());
            System.out.println(person.getCar().getModel());

        }
    }

    public static void save1(){
        EntityManager entityManager = JPA.getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        Person person1 = new Person().setName("Ali").setFamily("Ghaderi");
        Car car1 = new Car().setModel("bmw");
        person1.setCar(car1);

        entityManager.persist(person1);
        entityTransaction.commit();
        entityManager.close();

        System.out.println(person1.getName());
        System.out.println(person1.getCar());
    }
    public  static void find1(){
        EntityManager entityManager = JPA.getEntityManager();
//        Query query = entityManager.createQuery("select o from person o");
        Query query = entityManager.createNativeQuery("select  * from PERSON" , Person.class);
        List<Person> list  = query.getResultList();
        entityManager.close();
        for (Person person : list){
            System.out.println(person.getId());
            System.out.println(person.getName());
            System.out.println(person.getFamily());
            System.out.println(person.getCar().getId());
            System.out.println(person.getCar().getModel());
            System.out.println("********************************************");
        }
    }
    public static void main(String[] args) {
        find1();
    }
}
