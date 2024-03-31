package jpaexam1.app;

import jakarta.persistence.*;
import jpaexam1.entity.EntityTest;
import jpaexam1.entity.Imsi;

import java.util.List;

public class EntityTestApp4 {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("entitytest");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        Imsi i1 = new Imsi();
        i1.setStnum(5);
        i1.setStname("유니코5");
        System.out.println("i1 생성");
        Imsi i2 = new Imsi();
        i2.setStnum(6);
        i2.setStname("유니코6");
        System.out.println("i2 생성");
        em.persist(i1);
        System.out.println("i1 영속객체로 만듬");
        em.persist(i2);
        System.out.println("i2 영속객체로 만듬");
        TypedQuery<Imsi> q = em.createQuery("select t from Imsi t", Imsi.class);
    	List<Imsi> list = q.getResultList();
    	list.stream().forEach(System.out::println);
        em.getTransaction().rollback();
        em.close();       
        factory.close();
	}
}
