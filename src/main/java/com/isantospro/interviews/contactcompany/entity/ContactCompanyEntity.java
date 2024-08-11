package com.isantospro.interviews.contactcompany.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ContactCompanyEntity {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("companyId")
    private Long companyId;
    @JsonProperty("companyContact")
    private String companyContact;
    @JsonProperty("email")
    private String email;
    @JsonProperty("phone")
    private String phone;
    @JsonProperty("companyName")
    private String companyName;
}
