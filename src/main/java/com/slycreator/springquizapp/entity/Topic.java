package com.slycreator.springquizapp.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
//@Table(name = "topics")
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int id;

    @Column(unique = true,nullable = false)
    private String title;
    @Column(nullable = false)
    private String description;

   @OneToMany(mappedBy = "topic",fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JsonIgnoreProperties("topic")
    private List<Question> questions;


}
