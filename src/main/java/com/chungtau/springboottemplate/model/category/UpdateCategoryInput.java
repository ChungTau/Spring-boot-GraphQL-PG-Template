package com.chungtau.springboottemplate.model.category;

import lombok.Data;

@Data
public class UpdateCategoryInput {
    private String id;
    private String name;
    private String description;
}
