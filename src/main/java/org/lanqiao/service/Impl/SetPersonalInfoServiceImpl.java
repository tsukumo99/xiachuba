package org.lanqiao.service.Impl;

import org.lanqiao.dao.UserDao;
import org.lanqiao.dao.impl.UserDaoImpl;
import org.lanqiao.entity.User;
import org.lanqiao.service.SetPersonalInfoService;

import java.util.ArrayList;

public class SetPersonalInfoServiceImpl implements SetPersonalInfoService {
    @Override
    public int alterUser(User u) {
        UserDao ud=new UserDaoImpl();
        return ud.alterUserInfo(u);
    }
}
