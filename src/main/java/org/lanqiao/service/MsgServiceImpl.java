package org.lanqiao.service;

import org.lanqiao.dao.impl.LiuyanDaoImpl;
import org.lanqiao.dao.impl.UserDaoImpl;
import org.lanqiao.entity.Liuyan;
import org.lanqiao.entity.ShowMsg;
import org.lanqiao.entity.User;
import org.lanqiao.entity.ShowMsg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class MsgServiceImpl implements LiuyanService {
    private UserDaoImpl userDaoImpl = new UserDaoImpl();
    private LiuyanDaoImpl liuyanDaoImpl = new LiuyanDaoImpl();
    Date date = new Date();
    @Override
    public ShowMsg insertMsg(String msg, String otherName, User user) {
        //先插入
        //1、封装Liuyan对象

         String userName=user.getU_name();
         int  myId= user.getU_id();
         String  Avatar=user.getU_image();
        //获得被留言人的Id

         int otherId = userDaoImpl.getUserIdByName(otherName);
          Date leaveTime=new Date();
         Liuyan liuyan=new Liuyan(leaveTime,msg,myId,otherId);
        //2、调LiuyanDao插入

        int ret= liuyanDaoImpl.InsertLiuyan(liuyan);


        //判断插入成功与否
        int msgId = 0;
        if(ret==1){
             msgId= liuyanDaoImpl.ShowLiuyanByL_time(leaveTime);
          }

        //时间处理;计算出留言时间与系统当前时间的时间差（分钟）
        long dif = date.getTime() - leaveTime.getTime();
        long day= dif /(24*60*60*1000);
        long hour=( dif /(60*60*1000)-day*24);
        long min=(( dif /(60*1000))-day*24*60-hour*60);
        long allMIN = hour*24+min;
        int time=Integer.parseInt(String.valueOf(allMIN));
        //封装成ShowMsg对象
        ShowMsg  showMsg =new ShowMsg(userName,Avatar,time,msg,msgId);
        return showMsg;
    }

    @Override
    public List<ShowMsg>  showMsg(String otherName){
        List<ShowMsg>  res = new ArrayList<>();
        int otherId = new UserDaoImpl().getUserIdByName(otherName);
        List<Liuyan> list= new LiuyanDaoImpl().ShowU_idByO_id(otherId);
        for(int i=0;i<list.size();i++) {
            User user= userDaoImpl.getUserById(list.get(i).getU_id());
           String  Avatar=user.getU_image();
           String userName= user.getU_name();
            int  msgId=list.get(i).getL_id();
            Date  leaveTime= list.get(i).getL_time();
            Date  date =new Date();
            long dif = date.getTime() - leaveTime.getTime();
            long day= dif /(24*60*60*1000);
            long hour=( dif /(60*60*1000)-day*24);
            long min=(( dif /(60*1000))-day*24*60-hour*60);
            long allMIN = hour*24+min;
            int time=Integer.parseInt(String.valueOf(allMIN));
            String  msg=list.get(i).getL_content();
            ShowMsg  showMsg =new ShowMsg(userName,Avatar,time,msg,msgId);
            res.add(showMsg);
        }
        return res;
    }


}
