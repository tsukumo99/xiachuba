package org.lanqiao.entity;
/**
 * 关注表
 * @author 刘志辉
 */
public class Attention {
    private int  u_id;
    private int o_id;

    public Attention(){}

    public Attention(int u_id, int o_id) {
        this.u_id = u_id;
        this.o_id = o_id;
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
}
