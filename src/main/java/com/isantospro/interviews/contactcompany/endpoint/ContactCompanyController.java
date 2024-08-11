package com.isantospro.interviews.contactcompany.endpoint;

import com.isantospro.interviews.contactcompany.entity.ContactCompanyEntity;
import com.isantospro.interviews.contactcompany.service.ContactCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("contactcompany")
@RequestMapping("/api")
public class ContactCompanyController {

    @Autowired
    private ContactCompanyService service;

    @GetMapping("/contactcompany")
    public List<ContactCompanyEntity> getAllContactCompanies(@RequestParam(value = "nameCompany", required = false) final String nameCompany, @RequestHeader HttpHeaders headers) {

        return service.getAllContactCompanies(nameCompany);

    }

}
