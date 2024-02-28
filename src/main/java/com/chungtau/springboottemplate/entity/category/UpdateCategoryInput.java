package com.chungtau.springboottemplate.entity.category;

import lombok.Data;

@Data
public class UpdateCategoryInput {
    private String id;
    private String name;
    private String description;
}
