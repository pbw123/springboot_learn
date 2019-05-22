package cn.niit.mybatisforeach.mapper;

import cn.niit.mybatisforeach.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Mapper
@Component
public interface UserMapper {
    /**
     * 多个参数查询user集合
     */
    List<User> getUsersByListParam(@Param("list") List list);
    /**
     * 使用foreach批量插入
     */
    int insertMultiUsers(@Param("users") List<User> users);

    /**
     * 使用foreach接收数组参数
     */
    List getUserByArrayList(int[] ids);

    /**
     * 使用foreach接收map
     */
    List getUserByMap(Map params);
}
