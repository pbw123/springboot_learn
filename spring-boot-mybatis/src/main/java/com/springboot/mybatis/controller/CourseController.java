package com.springboot.mybatis.controller;

import com.springboot.mybatis.entity.Course;
import com.springboot.mybatis.service.CourseService;
import com.springboot.mybatis.util.RandomUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class CourseController {
    @Resource
    private CourseService courseService;

    /**
     * 查询所有班课
     *
     * @return
     */
    @RequestMapping(value = "/courses", method = RequestMethod.GET)
    public List<Course> selectAll() {
        return courseService.selectAll();
    }

    /**
     * 根据id查询班课
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/course/{id}", method = RequestMethod.GET)
    public Course getOne(@PathVariable("id") long id) {
        return courseService.getOne(id);
    }

    /**
     * 根据id删除班课
     *
     * @param id
     */
    @RequestMapping(value = "/course/{id}", method = RequestMethod.DELETE)
    public void deleteCourse(@PathVariable("id") long id) {
        courseService.delete(id);
    }

    /**
     * 新增班课
     *
     * @param course
     */
    @RequestMapping(value = "/course", method = RequestMethod.POST)
    public void addCourse(@RequestBody Course course) {
        course.setCourseCode(RandomUtil.getRandomCode());
        courseService.insert(course);
    }

    /**
     * 更新班课
     *
     * @param course
     */
    @RequestMapping(value = "/course", method = RequestMethod.PUT)
    public void updateCourse(@RequestBody Course course) {
        courseService.update(course);
    }
}
