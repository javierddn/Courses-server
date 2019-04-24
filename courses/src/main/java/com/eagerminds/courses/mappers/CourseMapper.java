package com.eagerminds.courses.mappers;

import com.eagerminds.courses.model.Course;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CourseMapper {

    @Insert("INSERT INTO courses (title,teacher,level,duration,active) VALUES (#{title},#{teacher.id},#{level},#{duration},#{active})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    void create(Course course);

    @Select("SELECT " 
                + "c.id AS id, " 
                + "c.title AS title, " 
                + "t.id AS teacher_id, "
                + "t.first_name AS teacher_first_name, "
                + "t.last_name AS teacher_last_name, "
                + "c.level AS level, " 
                + "c.duration AS duration, " 
                + "c.active AS active " 
            + "FROM courses AS c, teachers AS t WHERE c.teacher = t.id")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "title", column = "title"),
            @Result(property = "teacher.id", column = "teacher_id"),
            @Result(property = "teacher.firstName", column = "teacher_first_name"),
            @Result(property = "teacher.lastName", column = "teacher_last_name"),
            @Result(property = "level", column = "level"),
            @Result(property = "duration", column = "duration"),
            @Result(property = "active", column = "active"),
    })
    List<Course> getAll();

    @Select("SELECT "
            + "c.id AS id, "
            + "c.title AS title, "
            + "t.id AS teacher.id, "
            + "t.first_name AS teacher.firstName, "
            + "t.last_name AS teacher.lastName, "
            + "c.level AS level, "
            + "c.duration AS duration, "
            + "c.active AS active "
            + "FROM courses AS c, teachers AS t WHERE c.teacher = t.id AND c.teacher = #{id}")
    Course selectById(Integer id);

}
