package org.lanqiao.dao.impl;

import org.lanqiao.dao.BaseDao;
import org.lanqiao.dao.PinglunAndUserDao;
import org.lanqiao.dao.PinglunDao;
import org.lanqiao.entity.PinglunAndUser;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class PinglunAndUserDaoImpl extends BaseDao<PinglunAndUser> implements PinglunAndUserDao {

    /**
     * 刘志辉
     * 评论用
     * @param pl
     * @return
     */
    @Override
    public List<PinglunAndUser> findPinglun(PinglunAndUser pl) {

        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String p_time=simpleDateFormat.format(pl.getP_time());

        return executeQuery("select p_id,p_content,u_name,u_image,u_nowlive,p_time from Pinglun a,User b  " +
                        "where a.u_id=b.u_id and a.u_id=? and a.d_id=? and p_time=?",
                new Object[]{pl.getU_id(),pl.getD_id(),p_time});
    }

    @Override
    public List<PinglunAndUser> findPinglunByd_id(int d_id) {
        return executeQuery("select p_id,p_content,u_name,u_image,u_nowlive,p_time from Pinglun a,User b  " +
                "where a.u_id=b.u_id and a.d_id=? ",new Object[]{d_id});
    }
}
