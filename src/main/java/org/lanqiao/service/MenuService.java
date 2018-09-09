package org.lanqiao.service;

import org.lanqiao.entity.Caipu;
import org.lanqiao.queryclass.MykitchenMenuShow;

import java.util.List;

/**
 * @作者：dhc
 * @创建时间：16:21 2018/9/2
 * @描述：创建菜谱功能接口
 */
public interface MenuService {
    /**
     * 段鸿川
     * 创建菜谱
     * @param caipu
     * @return
     */
    public int createMenu(Caipu caipu);

    /**
     * 段鸿川
     * 厨房页中菜谱显示
     * @param kitchenUsername
     * @return
     */
    public String listMykitchenMenu(String kitchenUsername);
}
