package com.isantospro.interviews.status.service;

import com.isantospro.interviews.status.data.StatusInterview;
import com.isantospro.interviews.status.data.StatusInterviewRepository;
import com.isantospro.interviews.status.entity.StatusInterviewEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StatusInterviewService {

    @Autowired
    private StatusInterviewRepository repository;

    public List<StatusInterviewEntity> getStatusInterview(final Long id, final String name) {
        List<StatusInterviewEntity> entityList = new ArrayList<>();
        if (id != null) {
            repository.findById(id).ifPresent(row -> getBuild(row, entityList));
        } else {
            repository.findAll().forEach(row -> getBuild(row, entityList));
        }
        return entityList;
    }

    public StatusInterviewEntity getStatusInterviewById(final Long id) {
        final StatusInterviewEntity[] entity = new StatusInterviewEntity[1];
        if (id != null) {
            repository.findById(id).ifPresent(row -> entity[0] = getBuild(row));
        }
        return entity[0];
    }

    private void getBuild(StatusInterview row, List<StatusInterviewEntity> entityList) {
        entityList.add(getBuild(row));
    }

    private StatusInterviewEntity getBuild(StatusInterview row) {
        return StatusInterviewEntity.builder()
                .id(row.getId())
                .name(row.getName())
                .date(row.getDate())
                .build();
    }
}


