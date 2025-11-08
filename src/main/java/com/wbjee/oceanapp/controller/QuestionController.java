package com.wbjee.oceanapp.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

import com.wbjee.oceanapp.service.QuestionService;
import com.wbjee.oceanapp.dto.question.QuestionRequest;
import com.wbjee.oceanapp.model.Question;

@RestController
@RequestMapping("/api/questions")
public class QuestionController {
	@Autowired
	private QuestionService questionService;

	@PostMapping
	public Question create(@RequestBody QuestionRequest req) {
		Question q = new Question();
		q.setSetId(req.getSetId());
		q.setSubject(req.getSubject());
		q.setSequenceNum(req.getSequenceNum());
		q.setQuestionText(req.getQuestionText());
		q.setOptionA(req.getOptionA());
		q.setOptionB(req.getOptionB());
		q.setOptionC(req.getOptionC());
		q.setOptionD(req.getOptionD());
		q.setCorrectOption(req.getCorrectOption());
		q.setMarks(req.getMarks());
		q.setIsPyq(req.getIsPyq());
		q.setPyqYear(req.getPyqYear());
		q.setAllowPreview(req.getAllowPreview());
		q.setExtraJson(req.getExtraJson());
		return questionService.createQuestion(q);
	}

	@GetMapping("/{setId}")
	public List<Question> getBySet(@PathVariable Long setId, @RequestParam(required = false) String subject) {
		return questionService.getQuestions(setId, subject);
	}

	@GetMapping("/id/{id}")
	public Question getById(@PathVariable Long id) {
		return questionService.getById(id).orElseThrow(() -> new IllegalArgumentException("Not found"));
	}

	@PutMapping("/{id}")
	public Question update(@PathVariable Long id, @RequestBody QuestionRequest req) {
		Question q = new Question();
		q.setQuestionText(req.getQuestionText());
		q.setOptionA(req.getOptionA());
		q.setOptionB(req.getOptionB());
		q.setOptionC(req.getOptionC());
		q.setOptionD(req.getOptionD());
		q.setCorrectOption(req.getCorrectOption());
		q.setMarks(req.getMarks());
		q.setIsPyq(req.getIsPyq());
		q.setPyqYear(req.getPyqYear());
		q.setAllowPreview(req.getAllowPreview());
		q.setExtraJson(req.getExtraJson());
		return questionService.updateQuestion(id, q);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		questionService.deleteQuestion(id);
	}
}
