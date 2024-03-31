package jpaexam1.app;

import jakarta.persistence.*;
import jpaexam1.entity.EntityTest;
import jpaexam1.entity.Imsi;

import java.time.LocalDateTime;
import java.util.List;

public class EntityTestApp7 {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("entitytest");
        EntityManager em = factory.createEntityManager();
        Imsi entity;
        em.getTransaction().begin();
        for(int num=11; num <= 15; num++) {
            entity = em.find(Imsi.class, num);
            System.out.println("ID가 " + num + "인 영속객체 추출");
            em.remove(entity);
            System.out.println("ID가 " + num + "인 영속객체 삭제");
        }
        TypedQuery<Imsi> q = em.createQuery("select t from Imsi t", Imsi.class);
        List<Imsi> list = q.getResultList();
        list.stream().forEach(System.out::println);
        em.getTransaction().rollback();
        em.close();       
        factory.close();
	}
}
