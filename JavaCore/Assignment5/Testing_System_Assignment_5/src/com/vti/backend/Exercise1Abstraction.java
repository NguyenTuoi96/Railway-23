package com.vti.backend;

import java.util.Scanner;

import org.apache.commons.lang3.ArrayUtils;

import com.vti.entity.News;
import com.vti.entity.TuyenSinh;

public class Exercise1Abstraction {
	private Scanner sc;
	private News[] newsArr;
	
	public Exercise1Abstraction() {
		sc = new Scanner(System.in);
		newsArr = new News[] {};
	}
	
//	Tạo chương trình demo có tên là MyNews và tạo một menu lựa chọn gồm các mục sau:
//		 Insert news
//		 View list news
//		 Average rate
//		 Exit
//	Nếu người dùng chọn 1 từ bàn phím thì tạo một object của class News và nhập giá trị cho các thuộc tính Title, PublishDate, Author, Content sau đó yêu cầu người dùng nhập vào 3 đánh giá để lưu vào Rates.
//	Nếu người dùng chọn 2 từ bàn phím thì thực thi method Display().
//	Nếu người dùng chọn 3 từ bàn phím thì thực hiện method Calculate() để tính đánh giá trung bình, sau đó thực thi method Display().
//	Trường hợp người dùng chọn 4 thì sẽ thoát khỏi chương trình.
	public void question1() {
		while(true) {
			System.out.println("Lựa chọn chức năng");
			System.out.println("1. Insert news");
			System.out.println("2. View list news");
			System.out.println("3. Average rate");
			System.out.println("4. Exit");
			int selectNum = sc.nextInt();
			switch (selectNum) {
			case 1:	insertNews();
				break;
			case 2:	viewListNews();	
				break;
			case 3:	averageRate();
				break;
			case 4:
				System.out.println("Bye!");
				sc.close();
				return;
			default:
				System.out.println("Lựa chọn đúng số trên menu");
				break;
			}
		}
		
	}
	
	private void insertNews() {
		sc.nextLine();
		System.out.println("Nhập vào tiêu đề");
		String title = sc.nextLine();
		System.out.println("Nhập vào ngày phát hành có dạng 'dd-MM-yyyy'");
		String publishDate = sc.nextLine();
		System.out.println("Nhập vào tên tác giả");
		String author = sc.nextLine();
		System.out.println("Nhập vào nội dung");
		String content = sc.nextLine();
		System.out.println("Nhập vào đánh giá 1");
		int rate1 = sc.nextInt();
		System.out.println("Nhập vào đánh giá 2");
		int rate2 = sc.nextInt();
		System.out.println("Nhập vào đánh giá 3");
		int rate3 = sc.nextInt();
		
		int[] rateArr = new int[] {rate1, rate2, rate3};
		
		News news = new News(newsArr.length, title, publishDate, author, content, rateArr);
		newsArr = ArrayUtils.add(newsArr, news);
		System.out.println("Đã thêm tin: ");
		System.out.println(news);
	}
	
	private void viewListNews() {
		News[] news = newsArr;
		for(News newItem : news) {
			newItem.Display();
		}
	}
	
	private void averageRate() {
		News[] news = newsArr;
		for(News newItem : news) {
			newItem.Calculate();
			newItem.Display();
		}
	}
	
	public void question2() {
		TuyenSinh tuyensinh = new TuyenSinh();
		while(true) {
			System.out.println("Lựa chọn chức năng");
			System.out.println("1. Thêm mới thí sinh.");
			System.out.println("2. Hiện thị thông tin của thí sinh và khối thi của thí sinh.");
			System.out.println("3. Tìm kiếm theo số báo danh.");
			System.out.println("4. Thoát khỏi chương trình.");
			int selectNum = sc.nextInt();
			switch (selectNum) {
			case 1:	tuyensinh.themThiSinh();
				break;
			case 2:	tuyensinh.hienThiThongTin();
				break;
			case 3:	tuyensinh.timKiem();
				break;
			case 4: tuyensinh.thoatChuongTrinh();
				return;
			default:
				System.out.println("Lựa chọn đúng số trên menu");
				break;
			}
		}
		
	}
	
}
