package com.isantospro.interviews.company.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "COMPANY")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Company {

    @Id
    @SequenceGenerator(name = "COMPANY", sequenceName = "SQ_COMPANY")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "C_ID")
    @Column(name = "C_ID")
    private Long id;
    @Column(name = "C_NAME")
    private String name;
    @Column(name = "C_URL")
    private String url;
    @Column(name = "C_PHONE")
    private String phone;
}
