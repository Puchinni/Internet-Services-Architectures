package com.example.demo.controller.api;

import com.example.demo.dto.*;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import org.springframework.http.HttpStatus;

public interface ClassController {
    @GetMapping("/api/class")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetClassesResponse getClasses();

    @GetMapping("classes/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetClassResponse getClassById(
            @PathVariable UUID id
    );

    @PostMapping("/api/class/create")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    GetClassResponse createClass(
            @RequestBody
            PutClassRequest putClassRequest
    );

    @PatchMapping("/api/class/update/{uuid}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @ResponseBody
    GetClassResponse updateClass(
            @PathVariable
            UUID uuid,
            @RequestBody
            PatchClassRequest patchClassRequest
    );

    @DeleteMapping("/api/class/{uuid}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteClass(
            @PathVariable UUID uuid
    );
}
