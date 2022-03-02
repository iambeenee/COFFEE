package co.edu.member.service;

import java.util.List;

import co.edu.member.vo.MemberVO;

public interface MemberService {
	List<MemberVO> selectMemberList(); //전체조회
	MemberVO selecteMember(MemberVO vo); //단건조회
	public int insertMember(MemberVO vo); //회원가입
	public int updateMember(MemberVO vo); // 회원정보수정
	public int deleteMember(MemberVO vo); //회원탈퇴
	public MemberVO loginCheck(MemberVO vo); // 로그인 정보
	boolean isIdcheck(String id); // 아이디 중복 체크 -> boolean은 디폴트값이 false, 존재하면 false
}
