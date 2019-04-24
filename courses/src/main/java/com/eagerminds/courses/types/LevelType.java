package com.eagerminds.courses.types;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;

@Getter
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
@JsonPropertyOrder({"name", "level"})
public enum LevelType {

    BASIC("Básico"),
    INTERMEDIATE("Intermedio"),
    ADVANCED("Avanzado");

    private String level;

    LevelType(String level) {
        this.level = level;
    }

    @SuppressWarnings("unused")
    public String getName() {
        return name();
    }
}
