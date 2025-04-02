package com.example.demo.function;

import com.example.demo.dto.PatchClassRequest;
import com.example.demo.model.Class;
import org.springframework.stereotype.Component;
import java.util.UUID;
import java.util.function.BiFunction;

@Component
public class UpdateToClassFunction implements BiFunction<UUID, PatchClassRequest, Class> {
    @Override
    public Class apply(UUID uuid, PatchClassRequest request) {
        return Class.builder()
                .name(request.getName())
                .date(request.getDate())
                .build();
    }
}
