package com.learning.quiz_app.dao;

import com.learning.quiz_app.model.Questions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Questions,Integer> {
    List<Questions> findByCategory(String category);

    @Query(value="SELECT * FROM questions q WHERE q.category=:category ORDER BY RANDOM() LIMIT :noQ",nativeQuery = true)
    List<Questions> findRandomQuestionByCategory(String category, Integer noQ);
}
