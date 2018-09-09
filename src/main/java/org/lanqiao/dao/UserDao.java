package org.lanqiao.dao;
import org.lanqiao.entity.User;
import java.util.ArrayList;
import java.util.List;
/**
 * @描述：interface UserDao
 */
public interface UserDao {
    /**
     * 刘志辉
     * 获取用户头像
     */
    public User  getUserImage(User u);

    /**
     * 修改用户信息（更新单列）（王咸林，段）
     * @param u
     * @param
     * @return
     */
    public int updateUserInfo(User u);


    /**
     * 删除用户信息（王咸林）
     * @param
     * @return
     */
    public int deleteUserInfo(User u);

    /**
     * 王筱萌
     * 添加用户
     * @param
     * @return
     */
    public int insertUesrInfo(User u);



    /**
     * 显示所有用户	信息（分页）（王咸林）
     * @param
     * @param
     * @return
     */
    public List<User> showAllUserInfo(int pageNum,int pageSize);

    /**
     * 王三芝
     * 获取用户id
     */
    public int getUserIdByName(String name);

    /**
     * 用过用户的id查找到用户的信息
     * @param
     * @return
     */
    public List<User> findUserById(User u);


    /**
     * 登录验证
     * @param
     * @return
     */
    public User checkLockUser(User u);


        /**
     * 查询数据库的总条数
     * @param
     * @return
     */
    public int CountUser();

    /**
     * 张敏
     *修改用户信息
     * @param u
     * @return
     */
    public int alterUserInfo(User u);

    /**
     * 张敏
     * 获取用户当前密码
     * @param
     * @return
     */
    //public int getUserPassword(int a,String s);
    public List<User> getUserPassword(User user);
    /**
     * 修改用户密码
     * @param u
     * @return
     */
    public int alterPassword(User u);

    /**
     * 添加用户头像
     * @param user
     * @return
     */
    public int addimg(User user);

    /**
     * 获取用户全部信息
     * @param user
     * @return
     */
    public List<User> getUserInfo(User user);

    /**
     * 段鸿川
     * 用户未登录获得数据库前3条用户数据（用户id，名，头像）；
     * @return
     */
    public List<User> getUser();

    /**
     * 段鸿川
     * 用户登录时获得没有关注该用户的其他用户的前三条用户数据（用户id，名，头像）；
     * @param id
     * @return
     */
    public List<User> getUser(int id);

    /**
     * 段鸿川
     * 根据用户名获得用户id
     * @param username
     * @return
     */
    public int getIdByUsername(String username);

    /**
     * 根据用户id获得用户的头像和名字
     * @param uid
     * @return
     */
    public User getUsernameAndImage(int uid);

}
