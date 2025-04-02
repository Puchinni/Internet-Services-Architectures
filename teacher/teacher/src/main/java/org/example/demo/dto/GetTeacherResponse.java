package org.example.demo.dto;

import lombok.*;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode

public class GetTeacherResponse {
    private UUID id;
    private String name;
    private String address;
    private double salary;
    private Class classes;

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @ToString
    @EqualsAndHashCode
    public static class Class {
        private UUID id;
        private String name;
        private String description;
        private LocalDate date;
    }
}
