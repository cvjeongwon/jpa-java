package jpaexam1.app;

import jpaexam1.entity.EntityTest;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class EntityTestApp2 {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("entities");
        EntityManager em = factory.createEntityManager();
       	TypedQuery<EntityTest> q = em.createQuery("select t from EntityTest t", EntityTest.class);
    	List<EntityTest> list = q.getResultList();
    	list.stream().forEach(e -> System.out.println(e));      
        factory.close();
	}
}
