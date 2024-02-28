package com.chungtau.springboottemplate.entity.event;

import lombok.Data;

@Data
public class UpdateEventInput {
    private String id;
    private String title;
    private String description;
    private String date;
    private String location;
    private String hostId;
}
