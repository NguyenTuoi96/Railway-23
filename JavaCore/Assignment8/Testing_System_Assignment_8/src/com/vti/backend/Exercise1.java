package com.vti.backend;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.vti.entity.Student;

public class Exercise1 {
	private List<Student> students;

	public Exercise1() {
		students = new ArrayList<Student>();
		for (int i = 0; i < 5; i++) {
			if (i < 3) {
				students.add(new Student("Nguyễn Văn A"));
			} else {
				students.add(new Student("Nguyễn Văn B" + i));
			}
		}
	}

//	Question 1: List
//	Tạo 1 student có property id, name (trong đó có 3 student có name trùng nhau, id sẽ là auto increment)
//	Khai báo 1 ArrayList students, sau đó
//	a) In ra tổng số phần tử của students
//	b) Lấy phần tử thứ 4 của students
//	c) In ra phần tử đầu và phần tử cuối của students
//	d) Thêm 1 phần tử vào vị trí đầu của students
//	e) Thêm 1 phần tử vào vị trí cuối của students
//	f) Đảo ngược vị trí của students
//	g) Tạo 1 method tìm kiếm student theo id
//	h) Tạo 1 method tìm kiếm student theo name
//	i) Tạo 1 method để in ra các student có trùng tên
//	j) Xóa name của student có id = 2;
//	k) Delete student có id = 5;
//	l) Tạo 1 ArrayList tên là studentCopies và add tất cả students vào studentCopies
	public void question1() {
		// a. In ra tổng số phần tử của students
		System.out.println("Tổng số phần tử của students: " + students.size());

		// b. Lấy phần tử thứ 4 của students
		System.out.println("Phần tử thứ 4 của students: " + students.get(3));

		// c. In ra phần tử đầu và phần tử cuối của students
		System.out.println("Phần đầu của students: " + students.get(0));
		System.out.println("Phần cuối của students: " + students.get(students.size() - 1));

		// d. Thêm 1 phần tử vào vị trí đầu của students
		students.add(0, new Student("Nguyễn Văn C"));
		System.out.println(
				"Danh sách phần tử của students sau khi thêm 1 phần tử vào vị trí đầu của students: \n" + students);

		// e. Thêm 1 phần tử vào vị trí cuối của students
		students.add(new Student("Nguyễn Văn D"));
		System.out.println(
				"Danh sách phần tử của students sau khi thêm 1 phần tử vào vị trí cuối của students: \n" + students);

		// f. Đảo ngược vị trí của students
		Collections.reverse(students);
		System.out.println("Danh sách phần tử của students sau khi đảo ngược vị trí của students: \n" + students);

		// g. Tạo 1 method tìm kiếm student theo id
		Student returnStudentSearchById = searchById(2);
		if (returnStudentSearchById != null) {
			System.out.println("Kết quả tìm kiếm student theo id: " + returnStudentSearchById);
		}

		// h. Tạo 1 method tìm kiếm student theo name
		students.add(new Student(null));
		List<Student> returnStudentSearchByName = searchByName(null);
		if (returnStudentSearchByName.size() != 0) {
			System.out.println("Kết quả tìm kiếm student theo tên: " + returnStudentSearchByName);
		} else {
			System.out.println("Tên không tồn tại");
		}

		// i. Tạo 1 method để in ra các student có trùng tên
		students.add(new Student("Nguyễn Văn A"));
		students.add(new Student("Nguyễn Văn B"));
		students.add(new Student("Nguyễn Văn A"));
		students.add(new Student(null));
		Set<Student> returnStudentDuplicationName = getDuplicationName();
		if (returnStudentDuplicationName == null) {
			System.out.println("Không có student nào trùng tên nhau: ");
		} else {
			System.out.println("Các student trùng tên: ");
			for (Student student : returnStudentDuplicationName) {
				System.out.println(student);
			}
		}

		// j. Xóa name của student có id = 2;
		for (Student student : students) {
			if (student.getId() == 2) {
				student.setName(null);
			}
		}
		System.out.println("Danh sách phần tử của students sau khi xóa name của student có id = 2: \n" + students);

		// k. Delete student có id = 5
		Student studentDel = new Student();
		for (Student student : students) {
			if (student.getId() == 5) {
				studentDel = student;
			}
		}
		students.remove(studentDel);
		System.out.println("Danh sách phần tử của students sau khi xóa student có id = 5: \n" + students);

		// l. Tạo 1 ArrayList tên là studentCopies và add tất cả students vào
		// studentCopies
		List<Student> studentCopies = new ArrayList<Student>();
		studentCopies.addAll(students);
		System.out.println("Danh sách phần tử của studentCopies\n" + studentCopies);

	}

	// g. Tạo 1 method tìm kiếm student theo id
	private Student searchById(int id) {
		for (Student student : students) {
			if (student.getId() == id) {
				return student;
			}
		}
		System.out.println("id không tồn tại");
		return null;
	}

	// h. Tạo 1 method tìm kiếm student theo name
	private List<Student> searchByName(String name) {
		List<Student> studentResult = new ArrayList<Student>();
		for (Student student : students) {
			if (name != null && student.getName() != null) {
				if (student.getName().toLowerCase().contains(name.toLowerCase())) {
					studentResult.add(student);
				}
			} else if (name == null) {
				if (student.getName() == null) {
					studentResult.add(student);
				}
			}
		}
		return studentResult;
	}

	// i. Tạo 1 method để in ra các student có trùng tên
	private Set<Student> getDuplicationName() {
		Set<Student> setStudent = new HashSet<Student>();
		for (int i = 0; i < students.size(); i++) {
			for (int j = i + 1; j < students.size(); j++) {
				if (students.get(i).getName() != null && students.get(j).getName() != null) {
					if (students.get(i).getName().equals(students.get(j).getName())) {
						setStudent.add(students.get(i));
						setStudent.add(students.get(j));
					}
				} else if (students.get(i).getName() == null && students.get(j).getName() == null) {
					setStudent.add(students.get(i));
					setStudent.add(students.get(j));
				}

			}
		}
		return setStudent;

	}

//	Question 6: Map
//	Để thay thế 1 object ta có thể tạo 1 map tên là students có key = id của student , value là name của students
	public void question6() {
		HashMap<Integer, String> mapStudent = new HashMap<>();
		for (Student std : students) {
			mapStudent.put(std.getId(), std.getName());
		}

		System.out.println("mapStudent: " + mapStudent);
		
		Set<Map.Entry<Integer, String>> set = mapStudent.entrySet();		
		Iterator<Map.Entry<Integer, String>> itr = set.iterator();
		while(itr.hasNext()) {
			Map.Entry e = itr.next();
			System.out.println(e.getKey() + ": " + e.getValue());
		}
		
	}
}
