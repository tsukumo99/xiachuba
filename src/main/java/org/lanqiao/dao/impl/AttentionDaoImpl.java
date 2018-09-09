package org.lanqiao.dao.impl;

import org.lanqiao.dao.AttentionDao;
import org.lanqiao.dao.BaseDao;
import org.lanqiao.entity.Attention;

import java.util.List;

public class AttentionDaoImpl extends BaseDao<Attention> implements AttentionDao {
    @Override
    public int getAttentionNum(int id){
        return getRecordCount("select count(*) from Attention where o_id = "+id);
    }

    @Override
    public int addAttention(int uid, int oid) {
        return executeUpdate("insert into Attention values(?,?)",new Object[]{uid,oid});
    }

    @Override
    public int deleteAttention(int uid, int oid) {
        return executeUpdate("delete from Attention where u_id = ? and o_id = ?",new Object[]{uid,oid});
    }

    @Override
    public int getFollowNum(int id) {
        return getRecordCount("select count(*) from Attention where u_id = "+id);
    }

    @Override
    public int isFollowed(int uid, int oid) {
        return getRecordCount("select count(*) from Attention where u_id = "+uid+" and o_id = " + oid);
    }

    public static void main(String[] args) {
        System.out.println(new AttentionDaoImpl().isFollowed(1,2));
    }

    @Override
    public List<Attention> getFollowUserId(int uid) {
        return executeQuery("select o_id from Attention where u_id = ?",new Object[]{uid});
    }

    @Override
    public List<Attention> getFollowedUserId(int oid) {
        return executeQuery("select u_id from Attention where o_id = ?",new Object[]{oid});
    }
}
