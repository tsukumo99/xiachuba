package org.lanqiao.entity;

import java.util.Date;

/**
 *查询类(将要在留言板上显示的属性封装成一个ShowMsg类)
 */
public class ShowMsg {
    String username;
    String Avatar;
    int  time;
    String msg;
    int msgId;
    public ShowMsg(){}
    public ShowMsg( String userName,String Avatar,int time, String msgContent,int msgId){
        this.username=userName;
        this.Avatar=Avatar;
        this.time=time;
        this.msg=msgContent;
        this.msgId= msgId;
    }

    public int getMsgId() {
        return msgId;
    }

    public void setMsgId(int msgId) {
        this.msgId = msgId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAvatar() {
        return Avatar;
    }

    public void setAvatar(String avatar) {
        Avatar = avatar;
    }

    public int  getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
