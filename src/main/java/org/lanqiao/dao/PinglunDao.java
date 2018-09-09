package org.lanqiao.dao;

import org.lanqiao.entity.Pinglun;

import java.util.List;

/**
 * @作者：dhc
 * @创建时间：21:23 2018/8/27
 * @描述：PinglunDao接口
 */
public interface PinglunDao {

    /**
     * 刘志辉
     * 插入评论
     */
    public int addPinglun(Pinglun pl);

    /**
     * 刘志辉
     * 查询评论
     */
    public List<Pinglun> findPinglun(Pinglun pl);

}
