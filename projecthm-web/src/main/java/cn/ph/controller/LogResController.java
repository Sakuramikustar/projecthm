package cn.ph.controller;

import cn.ph.common.ResultEntity;
import cn.ph.model.User;
import cn.ph.service.LogService;
import cn.ph.service.ResService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("user")
public class LogResController {
    @Autowired
    private LogService loginService;
    @Autowired
    private ResService registerService;
//    登录
    @RequestMapping("/index")
    public String index() { return "ad_login_home"; }

    @RequestMapping("/success")
    public String success() {
        return "ad_login_home";
    }

    @RequestMapping("/login")
    @ResponseBody
    public ResultEntity login(User user, Model model) {
        ResultEntity resultEntity = loginService.log(user);
        if (resultEntity.getCode() == 200)
            model.addAttribute("user", user);//将user存放到session
        return resultEntity;
    }

//    注册
    @RequestMapping("/register")
    public String register(){
        return "register";
    }

    @RequestMapping("/resuces")
    public String resuces(){
        return "resuces";
    }

    @RequestMapping("/register/valid")
    @ResponseBody
    public ResultEntity register(User user, Model model) {
        ResultEntity resultEntity = registerService.res(user);
        if (resultEntity.getCode() == 200)
            model.addAttribute("user", user);//将user存放到session
        return resultEntity;
    }
}
