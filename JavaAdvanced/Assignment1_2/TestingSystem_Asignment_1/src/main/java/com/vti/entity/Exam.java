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
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "exam")
public class Exam implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "exam_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short examId;

	@Column(name = "`code1`", length = 10, nullable = false)
//	@Id
//	@GenericGenerator(
//			name = "exam-code-generator", 
//			strategy = "com.vti.entity.ExamCodeGenerator"
//	)
//	@GeneratedValue(generator = "exam-code-generator")
	private String code1;

	@Column(name = "`code2`", length = 10)
	private String code2;

	@Column(name = "title", length = 50, nullable = false)
	private String title;

	@Column(name = "duration", columnDefinition = "TINYINT UNSIGNED DEFAULT 45")
	private short duration;

	@Column(name = "create_date", updatable = false) //  columnDefinition = "DATETIME DEFAULT NOW()"
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date createDate;

	public Exam() {
	}

	/**
	 * @return the examId
	 */
	public short getExamId() {
		return examId;
	}

	/**
	 * @param examId the examId to set
	 */
	public void setExamId(short examId) {
		this.examId = examId;
	}

	/**
	 * @return the code1
	 */
	public String getCode1() {
		return code1;
	}

	/**
	 * @param code1 the code1 to set
	 */
	public void setCode1(String code1) {
		this.code1 = code1;
	}

	/**
	 * @return the code2
	 */
	public String getCode2() {
		return code2;
	}

	/**
	 * @param code2 the code2 to set
	 */
	public void setCode2(String code2) {
		this.code2 = code2;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the duration
	 */
	public short getDuration() {
		return duration;
	}

	/**
	 * @param duration the duration to set
	 */
	public void setDuration(short duration) {
		this.duration = duration;
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
		return "Exam [examId=" + examId + ", code1=" + code1 + ", code2=" + code2 + ", title=" + title + ", duration="
				+ duration + ", createDate=" + createDate + "]";
	}
	
}
