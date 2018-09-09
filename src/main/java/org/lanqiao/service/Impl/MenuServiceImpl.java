package org.lanqiao.service.Impl;

import net.sf.json.JSONArray;
import org.lanqiao.dao.impl.CaipuDaoImpl;
import org.lanqiao.dao.impl.CollectionDaoImpl;
import org.lanqiao.dao.impl.DynamicDaoImpl;
import org.lanqiao.dao.impl.UserDaoImpl;
import org.lanqiao.entity.Caipu;
import org.lanqiao.queryclass.MykitchenMenuShow;
import org.lanqiao.service.MenuService;

import java.util.ArrayList;
import java.util.List;

/**
 * @作者：dhc
 * @创建时间：16:23 2018/9/2
 * @描述：MenuService实现类
 */
public class MenuServiceImpl implements MenuService {
    private CaipuDaoImpl caipuDaoImpl = new CaipuDaoImpl();
    private UserDaoImpl userDaoImpl = new UserDaoImpl();
    private DynamicDaoImpl dynamicDaoImpl = new DynamicDaoImpl();
    private CollectionDaoImpl collectionDaoImpl = new CollectionDaoImpl();
    @Override
    public int createMenu(Caipu caipu) {
        return caipuDaoImpl.createMenu(caipu);
    }

    @Override
    public String listMykitchenMenu(String kitchenUsername) {
        List<MykitchenMenuShow> res = new ArrayList<MykitchenMenuShow>();
        int didNum = 0;
        int collectedNum = 0;
        int cid = 0;
        String cImage;
        String cName;
        //获得用户id
        int uid = userDaoImpl.getIdByUsername(kitchenUsername);
        //查菜谱表
        List<Caipu> re = caipuDaoImpl.listAllMenuByUid(uid);
        //循环获得菜谱被多少人做过、被多少人收藏，封装，add
        for (int i = 0; i < re.size(); i++) {
            cid = re.get(i).getC_id();
            cImage = re.get(i).getC_image();
            cName = re.get(i).getC_name();
            didNum = dynamicDaoImpl.getDidNumByCid(cid);
            collectedNum = collectionDaoImpl.getCollectedNumByCid(cid);
            res.add(new MykitchenMenuShow(cImage,cName,didNum,collectedNum));
        }
        //获得某人的菜谱数
        JSONArray resJA = JSONArray.fromObject(res);

        return resJA.toString();
    }

    public static void main(String[] args) {
        String re = new MenuServiceImpl().listMykitchenMenu("张三");
        System.out.println(re);
    }
}
