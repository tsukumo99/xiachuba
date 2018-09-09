package org.lanqiao.dao.impl;

import org.lanqiao.dao.BaseDao;
import org.lanqiao.dao.LikesDao;
import org.lanqiao.entity.Likes;

import java.util.List;

public  class LikeDaoImpl extends BaseDao<Likes> implements LikesDao {
    @Override
    /**
     * 插入一条点赞记录
     */
    public int addLike(Likes like){
        int i= executeUpdate("insert  into Likes (u_id, d_id) values (?,?) ",new Object[]{like.getU_id(),like.getD_id()});
        return i;
    }

    /**
     * 删除一条点赞记录
     * @param like
     * @return
     */
    @Override
    public int delectLike(Likes like) {
        int i=executeUpdate("delete from Likes Where u_id=? and d_id=?",new Object[]{like.getU_id(),like.getD_id()});
        return i;
    }

    /**
     * 获取用户的点赞状态
     * @param likes
     * @return
     */
    @Override
    public List<Likes> getUserLikes(Likes likes) {
        return executeQuery("select * from Likes Where  u_id=? and d_id=?",new Object[]{likes.getU_id(),likes.getD_id()});
    }
}

