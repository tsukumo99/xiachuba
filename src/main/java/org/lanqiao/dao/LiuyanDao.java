package org.lanqiao.dao;

import org.lanqiao.entity.Liuyan;

import java.util.Date;
import java.util.List;

/**
 * @作者：dhc
 * @创建时间：21:05 2018/8/27
 * @描述：LiuyanDao接口
 */
public interface LiuyanDao {

    //添加留言,同时用当前时间，获取l_id,存到前端评论的某个属性中，以便删用
    int  InsertLiuyan( Liuyan liuyan);

    int ShowLiuyanByL_time(Date leaveTime);

    //查询该用户所有留言
    List<Liuyan> ShowU_idByO_id(int otherId);

    //删除留言，根据添加时存的l_id来删除
    int deleteLiuyan(int msgId);

    int QueryU_idByMsgid(int msgId);
}
