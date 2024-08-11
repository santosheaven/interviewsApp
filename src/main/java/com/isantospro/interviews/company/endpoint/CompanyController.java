package com.isantospro.interviews.company.endpoint;

import com.isantospro.interviews.company.entity.CompanyEntity;
import com.isantospro.interviews.company.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("company")
@RequestMapping("/api")
public class CompanyController {

    @Autowired
    private CompanyService service;

    @GetMapping("/company")
    public List<CompanyEntity> getAllCompanies(@RequestParam(value = "name", required = false) final String name, @RequestHeader HttpHeaders headers) {

        return service.getAllCompanies(name);

    }

}
