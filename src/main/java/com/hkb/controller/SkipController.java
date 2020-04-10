package com.hkb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/*
* 跳转Controller
*/
@Controller
public class SkipController {
    @RequestMapping("/index")
    public String goIndex(){
        return "redirect:/index.jsp";
    }

    @RequestMapping("/getIn")
    public String goIn(){
        return "in";
    }

    @RequestMapping("/getOut")
    public String goOut(){
        return "out";
    }

    @RequestMapping("/record")
    public String goRecord(){
        return "recond";
    }
}
