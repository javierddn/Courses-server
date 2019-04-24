package com.eagerminds.courses.services;

import com.eagerminds.courses.model.Teacher;

import java.util.List;

public interface TeacherService {

    Teacher insert(Teacher teacher);

    List<Teacher> getAllTeachers();

    Teacher getTeacherById(Integer id);
}
