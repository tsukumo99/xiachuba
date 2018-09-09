package org.lanqiao.dao.impl;
import org.lanqiao.dao.BaseDao;
import org.lanqiao.dao.UserDao;
import org.lanqiao.entity.User;
import org.lanqiao.util.StringToDate;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class UserDaoImpl extends BaseDao<User> implements UserDao  {
    /**
     * 刘志辉
     * 实现获取用户头像
     * @param u
     * @return
     */
    @Override
    public User getUserImage(User u) {
        List<User> listUser=executeQuery("select u_image from User where u_id=?",new Object[]{u.getU_id()});
        return listUser.get(0);
    }

        @Override
    public int updateUserInfo(User u) {
        return executeUpdate("update User set u_name=?,u_password=?,u_sex=?,u_birthday=? ," +
                "u_hometown=?,u_nowlive=?,u_job=?,u_email=?,u_image=?,u_phone=?,u_introduce=? where u_id=?",new Object[]{
                        u.getU_name(),u.getU_password(),u.getU_sex(),u.getU_birthday(),u.getU_hometown(),u.getU_nowlive(),
                u.getU_job(),u.getU_email(),u.getU_image(),u.getU_phone(),u.getU_introduce(),u.getU_id()
        });
    }
    @Override
    public int deleteUserInfo(User u) {
        return executeUpdate("delete from User where u_id = ?",new Object[]{u.getU_id()});
    }

    @Override
    public int insertUesrInfo(User user) {
        return executeUpdate("insert into User(u_name,u_phone,u_password) values(?,?,?)",new Object[]{user.getU_name(),user.getU_phone(),user.getU_password()});
    }

    @Override
    public User checkLockUser(User u) {
        List<User> userList = executeQuery("select * from User" +
                " where u_name = ? and u_password = ?",new Object[]{u.getU_name(),u.getU_password()});
        if(userList.size()>0){
            return userList.get(0);
        }else{
            return null;
        }
    }
//    计算数据库中的总记录数
    @Override
    public int CountUser() {
        return getRecordCount("select count(*) from User");
    }


//    后台数据进行分页
    @Override
    public List<User> showAllUserInfo(int pageNum,int pageSize) {
        return executeQuery("select * from User limit ?,?",new Object[]{(pageNum-1)*pageSize,pageSize});
    }

    @Override
    public List<User> findUserById(User u) {
        List<User> userList = executeQuery("select * from User where u_id=?",new Object[]{u.getU_id()});
       if(userList.size()>0){
           return userList;
       }
        return null;
    }

    /**
     * 张敏
     * 修改用户设置
     * @param u
     * @return
     */
    @Override
    public int alterUserInfo(User u) {
        //,u.getU_birthday()
        String sql="update User set ";
        List<String> list=new ArrayList<String>();
        if(u.getU_name()!=null && u.getU_name()!=""){
            sql+="u_name=? ";
            list.add(u.getU_name());
        }
        if(u.getU_sex()!=null && u.getU_sex()!=""){
            sql+="u_sex=? ";
            list.add(u.getU_sex());
        }
        if(u.getU_hometown()!=null && u.getU_hometown()!=""){
            sql+="u_hometown=? ";
            list.add(u.getU_hometown());
        }
        if(u.getU_nowlive()!=null && u.getU_nowlive()!=""){
            sql+="u_nowlive=? ";
            list.add(u.getU_nowlive());
        }
        if(u.getU_job()!=null && u.getU_job()!=""){
            sql+="u_job=? ";
            list.add(u.getU_job());
        }
        if(u.getU_email()!=null && u.getU_email()!=""){
            sql+="u_email=? ";
            list.add(u.getU_email());
        }
        if(u.getU_introduce()!=null && u.getU_introduce()!=""){
            sql+="u_introduce=? ";
            list.add(u.getU_introduce());
        }
        if(u.getU_birthday()!=null ){
            sql+="u_birthday=? ";
            list.add(StringToDate.DateToStr(u.getU_birthday()));
        }
        sql+=" where u_id = ?";
        list.add(Integer.toString(u.getU_id()));
        if(list.size() != 0){
            String sql1 = sql.replaceAll("\\?","?,");
            String sql2 = sql1.substring(0,sql1.length()-1);
            int index = sql2.lastIndexOf("?,");
            String sql3 = sql2.substring(0,index+1) +sql2.substring(index+2);
            return executeUpdate(sql3,list.toArray());
        }
        return  0;
    }


    /**
     * 查看用户当前密码是否存在
     * @param
     * @return
     */

    @Override
    public List<User> getUserPassword(User user) {
        return executeQuery("select * from User where u_id=? and u_password= ?",new Object[]{user.getU_id(),user.getU_password()});
    }

    /**
     * 更改用户密码
     * @param u
     * @return
     */
    @Override
    public int alterPassword(User u) {
        return executeUpdate("update User set u_password=? where u_id= ? ",new Object[]{u.getU_password(),u.getU_id()});
    }

    /**
     * 添加用户头像
     * @param user
     * @return
     */
    @Override
    public int addimg(User user) {
        int i= executeUpdate("update User Set  u_image= ? where u_id= ? ",new Object[]{user.getU_image(),user.getU_id()});
        return i;
    }

    /**
     * 获取用户头像
     * @param user
     * @return
     */


    @Override
    public List<User> getUserInfo(User user) {
        return executeQuery("select * from User Where u_id=?",new Object[]{user.getU_id()});
    }

    //留言板上通过用户名字获取用户Id
    public   int  getUserIdByName(String name){
        return executeQuery("select u_id from User where u_name=?",new Object[]{name}).get(0).getU_id();
    }
    public   User  getUserById(int userId){
        return executeQuery("select u_name,u_image from User where u_id=?",new Object[]{userId}).get(0);
    }

    @Override
    public List<User> getUser() {
        return executeQuery("select u_id,u_name,u_image from User limit 0,3");
    }
    @Override
    public List<User> getUser(int id){
        return executeQuery("select a.u_id,a.u_name,a.u_image from (select * from User where u_id not in (select u_id from Attention where o_id = ?)) a where a.u_id != ? limit 0,3",new Object[]{id,id});
    }

    @Override
    public int getIdByUsername(String username) {
        List<User> user = executeQuery("select u_id from User where u_name = ?",new Object[]{username});
        return user.get(0).getU_id();
    }

    public static void main(String[] args) {
        System.out.println(new UserDaoImpl().getIdByUsername("张三"));
    }

    @Override
    public User getUsernameAndImage(int uid) {
        List<User> ret = executeQuery("select u_name,u_image from User where u_id = ?",new Object[]{uid});
        return ret.get(0);
    }


}
