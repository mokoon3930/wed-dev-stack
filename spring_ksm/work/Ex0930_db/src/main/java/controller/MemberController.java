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
	
	// set���������� �ޱ�
	public void setMember_dao(MemberDAO member_dao) {
		this.member_dao = member_dao;
	}
	
	//value = {"/","list.do"} - ��ΰ� �ִ� ���� ��� ���� ����
	@RequestMapping(value= {"/", "list.do"})
	public String list(Model model) {
		List<MemberVO> list = member_dao.selectList();
		model.addAttribute("list", list); // ���ε�
		return "member/member_list"; // ������
	}
	
	@RequestMapping("member_regi_form.do")
	public String MemberForm() {
		return "member/member_regi";
	
	}
	
	//member_insert.do?
	@RequestMapping("member_insert.do")
	public String memberInsert(MemberVO vo) {
		
		PwdBcrypt pbc = new PwdBcrypt();
		//��ȣȭ �� ��й�ȣ �ޱ�
		String encodePwd = pbc.encodingPwd(vo.getPwd());
		
		//��ȣȭ �� ��й�ȣ �ֱ�
		vo.setPwd(encodePwd);
		
		int res = member_dao.memberInsert(vo);
		
		return "redirect:list.do";
	}
	
	//����
	@RequestMapping("/del_member.do")
	@ResponseBody
	public String delMember(int idx) {
		int res = member_dao.delMember(idx);
		
		String result = "no";
		
		
		if(res == 1) {
			//���� ���� ��
			result = "yes";
		}
		
		return result;
	}
	
	//���� �󼼺���
	@RequestMapping("/member_select_form.do")
	public String MemberDetail(int idx, Model model) {
		MemberVO vo = member_dao.selectOne(idx);
		model.addAttribute("vo", vo);
		return "/member/member_detail";
	}
	
	//���� ������Ʈ
	@RequestMapping("/member_update.do")
	public String MemberUpdate(MemberVO vo) {
		
		PwdBcrypt pbc = new PwdBcrypt();
		//��ȣȭ �� ��й�ȣ �ޱ�
		String encodePwd = pbc.encodingPwd(vo.getPwd());
		
		//��ȣȭ �� ��й�ȣ �ֱ�
		vo.setPwd(encodePwd);
		
		int res = member_dao.memberUpdate(vo);
		
		//���� �׸��� ����
		return "redirect:list.do";
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
