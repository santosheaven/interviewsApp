package com.isantospro.interviews.data;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "COMMENTS_INTERVIEW")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Comments {
    @Id
    @SequenceGenerator(name = "COMMENTS_INTERVIEW", sequenceName = "SQ_COMMENTS_INTERVIEW")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CI_ID")
    @Column(name = "CI_ID")
    private Long id;
    @Column(name = "CI_COMMENTS")
    private String comment;

}