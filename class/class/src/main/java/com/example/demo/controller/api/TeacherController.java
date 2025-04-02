package com.example.demo.controller.api;

import com.example.demo.dto.GetTeacherResponse;
import com.example.demo.dto.PatchTeacherRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

public interface TeacherController {
//    @GetMapping("/api/teacher")
//    @ResponseStatus(HttpStatus.OK)
//    @ResponseBody
//    GetTeachersResponse getTeachers();
//
//    @GetMapping("/api/users/{userId}/teacher")
//    @ResponseStatus(HttpStatus.OK)
//    @ResponseBody
//    GetTeacherResponse getTeachersById(
//            @PathVariable("userId")
//            UUID userId
//    );

//    @PostMapping("/api/teacher/create")
//    @ResponseStatus(HttpStatus.CREATED)
//    @ResponseBody
//    GetTeacherResponse createTeacher(
//            @RequestBody
//            PutTeacherRequest putTeacherRequest
//    );

//    @PutMapping("/api/teacher/update/{uuid}")
//    @ResponseStatus(HttpStatus.ACCEPTED)
//    @ResponseBody
//    GetTeacherResponse updateTeacher(
//            @PathVariable("uuid")
//            UUID uuid,
//            @RequestBody
//            PatchTeacherRequest patchTeacherRequest
//    );

//    @DeleteMapping("/api/teacher/{uuid}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    void deleteTeacher(
//            @PathVariable("uuid")
//            UUID uuid
//    );

    @PutMapping("/api/teacher/create/{uuid}")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    void createTeacher(@PathVariable UUID uuid);


    @DeleteMapping("/api/teacher/delete/{uuid}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteTeacher(@PathVariable UUID uuid);
}
