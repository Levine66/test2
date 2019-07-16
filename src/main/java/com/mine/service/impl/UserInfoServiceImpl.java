package com.mine.service.impl;

import com.mine.bean.UserInfo;
import com.mine.dao.IUserInfoDao;
import com.mine.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userInfoService")
public class UserInfoServiceImpl implements IUserInfoService {

    @Autowired
    IUserInfoDao userInfoDao;

    @Override
    public List<UserInfo> findAll() {
        return userInfoDao.findAll();
    }

    public void add(UserInfo userInfo){
        userInfoDao.add(userInfo);
    }

    public void delete(int id){
        userInfoDao.delete(id);
    }

    public UserInfo find(int id){

        return  userInfoDao.find(id);

    }

    public void update(UserInfo userInfo){
        userInfoDao.update(userInfo);
    }

}
