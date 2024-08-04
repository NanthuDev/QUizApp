package com.learning.quiz_app.questionService;


import com.learning.quiz_app.Questions;
import com.learning.quiz_app.Questions;
import com.learning.quiz_app.dao.QuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    @Autowired
    QuestionDao questionDao;

    public ResponseEntity< List<Questions>> getAllQuestions() {
        try{
            return new ResponseEntity<>( questionDao.findAll(), HttpStatus.OK);
        }catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>( new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public List<Questions> getQuestionsByCategory(String category){
        return questionDao.findByCategory(category);
    }

    public ResponseEntity<String> addQuestion(Questions question){
         questionDao.save(question);
        return new ResponseEntity<>("success",HttpStatus.CREATED) ;
    }
}
