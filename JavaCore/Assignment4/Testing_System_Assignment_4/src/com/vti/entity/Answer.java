package com.vti.entity;

public class Answer {
	private int answerId;
	private String content;
	private Question question;
	private boolean isCorrect;
	/**
	 * @return the answerId
	 */
	public int getAnswerId() {
		return answerId;
	}
	/**
	 * @param answerId the answerId to set
	 */
	public void setAnswerId(int answerId) {
		this.answerId = answerId;
	}
	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}
	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * @return the question
	 */
	public Question getQuestion() {
		return question;
	}
	/**
	 * @param question the question to set
	 */
	public void setQuestion(Question question) {
		this.question = question;
	}
	/**
	 * @return the isCorrect
	 */
	public boolean isCorrect() {
		return isCorrect;
	}
	/**
	 * @param isCorrect the isCorrect to set
	 */
	public void setCorrect(boolean isCorrect) {
		this.isCorrect = isCorrect;
	}
	
}
