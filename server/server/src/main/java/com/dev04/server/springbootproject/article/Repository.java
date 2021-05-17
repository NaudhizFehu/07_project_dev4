package com.dev04.server.springbootproject.article;

import java.awt.print.Pageable;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repository extends JpaRepository<ArticleVO, String>{

//	Page<ArticleVO> findAll(Pageable request);
	Optional<ArticleVO> findByNo(int no);
}
