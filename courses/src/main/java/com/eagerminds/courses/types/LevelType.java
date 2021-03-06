package com.eagerminds.courses.types;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;

@Getter
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
@JsonPropertyOrder({"name", "description"})
public enum LevelType {

    BASIC("Básico"),
    INTERMEDIATE("Intermedio"),
    ADVANCED("Avanzado");

    private String description;

    LevelType(String description) {
        this.description = description;
    }

    @SuppressWarnings("unused")
    public String getName() {
        return name();
    }
}
