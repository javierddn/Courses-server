package com.eagerminds.courses.services;

import com.eagerminds.courses.mappers.TeacherMapper;
import com.eagerminds.courses.model.Teacher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    private final TeacherMapper teacherMapper;

    public TeacherServiceImpl(TeacherMapper teacherMapper) {
        this.teacherMapper = teacherMapper;
    }

    @Override
    public Teacher insert(final Teacher teacher) {
        teacherMapper.create(teacher);
        return teacher;
    }

    @Override
    public List<Teacher> getAllTeachers() {
        return teacherMapper.getAll();
    }

    @Override
    public Teacher getTeacherById(final Integer id) {
        return teacherMapper.selectById(id);
    }
}
