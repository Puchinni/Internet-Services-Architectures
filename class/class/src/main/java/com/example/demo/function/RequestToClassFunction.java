package com.example.demo.function;

import com.example.demo.dto.PutClassRequest;
import com.example.demo.model.Class;
import com.example.demo.model.Teacher;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.UUID;
import java.util.function.BiFunction;

@Component
public class RequestToClassFunction implements BiFunction<UUID, PutClassRequest, Class> {
    @Override
    public Class apply(UUID uuid, PutClassRequest request) {
        return Class.builder()
                .id(UUID.randomUUID())
                .name(request.getName())
                .date(request.getDate())
                .description(request.getDescription())
                .teacher(Teacher.builder().id(uuid).build())
                .build();
    }
}
