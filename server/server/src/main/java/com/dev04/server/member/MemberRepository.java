package com.dev04.server.member;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<MemberVO, String>{
	
	Optional<MemberVO> findByIdAndPassword(String Id, String Password);

	Optional<MemberVO> deleteByIdAndPassword(String Id, String Password);
	
	
}