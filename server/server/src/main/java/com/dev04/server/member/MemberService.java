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
	
	return mr.findByMemberidAndPassword(memberVO.getMemberid(), memberVO.getPassword());
		 
	
		
	}
	
	
}
