package org.lanqiao.dao;

import org.lanqiao.entity.CaipuAndUser;

import java.util.List;

public interface CaipuAndUserDao {
    /**
     * 刘志辉
     * 分页查询所有菜谱与用户链接的表并根据条件(收藏量，时间)排序
     * @return
     */
    public List<CaipuAndUser> findAllCaipuAndUserSort(String field, int pageNumber, int pageSize );

    /**
     * 获取所有菜谱与用户链接的表的记录数，分页用
     * 刘志辉
     */
    public int getAllCaipuAndUserCount();

    /**
     * 刘志辉
     * 获取所有菜谱和用户名
     */
    public List<CaipuAndUser> findAllCaipuAndUser();

}
