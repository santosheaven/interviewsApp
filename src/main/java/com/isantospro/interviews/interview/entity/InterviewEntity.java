package com.isantospro.interviews.interview.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.isantospro.interviews.candidate.entity.CandidateEntity;
import com.isantospro.interviews.contactcompany.entity.ContactCompanyEntity;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class InterviewEntity {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("position")
    private String position;
    @JsonProperty("whoContact")
    private String whoContact;
    @JsonProperty("todo")
    private String todo;
    @JsonProperty("statusInterview")
    private String statusInterview;
    @JsonProperty("companyContact")
    private ContactCompanyEntity contactCompany;
    @JsonProperty("candidate")
    private CandidateEntity candidate;

}