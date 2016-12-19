package com.lcc.controller;


import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import com.lcc.domain.User;
import com.lcc.service.UserService;
import com.lcc.util.PagedResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.github.pagehelper.Page;

@Controller
public class UserController extends BaseController{

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private UserService userService;

    @RequestMapping("/")
    public ModelAndView getIndex(){
        ModelAndView mav = new ModelAndView("index");
        User user = userService.selectUserById(1);
        mav.addObject("user", user);
        return mav;
    }

    /**
     * 显示首页
     */
    @RequestMapping("/bootstrapTest1")
    public String bootStrapTest1(){
        return "bootstrap/bootstrapTest1";
    }

    @RequestMapping(value = "list.do",method = RequestMethod.POST)
    @ResponseBody
    public String list(Integer pageNumber,Integer pageSize,String userName){
        logger.info("分页查询用户信息列表请求入参：pageNumber{},pageSize{}", pageNumber,pageSize);
        try{
            PagedResult<User> pagedResult = userService.queryByPage(userName,pageNumber,pageSize);
            return responseSuccess(pagedResult);
        }catch (Exception e){
            return responseFail(e.getMessage());
        }
    }
}
