package org.lanqiao.entity;

import java.util.Date;

public class Reply {
    private int r_id;
    private String r_content;
    private int p_id;
    private int u_id;
    private int o_id;
    private Date r_createTime;

    public Reply(){}

    public Reply(int r_id, String r_content, int p_id, int u_id, int o_id, Date r_createTime) {
        this.r_id = r_id;
        this.r_content = r_content;
        this.p_id = p_id;
        this.u_id = u_id;
        this.o_id = o_id;
        this.r_createTime = r_createTime;
    }

    public int getR_id() {
        return r_id;
    }

    public void setR_id(int r_id) {
        this.r_id = r_id;
    }

    public String getR_content() {
        return r_content;
    }

    public void setR_content(String r_content) {
        this.r_content = r_content;
    }

    public int getP_id() {
        return p_id;
    }

    public void setP_id(int p_id) {
        this.p_id = p_id;
    }

    public int getU_id() {
        return u_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }

    public int getO_id() {
        return o_id;
    }

    public void setO_id(int o_id) {
        this.o_id = o_id;
    }

    public Date getR_createTime() {
        return r_createTime;
    }

    public void setR_createTime(Date r_createTime) {
        this.r_createTime = r_createTime;
    }
}
