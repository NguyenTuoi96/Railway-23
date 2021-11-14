package com.vti.academy;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.vti.academy.enums.PositionName;
import com.vti.academy.enums.TypeName;

public class Program {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		// tạo đối tượng Department
		Department department1 = new Department();
		department1.departmentId = 1;
		department1.departmentName = "Phòng giám đốc";
		
		Department department2 = new Department();
		department2.departmentId = 2;
		department2.departmentName = "Phòng Sale";
		
		Department department3 = new Department();
		department3.departmentId = 3;
		department3.departmentName = "Phòng marketting";
		
		// In giá trị
		System.out.println("Danh sách phòng ban");
		System.out.println("Department1: departmentId = " + department1.departmentId + ", departmentName = " + department1.departmentName);
		System.out.println("Department2: departmentId = " + department2.departmentId + ", departmentName = " + department2.departmentName);
		System.out.println("Department3: departmentId = " + department3.departmentId + ", departmentName = " + department3.departmentName);
		System.out.println();

		// tạo đối tượng Position
		Position position1 = new Position();
		position1.positionId = 1;
		position1.positionName = PositionName.POSITION_DEV.getPositionName();
		
		Position position2 = new Position();
		position2.positionId = 2;
		position2.positionName = PositionName.POSITION_PM.getPositionName();
		
		Position position3 = new Position();
		position3.positionId = 3;
		position3.positionName = PositionName.POSITION_SCRUM_MASTER.getPositionName();
		
		// In giá trị
		System.out.println("Danh sách vị trí");
		System.out.println("Position1: positionId = " + position1.positionId + ", positionName = " + position1.positionName);
		System.out.println("Position2: positionId = " + position2.positionId + ", positionName = " + position2.positionName);
		System.out.println("Position3: positionId = " + position3.positionId + ", positionName = " + position3.positionName);
		System.out.println();

		// tạo đối tượng Account		
		Account account1 = new Account();
		account1.accountId = 1;
		account1.email = "nguyenanh@gmail.com";
		account1.userName = "NguyenAnh";
		account1.fullName = "Nguyễn Văn Anh";
		account1.department = department1;
		account1.position = position1;
		account1.createDate = dateFormat.parse("01-01-1996");
		
		Account account2 = new Account();
		account2.accountId = 2;
		account2.email = "nguyenhoa@gmail.com";
		account2.userName = "HoaNguyen";
		account2.fullName = "Nguyễn Thị Hoa";
		account2.department = department2;
		account2.position = position2;
		account2.createDate = new Date();
		
		Account account3 = new Account();
		account3.accountId = 3;
		account3.email = "nguyenphuong@gmail.com";
		account3.userName = "PhuongNguyen";
		account3.fullName = "Nguyễn Thảo Phương";
		account3.department = department3;
		account3.position = position3;
		account3.createDate = new Date();

		// In giá trị
		System.out.println("Danh sách Account");
		System.out.println("Account1: accountId = " + account1.accountId + ", email = " + account1.email
				+ ", \n\t  userName = " + account1.userName + ", fullName = " + account1.fullName
				+ ", \n\t  department = " + account1.department.departmentName + ", position = " + account1.position.positionName
				+ ", \n\t  createDate = " + dateFormat.format(account1.createDate));
		System.out.println("Account2: accountId = " + account2.accountId + ", email = " + account2.email
				+ ", \n\t  userName = " + account2.userName + ", fullName = " + account2.fullName
				+ ", \n\t  department = " + account2.department.departmentName + ", position = " + account2.position.positionName
				+ ", \n\t  createDate = " + dateFormat.format(account2.createDate));
		System.out.println("Account3: accountId = " + account3.accountId + ", email = " + account3.email
				+ ", \n\t  userName = " + account3.userName + ", fullName = " + account3.fullName
				+ ", \n\t  department = " + account3.department.departmentName + ", position = " + account3.position.positionName
				+ ", \n\t  createDate = " + dateFormat.format(account3.createDate));
		System.out.println();

		// tạo đối tượng Group
		Group group1 = new Group();
		group1.groupId = 1;
		group1.groupName = "Group 1";
		group1.creator = account1;
		group1.createDate = new Date();
		
		Group group2 = new Group();
		group2.groupId = 2;
		group2.groupName = "Group 2";
		group2.creator = account3;
		group2.createDate = new Date();
		
		Group group3 = new Group();
		group3.groupId = 3;
		group3.groupName = "Group 3";
		group3.creator = account2;
		group3.createDate = new Date();

		// In giá trị
		System.out.println("Danh sách Group");
		System.out.println("Group1: groupId = " + group1.groupId + ", groupName = " + group1.groupName
				+ ", \n\t  creator = " + group1.creator.fullName + ", createDate = " + dateFormat.format(group1.createDate));
		System.out.println("Group2: groupId = " + group2.groupId + ", groupName = " + group2.groupName
				+ ", \n\t  creator = " + group2.creator.fullName + ", createDate = " + dateFormat.format(group2.createDate));
		System.out.println("Group3: groupId = " + group3.groupId + ", groupName = " + group3.groupName
				+ ", \n\t  creator = " + group3.creator.fullName + ", createDate = " + dateFormat.format(group3.createDate));
		System.out.println();
		
