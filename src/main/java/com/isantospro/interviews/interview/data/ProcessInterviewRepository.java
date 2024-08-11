package com.isantospro.interviews.interview.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcessInterviewRepository extends CrudRepository<ProcessInterview, Long> {
}
