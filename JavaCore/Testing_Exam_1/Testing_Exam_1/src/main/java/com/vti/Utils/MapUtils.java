package com.vti.Utils;

import java.util.HashMap;

@SuppressWarnings({ "serial", "rawtypes" })
public class MapUtils<K, V> extends HashMap {
	private K key;
	private V value;
	public K getKey() {
		return key;
	}
	public void setKey(K key) {
		this.key = key;
	}
	public V getValue() {
		return value;
	}
	public void setValue(V value) {
		this.value = value;
	}
	
	public MapUtils() {
		super();
	}
	
	public MapUtils(K key, V value) {
		super();
		this.key = key;
		this.value = value;
	}
	@Override
	public String toString() {
		return "MapUtils [key=" + key + ", value=" + value + "]";
	}
	
}
