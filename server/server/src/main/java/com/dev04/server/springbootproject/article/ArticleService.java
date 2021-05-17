package com.dev04.server.springbootproject.article;

import java.awt.print.Pageable;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
@Service
@Transactional
public class ArticleService {
	@Autowired
	 private Repository rp;
	 
	public void writeArticle(ArticleVO vo) {
		rp.save(vo);
	}
	public void updateArticle(ArticleVO vo) {
		rp.save(vo);
	}
	public Optional<ArticleVO> readArticle(ArticleVO vo) {
		 return rp.findById(String.format("%d", vo.getNo()));
	}
	public void deleteArticle(ArticleVO vo) {
		rp.delete(vo);
	}
//	public Page<ArticleVO> articleList(Pageable pageable) {
//		Page<ArticleVO> articlePage =rp.findAll(pageable);
//		return articlePage;
//	}
}
