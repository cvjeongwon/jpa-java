package jpaexam1.app;

import jakarta.persistence.*;
import jpaexam1.entity.EntityTest;

import java.time.LocalDateTime;
import java.util.List;

public class EntityTestApp5 {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("entitytest");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        EntityTest et = em.find(EntityTest.class, 3);
        et.setName("dooly");
        et = new EntityTest();
        et.setName("도우너");
        et.setAge(10);
        et.setBirthday(LocalDateTime.now());
        em.persist(et);
        em.getTransaction().commit();
        em.close();       
        factory.close();
	}
}
