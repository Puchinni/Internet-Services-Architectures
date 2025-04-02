package com.example.demo.function;

import com.example.demo.dto.GetClassResponse;
import org.springframework.stereotype.Component;
import com.example.demo.model.Class;
import java.util.function.Function;

@Component
public class ClassToResponseFunction implements Function<Class, GetClassResponse> {
    @Override
    public GetClassResponse apply(Class clazz) {
        return GetClassResponse.builder()
                .id(clazz.getId())
                .name(clazz.getName())
                .description(clazz.getDescription())
                .date(clazz.getDate())
                .teachers(clazz.getTeacher() != null ? GetClassResponse.Teacher.builder()
                        .id(clazz.getTeacher().getId())
                        .name(clazz.getTeacher().getName())
                        .address(clazz.getTeacher().getAddress())
                        .salary(clazz.getTeacher().getSalary())
                        .build() : null)
                .build();
    }
}
