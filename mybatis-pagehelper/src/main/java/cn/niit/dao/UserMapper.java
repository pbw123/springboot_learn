package cn.niit.dao;

import cn.niit.entity.User;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

/**
 * Created by 潘炳稳 on 2019/4/1.
 */
@Mapper
@Component
public interface UserMapper {

    @Select("SELECT * FROM USER")
    Page<User> getUserList();
}