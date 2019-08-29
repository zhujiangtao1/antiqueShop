package com.sailing.service;

import com.sailing.dao.UserMapper;
import com.sailing.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;

//    public User login(User user) throws Exception{
//        return userMapper.login(user);
//    }
@Override
public ModelAndView showUserInfo(User user) {

    ModelAndView model = new ModelAndView("user/usercenter");
    model.addObject("username", user.getUsername());

    if (user.getUname() == null) model.addObject("name", "未填写");
    else model.addObject("name", user.getUname());

    if (user.getUsex() == null) model.addObject("sex", "未填写");
    else model.addObject("sex", user.getUsex());

    if (user.getUage() == null) model.addObject("age", "未填写");
    else model.addObject("age", user.getUage());

    model.addObject("phone", user.getUphone());
    model.addObject("email", user.getUemail());
    model.addObject("registertime", user.getUregistertime());

    return model;
}
    @Override
    public int deleteByPrimaryKey(String id){
        return userMapper.deleteByPrimaryKey(id);
    }

    public int insert(User record){
        return userMapper.insert(record);
    }

    public int insertSelective(User record){
        return userMapper.insertSelective(record);
    }

    public User selectByUid(String uid){
        return userMapper.selectByUid(uid);
    }

    public int updateByPrimaryKeySelective(User record){
        return userMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(User record){
        return userMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<User> selectAll() {
        return userMapper.selectAll();
    }

    @Override
    public User selectByUsername(String username) {
        return userMapper.selectByUsername(username);
    }
}
