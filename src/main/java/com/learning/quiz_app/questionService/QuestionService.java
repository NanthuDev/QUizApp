package com.learning.quiz_app.questionService;


import com.learning.quiz_app.Questions;
import com.learning.quiz_app.Questions;
import com.learning.quiz_app.dao.QuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    @Autowired
    QuestionDao questionDao;

    public List<Questions> getAllQuestions() {
    return questionDao.findAll();
    }
}
