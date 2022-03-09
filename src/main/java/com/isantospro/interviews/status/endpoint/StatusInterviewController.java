package com.isantospro.interviews.status.endpoint;

import com.isantospro.interviews.status.entity.StatusInterviewEntity;
import com.isantospro.interviews.status.service.StatusInterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/statusinterview")
public class StatusInterviewController {

    @Autowired
    private StatusInterviewService service;

    @RequestMapping(method = RequestMethod.GET)
    public String getAllStatusInterview(@RequestParam(value = "name", required = false) final String name, Model model) {
        List<StatusInterviewEntity> entityList = service.getStatusInterview(null,null);
        model.addAttribute("statusInterviews", entityList);
        return "statusint";
    }

}
