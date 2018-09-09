package org.lanqiao.dao;

import org.lanqiao.entity.Attention;

import java.util.List;

/**
 * @作者：dhc
 * @创建时间：21:05 2018/8/27
 * @描述：AttentionDao接口
 */
public interface AttentionDao {
    /**
     * 段鸿川
     * 获得某人的被关注数
     * @param id
     * @return
     */
    int getAttentionNum(int id);

    /**
     * 段鸿川
     * 获得某人关注的别人的数
     * @param id
     * @return
     */
    int getFollowNum(int id);
    /**
     * 段鸿川
     * 增加关注
     * @param uid 被关注人id
     * @param oid 关注人id
     * @return
     */
    int addAttention(int uid,int oid);
    /**
     * 段鸿川
     * 删除关注
     * @param uid 被关注人id
     * @param oid 关注人id
     * @return
     */
    int deleteAttention(int uid,int oid);

    /**
     * 段鸿川
     * 判断某人是否关注了某人
     * @param uid
     * @param oid
     * @return
     */
    int isFollowed(int uid,int oid);

    /**
     * 根据用户id获得用户关注的人
     * @param uid
     * @return
     */
    List<Attention> getFollowUserId(int uid);

    /**
     * 根据用户获得关注该用户的所有人的id
     * @param oid
     * @return
     */
    List<Attention> getFollowedUserId(int oid);
}
