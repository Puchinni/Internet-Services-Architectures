package com.example.demo.dto;

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

public class GetClassResponse {
    private UUID id;
    private String name;
    private String description;
    private LocalDate date;
    private Teacher teachers;

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @ToString
    @EqualsAndHashCode
    public static class Teacher {
        private UUID id;
        private String name;
        private String address;
        private double salary;
    }
}
