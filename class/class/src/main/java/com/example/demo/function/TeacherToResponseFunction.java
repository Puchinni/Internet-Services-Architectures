package com.example.demo.function;

import com.example.demo.dto.GetTeacherResponse;
import com.example.demo.model.Teacher;
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
                .classes(GetTeacherResponse.Class.builder()
                        .id(teacher.getClasses().get(0).getId())
                        .name(teacher.getClasses().get(0).getName())
                        .description(teacher.getClasses().get(0).getDescription())
                        .date(teacher.getClasses().get(0).getDate())
                        .build())
                .build();
    }
}
