package org.lanqiao.dao;

import org.lanqiao.entity.PinglunAndUser;

import java.util.List;

public interface PinglunAndUserDao {


    /**
     * 刘志辉
     * 查询评论
     */
    public List<PinglunAndUser> findPinglun(PinglunAndUser pl);

    /**
     * 刘志辉
     * 查询评论
     */
    public List<PinglunAndUser> findPinglunByd_id(int  d_id);
}
