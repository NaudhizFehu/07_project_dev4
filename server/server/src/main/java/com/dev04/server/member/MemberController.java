package com.dev04.server.member;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@RestController
public class MemberController {
	
	@Autowired
	MemberService memberService;
	
	@PostMapping("/login")
	public MemberVO login(@RequestBody MemberDTO memberDTO) {
		return memberService.login(memberDTO).get(); 
	}
	
	@PostMapping("/join")
	public void join(@RequestBody MemberVO memberVO) {
		memberService.join(memberVO);
	}
	/*@PostMapping("/join")
	public void join(@RequestPart("memberVO") MemberVO memberVO, @RequestPart("file") MultipartFile file) {
		memberService.join(memberVO, file);		
	} */
	
	@PostMapping("/myPage")
	public MemberVO myPage(@RequestBody MemberVO memberVO) {
		return memberService.myPage(memberVO).get();
	}
	
	@PostMapping("/changeMyInfo")
	public void update(@RequestBody MemberVO memberVO) {
		memberService.update(memberVO);
	}
		
	/*@PostMapping("/changeMyInfo")
	public void update(@RequestPart("memberVO") MemberVO memberVO, @RequestPart("file") MultipartFile file) {
		memberService.update(memberVO, file);
	} */
	
	@PostMapping("/quit")
	public void quit(@RequestBody MemberVO memberVO) {
		
		memberService.delete(memberVO);
	}
	
}