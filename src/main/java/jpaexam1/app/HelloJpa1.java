package jpaexam1.app;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class HelloJpa1 {
    public static void main(String[] args) {
    	EntityManagerFactory factory = Persistence.createEntityManagerFactory("entities");
    	System.out.println("EntityManagerFactory 객체 : " + factory.getClass().getName());    	
        factory.close();
    }
}
