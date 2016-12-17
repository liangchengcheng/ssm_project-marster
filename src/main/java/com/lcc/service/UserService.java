package com.lcc.service;

import java.util.List;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.lcc.domain.User;
import com.lcc.util.PagedResult;

/**
 * 功能概要：UserService接口类
 */
public interface UserService {

    User selectUserById(Integer userId);

    List<User> selectUserByUserName(String userName);

    /**
     *
     * @since  2015年10月23日
     * @param userName 查询条件，可为空
     * @param pageNo 查询条件，可为空，默认取1
     * @param pageSize 查询条件，可为空，默认取10
     */
    PagedResult<User> queryByPage(String userName, Integer pageNo, Integer pageSize);

}
