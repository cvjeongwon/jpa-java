package jpaexam1.app;

import jakarta.persistence.*;
import jpaexam1.entity.EntityTest;
import jpaexam1.entity.Imsi;

import java.time.LocalDateTime;
import java.util.List;

public class EntityTestApp6 {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("entities");
        EntityManager em = factory.createEntityManager();
        Imsi entity;
        em.getTransaction().begin();
        for(int num=11; num <= 15; num++) {
            entity = new Imsi();
            entity.setStnum(num);
            entity.setStname("유니코" + num);
            em.persist(entity);
            System.out.println("ID 를 " + num + "으로 설정하여 영속객체로 만듬");
        }
        TypedQuery<Imsi> q = em.createQuery("select t from Imsi t", Imsi.class);
        List<Imsi> list = q.getResultList();
        list.stream().forEach(System.out::println);
        em.getTransaction().commit();
        em.close();       
        factory.close();
	}
}
