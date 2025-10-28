package com.wbjee.oceanapp.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.wbjee.oceanapp.model.ChemistryQuestion;

@Repository
public interface ChemistryRepository extends JpaRepository<ChemistryQuestion, Long> {
    List<ChemistryQuestion> findBySetNumber(int setNumber);
}
