package org.lanqiao.queryclass;

/**
 * @作者：dhc
 * @创建时间：18:13 2018/8/29
 * @描述：用于封装首页厨友显示的信息
 */
public class HomeFriendShow {
    private String userAvatar;
    private String username;
    private int attentionNum;
    private int menuNum;
    private int worksNum;

    public String getUserAvatar() {
        return userAvatar;
    }

    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAttentionNum() {
        return attentionNum;
    }

    public void setAttentionNum(int attentionNum) {
        this.attentionNum = attentionNum;
    }

    public int getMenuNum() {
        return menuNum;
    }

    public void setMenuNum(int menuNum) {
        this.menuNum = menuNum;
    }

    public int getWorksNum() {
        return worksNum;
    }

    public void setWorksNum(int worksNum) {
        this.worksNum = worksNum;
    }
}
