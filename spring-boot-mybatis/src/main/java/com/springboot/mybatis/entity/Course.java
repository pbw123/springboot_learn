package com.springboot.mybatis.entity;

import lombok.Data;

@Data
public class Course {
    private Long courseId;
    private String courseName;
    private Long userId;
    private String courseClass;
    private String cover;
    private String courseCode;
    private Short finished;
}
