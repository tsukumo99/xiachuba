package org.lanqiao.entity;
import java.util.Date;
/**
 * 评论表
 * @author 刘志辉
 */
public class Pinglun {
    private int  p_id;
    private String p_content;
    private int u_id;
    private int d_id;
    private Date p_time;

    public  Pinglun(){}

    public Pinglun(int p_id, String p_content, int u_id, int d_id, Date p_time) {
        this.p_id = p_id;
        this.p_content = p_content;
        this.u_id = u_id;
        this.d_id = d_id;
        this.p_time = p_time;
    }

    public int getP_id() {
        return p_id;
    }

    public void setP_id(int p_id) {
        this.p_id = p_id;
    }

    public String getP_content() {
        return p_content;
    }

    public void setP_content(String p_content) {
        this.p_content = p_content;
    }

    public int getU_id() {
        return u_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }

    public int getD_id() {
        return d_id;
    }

    public void setD_id(int d_id) {
        this.d_id = d_id;
    }

    public Date getP_time() {
        return p_time;
    }

    public void setP_time(Date p_time) {
        this.p_time = p_time;
    }
}
