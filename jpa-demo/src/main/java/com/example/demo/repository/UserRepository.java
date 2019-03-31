package com.example.demo.repository;

import com.example.demo.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by 潘炳稳 on 2019/3/28.
 */
public interface UserRepository extends JpaRepository<Users,Integer> {
}
