package com.example.demo.dto;

import lombok.*;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode

//fields that can be updated
public class PatchClassRequest {
    private String name;
    private LocalDate date;
}
