package org.lanqiao.dao.impl;

import org.lanqiao.dao.BaseDao;
import org.lanqiao.dao.PinglunDao;
import org.lanqiao.entity.Pinglun;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class PinglunDaoImpl extends BaseDao<Pinglun> implements PinglunDao {
    @Override
    public int addPinglun(Pinglun pl) {
        SimpleDateFormat sDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String p_time= sDateFormat.format(pl.getP_time());
//      Timestamp t=new Timestamp(pl.getP_time().getTime());//让日期时间转换为数据库中的timestamp类型
        int i= executeUpdate("insert into Pinglun(p_content,u_id,d_id,p_time) values(?,?,?,?)",new Object[]{pl.getP_content(),pl.getU_id(),pl.getD_id(),p_time});
        return i;
    }


    @Override
    public List<Pinglun> findPinglun(Pinglun pl) {
        return null;
    }
}
