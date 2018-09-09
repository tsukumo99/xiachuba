package org.lanqiao.dao;

import org.lanqiao.entity.Dynamic;
import org.lanqiao.entity.User;

import java.util.List;

/**
 * @作者：dhc
 * @创建时间：21:21 2018/8/27
 * @描述：DynaimicDao接口
 */
public interface DynamicDao {
    /**
     * 发表动态（刘志辉）
     * @param d
     * @return
     */
    public int addDynamic(Dynamic d);

    /**
     * 刘志辉
     * 功能：查询动态所有记录条数
     */
    public int getAllDynamicCount();
    /**
     * 刘志辉
     * 功能：添加动态
     */
    public int createDynamic(Dynamic dynamic);

    /**
     * 根据用户名查询作品所有信息(段)
     * @param username
     * @return
     */
    //public List<Dynamic> findDynamic(String username);

    /**
     * 更新用户的信息
     * @param
     * @return
     */
    public int updateDynamic(Dynamic d);//点赞，要先判断，根据文本内	容

    /**
     * 显示所有得动态（分页）
     * @param  pageNum，pageSize
     * @return List<Dynamic>
     */
    public List<Dynamic> showDynamic(int pageNum, int pageSize);

    /**
     * 后台用于查询
     * @param
     * @return List<Dynamic>
     */
    public List<Dynamic> findUserById(Dynamic d);



    /**
     * 删除动态
     * @param d
     * @return List<Dynamic>
     */
    public int deleteDynamic(Dynamic d);


    /**
     * 统计动态的总数量（王咸林）
     * @param
     * @return
     */
    public int getDynamicCount();

    /**
     * 获得某人发表动态数
     * @param id
     * @return
     */
    int getDynamicNumById(int id);

    /**
     * 根据菜谱id来查询该菜谱被多少人做过
     * @param cid
     * @return
     */
    int getDidNumByCid(int cid);

}
