package jpaexam1.app;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jpaexam1.entity.EntityTest;

import java.time.LocalDateTime;

public class EntityTestApp1 {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("entities");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        EntityTest et1 = new EntityTest();
        et1.setName("둘리");
        et1.setAge(10);
        et1.setBirthday(LocalDateTime.now());
        System.out.println("et1 생성");
        EntityTest et2 = new EntityTest();
        et2.setName("또치");
        et2.setAge(10);
        et2.setBirthday(LocalDateTime.now());
        System.out.println("et2 생성");
        em.persist(et1);
        System.out.println("et1 영속객체로 만듬");
       	em.persist(et2);
        System.out.println("et2 영속객체로 만듬");
        System.out.println("===== 커밋 =====");
        //em.getTransaction().rollback();
        em.getTransaction().commit();
        em.close();
        factory.close();
	}
}
