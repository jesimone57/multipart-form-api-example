package com.jsimone.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;


@ApiModel(description = "Class representing a name.")
public class Name {

    @ApiModelProperty(notes = "name", example = "Fred", required = true, position = 1)
    @NotNull(message = "name is a required parameter")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}