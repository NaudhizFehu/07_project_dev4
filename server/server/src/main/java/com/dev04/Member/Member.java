package com.dev04.Member;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

import com.sun.istack.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Member {
	
	@Id @GeneratedValue
	private long seq;
	
	@NotNull
	private String email;
	
	@NotNull
	private String password;
	
	private String name;
	
	@Column(name = "RegDate")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate date;
	
	public Member(@NotNull String email, @NotNull String password, String name) {
		this.email = email;
		this.password = password;
		this.name = name;
		this.date = LocalDate.now();
	}
	

}
