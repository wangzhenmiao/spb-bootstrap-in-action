package com.wangzhen.spbbootstrapinaction.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ClassName HelloController
 * @Description
 * @Author wangzhen
 * @Date 2018/11/7 下午5:46
 **/

@RestController
public class HelloController {

    @RequestMapping("hello")
    public String testVelocity(Model model, String name){
        model.addAttribute("name",name);
        return "hello";
    }

    @RequestMapping("model")
    public ModelAndView testModel(String name) {
        //构建ModelAndView实例，并设置跳转地址
        ModelAndView view = new ModelAndView("testModelAndView");
        //将数据放置到ModelAndView对象view中,第二个参数可以是任何java类型
        view.addObject("name",name);
        //返回ModelAndView对象view
        return view;
    }

}
