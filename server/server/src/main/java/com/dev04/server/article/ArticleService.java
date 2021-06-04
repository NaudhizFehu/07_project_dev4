package com.dev04.server.article;

import java.awt.print.Pageable;
import java.util.List;
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
	//게시글리스트
	public List<ArticleVO> listArticle() {
		return rp.findAll();
	}
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
		System.out.println(vo.getNo());
		return rp.findByNo(vo.getNo());
	}

}
