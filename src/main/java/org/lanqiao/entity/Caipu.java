package org.lanqiao.entity;
import java.util.Date;
/**
 * 菜谱表
 * @author 刘志辉
 */
public class Caipu {
    private  int c_id ;
    private String c_name;
    private String c_made;//材料
    private String c_image;//封面图片
    private String c_step;//步骤文本
    private Date c_createtime ;
    private int c_count ;
    private String c_step_image;
    private String c_introduce;
    private int u_id;

    public Caipu(){

    }

    public Caipu(int c_id, String c_name, String c_made, String c_image, String c_step, Date c_createtime, int c_count, String c_step_image, int u_id,String c_introduce) {
        this.c_id = c_id;
        this.c_name = c_name;
        this.c_made = c_made;
        this.c_image = c_image;
        this.c_step = c_step;
        this.c_createtime = c_createtime;
        this.c_count = c_count;
        this.c_step_image = c_step_image;
        this.u_id = u_id;
        this.c_introduce=c_introduce;
    }

    public String getC_introduce() {
        return c_introduce;
    }

    public void setC_introduce(String c_introduce) {
        this.c_introduce = c_introduce;
    }

    public int getC_id() {
        return c_id;
    }

    public void setC_id(int c_id) {
        this.c_id = c_id;
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public String getC_made() {
        return c_made;
    }

    public void setC_made(String c_made) {
        this.c_made = c_made;
    }

    public String getC_image() {
        return c_image;
    }

    public void setC_image(String c_image) {
        this.c_image = c_image;
    }

    public String getC_step() {
        return c_step;
    }

    public void setC_step(String c_step) {
        this.c_step = c_step;
    }

    public Date getC_createtime() {
        return c_createtime;
    }

    public void setC_createtime(Date c_createtime) {
        this.c_createtime = c_createtime;
    }

    public int getC_count() {
        return c_count;
    }

    public void setC_count(int c_count) {
        this.c_count = c_count;
    }

    public String getC_step_image() {
        return c_step_image;
    }

    public void setC_step_image(String c_step_image) {
        this.c_step_image = c_step_image;
    }

    public int getU_id() {
        return u_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }
}
