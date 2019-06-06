package com.mmabj.common.service.impl;

import com.mmabj.common.service.MemberService;
import com.mmabj.ctable.entity.Mmabj;
import com.mmabj.ctable.mapper.MmabjMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    private MmabjMapper mmabjMapper;
    @Override
    public String member() {
        List<Mmabj> mmabjs = mmabjMapper.selectAll();
/*
       for (Mmabj mmabj : mmabjs) {
            mmabj.setId(null);
            mmabjMapper.insert(mmabj);
        }
*/

/*
      for (int i=0;i<10;i++) {
            mmabjMapper.inser();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
*/

        Example cardExample = new Example(Mmabj.class);
        Example.Criteria cardCriteria = cardExample.createCriteria();
        cardCriteria.andEqualTo("id",1);
        List<Mmabj> mmabjs1 = mmabjMapper.selectByExample(cardExample);
        List<Integer> selectmmabj = mmabjMapper.selectmmabj();
        return "mmabjjService"+mmabjs.size();
    }
}
