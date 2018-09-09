package org.lanqiao.dao;

import org.lanqiao.entity.Caipu;
import org.lanqiao.entity.User;

import java.util.List;

/**
 * @作者：dhc
 * @创建时间：21:02 2018/8/27
 * @描述：CaipuDao接口
 */
public interface CaipuDao {

    /**
     * 刘志辉
     * 分页查询所有菜谱并根据条件(收藏量，时间)排序
     * @return
     */
    public List<Caipu> findAllCaipuAndSort(String field,int pageNumber,int pageSize );

    /**
     * 获取所有菜谱的记录数，分页用
     * 刘志辉
     */
    public int getAllCaipuCount();

    /**
     * 不确定条件查询数据
     */
    public List<Caipu> findCaipuByfield(Caipu cp);

    /**
     * 删除菜谱
     */
    public int deleteCaipu(Caipu caipu);


    /**
     * 导航栏查询
     * 关键字模糊查询菜名
     * 通过菜名精确查询
     *王三芝
     * @param
     * @return
     */
    public List<Caipu> searchC_nameQuery(String keyword);


    /**
     * 后台用于添加菜谱
     */
    public int addCaipu(Caipu cp);

    /**
     * 后台根据ID查询
     */

    public List<Caipu> findUserById(Caipu c);



    /**
     * 后台显示分页（王咸林）
     * @param pageNum,pageSize
     * @return
     */
    public List<Caipu> showCaipu(int pageNum,int pageSize);

    /**
     * 段鸿川
     * 获得某人创建的菜谱数
     * @param id
     * @return
     */
    int getMenuNum(int id);

    /**
     * 段鸿川
     * 创建菜谱
     * @param caipu
     * @return
     */
    int createMenu(Caipu caipu);

    /**
     * 段鸿川
     * 用于我的厨房页菜谱的显示
     * 查询菜谱的封面、名字、id
     * @param uid
     * @return
     */
    List<Caipu> listAllMenuByUid(int uid);

}
