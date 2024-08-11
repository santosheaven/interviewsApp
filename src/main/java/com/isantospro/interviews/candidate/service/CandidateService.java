package com.isantospro.interviews.candidate.service;

import com.isantospro.interviews.candidate.data.Candidate;
import com.isantospro.interviews.candidate.data.CandidateRepository;
import com.isantospro.interviews.candidate.entity.CandidateEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CandidateService {
    @Autowired
    private CandidateRepository repository;

    public Boolean saveCandidate(final CandidateEntity entity) {

        try {
            repository.save(Candidate.builder()
                    .dob(entity.getDob())
                    .currentPackage(entity.getCurrentPackage())
                    .address(entity.getAddress())
                    .currentSalary(entity.getCurrentSalary())
                    .expectSalaryEnd(entity.getExpectSalaryEnd())
                    .expectSalaryInit(entity.getExpectSalaryInit())
                    .email(entity.getEmail())
                    .build());
        } catch (Exception e) {

        }
        return true;
    }

    public List<CandidateEntity> getCandidate(final Long id) {
        List<CandidateEntity> entityList = new ArrayList<>();
        if (id != null) {
            repository.findById(id).ifPresent(row -> getBuild(entityList, row));
        } else {
            repository.findAll().forEach(row -> getBuild(entityList, row));
        }
        return entityList;
    }

    public CandidateEntity getCandidateById(final Long id) {
        final CandidateEntity[] entity = new CandidateEntity[1];
        if (id != null) {
            repository.findById(id).ifPresent(row -> entity[0] = getBuild(row));
        }
        return entity[0];
    }
    private void getBuild(List<CandidateEntity> entityList, Candidate row) {
        entityList.add(getBuild(row));
    }

    private CandidateEntity getBuild(Candidate row) {
        return CandidateEntity.builder()
                        .id(row.getId())
                        .firstName(row.getFirstName())
                        .lastName(row.getLastName())
                        .dob(row.getDob())
                        .nationality(row.getNationality())
                        .address(row.getAddress())
                        .email(row.getEmail())
                        .phone(row.getPhone())
                        .workPermit(row.getWorkPermit())
                        .workPermitDesc(row.getWorkPermitDesc())
                        .currentSalary(row.getCurrentSalary())
                        .expectSalaryInit(row.getExpectSalaryInit())
                        .expectSalaryEnd(row.getExpectSalaryEnd())
                        .resume(row.getResume())
                        .currentPackage(row.getCurrentPackage())
                        .offerPackage(row.getOfferPackage())
                        .build();
    }
}

