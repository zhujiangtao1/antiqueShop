package com.sailing.service;


import com.sailing.entity.User;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

public interface UserService {
//    public User login(User user) throws Exception;    //

    public ModelAndView showUserInfo(User user);//by

    public int deleteByPrimaryKey(String id);

    public int insert(User record);

    public int insertSelective(User record);

    User selectByUid(String uid);

    public int updateByPrimaryKeySelective(User record);

    public int updateByPrimaryKey(User record);
    //查找所有用户
    List<User> selectAll();
    //通过用户名查找用户
    User selectByUsername(String username);
}
