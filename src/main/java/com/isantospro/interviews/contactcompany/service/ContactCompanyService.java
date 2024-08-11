package com.isantospro.interviews.contactcompany.service;

import com.isantospro.interviews.company.entity.CompanyEntity;
import com.isantospro.interviews.company.service.CompanyService;
import com.isantospro.interviews.contactcompany.data.CompanyContact;
import com.isantospro.interviews.contactcompany.data.CompanyContactRepository;
import com.isantospro.interviews.contactcompany.entity.ContactCompanyEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContactCompanyService {
    @Autowired
    private CompanyContactRepository repository;
    @Autowired
    private CompanyService companyService;

    public List<ContactCompanyEntity> getAllContactCompanies(final String nameCompany) {
        List<ContactCompanyEntity> entityList = new ArrayList<>();
        if (StringUtils.hasText(nameCompany)) {

        } else {
            repository.findAll()
                    .forEach(row -> {
                        CompanyEntity companyEntity = companyService.getCompanyById(row.getCompanyId());
                        getBuild(entityList, row, companyEntity);
                    });
        }

        return entityList;
    }

    public ContactCompanyEntity getContactCompanyById(final Long id) {
        final ContactCompanyEntity[] entity = new ContactCompanyEntity[1];
        if (id != null) {
            repository.findById(id).ifPresent(row -> {
                CompanyEntity companyEntity = companyService.getCompanyById(row.getCompanyId());
                entity[0] = getBuild(row, companyEntity);
            });
        }

        return entity[0];
    }

    private void getBuild(List<ContactCompanyEntity> entityList, CompanyContact row, CompanyEntity companyEntity) {
        entityList.add(getBuild(row, companyEntity));
    }

    private ContactCompanyEntity getBuild(CompanyContact row, CompanyEntity companyEntity) {
        return ContactCompanyEntity.builder()
                .companyId(companyEntity.getId())
                .id(row.getId())
                .companyName(companyEntity.getName())
                .companyContact(row.getContactCompany())
                .email(row.getEmail())
                .phone(row.getPhone())
                .build();
    }
}


