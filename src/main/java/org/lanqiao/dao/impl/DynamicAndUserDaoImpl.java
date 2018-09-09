package org.lanqiao.dao.impl;

import org.lanqiao.dao.BaseDao;
import org.lanqiao.dao.DynamicAndUserDao;
import org.lanqiao.entity.DynamicAndUser;

import java.util.List;

public class DynamicAndUserDaoImpl extends BaseDao<DynamicAndUser> implements DynamicAndUserDao {
    /**
     * 查出所有用户发表的动态
     * 刘志辉
     * @return
     */
    @Override
    public List<DynamicAndUser> findAllDynamicAndUser() {
        return executeQuery("select d_id,d_image,d_xinde,d_createtime,Dynamic.u_id,c_id,d_count,u_name,u_image from Dynamic,User where Dynamic.u_id=`User`.u_id");
    }
}
