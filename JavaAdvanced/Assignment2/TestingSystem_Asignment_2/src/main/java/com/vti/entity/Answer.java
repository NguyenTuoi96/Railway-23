package com.vti.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "answer")
public class Answer implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "answer_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short answerId;

	@Column(name = "content", length = 100, nullable = false)
	private String Content;

	@Column(name = "is_correct", columnDefinition = "1")
	private Boolean isCorrect;

	public Answer() {
	}

	/**
	 * @return the answerId
	 */
	public short getAnswerId() {
		return answerId;
	}

	/**
	 * @param answerId the answerId to set
	 */
	public void setAnswerId(short answerId) {
		this.answerId = answerId;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return Content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		Content = content;
	}

	/**
	 * @return the isCorrect
	 */
	public Boolean getIsCorrect() {
		return isCorrect;
	}

	/**
	 * @param isCorrect the isCorrect to set
	 */
	public void setIsCorrect(Boolean isCorrect) {
		this.isCorrect = isCorrect;
	}

	@Override
	public String toString() {
		return "Answer [answerId=" + answerId + ", Content=" + Content + ", isCorrect=" + isCorrect + "]";
	}
	
}
