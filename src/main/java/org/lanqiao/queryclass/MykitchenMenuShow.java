package org.lanqiao.queryclass;

/**
 * @作者：dhc
 * @创建时间：9:30 2018/9/3
 * @描述：用于我的厨房菜谱显示，显示信息包括菜谱封面、菜谱名字、做过人数（动态数）、收藏数
 */
public class MykitchenMenuShow {
    private String c_image;
    private String c_name;
    private int didNum;
    private int collectedNum;

    public MykitchenMenuShow(){

    }
    public MykitchenMenuShow(String c_image,String c_name,int didNum,int collectedNum){
        this.c_image = c_image;
        this.c_name = c_name;
        this.didNum = didNum;
        this.collectedNum = collectedNum;
    }
    public String getC_image() {
        return c_image;
    }

    public void setC_image(String c_image) {
        this.c_image = c_image;
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public int getDidNum() {
        return didNum;
    }

    public void setDidNum(int didNum) {
        this.didNum = didNum;
    }

    public int getCollectedNum() {
        return collectedNum;
    }

    public void setCollectedNum(int collectedNum) {
        this.collectedNum = collectedNum;
    }
}
