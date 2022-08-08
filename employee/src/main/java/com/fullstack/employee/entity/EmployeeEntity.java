package com.fullstack.employee.entity;

import jdk.jfr.DataAmount;
import lombok.Data;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;

@Entity
@Data
@Table(name="employee23")
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="organizationName")
    private String organizationName;
    @Column(name="emailId")
    private String emailId;
    @Column(name="purpose")
    private String purpose;
    @Column(name="studentId")
    private String studentId;
}
