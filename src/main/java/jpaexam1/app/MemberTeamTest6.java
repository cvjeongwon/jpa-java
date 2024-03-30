package jpaexam1.app;

import jpaexam1.entity.Member;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class MemberTeamTest6 {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("entities");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        
        String jpql = "select m from Member m where m.team is null";
        
        TypedQuery<Member> q = em.createQuery(jpql, Member.class);
        List<Member> list = q.getResultList();
        
        System.out.println("팀이 설정되지 않은 데이터 갯수 : "+list.size());
        
        if(list.size() > 0) 
        	list.stream().forEach(x -> {em.remove(x);System.out.println("삭제함");});
        
        System.out.println("데이터 삭제~~ ");       
        em.getTransaction().commit();       
        em.close();
        factory.close();
	}
}
