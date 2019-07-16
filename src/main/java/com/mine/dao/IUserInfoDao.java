package com.mine.dao;

import com.mine.bean.UserInfo;

import java.util.List;

public interface IUserInfoDao {

    public List<UserInfo>  findAll();
    public void add(UserInfo userInfo);
    public void delete(int id);
    public UserInfo find(int id);
    public void update(UserInfo userInfo);
}
