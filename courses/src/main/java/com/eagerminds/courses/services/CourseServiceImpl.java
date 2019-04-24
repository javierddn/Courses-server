package com.eagerminds.courses.services;

import com.eagerminds.courses.mappers.CourseMapper;
import com.eagerminds.courses.mappers.TeacherMapper;
import com.eagerminds.courses.model.Course;
import com.eagerminds.courses.model.Teacher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseMapper courseMapper;
    private final TeacherMapper teacherMapper;

    public CourseServiceImpl(CourseMapper courseMapper, TeacherMapper teacherMapper) {
        this.courseMapper = courseMapper;
        this.teacherMapper = teacherMapper;
    }

    @Override
    public Course insert(final Course course) throws Exception {
        Teacher teacher = teacherMapper.selectById(course.getTeacher().getId());
        if (teacher == null) {
            throw new Exception("Teacher not found.");
        }
        course.setTitle(course.getTitle());
        course.setTeacher(teacher);
        course.setLevel(course.getLevel());
        course.setDuration(course.getDuration());
        course.setActive(course.getActive());
        courseMapper.create(course);
        return course;
    }

    @Override
    public List<Course> getAllCourses() {
        return courseMapper.getAll();
    }

    @Override
    public Course getCourseById(final Integer id) {
        return courseMapper.selectById(id);
    }
}
