package com.vti.entity;

//Question 2:
//Tạo Car có property: name, type
//Tạo inner class Engine có property engineType và tạo getter, setter cho property engineType
//Khởi tạo object Car có name = Mazda, type = 8WD, có loại động cơ là "Crysler".
//Sau đó in ra thông tin của động cơ
public class Car {
	String name;
	String type;
	Engine engine;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Engine getEngine() {
		return engine;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}

	public Car(String name, String type) {
		super();
		this.name = name;
		this.type = type;
	}

	@Override
	public String toString() {
		return "Car [name=" + name + ", type=" + type + ", engine=" + engine + "]";
	}

	public static class Engine{
		String engineType;

		public Engine(String engineType) {
			super();
			this.engineType = engineType;
		}

		public String getEngineType() {
			return engineType;
		}

		public void setEngineType(String engineType) {
			this.engineType = engineType;
		}

		@Override
		public String toString() {
			return "Engine [engineType=" + engineType + "]";
		}
		
	}
}
