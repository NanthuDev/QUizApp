package com.learning.quiz_app.model;


import lombok.Data;

@Data
public class QuestionWrapper {
    private Integer id;
    private String category;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String question;
}
