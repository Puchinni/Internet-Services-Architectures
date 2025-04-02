package org.example.demo.function;

import org.example.demo.dto.GetTeacherResponse;
import org.example.demo.model.Teacher;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class TeacherToResponseFunction implements Function<Teacher, GetTeacherResponse> {

    @Override
    public GetTeacherResponse apply(Teacher teacher) {
        return GetTeacherResponse.builder()
                .id(teacher.getId())
                .name(teacher.getName())
                .salary(teacher.getSalary())
                .address(teacher.getAddress())
                .build();
    }
}
