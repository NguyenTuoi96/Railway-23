package com.vti.entity;

public class Phone<K, V> extends MyMap<K, V> {

	public Phone(K key, V value) {
		super(key, value);
	}

	public String getPhoneNumber() {
		return (String) super.getValue();
	}

	public K getKey() {
		return super.getKey();
	}
}
