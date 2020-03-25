package Utilites;

import entities.People;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
public class JpaEntityManager {
    private  static final EntityManagerFactory emfactory;
    private  static final String PERSISTENCE_UNIT_NAME="LAB";

    static {
        emfactory= Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    }
    public static EntityManager getEntityManager() {
        return emfactory.createEntityManager();
    }
    public static void main(String[] args) {

        EntityManager entityMgr = getEntityManager();
        entityMgr.getTransaction().begin();

        People people = new People();
        people.setAge("99");
        people.setCar("Hummer");
        people.setName("john");
        entityMgr.persist(people);

        entityMgr.getTransaction().commit();

        entityMgr.clear();
        System.out.println("Record Successfully Inserted In The Database");
    }
}
