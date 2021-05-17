package com.dev04.server.springbootproject.article;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ArticleServiceTest {
	@Autowired
	ArticleService articleservice;
	@Autowired
	Repository repository;

	@Test
	public void testWrite() {
		ArticleVO vo = new ArticleVO();
		vo.setNo(1);
		vo.setTitle("안녕");
		vo.setContent("안녕하세요");
		vo.setWriterid("서주영");
		vo.setWritername("성민주");
		vo.setRegDate("A");
		vo.setReadcnt(12);
		System.out.println("게시글생성");

		articleservice.writeArticle(vo);
		System.out.println("생성완료");

		Optional<ArticleVO> articlelist = repository.findByno(vo.getNo());
		System.out.println("이건?");
		ArticleVO ar = null;
		if (articlelist.isPresent()) {
			ar = articlelist.get();
		}
		if (ar != null)
			assertEquals(String.format("%d", vo.getNo()), String.format("%d", ar.getNo()));
	System.out.println("완성");
	}
	
}
