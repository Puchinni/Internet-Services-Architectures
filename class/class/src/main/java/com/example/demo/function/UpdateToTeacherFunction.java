package com.example.demo.function;

import com.example.demo.dto.PatchTeacherRequest;
import com.example.demo.model.Teacher;
import org.springframework.stereotype.Component;
import java.util.UUID;
import java.util.function.BiFunction;

@Component
public class UpdateToTeacherFunction implements BiFunction<UUID, PatchTeacherRequest, Teacher> {
    @Override
    public Teacher apply(UUID uuid, PatchTeacherRequest request) {
        return Teacher.builder()
                .name(request.getName())
                .address(request.getAddress())
                .build();
    }
}
