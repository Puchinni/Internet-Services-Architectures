package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
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

//all fields
public class PutClassRequest {
    private String name;
    private String description;
    private LocalDate date;
    @JsonProperty("teacherName")
    private String teacherName;
    private UUID teacherID;
}
