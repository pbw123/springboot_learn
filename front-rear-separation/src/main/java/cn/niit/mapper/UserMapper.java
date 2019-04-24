package cn.niit.mapper;

import cn.niit.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by 公子白 on 2019/4/23.
 */
public interface UserMapper extends JpaRepository<User,Integer> {
}
