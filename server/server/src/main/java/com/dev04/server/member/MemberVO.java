package com.dev04.server.member;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



import lombok.Getter;
import lombok.Setter;

@Getter@Setter
@Entity
@Table(name="MEMBER")
public class MemberVO {
	
	@Id
	@Column(name="IDX", nullable = false)
	private int idx;
	
	@Column(name="ID", length=10, nullable = false, unique = true)
	private String memberid;
	
	@Column(name="PASSWORD", length = 15, nullable = false)
	private String password;
	
	@Column(name="NAME", length = 25, nullable = false)
	private String name;
	
	@Column(name="EMAIL", length = 26, nullable = false)
	private String email;
	
	@Column(name="PHONENOMBER", length = 11, nullable = false)
	private String phonenomber;
	
	@Column(name="REGDATE", length = 11, nullable = false)
	private String regdate;
	
	@Column(name="PATH", length = 500)
	private String path;
	




}
