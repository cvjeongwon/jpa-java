package jpaexam1.app;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jpaexam1.entity.Imsi;

public class EntityTestApp3 {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("entitytest");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        Imsi i1 = new Imsi();
        i1.setStnum(3);
        i1.setStname("유니코3");
        System.out.println("i1 생성");
        Imsi i2 = new Imsi();
        i2.setStnum(4);
        i2.setStname("유니코4");
        System.out.println("i2 생성");
        em.persist(i1);
        System.out.println("i1 영속객체로 만듬");
        em.flush();
        em.persist(i2);
        System.out.println("i2 영속객체로 만듬");
        em.flush();
        System.out.println("===== 커밋 =====");
        em.getTransaction().commit();
        em.close();
        factory.close();
    }
}
