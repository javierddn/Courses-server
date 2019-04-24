package com.eagerminds.courses.model;

import com.eagerminds.courses.types.LevelType;
import lombok.Data;

@Data
public class Course {

    private Integer id;
    private String title;
    private Teacher teacher;
    private LevelType level;
    private Integer duration;
    private Boolean active;

}
