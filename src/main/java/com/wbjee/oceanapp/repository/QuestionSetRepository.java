package com.wbjee.oceanapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.wbjee.oceanapp.model.QuestionSet;
import java.util.Optional;

@Repository
public interface QuestionSetRepository extends JpaRepository<QuestionSet, Long> {
    Optional<QuestionSet> findBySlug(String slug);
}
