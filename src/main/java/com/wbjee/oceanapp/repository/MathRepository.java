package com.wbjee.oceanapp.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.wbjee.oceanapp.model.MathQuestion;

@Repository
public interface MathRepository extends JpaRepository<MathQuestion, Long> {
    List<MathQuestion> findBySetNumber(int setNumber);
}
