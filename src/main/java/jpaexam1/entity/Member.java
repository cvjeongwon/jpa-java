package jpaexam1.entity;

import lombok.*;
import jakarta.persistence.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name="membertbl")
public class Member {
	@Id
	@Column(name = "MEMBER_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String username;
	// 연관관계 매핑 : 팀에는 여러 멤머가 있고 팀과 락커는 1:1 관계이다.
	// 연관관계 매핑 : 팀에는 여러 멤머가 있고 팀과 락커는 1:1 관계이다.
	@ManyToOne
	@JoinColumn(name = "TEAM_ID") // 테이블의 컬럼명 'TEAM_ID'
	private Team team;  // team_TEAM_ID
	@OneToOne
	@JoinColumn(name = "LOCKER_ID")  // 테이블의 컬럼
	private Locker locker;

	public Member(String username, Team team, Locker locker) {
		super();
		this.username = username;
		this.team = team;
		this.locker = locker;
	}
}
