package com.chungtau.springboottemplate.entity.event;

import java.util.List;

import lombok.Data;

@Data
public class AddAttendeesInput {
    private String eventId;
    private List<String> attendeeIds;
}
