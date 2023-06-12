package com.unal.TeachingEvaluation.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "evaluation")
public class Evaluation implements Serializable {
    @Id
    private Integer idEvaluation;
    private Date timeStamp;
    private String semester;

    @ManyToMany
    @JoinTable(
            name = "questions_evaluations",
            joinColumns = @JoinColumn(name = "idEvaluation"),
            inverseJoinColumns = @JoinColumn(name = "idQuestion" )
    )
    @JsonIgnoreProperties("evaluations")
    private List<Questions> questions;

    @ManyToOne
    @JoinColumn(name="idTeacher")
    @JsonIgnoreProperties("evaluation")
    private Teachers teacher;

    @ManyToOne
    @JoinColumn(name="idCourse")
    @JsonIgnoreProperties("evaluation")
    private Courses course;
}