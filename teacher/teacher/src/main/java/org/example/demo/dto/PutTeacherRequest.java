package org.example.demo.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode

//all fields
public class PutTeacherRequest {
    private String name;
    private String address;
    private double salary;
}
