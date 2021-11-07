DROP DATABASE IF EXISTS ThucTap;
CREATE DATABASE ThucTap;
USE ThucTap;

ALTER DATABASE testing_system CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci; -- sửa DB khi không sử dụng được NVARCHAR
DROP TABLE IF EXISTS GiangVien;
CREATE TABLE GiangVien(
	magv 	SMALLINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    hoten 	VARCHAR(50) CHAR SET utf8mb4 NOT NULL,
    luong 	DOUBLE(12,2)
);
INSERT INTO GiangVien(hoten, luong) 
VALUES 
	('Nguyễn Ngọc Anh', 10000000),
	('Hoàng Văn Phong', 11000000),
	('Phạm Hồng Phúc', 	12000000);
    
DROP TABLE IF EXISTS SinhVien;
CREATE TABLE SinhVien(
	masv 		INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    hoten 		VARCHAR(50) CHAR SET utf8mb4 NOT NULL,
    namsinh 	SMALLINT NOT NULL,
    quequan		VARCHAR(50) CHAR SET utf8mb4 
);
INSERT INTO SinhVien(hoten, namsinh, quequan) 
VALUES 
	('Nguyễn Thị Hoa', 		1996, 'Hà Nội'),
	('Nguyễn Văn An', 		1995, 'Thái Bình'),
	('Nguyễn Yến Trang', 	1996, 'Nghệ An'),
	('Trần Văn Phi', 		1996, 'Nghệ An');

DROP TABLE IF EXISTS DeTai;
CREATE TABLE DeTai(
	madt 			SMALLINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    tendt 			VARCHAR(100) CHAR SET utf8mb4 NOT NULL UNIQUE,
    kinhphi 		DOUBLE(12,2) NOT NULL,
    NoiThucTap		VARCHAR(100) CHAR SET utf8mb4 
);
INSERT INTO DeTai(tendt, kinhphi, NoiThucTap) 
VALUES 
	('CONG NGHE SINH HOC', 	8000000, 'Hà Nội'),
	('AN TOAN GIAO THONG', 	9000000, 'Hà Giang'),
	('CONG NGHE HOA HOC', 	7000000, 'Bắc Giang');
    
DROP TABLE IF EXISTS HuongDan;
CREATE TABLE HuongDan(
	id 			INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    masv 		INT,
    madt 		SMALLINT,
    magv		SMALLINT,
    ketqua		VARCHAR(100) CHAR SET utf8mb4,
    FOREIGN KEY (masv) REFERENCES SinhVien(masv) ON UPDATE SET NULL ON DELETE SET NULL,
    FOREIGN KEY (madt) REFERENCES DeTai(madt) ON UPDATE SET NULL ON DELETE SET NULL,
    FOREIGN KEY (magv) REFERENCES GiangVien(magv) ON UPDATE SET NULL ON DELETE SET NULL
);
INSERT INTO HuongDan(masv, madt, magv, ketqua) 
VALUES 
	(1, 1, 1, 'kết quả 1'),
	(2, 2, 3, 'kết quả 2'),
	(4, 1, 2, 'kết quả 3');

-- 2. Viết lệnh để
-- a) Lấy tất cả các sinh viên chưa có đề tài hướng dẫn
SELECT sv.hoten
FROM SinhVien sv
LEFT JOIN HuongDan hd ON sv.masv = hd.masv
WHERE hd.id IS NULL;

-- b) Lấy ra số sinh viên làm đề tài ‘CONG NGHE SINH HOC’
SELECT COUNT(sv.masv) 'số sinh viên làm đề tài CONG NGHE SINH HOC'
FROM SinhVien sv
INNER JOIN HuongDan hd ON sv.masv = hd.masv
INNER JOIN DeTai dt ON hd.madt = dt.madt
WHERE dt.tendt = 'CONG NGHE SINH HOC';

-- 3. Tạo view có tên là "SinhVienInfo" lấy các thông tin về học sinh bao gồm: 
-- mã số, họ tên và tên đề tài
-- (Nếu sinh viên chưa có đề tài thì column tên đề tài sẽ in ra "Chưa có")
DROP VIEW IF EXISTS SinhVienInfo;
CREATE VIEW SinhVienInfo AS
	SELECT sv.masv 'mã số'
		, sv.hoten 'họ tên'
		, CASE WHEN dt.tendt IS NULL THEN 'Chưa có'
			ELSE dt.tendt 
		END 'tên đề tài'
	FROM SinhVien sv
	LEFT JOIN HuongDan hd ON sv.masv = hd.masv
	LEFT JOIN DeTai dt ON hd.madt = dt.madt;
-- xem lại view vừa tạo
SELECT * FROM SinhVienInfo;

-- 4. Tạo trigger cho table SinhVien khi insert sinh viên có năm sinh <= 1900 
-- thì hiện ra thông báo "năm sinh phải > 1900"
DROP TRIGGER IF EXISTS trg_check_nam_sinh;
DELIMITER $$
CREATE TRIGGER trg_check_nam_sinh
	BEFORE INSERT ON SinhVien
    FOR EACH ROW
    BEGIN
		IF NEW.namsinh <= 1900 then
			SIGNAL SQLSTATE '12345'
            SET MESSAGE_TEXT = 'năm sinh phải > 1900';
		END IF;
    END $$
DELIMITER ;

INSERT INTO SinhVien(hoten, namsinh, quequan) 
VALUES 
	('Nguyễn Hồng Trang', 1900, 'Hà Nội');

-- 5. Hãy cấu hình table sao cho khi xóa 1 sinh viên nào đó thì sẽ tất cả thông 
-- tin trong table HuongDan liên quan tới sinh viên đó sẽ bị xóa đi
-- trả lời: 
-- 1. trong bảng hướng dẫn, set khóa ngoại với ON DELETE CASCADE
-- thì khi xóa ở bảng sinh viên sẽ tự động xóa tất cả thông tin ở bảng HuongDan liên quan tới sinh viên đó
-- 2. sử dụng trigger
DROP TRIGGER IF EXISTS trg_xoa_sinh_vien;
DELIMITER $$
CREATE TRIGGER trg_xoa_sinh_vien
	BEFORE DELETE ON SinhVien
    FOR EACH ROW
    BEGIN
		DELETE FROM HuongDan WHERE masv = OLD.masv;
    END $$
DELIMITER ;
DELETE FROM SinhVien WHERE masv = 2;














