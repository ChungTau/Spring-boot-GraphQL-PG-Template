package com.chungtau.springboottemplate.model.event;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Jacksonized
@Builder
@Data
public class CreateEventInput {
    private String title;
    private String description;
    private String date;
    private String location;
    private String hostId;
}
