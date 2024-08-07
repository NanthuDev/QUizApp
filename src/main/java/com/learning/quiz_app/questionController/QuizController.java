package com.learning.quiz_app.questionController;


import com.learning.quiz_app.model.QuestionWrapper;
import com.learning.quiz_app.model.Questions;
import com.learning.quiz_app.questionService.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    QuizService quizService;
    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam Integer noQ, @RequestParam String title){
      return quizService.createQuiz(category,noQ,title);
//        return new ResponseEntity<>("Quiz", HttpStatus.OK);
    }

    @GetMapping("get/{Id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable Integer Id){

       return quizService.getQuestionsById(Id);

    };


}
