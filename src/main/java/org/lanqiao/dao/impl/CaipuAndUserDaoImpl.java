package org.lanqiao.dao.impl;

import org.lanqiao.dao.BaseDao;
import org.lanqiao.dao.CaipuAndUserDao;
import org.lanqiao.dao.CaipuDao;
import org.lanqiao.entity.CaipuAndUser;

import java.util.List;

public class CaipuAndUserDaoImpl extends BaseDao<CaipuAndUser> implements CaipuAndUserDao {

    @Override
    public List<CaipuAndUser> findAllCaipuAndUserSort(String field, int pageNumber, int pageSize) {
        List<CaipuAndUser> list;

        System.out.println("findAllCaipuAndSort:"+field+" "+pageNumber+" "+pageSize);

        if(field.equals("c_count")) {
             list = executeQuery("select c_id,c_name,c_image,c_count,c_createtime,u.u_name from Caipu c,`User` u where  c.u_id=u.u_id ORDER BY c_count desc LIMIT ?,?",
                    new Object[]{(pageNumber - 1) * pageSize, pageSize});
        }
        else{
             list = executeQuery("select c_id,c_name,c_image,c_count,c_createtime,u.u_name from Caipu c,`User` u where  c.u_id=u.u_id ORDER BY c_createtime desc LIMIT ?,?",
                    new Object[]{(pageNumber - 1) * pageSize, pageSize});
        }

        for (CaipuAndUser cp: list){
            System.out.println(cp.getC_name());
        }

        return list;
    }

    @Override
    public int getAllCaipuAndUserCount() {
         return getRecordCount("select count(*) from Caipu c,`User` u where  c.u_id=u.u_id");
    }

    @Override
    public List<CaipuAndUser> findAllCaipuAndUser() {
        return  executeQuery("select c_id,c_name,c_image,c_count,c_createtime,u.u_name from Caipu c,`User` u where  c.u_id=u.u_id");
    }
}
