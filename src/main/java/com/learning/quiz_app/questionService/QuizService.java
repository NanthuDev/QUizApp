package com.learning.quiz_app.questionService;

import com.learning.quiz_app.model.QuestionWrapper;
import com.learning.quiz_app.model.Questions;
import com.learning.quiz_app.dao.QuestionDao;
import com.learning.quiz_app.dao.QuizDao;
import com.learning.quiz_app.model.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public ResponseEntity<List<QuestionWrapper>> getQuestionsById(Integer questionId) {
       Optional<Quiz> quiz =  quizDao.findById(questionId);
       List<Questions> questionsFromDb = quiz.get().getQuestions();
       List<QuestionWrapper> questionWrapper = new ArrayList<>();
    for(Questions q: questionsFromDb){
        QuestionWrapper qw = new QuestionWrapper(q.getId(),q.getCategory(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4(),q.getQuestion());
        questionWrapper.add(qw);

    }

        return new ResponseEntity<>(questionWrapper, HttpStatus.OK);

    }
    }
