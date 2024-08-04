package com.learning.quiz_app.questionController;


import com.learning.quiz_app.Questions;
import com.learning.quiz_app.Questions;
import com.learning.quiz_app.questionService.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    QuestionService questionService;
    @GetMapping("allQuestions")
    public ResponseEntity <List<Questions>> getAllQuestions(){
        return questionService.getAllQuestions();
    }

    @GetMapping("category/{category}")
    public List<Questions> getQuestionByCategory(@PathVariable String category){
         return questionService.getQuestionsByCategory(category);
    }

    @PostMapping("add")
    public  ResponseEntity<String> addQuestion(@RequestBody Questions question ){
           return  questionService.addQuestion(question);

    }
}
