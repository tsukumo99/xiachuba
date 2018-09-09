package org.lanqiao.service;

import org.lanqiao.entity.User;
import org.lanqiao.queryclass.HomeFriendShow;
import org.lanqiao.queryclass.KitchenShow;

import java.util.List;

/**
 * @作者：dhc
 * @创建时间：18:21 2018/8/29
 * @描述：关注功能接口
 */
public interface AttentionService {
    /**
     * 段鸿川
     * 该方法为当用户登录时返回给servlet的需要在前端首页“下厨房的厨友们”模块的信息
     * @return  返回的是前端所有需要显示的信息
     */
    List<HomeFriendShow> getFriends(int id);

    /**
     * 段鸿川
     * 该方法为当用户未登录时返回给servlet的需要在前端首页“下厨房的厨友们”模块的信息
     * @return 返回的是前端所有需要显示的信息
     */
    List<HomeFriendShow> getFriends();

    /**
     * 段鸿川
     * 增加或者关注
     * @param Uname 被关注人名字
     * @param id 关注人id
     * @return
     */
    int addOrDeleteAttenttion(String Uname, int id, String flag);

    /**
     * 段鸿川
     * 用来获得我的厨房页右上角显示相关信息
     * @param username  我的厨房页中用户名
     * @param myname 当前登录用户名
     * @return
     */
    public KitchenShow getKitchenShowInfo(String username, String myname);

    /**
     * 段鸿川
     * 我的厨房页中当点击当前用户的关注数或者被关注数时，显示相关用户头像和名字
     * @param uid 当前厨房用户
     * @param flag 标识是获取关注的人还是被关注的人
     * @return
     */
    public List<User> getKitchenFollowOrFollowedPersion(int uid, String flag);

    /**
     * 在作品动态页中，当用户未关注任何人，在我关注的人的更新下显示数据库前三条用户数据
     * @param user 当前登录用户
     * @return
     */
    public List<HomeFriendShow> getWorkDynamicFollowPerson(User user);
}
