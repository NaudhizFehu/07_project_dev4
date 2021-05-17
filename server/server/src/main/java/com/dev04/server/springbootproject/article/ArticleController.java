package com.dev04.server.springbootproject.article;

import java.awt.print.Pageable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/article")
public class ArticleController {
	@Autowired
	private ArticleService articleService;

	//게시글리스트
//	@GetMapping("/listArticle")
//	public Page<ArticleVO> list(Pageable pageable){
//		return articleService.articleList(pageable);
//	}
	//게시글 작성
	@PostMapping("/writeArticle")
	public void writeArticle(ArticleVO vo){
		articleService.writeArticle(vo);
	}
	//게시글수정
	@PutMapping("/modifyArticle")
	public void modifyArticle(ArticleVO vo) {
		articleService.updateArticle(vo);
	}
	//게시글삭제
	@DeleteMapping("/deleteArticle")
	public void deleteArticle(ArticleVO vo) {
		articleService.deleteArticle(vo);
	}

}
