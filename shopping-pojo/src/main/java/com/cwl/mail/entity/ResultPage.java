package com.cwl.mail.entity;

import java.util.List;

/**
 * angular前端 分页插件响应对象
 */
public class ResultPage {
    private List rows; //查询出来的区间数
    private Long total; //数据的总记录数

    public List getRows() {
        return rows;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
}
