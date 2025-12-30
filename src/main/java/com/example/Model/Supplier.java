package com.example.Model;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Supplier {
    private String supplierId;
    private String name;
    private String companyName;
    private String address;
    private String city;
    private String province;
    private Integer postalCode;
    private String phone;
    private String email;
}
