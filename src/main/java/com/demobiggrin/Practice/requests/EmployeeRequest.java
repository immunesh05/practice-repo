package com.demobiggrin.Practice.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeRequest {
    private Integer id;
    private String name;
    private String department;
    private String address;
}
