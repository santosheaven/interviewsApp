package com.isantospro.interviews.status.service;

import com.isantospro.interviews.status.data.StatusInterviewRepository;
import com.isantospro.interviews.status.entity.StatusInterviewEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StatusInterviewService {
    @Autowired
    private StatusInterviewRepository statusInterviewRepository;

    public List<StatusInterviewEntity> getStatusInterview(final Long id, final String name) {
        List<StatusInterviewEntity> statusInterviewEntityList = new ArrayList<>();
        statusInterviewRepository.findAll()
                .forEach(statusInterview -> statusInterviewEntityList
                        .add(new StatusInterviewEntity(statusInterview.getId(), statusInterview.getName(), statusInterview.getDate())));
        return statusInterviewEntityList;
    }
}


