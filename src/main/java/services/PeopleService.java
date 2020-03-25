package services;

import Utilites.JpaEntityManager;
import entities.People;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class PeopleService implements PeopleRepository {

    public static void main(String[] args) {
        PeopleService service = new PeopleService();
        service.findById(1L);
        service.update(4L,"Destiny");
        service.findAll();
        service.findAll();
        service.create("TRICIE","114","Benz");


    }
    EntityManager em =JpaEntityManager.getEntityManager();
    public People findById(Long peopleId) {
      People people=  em.find(People.class,peopleId);
        System.out.println(people);

         return people;
    }

    public void findAll() {
   String query= "SELECT c FROM People c WHERE c.id IS NOT NULL";
        TypedQuery<People> typedQuery=em.createQuery(query,People.class);
        List<People> p;
        p=typedQuery.getResultList();
        p.forEach(peps->System.out.println(peps.getName()));
    }

    public void update(Long id, String name) {
        EntityTransaction transaction;
        People  people =null;

        transaction=em.getTransaction();
        transaction.begin();
        people=em.find(People.class,id);
        people.setName(name);
        em.persist(people);
        transaction.commit();

    }

    public void create(String name, String age, String car) {
        EntityTransaction transaction;
        People  people =null;
        transaction=em.getTransaction();
        transaction.begin();

        People p = new People();
        p.setName(name);
        p.setAge(age);
        p.setCar(car);
        em.persist(p);
        transaction.commit();

    }

    public void delete(Long id) {
        EntityTransaction transaction;
        People  people =null;

        transaction=em.getTransaction();
        transaction.begin();
        people=em.find(People.class,id);
        em.remove(people);
        transaction.commit();

    }
}
