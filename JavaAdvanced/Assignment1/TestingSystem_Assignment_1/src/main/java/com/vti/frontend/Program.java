package com.vti.frontend;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.vti.entity.GroupEx1;
import com.vti.repository.GroupEx1Repository;

public class Program {
	public static void main(String[] args) {
		
		// Exercise 1
		GroupEx1Repository groupEx1Repository = new GroupEx1Repository();
		exercise1(groupEx1Repository);

	}
	
	private static void exercise1(GroupEx1Repository repository) {
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();

		System.out.println("***********GET ALL GROUPS***********");

		List<GroupEx1> groupEx1List = repository.getAllGroups();

		for (GroupEx1 groupEx1 : groupEx1List) {
			System.out.println(groupEx1);
		}

		System.out.println("\n\n***********GET GROUP BY ID***********");

		GroupEx1 groupEx1ById = repository.getGroupByID((short) 2);
		System.out.println(groupEx1ById);

		System.out.println("\n\n***********GET GROUP BY NAME***********");

		GroupEx1 groupEx1ByName = repository.getGroupByName("Marketting");
		System.out.println(groupEx1ByName);

		System.out.println("\n\n***********CREATE GROUP***********");

		GroupEx1 groupCreate = new GroupEx1();
		groupCreate.setName("group 1");
		groupCreate.setCreateDate(java.sql.Date.valueOf(simpleDateFormat.format(date)));
		repository.createGroups(groupCreate);

		System.out.println("\n\n***********UPDATE GROUP 1***********");

		repository.updateGroup((short) 3, "Group 2");

		System.out.println("\n\n***********UPDATE GROUP 2***********");

		GroupEx1 groupUpdate = new GroupEx1();
		groupUpdate.setId((short) 2);
		groupUpdate.setName("Security2");
		repository.updateGroup(groupUpdate);

		System.out.println("\n\n***********DELETE GROUP***********");
		repository.deleteGroup((short) 3);

		System.out.println("***********CHECK GROUP EXISTS BY ID***********");
		System.out.println(repository.isGroupExistsByID((short) 1));

		System.out.println("***********CHECK GROUP EXISTS BY NAME***********");
		System.out.println(repository.isGroupExistsByName("group 1"));
		
	}
}
