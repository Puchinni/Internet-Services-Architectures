package com.example.demo.controller.impl;

import com.example.demo.controller.api.TeacherController;
import com.example.demo.dto.*;
import com.example.demo.function.*;
import com.example.demo.model.Teacher;
import com.example.demo.service.TeacherService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import java.util.UUID;

@RestController
@Log
public class TeacherImpl implements TeacherController {
    private final TeacherService teacherService;
    private final TeacherToResponseFunction teacherToResponseFunction;
    private final TeachersToResponseFunction teachersToResponseFunction;
    private final RequestToTeacherFunction requestToTeacherFunction;

    @Autowired
    public TeacherImpl(
            TeacherService teacherService,
            TeacherToResponseFunction teacherToResponseFunction,
            TeachersToResponseFunction teachersToResponseFunction,
            RequestToTeacherFunction requestToTeacherFunction
    ) {
        this.teacherService = teacherService;
        this.teacherToResponseFunction = teacherToResponseFunction;
        this.teachersToResponseFunction = teachersToResponseFunction;
        this.requestToTeacherFunction = requestToTeacherFunction;
    }

//    @Override
//    public GetTeachersResponse getTeachers() {
//        return teachersToResponseFunction.apply(teacherService.getAllTeachers());
//    }
//
//    @Override
//    public GetTeacherResponse getTeachersById(UUID id) {
//        if (teacherService.getTeacherById(id) == null) {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
//        }
//        return teacherToResponseFunction.apply(teacherService.getTeacherById(id));
//    }

//    @Override
//    public GetTeacherResponse createTeacher(PutTeacherRequest teacherRequest) {
//        Teacher teacher = Teacher.builder().id(UUID.randomUUID()).name(teacherRequest.getName()).address(teacherRequest.getAddress()).build();
//        return teacherToResponseFunction.apply(teacherService.saveTeacher(teacher));
//    }

//    @Override
//    public GetTeacherResponse updateTeacher(UUID uuid, PatchTeacherRequest patchTeacherRequest) {
//        if (teacherService.getTeacherById(uuid) == null) {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
//        }
//        Teacher teacher = teacherService.getTeacherById(uuid);
//        if (patchTeacherRequest.getName() != null) {
//            teacher.setName(patchTeacherRequest.getName());
//        }
//        if (patchTeacherRequest.getAddress() != null) {
//            teacher.setAddress(patchTeacherRequest.getAddress());
//        }
//        return teacherToResponseFunction.apply(teacherService.saveTeacher(teacher));
//    }

//    @Override
//    public void deleteTeacher(UUID uuid) {
//        teacherService.deleteTeacher(uuid);
//    }

    @Override
    public void createTeacher(UUID uuid) {
        Teacher teacher = Teacher.builder().id(uuid).build();
        teacherService.saveTeacher(teacher);
    }

    @Override
    public void deleteTeacher(UUID uuid) {
        try {
            teacherService.deleteTeacher(uuid);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Teacher not found");
        }
    }
}
