package com.dev04.server.member;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<MemberVO, String>{
	
	Optional<MemberVO> findByMemberIdAndPassword(String memberId, String password);

	Optional<MemberVO> findByMemberId(String memberId);

	Optional<MemberVO> deleteByMemberIdAndPassword(String memberId, String password);
	
	
}