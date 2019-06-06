package com.mmabj.ctable.mapper;


import com.mmabj.ctable.entity.Mmabj;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
public interface MmabjMapper extends Mapper<Mmabj> {
    List<Integer> selectmmabj();
    void  inser();
}
