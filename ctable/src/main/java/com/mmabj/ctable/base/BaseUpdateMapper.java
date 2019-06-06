package com.mmabj.ctable.base;

import tk.mybatis.mapper.annotation.RegisterMapper;
import tk.mybatis.mapper.common.base.update.UpdateByPrimaryKeyMapper;
import tk.mybatis.mapper.common.base.update.UpdateByPrimaryKeySelectiveMapper;

/**
 * 通用Mapper接口,基础查询
 *
 * @param <T> 不能为空
 * @author will
 */
@RegisterMapper
public interface BaseUpdateMapper<T> extends
        UpdateByPrimaryKeyMapper<T>,
        UpdateByPrimaryKeySelectiveMapper<T> {

}
