package cn.niit.dao;

import cn.niit.entity.User;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by 潘炳稳 on 2019/4/2.
 */
@Mapper
@Component
public interface UserMapper extends BaseMapper<User> {
     List<User> getUserList();

}