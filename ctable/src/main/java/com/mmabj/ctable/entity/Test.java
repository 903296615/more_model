package com.mmabj.ctable.entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.Data;

import java.util.Date;

@Data
@Table(name="test")
public class Test {
    @Column(name="id",type = MySqlTypeConstant.INT,length = 11,isKey = true,isAutoIncrement = true)
    private Integer id;

    @Column(name="name",type = MySqlTypeConstant.VARCHAR,length = 20)
    private String name;

    @Column(name="description",type = MySqlTypeConstant.TEXT)
    private String description;

    @Column(name="create_time",type = MySqlTypeConstant.DATETIME)
    private Date create_time;

    @Column(name="update_time",type=MySqlTypeConstant.DATETIME)
    private Date update_time;

    @Column(name="number",type = MySqlTypeConstant.BIGINT)
    private long number;

    @Column(name="lifecycle",type = MySqlTypeConstant.VARCHAR)
    private String lifecycle;

    @Column(name="dekes",type = MySqlTypeConstant.INT)
    private Double dekes;

}
