package com.vti.entity;

public abstract class Phone {
	private Contact[] contacts;
	public Phone() {
		Contact contact1 = new Contact("Anh Thảo", "08039062410");
		contacts = new Contact[] {contact1};
	}
	
	public abstract void insertContact(String name, String phone);

	public abstract void removeContact(String name);

	public abstract void updateContact(String name, String newPhone);

	public abstract void searchContact(String name);

	/**
	 * @return the contacts
	 */
	public Contact[] getContacts() {
		return contacts;
	}

	/**
	 * @param contacts the contacts to set
	 */
	public void setContacts(Contact[] contacts) {
		this.contacts = contacts;
	}
}
