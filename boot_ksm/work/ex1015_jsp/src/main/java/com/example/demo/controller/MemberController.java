package com.example.demo.controller;

import com.example.demo.model.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MemberController {

    private List<Member> members = List.of( new Member(1l, "홍길동", "hong@a.com", 10),
            new Member(2l, "김길동", "kim@a.com", 50),
            new Member(3l, "박길순", "park@a.com", 60),
            new Member(4l, "김말똥", "ddong@a.com", 70));

    @GetMapping("/member/list")
    public String getMembers(Model model){
        model.addAttribute("members", members);
        return "member-list";
    }

}
