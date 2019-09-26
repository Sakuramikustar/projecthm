package cn.ph.controller;

import cn.ph.common.ResultEntity;
import cn.ph.model.User;
import cn.ph.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("user")
public class LogController {
    @Autowired
    private LogService loginService;

    @RequestMapping("/index")
    public String index() { return "logintest"; }

    @RequestMapping("/success")
    public String success() {
        return "admin_manage";
    }

    @RequestMapping("/login")
    @ResponseBody
    public ResultEntity login(User user, Model model) {
        ResultEntity resultEntity = loginService.log(user);
        if (resultEntity.getCode() == 200)
            model.addAttribute("user", user);//将user存放到session
        return resultEntity;
    }
}
