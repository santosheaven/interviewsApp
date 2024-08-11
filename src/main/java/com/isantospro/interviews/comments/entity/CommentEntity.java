package com.isantospro.interviews.comments.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class CommentEntity {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("comments")
    private String comments;
}