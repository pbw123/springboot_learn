package cn.niit.repository;

import cn.niit.entity.SysUser;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by 公子白 on 2019/5/5.
 */
public interface UserRepository extends CrudRepository<SysUser,Long> {

    SysUser findByUserName(String username);
}
