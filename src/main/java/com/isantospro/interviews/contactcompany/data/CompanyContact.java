package com.isantospro.interviews.contactcompany.data;

import com.isantospro.interviews.company.data.Company;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "COMPANY_CONTACT")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CompanyContact {

    @Id
    @SequenceGenerator(name = "COMPANY_CONTACT", sequenceName = "SQ_COMPANY_CONTACT")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CC_ID")
    @Column(name = "CC_ID")
    private Long id;
    @Column(name = "C_ID")
    private Long companyId;
    @Column(name = "CC_COMPANY_CONTACT")
    private String contactCompany;
    @Column(name = "CC_CONTACT_EMAIL")
    private String email;
    @Column(name = "CC_CONTACT_PHONE")
    private String phone;

    @OneToMany
    private Set<Company> companySet;

}