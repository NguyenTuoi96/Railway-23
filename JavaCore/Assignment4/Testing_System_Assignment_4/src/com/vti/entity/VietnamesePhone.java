package com.vti.entity;

import org.apache.commons.lang3.ArrayUtils;

public class VietnamesePhone extends Phone {
	private Contact[] contactArr;
	
	public VietnamesePhone() {
		contactArr = this.getContacts();
	}

	@Override
	public void insertContact(String name, String phone) {
		Contact contacAdd = new Contact(name, phone);
		contactArr = ArrayUtils.add(contactArr, contacAdd);
	}

	@Override
	public void removeContact(String name) {
		int[] idxArr = new int[] {};
		for(int i = 0; i < contactArr.length; i++) {
			if(name.equals(contactArr[i].getName())) {
				idxArr = ArrayUtils.add(idxArr, i);
			}
		}
		if(idxArr.length > 0) {
			contactArr = ArrayUtils.removeAll(contactArr, idxArr);
		}else {
			System.out.println("Không có tên nào trùng");
		}
	}

	@Override
	public void updateContact(String name, String newPhone) {
		for(Contact contact : contactArr) {
			if(name.equals(contact.getName())) {
				contact.setNumber(newPhone);
			}
		}

	}

	@Override
	public void searchContact(String name) {
		for(Contact contact : contactArr) {
			if(name.equals(contact.getName())) {
				System.out.println(contact);
			}
		}
	}
	
	public void showContact() {
		for (Contact contact : contactArr) {
			System.out.println(contact);
		}
	}

}
