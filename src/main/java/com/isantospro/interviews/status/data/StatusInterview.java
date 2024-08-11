package com.isantospro.interviews.status.data;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="STATUS_INTERVIEW")
public class StatusInterview implements Serializable {
    @Id
    @SequenceGenerator(name = "STATUS_INTERVIEW", sequenceName = "SQ_STATUS_INTERVIEW")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SI_ID")
    @Column(name = "SI_ID")
    private Long id;
    @Column(name = "SI_NAME")
    private String name;
    @Column(name = "SI_DATE")
    private Date date;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        StatusInterview that = (StatusInterview) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
