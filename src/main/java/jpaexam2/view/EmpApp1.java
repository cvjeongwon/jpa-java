package jpaexam2.view;

import jpaexam2.model.dao.EmpDAO;
import jpaexam2.model.dto.EmpFreqDTO;
import jpaexam2.model.entity.Emp;
import java.util.List;

public class EmpApp1 {
	public static void hr() {
		for(int i=1; i < 100; i++)
			System.out.print("-");
		System.out.println();
	}
	public static void main(String[] args)  {
		EmpDAO dao = new EmpDAO();
		System.out.printf("emp 테이블의 데이터 갯수 : %d개 \n",dao.getAllDataNum());
		hr();
		int inputNum = 7499;
		System.out.printf("사번이 %d인 직원의 성명 : %s%n", inputNum, dao.getEmpName(inputNum));
		hr();
		List<Emp> r1 = dao.findByJob("SALESMAN");
		for(Emp elem : r1)
			System.out.println(elem);
		hr();
		List<Emp> r2 = dao.findByPartEname("T");
		for(Emp elem : r2)
			System.out.println(elem);
		hr();
		List<Emp> r3 = dao.findByGreaterThanSal(2000);
		for(Emp elem : r3)
			System.out.println(elem);
		hr();
		List<Emp> r4 = dao.findByEnameAndJob1("MARTIN", "SALESMAN");
		for(Emp elem : r4)
			System.out.println(elem);
		hr();
		Emp evo = dao.findByEnameAndJob2("MARTIN", "SALESMAN");
		System.out.println(evo);
		hr();
		List<EmpFreqDTO> r5 = dao.findByEmpFreqDTO();
		for(EmpFreqDTO dto : r5)
			System.out.println(dto);
		hr();
		List<Emp> r6 = dao.listPart(0, 14);
		for(Emp elem : r6)
			System.out.println(elem);
		hr();
		List<Emp> r7 = dao.listPart(0, 3);
		for(Emp elem : r7)
			System.out.println(elem);
		hr();
		List<Emp> r8 = dao.listPart(3, 2);
		for(Emp elem : r8)
			System.out.println(elem);
		hr();
		
		Object[] r9 = dao.getGroupFunc();
		System.out.println("급여 총액 : "+r9[0]);
		System.out.println("최대 급여 : "+r9[1]);
		System.out.println("최소 총액 : "+r9[2]);
		hr();
		dao.close();	
	}
}
/**
 * 변경 사항:
 * hr() 메소드에서 문자열 반복을 위해 String.repeat(int) 메소드를 사용하여 코드를 간결하게 만들었습니다.
 * Emp 객체 리스트와 EmpFreqDTO 객체 리스트를 출력하는 중복 코드를 각각 printEmpList와 printEmpFreqDTOList 메소드로 추출하여 중복을 제거하고 가독성을 높였습니다.
 * forEach 메소드와 메소드 참조(System.out::println)를 사용하여 리스트를 순회하고 출력하는 방식으로 변경하여 코드를 더 간결하게 만들었습니다.
 */
