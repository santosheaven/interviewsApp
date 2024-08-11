package com.isantospro.interviews.comments.endpoint;

import com.isantospro.interviews.comments.entity.CommentEntity;
import com.isantospro.interviews.comments.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("comment")
@RequestMapping("/api")
public class CommentController {

    @Autowired
    private CommentService service;


    @GetMapping("/commentbyprocess")
    public List<CommentEntity> getCommentsByProcess(@RequestParam(value = "id", required = true) final Long id, @RequestHeader HttpHeaders headers) {

        return service.getCommentsById(id);

    }

}
