package cn.niit.mybatisforeach;

import cn.niit.mybatisforeach.mapper.UserMapper;
import cn.niit.mybatisforeach.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisForeachApplicationTests {

    @Test
    public void contextLoads() {
    }
    /**
     * 动态sql学习---foreach标签使用（查询）
     */
    @Autowired
    private UserMapper userMapper;
    @Test
    public void dynamicSQLToForeach() throws IOException {
            List<User> users = userMapper.getUsersByListParam(Arrays.asList(1,2,3,4));
            for(User user:users) {
                System.out.println(user);
            }
    }

    /**
     * 动态sql学习---foreach标签使用（新增）
     */
    @Test
    public void insertMultiUsers() throws IOException {
            List<User> users = new ArrayList<User>();
            users.add(new User(6,"陈大小姐"));
            users.add(new User(7,"少主"));
            users.add(new User(8,"天龙人"));
            int count = userMapper.insertMultiUsers(users);
            System.out.println("成功插入"+count+"条记录");
    }

    @Test
    public void getUserByArrayList() {
       int[] ids = new int[] {1,3,6,9};
        List users = userMapper.getUserByArrayList(ids);
        for (Object user:users)
        {
            System.out.println(user);
        }
    }

    @Test
    public void getUserByMapTest() {
        final List ids = new ArrayList();
        ids.add(1);
        ids.add(2);
        ids.add(3);
        ids.add(6);
        ids.add(7);
        ids.add(9);
        Map params = new HashMap();
        params.put("ids", ids);
        List users = userMapper.getUserByMap(params);
        for (Object user : users)
            System.out.println(user);
    }

}
