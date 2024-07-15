package com.codingshuttle.app.collegeManager.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="admission-records")
public class AdmissionRecordEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer fees;

    @OneToOne(mappedBy = "admissionRecord")
    @JsonIgnore
    private StudentEntity student;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AdmissionRecordEntity that)) return false;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getFees(), that.getFees());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFees());
    }
}
