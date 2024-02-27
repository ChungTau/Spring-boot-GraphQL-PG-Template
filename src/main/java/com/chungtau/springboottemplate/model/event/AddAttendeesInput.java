package com.chungtau.springboottemplate.model.event;

import java.util.List;

import lombok.Data;

@Data
public class AddAttendeesInput {
    private String eventId;
    private List<String> attendeeIds;
}
