package com.chungtau.springboottemplate.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chungtau.springboottemplate.exception.EntityRuntimeException;
import com.chungtau.springboottemplate.model.event.CreateEventInput;
import com.chungtau.springboottemplate.model.event.Event;
import com.chungtau.springboottemplate.model.event.UpdateEventInput;
import com.chungtau.springboottemplate.model.user.User;
import com.chungtau.springboottemplate.repository.EventRepository;
import com.chungtau.springboottemplate.repository.UserRepository;

@Service
public class EventService {
    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private UserRepository userRepository;

    public Optional<Event> getEventById(String id) {
        if(id != null){
            return eventRepository.findById(id);
        }else{
            return Optional.empty();
        }
    }

    public Iterable<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Event createEvent(CreateEventInput input) {
        String hostId = input.getHostId();

        if (hostId == null || hostId.isEmpty()) {
            throw EntityRuntimeException.entityIdNotNull(User.class);
        }

        Optional<User> optionalHost = userRepository.findById(hostId);
        User host = optionalHost.orElseThrow(() -> EntityRuntimeException.notFound(User.class, hostId));

        Event event = new Event();
        event.setHost(host);
        event.setTitle(input.getTitle());
        event.setDescription(input.getDescription());
        event.setLocation(input.getLocation());
        event.setDate(input.getDate());
        return eventRepository.save(event);
    }

    @SuppressWarnings("null")
    public Event updateEvent(UpdateEventInput input) {
        Optional<Event> optionalEvent = getEventById(input.getId());
        Event event = optionalEvent.orElseThrow(() -> EntityRuntimeException.notFound(Event.class, input.getId()));
        if(input.getTitle() != null && !input.getTitle().isEmpty()){
            event.setTitle(input.getTitle());
        }

        if(input.getDescription() != null && !input.getDescription().isEmpty()){
            event.setDescription(input.getDescription());
        }

        if(input.getLocation() != null && !input.getLocation().isEmpty()){
            event.setLocation(input.getLocation());
        }

        if(input.getDate() !=null && !input.getDate().isEmpty()){
            event.setDate(input.getDate());
        }

        String hostId = input.getHostId();
        if(hostId != null && !hostId.isEmpty()){
            Optional<User> optionalHost = userRepository.findById(hostId);
            User host = optionalHost.orElseThrow(() -> EntityRuntimeException.notFound(User.class, hostId));
            if(!event.getParticipants().contains(host)){
                String errorMessage = "The new host must be among the attendees of the event.";
                //eventControllerLogger.logEntityError(EntityAction.UPDATING, Event.class, errorMessage);
                throw new EntityRuntimeException(errorMessage);
            }
            event.setHost(host);
        }
        return eventRepository.save(event);
    }

    public boolean deleteCategoryEvent(String id) {
        if (id == null || id.isEmpty() || !eventRepository.existsById(id)) {
            return false;
        }
    
        eventRepository.deleteById(id);
        return true; 
    }
}
