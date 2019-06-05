package com.mmabj.common.service.impl;

import com.mmabj.common.service.MemberService;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {
    @Override
    public String member() {
        return "mmabjjService";
    }
}
