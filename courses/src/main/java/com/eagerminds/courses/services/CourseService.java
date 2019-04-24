package com.eagerminds.courses.services;

import com.eagerminds.courses.model.Course;
import com.eagerminds.courses.types.OrderType;

import java.util.List;

public interface CourseService {

    Course insert(Course course) throws Exception;

    List<Course> getAllCourses(Boolean enabled, OrderType orderType);

    Course getCourseById(Integer id);

}
