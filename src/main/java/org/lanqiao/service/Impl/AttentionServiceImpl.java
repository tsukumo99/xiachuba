package org.lanqiao.service.Impl;

import org.lanqiao.dao.impl.AttentionDaoImpl;
import org.lanqiao.dao.impl.CaipuDaoImpl;
import org.lanqiao.dao.impl.DynamicDaoImpl;
import org.lanqiao.dao.impl.UserDaoImpl;
import org.lanqiao.entity.Attention;
import org.lanqiao.entity.User;
import org.lanqiao.queryclass.HomeFriendShow;
import org.lanqiao.queryclass.KitchenShow;
import org.lanqiao.service.AttentionService;

import java.util.ArrayList;
import java.util.List;

/**
 * @作者：dhc
 * @创建时间：18:25 2018/8/29
 * @描述：实现AttentionService接口
 */
public class AttentionServiceImpl implements AttentionService {
    AttentionDaoImpl attentionDaoImpl = new AttentionDaoImpl();
    DynamicDaoImpl dynamicDaoImpl = new DynamicDaoImpl();
    CaipuDaoImpl caipuDaoImpl = new CaipuDaoImpl();
    UserDaoImpl userDaoImpl = new UserDaoImpl();
    /**
     * 段鸿川
     * 当用户登录时需要排除已经关注的用户,并且排除自己
     * @param id
     * @return
     */
    @Override
    public List<HomeFriendShow> getFriends(int id) {
        //调DaoImpl获得前3条User数据
        List<User> ret = new UserDaoImpl().getUser(id);
        return new AttentionServiceImpl().getHomeFriendShowList(ret);
    }

    /**
     *段鸿川
     *用户未登录时获得前三条数据
     * @return
     */
    @Override
    public List<HomeFriendShow> getFriends() {
        //调DaoImpl获得前3条User数据
        List<User> ret = new UserDaoImpl().getUser();
        return new AttentionServiceImpl().getHomeFriendShowList(ret);
    }

    /**
     * 段鸿川
     * 循环User数据获得关注数、菜谱数、动态数，添加到re中
     * @param ret
     * @return
     */
    public List<HomeFriendShow> getHomeFriendShowList(List<User> ret){
        List<HomeFriendShow> re = new ArrayList<HomeFriendShow>();
        for (int i = 0; i < ret.size(); i++) {
            HomeFriendShow tem = new HomeFriendShow();
            tem.setUsername(ret.get(i).getU_name());
            tem.setUserAvatar(ret.get(i).getU_image());
            //给tem赋属性值
            tem.setAttentionNum(attentionDaoImpl.getAttentionNum(ret.get(i).getU_id()));
            tem.setMenuNum(caipuDaoImpl.getMenuNum(ret.get(i).getU_id()));
            tem.setWorksNum(dynamicDaoImpl.getDynamicNumById(ret.get(i).getU_id()));
            re.add(tem);
        }
        return re;
    }

    @Override
    public int addOrDeleteAttenttion(String Uname, int id,String flag) {
        int uid = id;
        int oid = userDaoImpl.getIdByUsername(Uname);
        int re;
        //1表示增加关注
        if("1".equals(flag)){
            re = attentionDaoImpl.addAttention(uid,oid);
        }else{
            re = attentionDaoImpl.deleteAttention(uid,oid);
        }
        return re;
    }
    public KitchenShow getKitchenShowInfo(String username,String myname){
        KitchenShow ks = new KitchenShow();
        int uid;
        int attentionNum;
        int followedNum;
        uid = userDaoImpl.getIdByUsername(username);
        //自己的厨房页
        if(username.equals(myname)){
            ks.setIsMyKitchen("true");
        }else{ //别人的厨房页
            ks.setIsMyKitchen("false");
            //判断自己是否关注了该人
            int  isFollowd;
            int myid = userDaoImpl.getIdByUsername(myname);
            isFollowd = attentionDaoImpl.isFollowed(myid,uid);
            if(isFollowd == 1){
                ks.setIsFollowed("true");
            }else{
                ks.setIsFollowed("false");
            }
        }
        attentionNum = attentionDaoImpl.getFollowNum(uid);
        followedNum = attentionDaoImpl.getAttentionNum(uid);
        ks.setAttentionNum(attentionNum);
        ks.setFollowedNum(followedNum);
        return ks;

    }

    @Override
    public List<User> getKitchenFollowOrFollowedPersion(int uid, String flag) {
        List<User> re = new ArrayList<User>();
        //现获取关注该用户的所有人的id或者该用户关注的所有人的id
        List<Attention> user = new ArrayList<Attention>();
        //该用户关注的人
        if(flag.equals("follow")){
            user = attentionDaoImpl.getFollowUserId(uid);
            //循环取出这些用户的头像和用户名
            for (int i = 0; i < user.size(); i++) {
                User temp = new User();
                temp = userDaoImpl.getUsernameAndImage(user.get(i).getO_id());
                re.add(temp);
            }
        }else{ //关注该用户的人
            user = attentionDaoImpl.getFollowedUserId(uid);
            for (int i = 0; i < user.size(); i++) {
                User temp = new User();
                temp = userDaoImpl.getUsernameAndImage(user.get(i).getU_id());
                re.add(temp);
            }
        }
        return re;
    }

    @Override
    public List<HomeFriendShow> getWorkDynamicFollowPerson(User user) {
        List<HomeFriendShow> re = new ArrayList<HomeFriendShow>();
        //int uid = userDaoImpl.getIdByUsername(user.getU_name());
        //判断是否有关注的人(增加登录功能后改回来)
        //List<Attention> atten = attentionDaoImpl.getFollowUserId(uid);
        List<Attention> atten = attentionDaoImpl.getFollowUserId(7);
        if(atten.size() == 0){ //用户未关注任何人，显示数据库数据（这里和首页用户未登录一样，直接调上面的方法）
            re = new AttentionServiceImpl().getFriends();
        }else {
            //因为如果用户登录，re为空，不能返回空，用这个err标记
            HomeFriendShow temp = new HomeFriendShow();
            temp.setUsername("err");
            re.add(temp);
        }
        return re;
    }

    //test
    public static void main(String[] args) {
        List<User> re = new AttentionServiceImpl().getKitchenFollowOrFollowedPersion(1,"followed");
        for (int i = 0; i < re.size(); i++) {
            System.out.println(re.get(i).getU_name()+" "+re.get(i).getU_image());
        }
    }
}
