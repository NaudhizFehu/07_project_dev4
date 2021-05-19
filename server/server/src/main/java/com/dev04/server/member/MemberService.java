package com.dev04.server.member;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class MemberService {

	/*
	 * @Autowired LocalConfig localconfig;
	 */
	@Autowired
	MemberRepository mr;

	public void join(MemberVO memberVO) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		Date date = new Date();
		memberVO.setRegDate(format.format(date).substring(2));
		mr.save(memberVO);

	}

	/*
	 * public void join(MemberVO memberVO, MultipartFile file) { mr.save(memberVO);
	 * try { uploadProfilePictuer(memberVO.getId(), file); } catch(Exception e) {
	 * mr.delete(memberVO); throw e; } }
	 */

	public Optional<MemberVO> login(MemberDTO memberDTO) {
		return mr.findByIdAndPassword(memberDTO.getId(), memberDTO.getPassword());
	}

	public Optional<MemberVO> myPage(MemberVO memberVO) {

		return mr.findById(memberVO.getId());

	}

	public void update(MemberVO memberVO) {
		mr.save(memberVO);

	}

	/*
	 * public void update(MemberVO memberVO, MultipartFile file) {
	 * 
	 * Optional<MemberVO> target = mr.findById(memberVO.getId()); if
	 * (target.isPresent()) { mr.save(memberVO);
	 * uploadProfilePictuer(memberVO.getId(), file); } else { throw new
	 * MemberNotFoundException("회원 정보가 없습니다" + memberVO.getId()); }
	 * 
	 * }
	 */

	public void delete(MemberVO memberVO) {

		mr.deleteByIdAndPassword(memberVO.getId(), memberVO.getPassword());

	}

	/*
	 * public void delete(MemberVO memberVO){
	 * 
	 * Optional<MemberVO> profileDelete = mr.findByIdAndPassword(memberVO.getId(),
	 * memberVO.getPassword()); String path = profileDelete.get().getPath(); File
	 * file = new File(path); if(file.exists()) { file.delete(); }
	 * 
	 * mr.deleteByIdAndPassword(memberVO.getId(), memberVO.getPassword());
	 * 
	 * }
	 */

	/*
	 * public void createDirectory(String path) {
	 * 
	 * File directory = new File(path); if(!directory.exists()) {
	 * directory.mkdirs(); }
	 * 
	 * }
	 */

	/*
	 * public void uploadProfilePictuer (String memberId, MultipartFile file) {
	 * 
	 * Optional<MemberVO> target = mr.findById(memberId); if(target.isPresent()) {
	 * try { String fileName = file.getOriginalFilename();
	 * 
	 * createDirectory(localconfig.getUploadFilepath()); String saveUri =
	 * localconfig.getUploadFilepath() + "\\" + fileName; File profileFile = new
	 * File(saveUri); if(profileFile.exists()) { profileFile.delete(); } profileFile
	 * = new File(saveUri);
	 * 
	 * file.transferTo(profileFile);
	 * 
	 * MemberVO memberVO = target.get(); memberVO.setPath(localconfig.getBaseUrl() +
	 * fileName); mr.save(memberVO);
	 * 
	 * } catch(Exception e) { throw new
	 * UploadFailureException("파일 업로드를 실패하였습니다. 왜냐하면 " + e.getMessage()); } } else {
	 * throw new MemberNotFoundException("회원 정보를 찾을 수 없습니다. 왜냐하면" + memberId); }
	 * 
	 * 
	 * 
	 * }
	 */

}
