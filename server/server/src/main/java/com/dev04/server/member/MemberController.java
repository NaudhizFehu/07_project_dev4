package com.dev04.server.member;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MemberController {
	
	@Autowired
	MemberService memberService;
	
	@PostMapping("/login")
	public MemberVO login(@RequestBody MemberDTO memberDTO) {
		System.out.println("login");
		return memberService.login(memberDTO).get(); 
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
	
	@PostMapping("/quit")
	public MemberVO quit(MemberVO memberVO) {
		
		return memberService.delete(memberVO).get();
	}
	
}