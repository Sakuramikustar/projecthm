package cn.ph.dao;
import cn.ph.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LogResMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    User selectByPrimaryKey(Integer id);

    List<User> selectAll();

    User log(User user);

    int updateByPrimaryKey(User record);

    List<User> userSearch(String loginname);
}