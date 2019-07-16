package com.mine.service;

import com.mine.bean.UserInfo;

import java.util.List;

public interface IUserInfoService {
    public List<UserInfo> findAll();

    public void add(UserInfo userInfo);

    public void delete(int id);

    public UserInfo find(int id);

    public void update(UserInfo userInfo);
}
