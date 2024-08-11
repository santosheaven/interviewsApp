package com.isantospro.interviews.comments.service;

import com.isantospro.interviews.comments.data.CommentsRepository;
import com.isantospro.interviews.comments.entity.CommentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentsRepository repository;

    public List<CommentEntity> getCommentsById(final Long id) {
        List<CommentEntity> entityList = new ArrayList<>();
        repository.findById(id).ifPresent(row -> entityList
                .add(CommentEntity.builder()
                        .id(row.getId())
                        .comments(row.getComment())
                        .build()));

        return entityList;
    }
}


