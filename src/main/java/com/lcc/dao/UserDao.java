package com.lcc.dao;

import com.lcc.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by lcc on 2016/12/17.
 */
public interface UserDao {

    User selectUserById(Integer userId);

    List<User> selectUserByUserName(@Param("userName") String userName);
}
