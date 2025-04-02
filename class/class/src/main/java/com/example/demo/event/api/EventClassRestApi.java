package com.example.demo.event.api;

import java.util.UUID;

public interface EventClassRestApi {
    void create(UUID uuid);
    void delete(UUID uuid);
    void update(UUID uuid);
}
