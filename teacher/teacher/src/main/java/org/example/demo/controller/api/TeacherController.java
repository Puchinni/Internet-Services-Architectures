package org.example.demo.controller.api;

import org.example.demo.dto.GetTeachersResponse;
import org.example.demo.dto.GetTeacherResponse;
import org.example.demo.dto.PatchTeacherRequest;
import org.example.demo.dto.PutTeacherRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

public interface TeacherController {
    @GetMapping("/api/teacher")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetTeachersResponse getTeachers();

    @GetMapping("/api/teacher/get/{uuid}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetTeacherResponse getTeachersById(
            @PathVariable("uuid")
            UUID uuid
    );

    @PostMapping("/api/teacher/create")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    GetTeacherResponse createTeacher(
            @RequestBody
            PutTeacherRequest putTeacherRequest
    );

    @PatchMapping("/api/teacher/update/{uuid}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @ResponseBody
    GetTeacherResponse updateTeacher(
            @PathVariable("uuid")
            UUID uuid,
            @RequestBody
            PatchTeacherRequest patchTeacherRequest
    );

    @DeleteMapping("/api/teacher/{uuid}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteTeacher(
            @PathVariable("uuid")
            UUID uuid
    );
}
