package jpaexam1.app;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import java.util.List;
import jpaexam2.model.entity.Emp;

public class HelloJpa3 {
    public static void main(String[] args) {
    	EntityManagerFactory factory = Persistence.createEntityManagerFactory("entities");
        EntityManager em = factory.createEntityManager();

        Query q = em.createQuery("select t from Emp t", Emp.class);  //jpql 언어로 상세 필터 지정함. from Entity Class name alias t ( LAZY 타입 지정으로 딱 원하는 이름만 조회 할 수 있다.) (JPA에서 LAZY의 반대 개념은 EAGER입니다. EAGER 로딩은 연관된 엔티티나 컬렉션을 즉시 로딩하는 것을 의미합니다. 반면에 LAZY 로딩은 연관된 엔티티나 컬렉션을 실제로 사용할 때까지 로딩을 지연시키는 것입니다.)
        List<Emp> empList = q.getResultList();
        for (Emp elem : empList) {
            System.out.println(elem.getEname());
        }
        System.out.println("데이터 갯수 : " + empList.size());
        em.close();
        factory.close();
    }
}
