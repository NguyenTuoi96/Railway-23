package com.vti.entity;

import java.util.Arrays;

//Tạo một class News bao gồm thuộc tính:
//ID (int), Title (String), PublishDate (String), Author (String), Content (String) và AverageRate (float).
//Tạo các setter và getter cho từng thuộc tính, riêng AverageRate thì chỉ có getter.
public class News implements INews {
	private int id;
	private String title;
	private String publishDate;
	private String author;
	private String content;
	private float averageRate;
	private int[] rates;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public float getAverageRate() {
		return averageRate;
	}

	public int[] getRates() {
		return rates;
	}

	public void setRates(int[] rates) {
		this.rates = rates;
	}

	@Override
	public String toString() {
		return "News [id=" + id + ", title=" + title + ", publishDate=" + publishDate + ", author=" + author
				+ ", content=" + content + ", averageRate=" + averageRate + ", rates=" + Arrays.toString(rates) + "]";
	}
	
	public News() {
	}

	public News(int id, String title, String publishDate, String author, String content, int[] rates) {
		super();
		this.id = id;
		this.title = title;
		this.publishDate = publishDate;
		this.author = author;
		this.content = content;
		this.rates = rates;
	}

	// Implement các method trong interface INews như sau:

	// Method Display() sẽ in ra Title, PublishDate, Author, Content và AverageRate
	// của tin tức ra console
	@Override
	public void Display() {
		System.out.println("Title = " + this.title + ", PublishDate = " + this.publishDate + ", Author = " + this.author
				+ ", Content = " + this.content + ", AverageRate = " + this.averageRate);
	}

	// Method có tên Calculate() để thiết đặt thuộc tính
	// Khai báo một array có tên Rates kiểu int gồm 3 phần tử
	// AverageRate là trung bình cộng của 3 phần tử của array Rates.
	@Override
	public float Calculate() {
		if(this.rates != null) {
			float averageRate = (this.rates[0] + this.rates[1] + this.rates[2]) / 3;
			this.averageRate = averageRate;
			return averageRate;
		}		
		return 0;
	}

}
