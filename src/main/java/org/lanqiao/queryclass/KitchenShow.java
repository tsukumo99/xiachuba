package org.lanqiao.queryclass;

/**
 * @作者：dhc
 * @创建时间：9:56 2018/8/30
 * @描述：用于封装我的厨房页右上角显示前端需要的数据（关注人数，被关注人数，标识<自己的还是别人的厨房>）
 * 如果是别人的厨房页还需传回是否已经关注该人
 */
public class KitchenShow {
    private String isMyKitchen;
    private int attentionNum;
    private int followedNum;
    private String isFollowed;

    public String getIsFollowed() {
        return isFollowed;
    }

    public void setIsFollowed(String isFollowed) {
        this.isFollowed = isFollowed;
    }

    public String getIsMyKitchen() {
        return isMyKitchen;
    }

    public void setIsMyKitchen(String isMyKitchen) {
        this.isMyKitchen = isMyKitchen;
    }

    public int getAttentionNum() {
        return attentionNum;
    }

    public void setAttentionNum(int attentionNum) {
        this.attentionNum = attentionNum;
    }

    public int getFollowedNum() {
        return followedNum;
    }

    public void setFollowedNum(int followedNum) {
        this.followedNum = followedNum;
    }
}
