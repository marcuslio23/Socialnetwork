package com.example.socialnetwork.service;

import com.example.socialnetwork.domain.Event;
import com.example.socialnetwork.repository.Repository;

import java.util.stream.StreamSupport;

public class EventService {
    private final Repository<Long, Event> repo;

    public EventService(Repository<Long, Event> repo) {
        this.repo = repo;
    }

    public Event saveEvent(Event event) {
        return repo.save(event);
    }

    public void updateEvent(Event event) {
        this.repo.update(event);
    }

    public void removeEvent(Event event) {
        this.repo.remove(event);
    }

    public Event findOne(Long id) {
        return repo.findOne(id);
    }

    public Event findByTitle(String title) {
        Iterable<Event> allEvents = repo.findAll();
        return StreamSupport.stream(allEvents.spliterator(), false)
                .filter(ev -> ev.getTitle().equals(title))
                .toList()
                .get(0);
    }

    public Iterable<Event> getAll() {
        return repo.findAll();
    }
}

