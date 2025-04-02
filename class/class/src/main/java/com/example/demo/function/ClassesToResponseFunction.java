package com.example.demo.function;

import com.example.demo.dto.GetClassesResponse;
import org.springframework.cglib.core.internal.Function;
import org.springframework.stereotype.Component;
import com.example.demo.model.Class;

import java.util.List;

@Component
public class ClassesToResponseFunction implements Function<List<Class>, GetClassesResponse> {
    @Override
    public GetClassesResponse apply(List<Class> classes) {
        return GetClassesResponse.builder()
                .classes(classes.stream()
                        .map(profession -> GetClassesResponse.Class.builder()
                                .id(profession.getId())
                                .name(profession.getName())
                                .build())
                        .toList())
                .build();
    }
}
