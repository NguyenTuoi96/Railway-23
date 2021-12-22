package com.vti.entity;

public class CPU {
	private float price;
	public Processor processor;
	public Ram ram;

	public CPU(float price) {
		super();
		this.price = price;
	}

	@Override
	public String toString() {
		return "CPU [price=" + price + ", processor=" + processor + ", ram=" + ram + "]";
	}

	// inner class Processor
	public class Processor {
		private float coreAmount;
		private String menufacturer;

		public Processor(float coreAmount, String menufacturer) {
			super();
			this.coreAmount = coreAmount;
			this.menufacturer = menufacturer;
		}

		@Override
		public String toString() {
			return "Processor [coreAmount=" + coreAmount + ", menufacturer=" + menufacturer + "]";
		}

		public float getCache() {
			return 4.3f;
		}
	}

	// inner class Ram
	public class Ram {
		private String memory;
		private String menufacturer;

		public Ram(String memory, String menufacturer) {
			super();
			this.memory = memory;
			this.menufacturer = menufacturer;
		}

		@Override
		public String toString() {
			return "Ram [memory=" + memory + ", menufacturer=" + menufacturer + "]";
		}

		public float getClockSpeed() {
			return 5.5f;
		}
	}
}
