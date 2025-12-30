package com.example.Model;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private String employeeId;
    private String name;
    private String nic;
    private String dob;
    private String position;
    private Double salary;
    private String contactNumber;
    private String address;
    private String joinedDate;
    private Boolean isActive = true;
}
