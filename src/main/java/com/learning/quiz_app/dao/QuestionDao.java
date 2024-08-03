package com.learning.quiz_app.dao;

import com.learning.quiz_app.Questions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionDao extends JpaRepository<Questions,Integer> {

}
