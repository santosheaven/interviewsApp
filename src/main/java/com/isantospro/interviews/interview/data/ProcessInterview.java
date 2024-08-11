package com.isantospro.interviews.interview.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "PROCESS_INTERVIEW")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProcessInterview {

    @Id
    @SequenceGenerator(name = "PROCESS_INTERVIEW", sequenceName = "SQ_PROCESS_INTERVIEW")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PI_ID")
    @Column(name = "PI_ID")
    private Long id;
    @Column(name = "PI_POSITION")
    private String positionDescription;
    @Column(name = "CC_ID")
    private Long companyContactId;
    @Column(name = "PI_WHOCONTACT")
    private String whoContact;
    @Column(name = "PI_TODO")
    private String todoList;
    @Column(name = "SI_ID")
    private Long statusInterviewId;
    @Column(name = "CA_ID")
    private Long candidateId;
}