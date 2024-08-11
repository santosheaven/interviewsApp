package com.isantospro.interviews.contactcompany.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyContactRepository extends CrudRepository<CompanyContact, Long> {
}
