package org.lanqiao.dao;

import org.lanqiao.entity.Likes;

import java.util.List;

public interface LikesDao {
    /**
     * 增加点赞记录
     * @param like
     * @return
     */
    public int addLike(Likes like);

    /**
     * 删除点赞记录
     * @param likes
     * @return
     */
    public int delectLike(Likes likes);

    /**
     * 获取用户的点赞状态
     * @param likes
     * @return
     */
    public List<Likes> getUserLikes(Likes likes);
}
