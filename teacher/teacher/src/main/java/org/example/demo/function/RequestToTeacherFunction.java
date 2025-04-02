package org.example.demo.function;

import org.example.demo.dto.PutTeacherRequest;
import org.example.demo.model.Teacher;
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
                .build();
    }
}
