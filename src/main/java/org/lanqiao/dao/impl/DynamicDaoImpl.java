package org.lanqiao.dao.impl;

import org.lanqiao.dao.BaseDao;
import org.lanqiao.dao.DynamicDao;
import org.lanqiao.entity.Dynamic;
import org.lanqiao.entity.User;

import java.util.List;

public class DynamicDaoImpl extends BaseDao<Dynamic> implements DynamicDao {
    /**
     * 刘志辉
     * 发表动态
     * @param dynamic
     * @return
     */
    @Override
    public int createDynamic(Dynamic dynamic){
        return    executeUpdate("insert into Dynamic(d_image,d_xinde,u_id,c_id) VALUES(?,?,?,?)",
                    new Object[]{dynamic.getD_image(),dynamic.getD_xinde(),dynamic.getU_id(),dynamic.getC_id()});
    }
    /**
     * 刘志辉
     * 功能：查询动态所有记录条数
     */
    public int getAllDynamicCount(){
     return  getRecordCount("select count(*) from Dynamic");
    }

    @Override
    public int addDynamic(Dynamic d) {
        return 0;
    }

    @Override
    public int updateDynamic(Dynamic d) {
        return 0;
    }

    @Override
    public List<Dynamic> showDynamic(int pageNum, int pageSize) {
        return executeQuery("select * from Dynamic limit ?,?",new Object[]{(pageNum-1)*pageSize,pageSize});
    }

    @Override
    public List<Dynamic> findUserById(Dynamic d) {
        List<Dynamic> dynamicList = executeQuery("select * from Dynamic  where d_id=?",new Object[]{d.getD_id()});
        if(dynamicList.size()>0){
            return dynamicList;
        }
        return null;
    }

    @Override
    public int deleteDynamic(Dynamic d) {
        return executeUpdate("delete from Dynamic where d_id=?",new Object[]{d.getD_id()});
    }

    @Override
    public int getDynamicCount() {
        return 0;
    }

    public int getDynamicNumById(int id){
        return getRecordCount("select count(d_id) from Dynamic where u_id="+id);
    }

    @Override
    public int getDidNumByCid(int cid) {
        return getRecordCount("select count(d_id) from Dynamic where c_id = "+cid);
    }

    public static void main(String[] args) {
        System.out.println(new DynamicDaoImpl().getDidNumByCid(2));
    }



}
