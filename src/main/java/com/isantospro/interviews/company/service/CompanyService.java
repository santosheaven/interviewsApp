package com.isantospro.interviews.company.service;

import com.isantospro.interviews.company.data.Company;
import com.isantospro.interviews.company.data.CompanyRepository;
import com.isantospro.interviews.company.entity.CompanyEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyService {
    @Autowired
    private CompanyRepository repository;

    public List<CompanyEntity> getAllCompanies(final String name) {
        List<CompanyEntity> entityList = new ArrayList<>();
        if (StringUtils.hasText(name)) {
            repository.findAll()
                    .forEach(row -> {
                        if (row.getName().contains(name)) {
                            getBuild(entityList, row);
                        }
                    });
        } else {
            repository.findAll().forEach(row -> getBuild(entityList, row));
        }

        return entityList;
    }

    public CompanyEntity getCompanyById(final Long id) {
        final CompanyEntity[] entity = new CompanyEntity[1];
        if (id != null) {
            repository.findById(id).ifPresent(row -> entity[0] = getBuild(row));
        }
        return entity[0];
    }

    private void getBuild(List<CompanyEntity> entityList, Company row) {
        entityList.add(getBuild(row));
    }

    private CompanyEntity getBuild(Company row) {
        return CompanyEntity.builder()
                .id(row.getId())
                .name(row.getName())
                .phone(row.getPhone())
                .url(row.getUrl())
                .build();
    }
}


