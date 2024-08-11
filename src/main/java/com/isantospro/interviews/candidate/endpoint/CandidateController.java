package com.isantospro.interviews.candidate.endpoint;

import com.isantospro.interviews.candidate.entity.CandidateEntity;
import com.isantospro.interviews.candidate.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("candidate")
@RequestMapping("/api")
public class CandidateController {

    @Autowired
    private CandidateService service;

    @GetMapping("/candidate")
    public List<CandidateEntity> getCandidate(@RequestParam(value = "id", required = false) final Long id, @RequestHeader HttpHeaders headers) {

        return service.getCandidate(id);

    }

}
