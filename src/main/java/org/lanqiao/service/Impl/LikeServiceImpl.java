package org.lanqiao.service.Impl;

import org.lanqiao.dao.impl.LikeDaoImpl;
import org.lanqiao.dao.impl.UserDaoImpl;
import org.lanqiao.entity.Likes;
import org.lanqiao.service.LikeService;

public class LikeServiceImpl implements LikeService {
    @Override
    public int addOrCancelLike(String flag, int uId, int dId) {
        int ret=-1;
        if(flag.equals("like")){
             Likes like=new Likes();
             like.setU_id(uId);
             like.setD_id(dId);
           ret = new LikeDaoImpl().addLike(like);
        }
        if(flag.equals("liked")){
            Likes like=new Likes();
            like.setU_id(uId);
            like.setD_id(dId);
           ret = new LikeDaoImpl().delectLike(like);
        }
        return ret;
    }

}
