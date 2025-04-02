package org.example.demo.event.impl;

import org.example.demo.dto.PatchTeacherRequest;
import org.example.demo.event.api.TeacherEventRestRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Repository
public class TeacherEventRestImpl implements TeacherEventRestRep {
    private final RestTemplate restTemplate;

    @Autowired
    public TeacherEventRestImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public void create(UUID uuid) {
        restTemplate.put("/api/teacher/create/{uuid}", null, uuid);
    }

    @Override
    public void delete(UUID uuid) {
        restTemplate.delete("/api/teacher/delete/{uuid}", uuid);
    }

//    @Override
//    public void update(UUID uuid, PatchTeacherRequest patchTeacherRequest) {
//        restTemplate.put("/api/teacher/update/{uuid}", patchTeacherRequest, uuid);
//    }
}
