package com.sbdemo.springbootdemo.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;

@Controller
@RequestMapping("/user")
public class FirstController {

    @Value("${com.name}")
    private String blogName;

    @Value("${com.title}")
    private String blogTitle;

    @Value("${com.test}")
    private String test;

    @ApiOperation("打印输出配置")
    @RequestMapping(value="/sout",method= RequestMethod.GET )
    @ResponseBody
    public String soutBlog() throws UnsupportedEncodingException {
        String s = new String(blogName.getBytes("ISO-8859-1"), "UTF-8");

        System.out.println("blogName = " + s + ", blogTitle = " + blogTitle);
        return "blogName = " + blogName + ", blogTitle = " + blogTitle + test;
    }

    @ApiOperation("打印输出user")
    @RequestMapping("/out")
    @ResponseBody
    public String soutUser(){
        return "user";
    }


    @RequestMapping("/index")
    public String soutUer(Model mp){
        mp.addAttribute("host","www.baidu.com");
        return "index";
    }


}
