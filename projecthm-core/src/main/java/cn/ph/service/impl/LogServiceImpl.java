package cn.ph.service.impl;

import cn.ph.dao.LogResMapper;
import cn.ph.common.ResultEntity;
import cn.ph.model.User;
import cn.ph.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class LogServiceImpl implements LogService {
    @Autowired
    private LogResMapper logMapper;
    private ResultEntity resultEntity;

    @Override
    public ResultEntity log(User user) {
        User log = logMapper.log(user);
        if (log != null) {
            resultEntity = new ResultEntity(200, "登陆成功");
        } else {
            resultEntity = new ResultEntity(201, "用户名或密码错误");
        }
        return resultEntity;
    }
}
