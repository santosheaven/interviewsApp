package com.isantospro.interviews.interview.endpoint;

import com.isantospro.interviews.interview.entity.InterviewEntity;
import com.isantospro.interviews.interview.service.InterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("interview")
@RequestMapping("/api")
public class InterviewController {

    @Autowired
    private InterviewService service;

    @GetMapping("/interviews")
    public List<InterviewEntity> getAllInterviews() {

        return service.getAllInterviews();

    }

}
