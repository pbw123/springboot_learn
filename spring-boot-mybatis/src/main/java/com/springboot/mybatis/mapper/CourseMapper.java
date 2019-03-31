package com.springboot.mybatis.mapper;

import com.springboot.mybatis.entity.Course;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface CourseMapper {
    @Results({
            @Result(property = "courseId", column = "course_id"),
            @Result(property = "courseName", column = "course_name"),
            @Result(property = "userId", column = "user_id"),
            @Result(property = "courseClass", column = "course_class"),
            @Result(property = "cover", column = "cover"),
            @Result(property = "courseCode", column = "course_code"),
            @Result(property = "finished", column = "finished")
    })
    @Select("SELECT * FROM t_course ")
    List<Course> selectAll();


    @Results({
            @Result(property = "courseId", column = "course_id"),
            @Result(property = "courseName", column = "course_name"),
            @Result(property = "userId", column = "user_id"),
            @Result(property = "courseClass", column = "course_class"),
            @Result(property = "cover", column = "cover"),
            @Result(property = "courseCode", column = "course_code"),
            @Result(property = "finished", column = "finished")
    })
    @Select("SELECT * FROM t_course WHERE course_id = #{courseId} ")
    Course getOne(Long courseId);

    @Delete("DELETE FROM t_course WHERE course_id =#{courseId} ")
    void delete(Long courseId);

    @Insert("INSERT INTO t_course(course_name,user_id,course_class,cover,course_code,finished)" +
            " VALUES(#{courseName}, #{userId}, #{courseClass},#{cover},#{courseCode},#{finished}) ")
    void insert(Course course);

    @Update("UPDATE t_course SET cover=#{cover},finished=#{finished} WHERE course_id =#{courseId}")
    void update(Course course);
}
