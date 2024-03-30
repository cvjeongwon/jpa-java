package jpaexam1.app;

import jpaexam1.entity.EntityTest;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class EntityTestApp3 {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("entities");
        EntityManager em = factory.createEntityManager();
        EntityTest et;
        em.getTransaction().begin();
        
        for(int i=1; i < 5; i++) {
        	et = new EntityTest();
        	et.setName("도우너"+i);
        	et.setAge(i);
        	et.setBirthday(LocalDateTime.now());
        	em.persist(et);
        }
        System.out.println("et = " + em);

        Scanner scan = new Scanner(System.in);
        System.out.print("엔터키> 1...em.persist(et)..");
        scan.nextLine();  
        TypedQuery<EntityTest> q = em.createQuery("select t from EntityTest t", EntityTest.class);
    	List<EntityTest> list = q.getResultList();
    	list.stream().forEach(System.out::println);
    	
    	for(int i=10; i < 15; i++) {
        	et = new EntityTest();
        	et.setName("또치"+i);
        	et.setAge(i);
        	et.setBirthday(LocalDateTime.now());
        	em.persist(et);
        }
        System.out.println("em = " + em);
    	System.out.print("엔터키 >2..select...");
        scan.nextLine();
        em.flush();  // db와 동기화
        System.out.println("em = " + em);
        q = em.createQuery("select t from EntityTest t", EntityTest.class);
        list = q.getResultList();
        list.stream().forEach(System.out::println);
        
        System.out.print("엔터키 > 3...commit()..");
        scan.nextLine();  
        em.getTransaction().commit();// 디비 적용 rollback();
        em.close();       
        factory.close();
        scan.close();
	}
}
