package com.eagerminds.courses.services;

import com.eagerminds.courses.model.Course;

import java.util.List;

public interface CourseService {

    Course insert(Course course) throws Exception;

    List<Course> getAllCourses();

    Course getCourseById(Integer id);

}
