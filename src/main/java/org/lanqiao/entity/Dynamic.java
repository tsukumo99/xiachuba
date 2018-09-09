package org.lanqiao.entity;
import java.util.Date;
/**
 * 动态表
 * @author 刘志辉
 */
public class Dynamic {
    private int d_id;
    private String d_image;
    private String d_xinde;
    private Date d_createtime;
    private int u_id;
    private int c_id;
    private int d_count;

    public Dynamic(){}

    public Dynamic(int d_id, String d_image, String d_xinde, Date d_createtime, int u_id, int c_id, int d_count) {
        this.d_id = d_id;
        this.d_image = d_image;
        this.d_xinde = d_xinde;
        this.d_createtime = d_createtime;
        this.u_id = u_id;
        this.c_id = c_id;
        this.d_count = d_count;
    }

    public int getD_id() {
        return d_id;
    }

    public void setD_id(int d_id) {
        this.d_id = d_id;
    }

    public String getD_image() {
        return d_image;
    }

    public void setD_image(String d_image) {
        this.d_image = d_image;
    }

    public String getD_xinde() {
        return d_xinde;
    }

    public void setD_xinde(String d_xinde) {
        this.d_xinde = d_xinde;
    }

    public Date getD_createtime() {
        return d_createtime;
    }

    public void setD_createtime(Date d_createtime) {
        this.d_createtime = d_createtime;
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

    public int getD_count() {
        return d_count;
    }

    public void setD_count(int d_count) {
        this.d_count = d_count;
    }
}
