package com.slycreator.springquizapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "questions_options")
public class Option {
    @Id
    @GeneratedValue
    private int id;
    private String option;
    private boolean isCorrect;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "question_id")
    @JsonIgnoreProperties("questions_options")
    private Question question;
}
