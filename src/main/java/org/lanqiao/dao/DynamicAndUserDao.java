package org.lanqiao.dao;

import org.lanqiao.entity.Dynamic;
import org.lanqiao.entity.DynamicAndUser;

import java.util.List;

public interface DynamicAndUserDao {
    /**
     * 刘志辉
     * 功能：查询所有记录
     */
    public List<DynamicAndUser> findAllDynamicAndUser();

}
