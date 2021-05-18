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
	 //글쓰기
	public void writeArticle(ArticleVO vo) {
		rp.save(vo);
	}
	//글수정
	public void updateArticle(ArticleVO vo) {
		rp.save(vo);
	}
	//글삭제
	public void deleteArticle(ArticleVO vo) {
		rp.delete(vo);
	}
	//게시글읽기
	public Optional<ArticleVO> readArticle(ArticleVO vo) {
		return rp.findByNo(vo.getNo());
	}
	
//	public Page<ArticleVO> articleList(Pageable pageable) {
//		Page<ArticleVO> articlePage =rp.findAll(pageable);
//		return articlePage;
//	}
}
