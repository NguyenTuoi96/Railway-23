package com.vti.entity;

public class Student {
	private short id;
	private String name;
	private String hometown;
	private float score;
	
//	Tạo constructor cho phép khi khởi tạo mỗi student thì người dùng sẽ nhập vào tên, hometown và có điểm học lực = 0
	public Student(String name, String hometown) {
		this.setName(name);
		this.setHometown(hometown);
		this.setScore(0f);
	}
	
//	Tạo 1 method cho phép set điểm vào
	public void setScore(Float score) {
		this.score = score;
	}
	
//	Tạo 1 method cho phép cộng thêm điểm
	public void plusScore(Float score) {
		this.setScore(this.getScore() + score);
	}
	
//	Tạo 1 method để in ra thông tin của sinh viên bao gồm có tên, điểm học lực 
//	nếu điểm <4.0 thì sẽ in ra là Yếu, 
//	nếu điểm > 4.0 và < 6.0 thì sẽ in ra là trung bình, 
//	nếu điểm > 6.0 và < 8.0 thì sẽ in ra là khá, 
//	nếu > 8.0 thì in ra là Giỏi
	public String toString() {
		String rank = null;
		if(this.getScore() < 4.0) {
			rank = "yếu";
		}else if(this.getScore() < 6.0) {
			rank = "Trung bình";
		}else if(this.getScore() < 8.0) {
			rank = "Khá";
		}else {
			rank = "Giỏi";
		}
		return "Student [name=" + getName() + ", score=" + getScore() + ", học lực=" + rank + "]";
	}

	/**
	 * @return the id
	 */
	public short getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(short id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	private void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the hometown
	 */
	public String getHometown() {
		return hometown;
	}

	/**
	 * @param hometown the hometown to set
	 */
	public void setHometown(String hometown) {
		this.hometown = hometown;
	}

	/**
	 * @return the score
	 */
	public float getScore() {
		return score;
	}

	/**
	 * @param score the score to set
	 */
	public void setScore(float score) {
		this.score = score;
	}
}
