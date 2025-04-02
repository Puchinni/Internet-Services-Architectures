package org.example.demo.event.api;

import org.example.demo.dto.PatchTeacherRequest;

import java.util.UUID;

public interface TeacherEventRestRep {
    void create(UUID uuid);
    void delete(UUID uuid);
    //void update(UUID uuid, PatchTeacherRequest patchTeacherRequest);
}
