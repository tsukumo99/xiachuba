package org.lanqiao.dao.impl;

import org.lanqiao.dao.BaseDao;
import org.lanqiao.dao.ReplyDao;
import org.lanqiao.entity.Reply;

public class ReplyDaoImpl extends BaseDao<Reply> implements ReplyDao {

    /**
     * 刘志辉
     * 添加回复评论
     */
    @Override
    public int addReply(Reply r) {
        return executeUpdate("insert into Reply values(?,?,?,?)",
                new Object[]{r.getR_content(),r.getP_id(),r.getU_id(),r.getO_id()});
    }
}
