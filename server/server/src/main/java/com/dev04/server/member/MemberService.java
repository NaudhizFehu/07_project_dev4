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
	
	public Optional<MemberVO> login(MemberVO memberVO) {
	System.out.println(0000);
	return mr.findByMemberidAndPassword(memberVO.getMemberid(), memberVO.getPassword());
		
		
	}
	
	public Optional<MemberVO> myPage(MemberVO memberVO){
		
		return mr.findByMemberid(memberVO.getMemberid());
		
	}
	
	public void update(MemberVO memberVO) {
		mr.save(memberVO);
		
	}
	
	
}
