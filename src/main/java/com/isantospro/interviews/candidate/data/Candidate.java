package com.isantospro.interviews.candidate.data;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Table(name = "CANDIDATE")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Candidate {

    @Id
    @SequenceGenerator(name = "CANDIDATE", sequenceName = "SQ_CANDIDATE")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CA_ID")
    @Column(name = "CA_ID")
    private Long id;
    @Column(name = "CA_FIRST_NAME")
    private String firstName;
    @Column(name = "CA_LAST_NAME")
    private String lastName;
    @Column(name = "CA_DOB")
    private Date dob;
    @Column(name = "CA_NATIONALITY")
    private String nationality;
    @Column(name = "CA_ADDRESS")
    private String address;
    @Column(name = "CA_EMAIL")
    private String email;
    @Column(name = "CA_CONTACT_PHONE")
    private String phone;
    @Column(name = "CA_WORK_PERMIT")
    private String workPermit;
    @Column(name = "CA_WORKPERMIT_DESC")
    private String workPermitDesc;
    @Column(name = "CA_CURRENT_SALARY")
    private BigDecimal currentSalary;
    @Column(name = "CA_EXPECT_SALARY_INIT")
    private BigDecimal expectSalaryInit;
    @Column(name = "CA_EXPECT_SALARY_END")
    private BigDecimal expectSalaryEnd;
    @Column(name = "CA_RESUME")
    private String resume;
    @Column(name = "CA_CURRENT_PACKAGE")
    private String currentPackage;
    @Column(name = "CA_OFFER_PACKAGE")
    private String offerPackage;
}
