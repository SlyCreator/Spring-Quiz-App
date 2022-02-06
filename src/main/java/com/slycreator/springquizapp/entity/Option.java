package com.slycreator.springquizapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "options")
public class Option {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String option;

    @Getter(AccessLevel.NONE)
    private boolean correct;
//    @JsonProperty("isCorrect")

    @JsonIgnore
    public boolean getIsCorrect() {
        return this.correct;
    }
    @JsonProperty
    public boolean setIsCorrect(boolean correct) {
        return this.correct = correct;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "question_id")
    @JsonIgnoreProperties("options")
    private Question question;
}
