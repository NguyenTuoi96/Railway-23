package com.vti.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "question")
public class Question implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "question_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short questionId;

	@Column(name = "content", length = 100, nullable = false)
	private String Content;

	@Column(name = "create_date", updatable = false) // , columnDefinition = "DATETIME DEFAULT NOW()"
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date createDate;

	public Question() {
	}

	/**
	 * @return the questionId
	 */
	public short getQuestionId() {
		return questionId;
	}

	/**
	 * @param questionId the questionId to set
	 */
	public void setQuestionId(short questionId) {
		this.questionId = questionId;
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
	 * @return the createDate
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * @param createDate the createDate to set
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "Question [questionId=" + questionId + ", Content=" + Content + ", createDate=" + createDate + "]";
	}
	
}
