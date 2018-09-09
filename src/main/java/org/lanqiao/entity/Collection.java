package org.lanqiao.entity;
/**
 * 收藏表
 * @author 刘志辉
 */
public class Collection {
    private int u_id;
    private int c_id;

    public  Collection(){}

    public Collection(int u_id, int c_id) {
        this.u_id = u_id;
        this.c_id = c_id;
    }

    public int getU_id() {
        return u_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }

    public int getC_id() {
        return c_id;
    }

    public void setC_id(int c_id) {
        this.c_id = c_id;
    }
}
