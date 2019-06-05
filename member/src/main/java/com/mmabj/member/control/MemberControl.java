package com.mmabj.member.control;

import com.mmabj.common.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberControl {
    @Autowired
    private MemberService memberService;

    @RequestMapping("/mmabj")
    public String mmm() {
        String member = memberService.member();
        return "123"+member;

    }
}
