package com.dev04.server.member;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class MemberService {
	@Autowired
	MemberRepository mr;

	public void join(MemberVO memberVO) {
		mr.save(memberVO);
					
	}
	
	public Optional<MemberVO> login(MemberDTO memberDTO) {
	
	return mr.findByMemberIdAndPassword(memberDTO.getMemberId(), memberDTO.getPassword());
		
		
	}
	
	public Optional<MemberVO> myPage(MemberVO memberVO){
		
		return mr.findByMemberId(memberVO.getMemberId());
		
	}
	
	public void update(MemberVO memberVO) {
		mr.save(memberVO);
		
	}
	
	public Optional<MemberVO> delete(MemberVO memberVO){
		
		return mr.deleteByMemberIdAndPassword(memberVO.getMemberId(), memberVO.getPassword());
				
	}
	
	
	
}
