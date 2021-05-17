package com.dev04.server.springbootproject.article;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
@Entity
@Table(name="ARTICLE")
public class ArticleVO {
//	@SequenceGenerator(name = "article_seq", sequenceName ="article_no",initialValue = 1,allocationSize = 1)
	@Id
	@Column(name="NO",nullable = false)
	private int no;
	
	@Column(name="TITLE",length=100,nullable = false)
	private String title;
	
	@Column(name="WRITERID",length=10,nullable = false)
	private String writerid;
	
	@Column(name="WRITERNAME",length=25,nullable = false)
	private String writername;
	
	@Column(name="CONTENT")
	private String content;
	
	@Column(name="REGDATE",length=11,nullable = false)
	private String regDate;
	
	@Column(name="READCNT",nullable= false)
	private int readcnt;
}
