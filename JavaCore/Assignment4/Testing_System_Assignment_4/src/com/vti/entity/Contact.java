package com.vti.entity;

public class Contact {
	private String number;
	private String name;
	
	public Contact(String name, String number) {
		this.number = number;
		this.name = name;
	}
	
	/**
	 * @return the number
	 */
	public String getNumber() {
		return number;
	}
	/**
	 * @param number the number to set
	 */
	public void setNumber(String number) {
		this.number = number;
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
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Contacts [number=" + number + ", name=" + name + "]";
	}
	
}
