package org.lanqiao.service;

import org.lanqiao.entity.ShowMsg;
import org.lanqiao.entity.User;
import org.lanqiao.entity.ShowMsg;

import java.util.List;

public interface LiuyanService {
    ShowMsg insertMsg(String msgContent, String otherName, User user);
    List<ShowMsg>  showMsg(String otherName);
}
