package com.dev04.Member;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



import lombok.Getter;
import lombok.Setter;

@Getter@Setter
@Table(name="MEMBER")
@Entity
public class Member {
	
	@Id
	@Column(name="IDX_NO", nullable = false)
	private int idx_no;
	
	@Column(name="ID", length=10, nullable = false, unique = true)
	private String id;
	
	@Column(name="PASSWORD", length = 15, nullable = false)
	private String password;
	
	@Column(name="NAME", length = 25, nullable = false)
	private String name;
	
	@Column(name="EMAIL", length = 26, nullable = false)
	private String email;
	
	@Column(name="PHONE_NO", length = 11, nullable = false)
	private int phone_no;
	
	@Column(name="REGDATE", length = 11, nullable = false)
	private String regdate;
	
	@Column(name="PATH", length = 500)
	private String path;
	




}
