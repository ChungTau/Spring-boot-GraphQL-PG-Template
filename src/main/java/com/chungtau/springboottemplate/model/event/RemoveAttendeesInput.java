package com.chungtau.springboottemplate.model.event;

import java.util.List;

import lombok.Data;

@Data
public class RemoveAttendeesInput {
    private String eventId;
    private List<String> attendeeIds;
}
