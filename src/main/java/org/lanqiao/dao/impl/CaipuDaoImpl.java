package org.lanqiao.dao.impl;

import org.lanqiao.dao.BaseDao;
import org.lanqiao.dao.CaipuDao;
import org.lanqiao.entity.Caipu;
import org.lanqiao.entity.User;

import java.util.ArrayList;
import java.util.List;

public class CaipuDaoImpl extends BaseDao<Caipu> implements CaipuDao {
    /**
     * 刘志辉
     * 查询所有菜谱并根据条件(收藏量，时间)排序
     * @return
     */
    @Override
    public List<Caipu> findAllCaipuAndSort(String field,int pageNumber,int pageSize) {
        System.out.println("CaipuDaoImpl:"+field+" "+pageNumber+" "+pageSize);
        List<Caipu> list= executeQuery("select c_id,c_name,c_image,c_count,c_createtime from Caipu ORDER BY ? desc LIMIT ?,?",new Object[]{field,(pageNumber-1)*pageSize,pageSize});

        for (Caipu cp: list){
            System.out.println(cp.getC_name());
        }

        return list;
    }
    /**
     * 获取所有菜谱记录数,分页用
     * 刘志辉
     */
    public int getAllCaipuCount(){
         return getRecordCount("select count(*) from Caipu");
    }


     @Override
    public List<Caipu> findCaipuByfield(Caipu cp) {
        String sql="select * from Caipu where 1=1";
        List<Object> list =new ArrayList<Object>();

        if(cp.getC_name()!=null && cp.getC_name()!=""){
            sql+=" and c_name=? ";
            list.add(cp.getC_name());
        }
        if(cp.getU_id()!=0){
            sql+=" and u_id=? ";
            list.add(cp.getU_id());
        }

        return executeQuery(sql,list.toArray());
    }


//    数据库菜谱的删除
    @Override
    public int deleteCaipu(Caipu caipu) {
            return executeUpdate("delete from  Caipu where c_id=?",new Object[]{caipu.getC_id()});

    }


    /**
     * 导航栏查询
     * 关键字模糊查询菜名
     * 通过菜名精确查询
     *王三芝
     * @param
     * @return
     */
    public List<Caipu> searchC_nameQuery(String keyword) {
        return executeQuery( "select c_name from Caipu where c_name like  \"%\"?\"%\" ",new Object[]{keyword});
//        return executeQuery( "select c_name from Caipu where c_name like ?",new Object[]{"%"+keyword+"%"});
    }

    @Override
    public int addCaipu(Caipu cp) {
        return executeUpdate("insert into Caipu (c_name,c_made,c_image,c_step,c_count,c_step_image,u_id,c_introduce) " +
                "values (?,?,?,?,?,?,?,?)",new Object[]{cp.getC_name(),cp.getC_made(),cp.getC_image(),cp.getC_step(),cp.getC_count(),cp.getC_step_image()
                ,cp.getU_id(),cp.getC_introduce()});
    }

    @Override
    public List<Caipu> findUserById(Caipu c) {
        List<Caipu> caipuList = executeQuery("select * from Caipu where c_id=?",new Object[]{c.getC_id()});
        if(caipuList.size()>0){
            return caipuList;
        }
        return null;
    }

    @Override
    public List<Caipu> showCaipu(int pageNum, int pageSize) {
        return executeQuery("select * from Caipu limit ?,?",new Object[]{(pageNum-1)*pageSize,pageSize});
    }

    /**
     *段鸿出
     * 获得某人创建的菜谱数
     * @param id
     * @return
     */
    public int getMenuNum(int id){
        return getRecordCount("select count(c_id) from Caipu where u_id="+id);
    }

    @Override
    public int createMenu(Caipu caipu) {
        String sql = "insert into Caipu(c_name,c_made,c_image,c_step,c_step_image,u_id,c_introduce) values(?,?,?,?,?,?,?)";
        Object[] objArray = new Object[]{caipu.getC_name(),caipu.getC_made(),caipu.getC_image(),caipu.getC_step(),caipu.getC_step_image(),caipu.getU_id(),caipu.getC_introduce()};
        return executeUpdate(sql,objArray);
    }

    @Override
    public List<Caipu> listAllMenuByUid(int uid) {
        return executeQuery("select c_id,c_name,c_image from Caipu where u_id = ?",new Object[]{uid});
    }

//    public static void main(String[] args) {
//        CaipuDaoImpl c=new CaipuDaoImpl();
//        int i= c.getMenuNum(6);
//        System.out.println(i);
//    }

}
