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
	@Id
	@SequenceGenerator(name = "article_seq", sequenceName ="article_no",initialValue = 1,allocationSize = 1)
	@Column(name="ARTICLE_NO",length=10,nullable = false)
	private int article_no;
	
	@Column(name="TITLE",length=100,nullable = false)
	private String title;
	
	@Column(name="WRITER_ID",length=10,nullable = false)
	private String writer_id;
	
	@Column(name="WRITER_NAME",length=25,nullable = false)
	private String writer_name;
	
	@Column(name="CONTENT",columnDefinition ="TEXT",nullable = false)
	private String content;
	
	@Column(name="REGDATE",length=11,nullable = false)
	private String article_regDate;
	
	@Column(name="READ_CNT",nullable= false)
	private int read_cnt;
}
