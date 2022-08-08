package com.fullstack.employee.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    private long id;
    private String organizationName;
    private String emailId;
    private String purpose;
    private String studentId;
}
