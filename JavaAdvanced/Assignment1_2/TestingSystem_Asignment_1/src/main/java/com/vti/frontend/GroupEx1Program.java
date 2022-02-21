package com.vti.frontend;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.vti.entity.GroupEx1;
import com.vti.repository.GroupEx1Repository;

public class GroupEx1Program {
	public static void main(String[] args) {
		GroupEx1Repository repository = new GroupEx1Repository();

		System.out.println("\n\n***********CREATE GROUP***********");
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();

		GroupEx1 groupCre = new GroupEx1();
		groupCre.setName("group test 1");
		groupCre.setCreateDate(java.sql.Date.valueOf(simpleDateFormat.format(date)));
		repository.createGroups(groupCre);

		System.out.println("***********GET ALL GROUP***********");

		List<GroupEx1> groups = repository.getAllGroups();

		for (GroupEx1 group : groups) {
			System.out.println(group);
		}

	}
}
