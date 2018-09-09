package org.lanqiao.entity;
import java.util.Date;
/**
 * 用户表
 * @author 刘志辉
 */
public class User {
    private  int u_id;
    private String u_name;
    private String u_password;
    private String  u_sex;
    private Date u_birthday;
    private String u_hometown;
    private String u_nowlive;
    private String u_job;
    private String u_email;
    private String u_image;
    private String u_phone;
    private String u_introduce;

    public User(){}

//    User upUser =new User(id,name,sex,hometown,nowlive,job,email,introduce,birthday1);


    public User(int u_id, String u_name,String u_sex,String u_hometown,String u_nowlive,String u_job,String u_email,String u_introduce,Date u_birthday) {
        this.u_id = u_id;
        this.u_name = u_name;
        this.u_sex=u_sex;
        this.u_hometown=u_hometown;
        this.u_nowlive=u_nowlive;
        this.u_job=u_job;
        this.u_email=u_email;
        this.u_introduce=u_introduce;
        this.u_birthday=u_birthday;
    }

    public User(int u_id, String u_name, String u_password, String u_sex, Date u_birthday, String u_hometown, String u_nowlive, String u_job, String u_email, String u_image, String  u_phone, String u_introduce) {
        this.u_id = u_id;
        this.u_name = u_name;
        this.u_password = u_password;
        this.u_sex = u_sex;
        this.u_birthday = u_birthday;
        this.u_hometown = u_hometown;
        this.u_nowlive = u_nowlive;
        this.u_job = u_job;
        this.u_email = u_email;
        this.u_image = u_image;
        this.u_phone = u_phone;
        this.u_introduce = u_introduce;
    }

    public int getU_id() {
        return u_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }

    public String getU_name() {
        return u_name;
    }

    public void setU_name(String u_name) {
        this.u_name = u_name;
    }

    public String getU_password() {
        return u_password;
    }

    public void setU_password(String u_password) {
        this.u_password = u_password;
    }

    public String getU_sex() {
        return u_sex;
    }

    public void setU_sex(String u_sex) {
        this.u_sex = u_sex;
    }

    public Date getU_birthday() {
        return u_birthday;
    }

    public void setU_birthday(Date u_birthday) {
        this.u_birthday = u_birthday;
    }

    public String getU_hometown() {
        return u_hometown;
    }

    public void setU_hometown(String u_hometown) {
        this.u_hometown = u_hometown;
    }

    public String getU_nowlive() {
        return u_nowlive;
    }

    public void setU_nowlive(String u_nowlive) {
        this.u_nowlive = u_nowlive;
    }

    public String getU_job() {
        return u_job;
    }

    public void setU_job(String u_job) {
        this.u_job = u_job;
    }

    public String getU_email() {
        return u_email;
    }

    public void setU_email(String u_email) {
        this.u_email = u_email;
    }

    public String getU_image() {
        return u_image;
    }

    public void setU_image(String u_image) {
        this.u_image = u_image;
    }

    public String getU_phone() {
        return u_phone;
    }

    public void setU_phone(String  u_phone) {
        this.u_phone = u_phone;
    }

    public String getU_introduce() {
        return u_introduce;
    }

    public void setU_introduce(String u_introduce) {
        this.u_introduce = u_introduce;
    }
}
