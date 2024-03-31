package jpaexam1.app;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jpaexam1.entity.Imsi;

import java.util.List;
import java.util.Scanner;

public class EntityTestApp8 {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("entities");
        EntityManager em = factory.createEntityManager();
        TypedQuery<Imsi> q = em.createQuery("select t from Imsi t", Imsi.class);
        List<Imsi> list = q.getResultList();
        for (Imsi i : list)
                System.out.println(i);

        System.out.println("엔터키.....");
        Scanner scan = new Scanner(System.in);
        scan.nextLine();
        scan.close();
        for (Imsi elem : list)
            em.refresh(elem);
        for (Imsi elem : list)
            System.out.println(elem);

        em.close();
        factory.close();
	}
}
