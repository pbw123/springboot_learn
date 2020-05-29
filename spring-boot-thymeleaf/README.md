# Spring Boot和Mybatis的集成——注解方式
- entity包：Course实体类
- mapper包：CourseMapper接口，采用Mybatis的注解开发CRUD操作
- service包：CourseService接口及实现类，调用CourseMapper接口
- controller包：CourseController类，采用RESTful风格请求，处理客户端的增删改查请求

# 注意点：
- service实现类加@Service注解
- 启动主类加：@MapperScan("com.springboot.mybatis.mapper")注解
- controller类加：@RestController注解
- 不同的操作用不同的请求方法:GET、POST、DELETE、PUT
- service层单元测试
- controller层Postman测试 。