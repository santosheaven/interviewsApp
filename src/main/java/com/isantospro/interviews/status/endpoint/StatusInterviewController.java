package com.isantospro.interviews.status.endpoint;

import com.isantospro.interviews.status.entity.StatusInterviewEntity;
import com.isantospro.interviews.status.service.StatusInterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("statusinterview")
@RequestMapping("/api")
public class StatusInterviewController {

    @Autowired
    private StatusInterviewService service;

    @GetMapping("/status")
    public List<StatusInterviewEntity> getAllStatusInterview(@RequestParam(value = "name", required = false) final String name, @RequestHeader HttpHeaders headers) {

        return service.getStatusInterview(null, null);

    }

}
