package com.slycreator.springquizapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "questions")
public class Question implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String question;

    @OneToMany(mappedBy = "question",fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JsonIgnoreProperties("question")
    private List<Option> options;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "topic_id")
    @JsonIgnoreProperties("questions")
    private Topic topic;


}
