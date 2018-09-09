package org.lanqiao.dao;

import org.lanqiao.entity.Caipu;
import org.lanqiao.entity.Collection;

import java.util.List;

/**
 * @作者：dhc
 * @创建时间：21:05 2018/8/27
 * @描述：CollectionDao接口
 */
public interface CollectionDao {
    /**
     *用户添加菜谱到收藏表（获取到菜谱的ID）（王筱萌）
     * @param
     * @return
     */
    public int addCollection(Collection c);

    /**
     * 查询出用户收藏的所有菜谱
     * 王筱萌
     * */
    public List<Caipu> showCollection(Caipu c);

    /**
     * 删除用户收藏的菜谱
     * 王筱萌
     * */
    public int deleteCollection(Collection collection);

    /**
     * 获取收藏数量
     * 王筱萌
     */
    public int getCollectionCount(String s);

    /**
     * 段鸿川
     * 根据菜谱id获得该菜谱有多少人收藏过
     * @param cid
     * @return
     */
    int getCollectedNumByCid(int cid);
}
