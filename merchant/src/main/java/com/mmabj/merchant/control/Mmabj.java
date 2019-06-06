package com.mmabj.merchant.control;

import com.mmabj.common.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mm")
public class Mmabj {
    @Autowired
    private MemberService memberService;

    @RequestMapping("/mmabj")
    public  String mm() {
        String member ="gg"+ memberService.member();
        return  "mmabjjmm"+member;
    }
}
