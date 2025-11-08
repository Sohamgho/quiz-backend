package com.wbjee.oceanapp.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.wbjee.oceanapp.repository.QuestionRepository;
import com.wbjee.oceanapp.repository.QuestionSetRepository;
import com.wbjee.oceanapp.model.Question;
import com.wbjee.oceanapp.model.QuestionSet;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {
	@Autowired
	private QuestionRepository questionRepo;
	@Autowired
	private QuestionSetRepository setRepo;

	public Question createQuestion(Question q) {
		// validate set exists
		Optional<QuestionSet> set = setRepo.findById(q.getSetId());
		if (set.isEmpty())
			throw new IllegalArgumentException("Question set not found");
		// uppercase subject
		q.setSubject(q.getSubject().toUpperCase());
		return questionRepo.save(q);
	}

	public List<Question> getQuestions(Long setId, String subject) {
		if (subject == null || subject.isBlank()) {
			return questionRepo.findBySetId(setId);
		}
		return questionRepo.findBySetIdAndSubjectOrderBySequenceNum(setId, subject.toUpperCase());
	}

	public Optional<Question> getById(Long id) {
		return questionRepo.findById(id);
	}

	public Question updateQuestion(Long id, Question updated) {
		Question existing = questionRepo.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Question not found"));
		// update fields (careful with nulls)
		existing.setQuestionText(updated.getQuestionText());
		existing.setOptionA(updated.getOptionA());
		existing.setOptionB(updated.getOptionB());
		existing.setOptionC(updated.getOptionC());
		existing.setOptionD(updated.getOptionD());
		existing.setCorrectOption(updated.getCorrectOption());
		existing.setMarks(updated.getMarks());
		existing.setIsPyq(updated.getIsPyq());
		existing.setPyqYear(updated.getPyqYear());
		existing.setAllowPreview(updated.getAllowPreview());
		existing.setExtraJson(updated.getExtraJson());
		return questionRepo.save(existing);
	}

	public void deleteQuestion(Long id) {
		questionRepo.deleteById(id);
	}
}
