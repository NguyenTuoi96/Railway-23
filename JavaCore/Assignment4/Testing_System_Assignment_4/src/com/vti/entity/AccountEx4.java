package com.vti.entity;

public class AccountEx4 {
	private String id;
	private String name;
	private int balance;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	// credit: nạp tiền
	public int credit(int amount) {
		return this.balance += amount;
	}

	// debit: rút tiền
	public int debit(int amount) {
		return this.balance -= amount;
	}

	// tranferTo: chuyển tiền
	public void tranferTo(AccountEx4 accEx4, int amount) {
		this.balance -= amount;
		accEx4.balance += amount;
	}
	
	@Override
	public String toString() {
		return "AccountEx4 [id=" + id + ", name=" + name + ", balance=" + balance + "]";
	}
	
	public AccountEx4(String id, String name, int balance) {
		super();
		this.id = id;
		this.name = name;
		this.balance = balance;
	}
	
	
}
