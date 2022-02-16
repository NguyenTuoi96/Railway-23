package com.vti.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "category_question")
public class CategoryQuestion implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "category_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short categoryId;

	@Column(name = "category_name", length = 50, nullable = false, unique = true)
	private String categoryName;

	public CategoryQuestion() {
	}

	/**
	 * @return the categoryId
	 */
	public short getCategoryId() {
		return categoryId;
	}

	/**
	 * @param categoryId the categoryId to set
	 */
	public void setCategoryId(short categoryId) {
		this.categoryId = categoryId;
	}

	/**
	 * @return the categoryName
	 */
	public String getCategoryName() {
		return categoryName;
	}

	/**
	 * @param categoryName the categoryName to set
	 */
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@Override
	public String toString() {
		return "CategoryQuestion [categoryId=" + categoryId + ", categoryName=" + categoryName + "]";
	}
	
}
