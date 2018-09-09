package org.lanqiao.dao.impl;

import org.lanqiao.dao.BaseDao;
import org.lanqiao.dao.LiuyanDao;
import org.lanqiao.entity.Liuyan;

import java.util.Date;
import java.util.List;

public class LiuyanDaoImpl extends BaseDao<Liuyan> implements LiuyanDao {
    public int  InsertLiuyan( Liuyan liuyan){
        Object[] obj=new Object []{liuyan.getL_time(),liuyan.getL_content(),liuyan.getU_id(),liuyan.getO_id()};
        return executeUpdate("insert into Liuyan(l_time,l_content,u_id,o_id) values(?,?,?,?)",obj);
    }
    //根据时间显示当前插入的留言，并返回l_id写入前端删除标签的一个属性中
    public int ShowLiuyanByL_time(Date leaveTime){
        return executeQuery("select l_id,l_content from Liuyan where l_time=?",new Object[]{leaveTime}).get(0).getL_id();
    }
    // 页面加载时利用从页面获取的otherName来获取此用户的所有留言
    public List<Liuyan> ShowU_idByO_id(int otherId){
        return executeQuery("select l_id,l_content,u_id,l_time from Liuyan where o_id=? order by l_time desc ",new Object[]{otherId});
    }

    public int deleteLiuyan(int msgId){
        return executeUpdate("delete from Liuyan where l_id=?",new Object[]{msgId});
    }
    public int QueryU_idByMsgid(int msgId){
        return  executeQuery("select u_id from Liuyan where l_id=?",new Object[]{msgId}).get(0).getU_id();
    }





}
