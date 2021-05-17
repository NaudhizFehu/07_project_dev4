package com.dev04.server.member;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class MemberController {
	
	MemberService memberService;
	
	@PostMapping("/login")
	public MemberVO login(MemberVO memberVO) {
		
		return memberService.login(memberVO).get(); 
		
	}
	
	@PostMapping("/join")
	public void join(MemberVO memberVO) {
		
		memberService.join(memberVO);		
		
	}
	
	
}