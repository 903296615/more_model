package com.mmabj.ctable.base;

import tk.mybatis.mapper.annotation.RegisterMapper;
import tk.mybatis.mapper.common.base.insert.InsertMapper;
import tk.mybatis.mapper.common.base.insert.InsertSelectiveMapper;

/**
 * 通用Mapper接口,基础查询
 *
 * @param <T> 不能为空
 * @author will
 */
@RegisterMapper
public interface BaseInsertMapper<T> extends
        InsertMapper<T>,
        InsertSelectiveMapper<T> {

}
