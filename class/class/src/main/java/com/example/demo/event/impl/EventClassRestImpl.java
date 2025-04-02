package com.example.demo.event.impl;

import com.example.demo.event.api.EventClassRestApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Repository
public class EventClassRestImpl implements EventClassRestApi {
    private final RestTemplate restTemplate;

    @Autowired
    public EventClassRestImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public void create(UUID uuid) {
        restTemplate.put("/api/class/create/{uuid}", null, uuid);
    }

    @Override
    public void delete(UUID uuid) {
        restTemplate.delete("/api/class/delete/{uuid}", uuid);
    }

    @Override
    public void update(UUID uuid) {
        restTemplate.put("/api/class/update/{uuid}", uuid);
    }
}
