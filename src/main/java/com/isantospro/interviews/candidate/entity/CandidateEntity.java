package com.isantospro.interviews.candidate.entity;

import lombok.*;

import java.math.BigDecimal;
import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class CandidateEntity {

    private Long id;
    private String firstName;
    private String lastName;
    private Date dob;
    private String nationality;
    private String address;
    private String email;
    private String phone;
    private String workPermit;
    private String workPermitDesc;
    private BigDecimal currentSalary;
    private BigDecimal expectSalaryInit;
    private BigDecimal expectSalaryEnd;
    private String resume;
    private String currentPackage;
    private String offerPackage;
}