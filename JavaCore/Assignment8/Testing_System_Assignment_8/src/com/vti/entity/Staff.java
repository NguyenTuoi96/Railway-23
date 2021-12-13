package com.vti.entity;

public class Staff<K, V> extends MyMap<K, V> {

	public Staff(K key, V value) {
		super(key, value);
		// TODO Auto-generated constructor stub
	}

	public <T> T getId() {
		return (T) super.getKey();
	}

	public String getName() {
		return (String) super.getValue();
	}
}
