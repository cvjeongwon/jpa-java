package jpaexam2.model.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import jakarta.persistence.*;

@Entity
@Getter
@Setter
@ToString
public class Emp {
    @Id
    private int empno;
    private String ename;
    private String job;
    private String mgr;
    private java.sql.Date  hiredate;
    private int sal;
    private Integer comm;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="deptno")
    private Dept deptno;
}
