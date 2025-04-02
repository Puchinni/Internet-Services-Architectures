package com.example.demo.controller.impl;

import com.example.demo.controller.api.ClassController;
import com.example.demo.dto.*;
import com.example.demo.function.ClassToResponseFunction;
import com.example.demo.function.ClassesToResponseFunction;
import com.example.demo.function.RequestToClassFunction;
import com.example.demo.service.ClassService;
import com.example.demo.model.Class;
import com.example.demo.model.Teacher;
import com.example.demo.service.TeacherService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@RestController
@Log
public class ClassImpl implements ClassController {
    private final ClassService classService;
    private final ClassToResponseFunction classToResponseFunction;
    private final ClassesToResponseFunction classesToResponseFunction;
    private final RequestToClassFunction requestToClassFunction;
    private final TeacherService teacherService;

    @Autowired
    public ClassImpl(
            ClassService classService,
            ClassToResponseFunction classToResponseFunction,
            ClassesToResponseFunction classesToResponseFunction,
            RequestToClassFunction requestToClassFunction,
            TeacherService teacherService) {
        this.classService = classService;
        this.classToResponseFunction = classToResponseFunction;
        this.classesToResponseFunction = classesToResponseFunction;
        this.requestToClassFunction = requestToClassFunction;
        this.teacherService = teacherService;
    }

    @Override
    public GetClassesResponse getClasses() {
        return classesToResponseFunction.apply(classService.getAllClasses());
    }

    @Override
    public GetClassResponse getClassById(UUID id) {
        if (classService.getClassById(id) == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return classToResponseFunction.apply(classService.getClassById(id));
    }

//    @Override
//    public GetClassResponse createClass(PutClassRequest putClassRequest) {
//        UUID idd = UUID.randomUUID();
//        Class clazz = requestToClassFunction.apply(idd, putClassRequest);
//        return classToResponseFunction.apply(classService.saveClass(clazz));
//    }

    @Override
    public GetClassResponse updateClass(UUID uuid, PatchClassRequest patchClassRequest) {
        if (classService.getClassById(uuid) == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        Class clazz = classService.getClassById(uuid);
        clazz.setName(patchClassRequest.getName());
        clazz.setDate(patchClassRequest.getDate());
        return classToResponseFunction.apply(classService.saveClass(clazz));
    }

    @Override
    public void deleteClass(UUID uuid) {
        classService.deleteClass(uuid);
    }

    @Override
    public GetClassResponse createClass(@RequestBody PutClassRequest classRequest){
        //Teacher teacher = teacherService.getTeacherByName(classRequest.getTeacherName());
        Teacher teacher = teacherService.getTeacherById(classRequest.getTeacherID());
//        System.out.println(teacher);
//        if (teacher == null) {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Teacher not found with name: " + classRequest.getTeacherName());
//        }
        Class clazz = Class.builder().id(UUID.randomUUID()).name(classRequest.getName()).date(classRequest.getDate()).description(classRequest.getDescription()).teacher(teacher).build();
        return classToResponseFunction.apply(classService.saveClass(clazz));
    }
}
