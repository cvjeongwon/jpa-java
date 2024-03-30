package jpaexam1.app;

import jpaexam1.entity.EntityTest;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class EntityTestApp4 {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("entities");
        EntityManager em = factory.createEntityManager();
        EntityTest et;
        em.getTransaction().begin();
        
        for(int i=10; i < 15; i++) {
        	et = new EntityTest();
        	et.setName("도우너"+i);
        	et.setAge(+i);
        	et.setBirthday(LocalDateTime.now());
        	em.persist(et);
        }
        
        Scanner scan = new Scanner(System.in);
        System.out.print("엔터키.....");
        scan.nextLine();  
        System.out.println("---------------------------");
    	System.out.println("엔티티 삭제");
    	EntityTest finalData = em.find(EntityTest.class, 5);
    	em.remove(finalData);
    	System.out.print("엔터키.....");
        System.out.println("finalData = " + finalData);
        scan.nextLine();  
        TypedQuery<EntityTest> q = em.createQuery("select t from EntityTest t", EntityTest.class);
    	List<EntityTest> list = q.getResultList();
    	list.stream().forEach(System.out::println);  
    	System.out.print("엔터키.....");
        System.out.println("list = " + list);
        scan.nextLine();     	
        em.getTransaction().commit();
        q = em.createQuery("select t from EntityTest t", EntityTest.class);
    	list = q.getResultList();
    	list.stream().forEach(System.out::println);
        em.close();       
        factory.close();
        scan.close();
	}
}
