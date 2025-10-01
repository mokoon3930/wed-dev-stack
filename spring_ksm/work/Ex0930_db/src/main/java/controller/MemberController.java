package controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.MemberDAO;
import util.PwdBcrypt;
import vo.MemberVO;

@Controller
public class MemberController {

	MemberDAO member_dao;
//	public MemberController(MemberDAO member_dao) {
//		this.member_dao = member_dao;
//	}
	
	// set인젝션으로 받기
	public void setMember_dao(MemberDAO member_dao) {
		this.member_dao = member_dao;
	}
	
	//value = {"/","list.do"} - 경로가 있던 없던 요기 먼저 실행
	@RequestMapping(value= {"/", "list.do"})
	public String list(Model model) {
		List<MemberVO> list = member_dao.selectList();
		model.addAttribute("list", list); // 바인딩
		return "member/member_list"; // 포워딩
	}
	
	@RequestMapping("member_regi_form.do")
	public String MemberForm() {
		return "member/member_regi";
	
	}
	
	//member_insert.do?
	@RequestMapping("member_insert.do")
	public String memberInsert(MemberVO vo) {
		
		PwdBcrypt pbc = new PwdBcrypt();
		//암호화 전 비밀번호 받기
		String encodePwd = pbc.encodingPwd(vo.getPwd());
		
		//암호화 된 비밀번호 넣기
		vo.setPwd(encodePwd);
		
		int res = member_dao.memberInsert(vo);
		
		return "redirect:list.do";
	}
	
	//삭제
	@RequestMapping("/del_member.do")
	@ResponseBody
	public String delMember(int idx) {
		int res = member_dao.delMember(idx);
		
		String result = "no";
		
		
		if(res == 1) {
			//삭제 성공 시
			result = "yes";
		}
		
		return result;
	}
	
	//유저 상세보기
	@RequestMapping("/member_select_form.do")
	public String MemberDetail(int idx, Model model) {
		MemberVO vo = member_dao.selectOne(idx);
		model.addAttribute("vo", vo);
		return "/member/member_detail";
	}
	
	//유저 업데이트
	@RequestMapping("/member_update.do")
	public String MemberUpdate(MemberVO vo) {
		
		PwdBcrypt pbc = new PwdBcrypt();
		//암호화 전 비밀번호 받기
		String encodePwd = pbc.encodingPwd(vo.getPwd());
		
		//암호화 된 비밀번호 넣기
		vo.setPwd(encodePwd);
		
		int res = member_dao.memberUpdate(vo);
		
		//수정 항목을 갱신
		return "redirect:list.do";
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
