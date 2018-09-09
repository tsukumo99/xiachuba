package org.lanqiao.entity;
import java.util.Date;
/**
 * 留言表
 * @author 刘志辉
 */
public class Liuyan {
    private int l_id ;
    private Date l_time ;
    private String l_content;
    private int u_id;
    private int o_id;

    public Liuyan(){}

    public Liuyan( Date l_time, String l_content, int u_id, int o_id) {
        this.l_id = l_id;
        this.l_time = l_time;
        this.l_content = l_content;
        this.u_id = u_id;
        this.o_id = o_id;
    }

    public int getL_id() {
        return l_id;
    }

    public void setL_id(int l_id) {
        this.l_id = l_id;
    }

    public Date getL_time() {
        return l_time;
    }

    public void setL_time(Date l_time) {
        this.l_time = l_time;
    }

    public String getL_content() {
        return l_content;
    }

    public void setL_content(String l_content) {
        this.l_content = l_content;
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
