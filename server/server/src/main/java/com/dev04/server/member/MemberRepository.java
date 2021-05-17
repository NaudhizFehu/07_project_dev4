package com.dev04.server.member;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<MemberVO, String>{
	
	Optional<MemberVO> findByMemberidAndPassword(String memberid, String password);
	
	
}