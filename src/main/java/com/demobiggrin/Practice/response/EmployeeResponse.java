package com.demobiggrin.Practice.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeResponse extends BaseResponse{
    private int id;
    private String name;
    private String department;
    private String address;
}
