package com.example.demo.function;

import com.example.demo.dto.PutTeacherRequest;
import com.example.demo.model.Teacher;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.UUID;
import java.util.function.BiFunction;

@Component
public class RequestToTeacherFunction implements BiFunction<UUID, PutTeacherRequest, Teacher> {
    @Override
    public Teacher apply(UUID uuid, PutTeacherRequest request) {
        return Teacher.builder()
                .id(UUID.randomUUID())
                .name(request.getName())
                .salary(request.getSalary())
                .address(request.getAddress())
                .classes(new ArrayList<>())
                .build();
    }
}
