package org.example.demo.function;

import org.example.demo.dto.GetTeachersResponse;
import org.example.demo.model.Teacher;
import org.springframework.cglib.core.internal.Function;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TeachersToResponseFunction implements Function<List<Teacher>, GetTeachersResponse> {
    @Override
    public GetTeachersResponse apply(List<Teacher> teachers) {
        return GetTeachersResponse.builder()
                .teachers(teachers.stream()
                        .map(teacher -> GetTeachersResponse.Teacher.builder()
                                .id(teacher.getId())
                                .name(teacher.getName())
                                .build())
                        .toList())
                .build();
    }
}
