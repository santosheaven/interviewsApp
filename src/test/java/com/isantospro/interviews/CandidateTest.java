package com.isantospro.interviews;

import com.isantospro.interviews.candidate.entity.CandidateEntity;
import com.isantospro.interviews.candidate.service.CandidateService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class CandidateTest {
    @Autowired
    private CandidateService service;

    @Test
    public void insertCandidate() {
        List<CandidateEntity> entity = service.getCandidate(null);
        if (entity != null && !entity.isEmpty()) {
            return;
        }
    }
}
