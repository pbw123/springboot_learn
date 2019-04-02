package cn.niit.config;//package cn.niit.config;

import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by 潘炳稳 on 2019/4/2.
 */
@Configuration
public class MybatisplusConfig {
//    分页拦截器
    @Bean
    public PaginationInterceptor pageInterceptor()
    {
        PaginationInterceptor paginationInterceptor=new PaginationInterceptor();
        paginationInterceptor.setDialectType("mysql");
        return paginationInterceptor;
    }
}
