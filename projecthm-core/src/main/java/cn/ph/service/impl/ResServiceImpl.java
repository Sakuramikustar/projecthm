package cn.ph.service.impl;

import cn.ph.common.ResultEntity;
import cn.ph.dao.LogResMapper;
import cn.ph.model.User;
import cn.ph.service.ResService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class ResServiceImpl implements ResService {
    @Autowired
    private LogResMapper resMapper;
    private ResultEntity resultEntity;

    @Override
    public ResultEntity res(User user) {
        int res = resMapper.insert(user);
        if (res != -1) {
            resultEntity = new ResultEntity(200, "注册成功");
        } else {
            resultEntity = new ResultEntity(201, "注册失败");
        }
        return resultEntity;
    }
}
