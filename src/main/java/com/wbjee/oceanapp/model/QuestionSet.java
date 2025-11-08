package com.wbjee.oceanapp.model;

import jakarta.persistence.*;
import java.time.OffsetDateTime;

@Entity
@Table(name = "question_sets")
public class QuestionSet {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 100)
	private String name;

	@Column(nullable = false, length = 100, unique = true)
	private String slug;

	@Column(columnDefinition = "text")
	private String description;

	@Column(name = "created_at")
	private OffsetDateTime createdAt = OffsetDateTime.now();

	// getters & setters...
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public OffsetDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(OffsetDateTime createdAt) {
		this.createdAt = createdAt;
	}
}
