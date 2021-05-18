package com.dev04.server.member;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
@SequenceGenerator(name = "memberseq", sequenceName = "no_seq", initialValue = 1 , allocationSize = 1 )
@Entity
@Table(name="MEMBER")
public class MemberVO {
	
	@Id
	@Column(name="ID", length=10, nullable = false, unique = true)
	private String id;

	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "no_seq")
	@Column(name="IDX", nullable = false)
	private int idx;
	
	@Column(name="PASSWORD", length = 15, nullable = false)
	private String password;
	
	@Column(name="NAME", length = 25, nullable = false)
	private String name;
	
	@Column(name="EMAIL", length = 26, nullable = false)
	private String email;
	
	@Column(name="PHONENUMBER", length = 11, nullable = false)
	private String phoneNumber;
	
	@Column(name="REGDATE", length = 11, nullable = false)
	private String regDate;
	
	@Column(name="PATH", length = 500)
	private String path;
	




}
