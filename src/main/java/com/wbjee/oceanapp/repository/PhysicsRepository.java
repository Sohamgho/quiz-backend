package com.wbjee.oceanapp.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.wbjee.oceanapp.model.PhysicsQuestion;

@Repository
public interface PhysicsRepository extends JpaRepository<PhysicsQuestion, Long> {
    List<PhysicsQuestion> findBySetNumber(int setNumber);
}