		// tạo đối tượng GroupAccount
		GroupAccount groupAccount1 = new GroupAccount();
		groupAccount1.group = group2;
		groupAccount1.account = account2;
		groupAccount1.JoinDate = new Date();
		
		GroupAccount groupAccount2 = new GroupAccount();
		groupAccount2.group = group3;
		groupAccount2.account = account3;
		groupAccount2.JoinDate = new Date();
		
		GroupAccount groupAccount3 = new GroupAccount();
		groupAccount3.group = group2;
		groupAccount3.account = account3;
		groupAccount3.JoinDate = new Date();

		// In giá trị
		System.out.println("Danh sách GroupAccount");
		System.out.println("GroupAccount1: group = " + groupAccount1.group.groupName + ", account = " + groupAccount1.account.fullName
				+ ", \n\t  JoinDate = " + dateFormat.format(groupAccount1.JoinDate));
		System.out.println("GroupAccount2: group = " + groupAccount2.group.groupName + ", account = " + groupAccount2.account.fullName
				+ ", \n\t  JoinDate = " + dateFormat.format(groupAccount2.JoinDate));
		System.out.println("GroupAccount3: group = " + groupAccount3.group.groupName + ", account = " + groupAccount3.account.fullName
				+ ", \n\t  JoinDate = " + dateFormat.format(groupAccount3.JoinDate));
		System.out.println();
		
		// tạo đối tượng TypeQuestion
		TypeQuestion typeQuestion1 = new TypeQuestion();
		typeQuestion1.typeId = 1;
		typeQuestion1.typeName = TypeName.TYPE_NAME_ESSAY.getTypeName();

		TypeQuestion typeQuestion2 = new TypeQuestion();
		typeQuestion2.typeId = 2;
		typeQuestion2.typeName = TypeName.TYPE_NAME_MULTIPLE_CHOICE.getTypeName();

		// In giá trị
		System.out.println("Danh sách TypeQuestion");
		System.out.println("TypeQuestion1: typeId = " + typeQuestion1.typeId + ", typeName = " + typeQuestion1.typeName);
		System.out.println("TypeQuestion2: typeId = " + typeQuestion2.typeId + ", typeName = " + typeQuestion2.typeName);
		System.out.println();
		
		// tạo đối tượng CategoryQuestion
		CategoryQuestion categoryQuestion1 = new CategoryQuestion();
		categoryQuestion1.categoryId = 1;
		categoryQuestion1.categoryName = "Java";

		CategoryQuestion categoryQuestion2 = new CategoryQuestion();
		categoryQuestion2.categoryId = 2;
		categoryQuestion2.categoryName = ".Net";

		CategoryQuestion categoryQuestion3 = new CategoryQuestion();
		categoryQuestion3.categoryId = 3;
		categoryQuestion3.categoryName = "SQL";

		// In giá trị
		System.out.println("Danh sách Category");
		System.out.println("CategoryQuestion1: categoryId = " + categoryQuestion1.categoryId + ", categoryName = " + categoryQuestion1.categoryName);
		System.out.println("CategoryQuestion2: categoryId = " + categoryQuestion2.categoryId + ", categoryName = " + categoryQuestion2.categoryName);
		System.out.println("CategoryQuestion3: categoryId = " + categoryQuestion3.categoryId + ", categoryName = " + categoryQuestion3.categoryName);
		System.out.println();
		
		// tạo đối tượng Question
		Question question1 = new Question();
		question1.questionId = 1;
		question1.content = "Content 1";
		question1.category = categoryQuestion1;
		question1.type = typeQuestion2;
		question1.creator = account1;
		question1.createDate = new Date();
		
		Question question2 = new Question();
		question2.questionId = 2;
		question2.content = "Content 2";
		question2.category = categoryQuestion2;
		question2.type = typeQuestion1;
		question2.creator = account2;
		question2.createDate = new Date();

		Question question3 = new Question();
		question3.questionId = 3;
		question3.content = "Câu h�?i 3";
		question3.category = categoryQuestion3;
		question3.type = typeQuestion2;
		question3.creator = account2;
		question3.createDate = new Date();

