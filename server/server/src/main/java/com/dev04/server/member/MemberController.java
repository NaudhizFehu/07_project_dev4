package com.dev04.server.member;


import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
public class MemberController {
	
	MemberService memberService;
	
	@PostMapping("/login")
	public MemberVO login(@RequestBody MemberVO memberVO) {
		System.out.println(memberVO.getMemberid());
		System.out.println(memberVO.getPassword());
		Optional<MemberVO> test = memberService.login(memberVO); 
		System.out.println(11);
		MemberVO vo = test.get();
		System.out.println(22);
		return vo;
		
	}
	
	@PostMapping("/join")
	public void join(MemberVO memberVO) {
		
		memberService.join(memberVO);		
		
	}
	
	@PostMapping("/myPage")
	public MemberVO myPage(MemberVO memberVO) {
		
		return memberService.myPage(memberVO).get();
	}
	
	@PostMapping("/changeMyInfo")
	public void update(MemberVO memberVO) {
		
		memberService.update(memberVO);
	}
	
	
}