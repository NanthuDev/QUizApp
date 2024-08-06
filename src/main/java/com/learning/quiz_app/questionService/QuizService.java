package com.learning.quiz_app.questionService;

import com.learning.quiz_app.model.Questions;
import com.learning.quiz_app.dao.QuestionDao;
import com.learning.quiz_app.dao.QuizDao;
import com.learning.quiz_app.model.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {

    @Autowired
    QuizDao quizDao;

    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<String> createQuiz(String category, Integer noQ, String title) {

        List<Questions> questions = questionDao.findRandomQuestionByCategory(category,noQ);
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizDao.save(quiz);
        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }
}
