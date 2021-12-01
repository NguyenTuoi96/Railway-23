package com.vti.entity;

//Tạo 1 class Student gồm các property id, name, group(int)
//Class Student sẽ implement interface như sau:
//Method điểm danh() sẽ in ra nội dung như sau:
//"Nguyễn Văn A điểm danh"
//"Nguyễn Văn B điểm danh"
//"Nguyễn Văn C điểm danh"
//….
//Method học Bài () sẽ in ra nội dung như sau:
//"Nguyễn Văn A đang học bài"
//"Nguyễn Văn B đang học bài "
//"Nguyễn Văn C đang học bài "
//…
//Tương tự với các method còn lại
public class Student implements Istudent {
	private int id;
	private String name;
	private int group;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGroup() {
		return group;
	}

	public void setGroup(int group) {
		this.group = group;
	}

	public Student(int id, String name, int group) {
		this.id = id;
		this.name = name;
		this.group = group;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", group=" + group + "]";
	}

	@Override
	public void diemDanh() {
		
		System.out.println(this.name + " đã điểm danh");
	}

	@Override
	public void hocBai() {
		
		System.out.println(this.name + " đã học bài");

	}

	@Override
	public void donVeSinh() {
		
		System.out.println(this.name + " đã dọn vệ sinh");

	}

}
