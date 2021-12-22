package com.vti.backend;

import java.sql.SQLException;
import java.util.List;

import com.vti.Utils.ScannerUtils;
import com.vti.backend.Dao.DepartmentDao;
import com.vti.entity.Department;

public class Exercise2 {
//	Question 1: read data – get list departments
//	Tạo method để lấy ra danh sách tất cả các Department
	public void question1() throws ClassNotFoundException, SQLException {
		DepartmentDao departmentDao = new DepartmentDao();
		List<Department> listDepartment = departmentDao.getDepartments();
		for (Department department : listDepartment) {
			System.out.println("Department Id: " + department.getDepartmentId() + "Department Name: "
					+ department.getDepartmentName());
		}
	}

//	Question 2: read data – get department by id
//	Tạo method để lấy ra Department có id = 5
	public void question2() throws ClassNotFoundException, SQLException {
		DepartmentDao departmentDao = new DepartmentDao();
		Department department = departmentDao.getDepartmentsById((byte) 5);
		if (department != null) {
			System.out.println("Department Id: " + department.getDepartmentId() + "Department Name: "
					+ department.getDepartmentName());
		}
	}

//	Question 3: Tiếp tục Question 2 (read data – get department by id)
//	Không fix cứng id nữa mà sẽ dùng scanner để yêu cầu người dùng nhập vào id, sau đó trả về thông tin department có id như người dùng nhập vào
	public void question3() throws ClassNotFoundException, SQLException {
		DepartmentDao departmentDao = new DepartmentDao();
		System.out.println("Nhập vào id bạn muốn tìm kiếm");
		int id = ScannerUtils.inputInt("Bạn nhập sai, hãy nhập 1 giá trị số");
		Department department = departmentDao.getDepartmentsById((byte) id);
		if (department != null) {
			System.out.println("Department Id: " + department.getDepartmentId() + "Department Name: "
					+ department.getDepartmentName());
		}
	}

//	Question 4: Tạo method để check department name có tồn tại hay không?
	public void question4() throws ClassNotFoundException, SQLException {
		DepartmentDao departmentDao = new DepartmentDao();
		System.out.println("Nhập vào tên phòng ban bạn muốn kiểm tra");
		String departmentName = ScannerUtils.inputString();
		boolean yuuDepartment = departmentDao.isDepartmentNameExists(departmentName);
		if (yuuDepartment) {
			System.out.println("Có phòng ban " + departmentName);
		}else {
			System.out.println("Không có phòng ban " + departmentName);
		}
	}

//	Question 5: Tạo method để người dùng có thể tạo được department
	public void question5() throws ClassNotFoundException, SQLException {
		DepartmentDao departmentDao = new DepartmentDao();
		System.out.println("Nhập vào tên phòng ban bạn muốn thêm");
		String departmentName = ScannerUtils.inputString();
		departmentDao.createDepartment(departmentName);
	}

//	Question 6: Tạo method để người dùng có thể update được department name
	public void question6() throws ClassNotFoundException, SQLException {
		DepartmentDao departmentDao = new DepartmentDao();
		System.out.println("Nhập vào id phòng ban bạn muốn sửa");
		int departmentId = ScannerUtils.inputInt("Bạn nhập sai, hãy nhập 1 giá trị số");
		System.out.println("Nhập vào tên phòng ban mới");
		String departmentName = ScannerUtils.inputString();
		departmentDao.updateDepartment(departmentId, departmentName);
	}

//	Question 7: Tạo method để người dùng có thể xóa được department theo id mà user nhập vào
	public void question7() throws ClassNotFoundException, SQLException {
		DepartmentDao departmentDao = new DepartmentDao();
		System.out.println("Nhập vào id phòng ban bạn muốn xóa");
		int departmentId = ScannerUtils.inputInt("Bạn nhập sai, hãy nhập 1 giá trị số");
		departmentDao.deleteDepartment(departmentId);
	}
}
