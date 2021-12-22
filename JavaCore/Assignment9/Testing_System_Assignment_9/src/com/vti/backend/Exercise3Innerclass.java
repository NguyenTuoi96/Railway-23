package com.vti.backend;

import com.vti.entity.CPU;
import com.vti.entity.Car;
import com.vti.entity.Car.Engine;

public class Exercise3Innerclass {
	public static void question1() {
		CPU cpu = new CPU(5.2f);
		CPU.Processor processor = cpu.new Processor(5.0f, "menufacturerTest");
		cpu.processor = processor;

		CPU.Ram ram = cpu.new Ram("memoryTest", "menufacturerTest");
		cpu.ram = ram;
		
		System.out.println(cpu.processor.getCache());
		System.out.println(cpu.ram.getClockSpeed());
	}
	
	public static void question2() {
		Car car = new Car("Mazda", "8WD");
		Engine engine = new Car.Engine("Crysler");
		car.setEngine(engine);
		System.out.println(car);
	}
}
