package com.isantospro.interviews.interview.service;

import com.isantospro.interviews.candidate.entity.CandidateEntity;
import com.isantospro.interviews.candidate.service.CandidateService;
import com.isantospro.interviews.contactcompany.entity.ContactCompanyEntity;
import com.isantospro.interviews.contactcompany.service.ContactCompanyService;
import com.isantospro.interviews.interview.data.ProcessInterview;
import com.isantospro.interviews.interview.data.ProcessInterviewRepository;
import com.isantospro.interviews.interview.entity.InterviewEntity;
import com.isantospro.interviews.status.entity.StatusInterviewEntity;
import com.isantospro.interviews.status.service.StatusInterviewService;
import com.isantospro.interviews.util.WhoContactEnum;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InterviewService {

    private final ProcessInterviewRepository processInterviewRepository;
    private final StatusInterviewService statusInterviewService;
    private final CandidateService candidateService;
    private final ContactCompanyService contactCompanyService;

    public InterviewService(ProcessInterviewRepository processInterviewRepository, StatusInterviewService statusInterviewService, CandidateService candidateService, ContactCompanyService contactCompanyService) {
        this.processInterviewRepository = processInterviewRepository;
        this.statusInterviewService = statusInterviewService;
        this.candidateService = candidateService;
        this.contactCompanyService = contactCompanyService;
    }

    public List<InterviewEntity> getAllInterviews() {
        List<InterviewEntity> entityList = new ArrayList<>();
        processInterviewRepository.findAll()
                .forEach(row -> {
                    StatusInterviewEntity statusInterview = statusInterviewService.getStatusInterviewById(row.getStatusInterviewId());
                    CandidateEntity candidateEntity = candidateService.getCandidateById(row.getCandidateId());
                    ContactCompanyEntity contactCompany = contactCompanyService.getContactCompanyById(row.getCompanyContactId());
                    getBuild(entityList, row, statusInterview, candidateEntity, contactCompany);
                });
        return entityList;
    }

    private void getBuild(List<InterviewEntity> entityList, ProcessInterview row, StatusInterviewEntity statusInterview, CandidateEntity candidateEntity, ContactCompanyEntity contactCompany) {
        entityList.add(getBuild(row, statusInterview, candidateEntity, contactCompany));
    }

    private InterviewEntity getBuild(ProcessInterview row, StatusInterviewEntity statusInterview, CandidateEntity candidateEntity, ContactCompanyEntity contactCompany) {
        return InterviewEntity.builder()
                .id(row.getId())
                .position(row.getPositionDescription())
                .todo(row.getTodoList())
                .whoContact(WhoContactEnum.getInstance(row.getWhoContact()).getValue())
                .statusInterview(statusInterview.getName())
                .candidate(candidateEntity)
                .contactCompany(contactCompany)
                .build();
    }
}


