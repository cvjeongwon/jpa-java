package jpaexam2.view;

import jpaexam2.model.dao.EmpDAO;
import jpaexam2.model.dto.EmpFreqDTO;
import jpaexam2.model.entity.Emp;
import java.util.List;

public class RefatoringEmpApp1 {
    public static void hr() {
        System.out.println("-".repeat(100));
    }

    private static void printEmpList(List<Emp> empList) {
        empList.forEach(System.out::println);
        hr();
    }

    private static void printEmpFreqDTOList(List<EmpFreqDTO> empFreqDTOList) {
        empFreqDTOList.forEach(System.out::println);
        hr();
    }

    public static void main(String[] args) {
        EmpDAO dao = new EmpDAO();
        System.out.printf("emp 테이블의 데이터 갯수 : %d개 \n", dao.getAllDataNum());
        hr();

        int inputNum = 7499;
        System.out.printf("사번이 %d인 직원의 성명 : %s%n", inputNum, dao.getEmpName(inputNum));
        hr();

        printEmpList(dao.findByJob("SALESMAN"));
        printEmpList(dao.findByPartEname("T"));
        printEmpList(dao.findByGreaterThanSal(2000));
        printEmpList(dao.findByEnameAndJob1("MARTIN", "SALESMAN"));

        Emp evo = dao.findByEnameAndJob2("MARTIN", "SALESMAN");
        System.out.println(evo);
        hr();

        printEmpFreqDTOList(dao.findByEmpFreqDTO());

        printEmpList(dao.listPart(0, 14));
        printEmpList(dao.listPart(0, 3));
        printEmpList(dao.listPart(3, 2));

        Object[] r9 = dao.getGroupFunc();
        System.out.println("급여 총액 : " + r9[0]);
        System.out.println("최대 급여 : " + r9[1]);
        System.out.println("최소 총액 : " + r9[2]);
        hr();

        dao.close();
    }
}