package com.isantospro.interviews.util;

import com.isantospro.interviews.candidate.data.Candidate;
import com.isantospro.interviews.candidate.data.CandidateRepository;
import com.isantospro.interviews.comments.data.Comments;
import com.isantospro.interviews.comments.data.CommentsRepository;
import com.isantospro.interviews.status.data.StatusInterview;
import com.isantospro.interviews.status.data.StatusInterviewRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class AppStartupEvent implements ApplicationListener<ApplicationReadyEvent> {
    private final Logger log = LogManager.getLogger(AppStartupEvent.class);
    private final StatusInterviewRepository statusInterviewRepository;
    private final CommentsRepository commentsRepository;
    private final CandidateRepository candidateRepository;

    public AppStartupEvent(StatusInterviewRepository statusInterviewRepository, CommentsRepository commentsRepository, CandidateRepository candidateRepository) {
        this.statusInterviewRepository = statusInterviewRepository;
        this.commentsRepository = commentsRepository;
        this.candidateRepository = candidateRepository;
    }


    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        Iterable<StatusInterview> statusInterviews = this.statusInterviewRepository.findAll();
        statusInterviews.forEach(log::info);
        Iterable<Comments> comments = this.commentsRepository.findAll();
        comments.forEach(log::info);
        Iterable<Candidate> candidates = this.candidateRepository.findAll();
        candidates.forEach(log::info);
    }
}
