package jpaexam1.app;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import jpaexam1.entity.Imsi;

import java.util.List;
import java.util.Scanner;

public class EntityTestApp9 {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("entities");
        EntityManager em = factory.createEntityManager();
        Imsi entity;
        em.getTransaction().begin();
        entity = em.find(Imsi.class, 2);
        System.out.println(entity);
        entity.setStname("듀크");

        System.out.println("엔터키.....");
        Scanner scan = new Scanner(System.in);
        scan.nextLine();
        scan.close();


        TypedQuery<Imsi> q = em.createQuery("select t from Imsi t", Imsi.class);
        List<Imsi> list = q.getResultList();
        list.stream().forEach(System.out::println);

        em.getTransaction().commit();
        em.close();       
        factory.close();
	}
}
/**
 * [ EntityTestApp9 테스트 ]
 *
 * start transaction;
 * update imsi set stname='BBB' where stnum = 2;
 *
 * 대기.....
 *
 * commit;
 */
