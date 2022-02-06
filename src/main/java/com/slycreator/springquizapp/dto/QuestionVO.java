package com.slycreator.springquizapp.dto;

import com.slycreator.springquizapp.entity.Option;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionVO {
    private String question;
    private List<Option> options;
    private Integer topicId;
}