		// In giá trị
		System.out.println("Danh sách Câu hỏi");
		System.out.println("Question1: questionId = " + question1.questionId + ", content = " + question1.content
				+ ", \n\t  category = " + question1.category.categoryName + ", type = " + question1.type.typeName
				+ ", \n\t  creator = " + question1.creator.fullName + ", createDate = " + dateFormat.format(question1.createDate));
		System.out.println("Question2: questionId = " + question2.questionId + ", content = " + question2.content
				+ ", \n\t  category = " + question2.category.categoryName + ", type = " + question2.type.typeName
				+ ", \n\t  creator = " + question2.creator.fullName + ", createDate = " + dateFormat.format(question2.createDate));
		System.out.println("Question3: questionId = " + question3.questionId + ", content = " + question3.content
				+ ", \n\t  category = " + question3.category.categoryName + ", type = " + question3.type.typeName
				+ ", \n\t  creator = " + question3.creator.fullName + ", createDate = " + dateFormat.format(question3.createDate));
		System.out.println();
		
		// tạo đối tượng Answer
		Answer answer1 = new Answer();
		answer1.answerId = 1;
		answer1.content = "Câu trả lời 1";
		answer1.question = question1;
		answer1.isCorrect = true;

		Answer answer2 = new Answer();
		answer2.answerId = 2;
		answer2.content = "Câu trả lời 2";
		answer2.question = question2;
		answer2.isCorrect = true;

		Answer answer3 = new Answer();
		answer3.answerId = 3;
		answer3.content = "Câu trả lời 2";
		answer3.question = question3;
		answer3.isCorrect = false;

		// In giá trị
		System.out.println("Danh sách câu trả lời");
		System.out.println("Answer1: answerId = " + answer1.answerId + ", content = " + answer1.content
				+ ", \n\t  question = " + answer1.question.content + ", isCorrect = " + answer1.isCorrect);
		System.out.println("Answer2: answerId = " + answer2.answerId + ", content = " + answer2.content
				+ ", \n\t  question = " + answer2.question.content + ", isCorrect = " + answer2.isCorrect);
		System.out.println("Answer3: answerId = " + answer3.answerId + ", content = " + answer3.content
				+ ", \n\t  question = " + answer3.question.content + ", isCorrect = " + answer3.isCorrect);
		System.out.println();
		
		// tạo đối tượng Exam
		Exam exam1 = new Exam();
		exam1.examId = 1;
		exam1.code = "Mã 1";
		exam1.title = "tiêu đề 1";
		exam1.category = categoryQuestion1;
		exam1.duration = 15;
		exam1.creator = account1;
		exam1.createDate = new Date();

		Exam exam2 = new Exam();
		exam2.examId = 2;
		exam2.code = "Mã 2";
		exam2.title = "tiêu đề 2";
		exam2.category = categoryQuestion2;
		exam2.duration = 45;
		exam2.creator = account2;
		exam2.createDate = new Date();

		Exam exam3 = new Exam();
		exam3.examId = 3;
		exam3.code = "Mã 3";
		exam3.title = "tiêu đề 3";
		exam3.category = categoryQuestion3;
		exam3.duration = 180;
		exam3.creator = account2;
		exam3.createDate = new Date();

		// In giá trị
		System.out.println("Danh sách bài thi");
		System.out.println("Exam1: examId = " + exam1.examId + ", code = " + exam1.code
				+ ", \n\t  title = " + exam1.title + ", category = " + exam1.category.categoryName
				+ ", \n\t  duration = " + exam1.duration + ", creator = " + exam1.creator.fullName
				+ ", \n\t  createDate = " + dateFormat.format(exam1.createDate));
		System.out.println("exam2: examId = " + exam2.examId + ", code = " + exam2.code
				+ ", \n\t  title = " + exam2.title + ", category = " + exam2.category.categoryName
				+ ", \n\t  duration = " + exam2.duration + ", creator = " + exam2.creator.fullName
				+ ", \n\t  createDate = " + dateFormat.format(exam2.createDate));
		System.out.println("exam3: examId = " + exam3.examId + ", code = " + exam3.code
				+ ", \n\t  title = " + exam3.title + ", category = " + exam3.category.categoryName
				+ ", \n\t  duration = " + exam3.duration + ", creator = " + exam3.creator.fullName
				+ ", \n\t  createDate = " + dateFormat.format(exam3.createDate));
		System.out.println();
		
		// tạo đối tượng ExamQuestion
		ExamQuestion examQuestion1 = new ExamQuestion();
		examQuestion1.exam = exam1;
		examQuestion1.question = question1;

		ExamQuestion examQuestion2 = new ExamQuestion();
		examQuestion2.exam = exam2;
		examQuestion2.question = question2;

		ExamQuestion examQuestion3 = new ExamQuestion();
		examQuestion3.exam = exam3;
		examQuestion3.question = question2;

		// In giá trị
		System.out.println("Danh sách ExamQuestion");
		System.out.println("ExamQuestion1: examQuestion1 = " + examQuestion1.exam.title + ", code = " + examQuestion1.question.content);
		System.out.println("ExamQuestion2: examQuestion1 = " + examQuestion2.exam.title + ", code = " + examQuestion2.question.content);
		System.out.println("ExamQuestion3: examQuestion1 = " + examQuestion3.exam.title + ", code = " + examQuestion3.question.content);
	}

}
