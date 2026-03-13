package Main;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("1. Them thong tin sinh vien");
			System.out.println("2. Hien thi thong tin toan bo sinh vien");
			System.out.println("3. Sua thong tin sinh vien");
			System.out.println("4. Xoa thong tin sinh vien");
			System.out.println("5. Hien thi thong tin sinh vien theo diem trung binh");
			System.out.println("6. Hien thi thong tin sinh vien theo lop");
			System.out.println("7. Hien thi thong tin sinh vien theo nganh hoc");
			System.out.println("8. Hien thi thong tin sinh vien theo thang sinh");
			System.out.println("Nhap bat ki so gi de thoat chuong trinh.");
			System.out.print("Nhap lua chon: ");
			int choice = sc.nextInt();
		
			
			if (choice == 1) {
				Control control = new Control();
				control.input();
				ControlDatabase controlDatabase = new ControlDatabase();
				for (Student student : control.listStudent) {
					controlDatabase.addStudentToDatabase(student);
				}
			} else if (choice == 2) {
				ControlDatabase controlDatabase = new ControlDatabase();
				controlDatabase.displayStudentsFromDatabase();
			}else if (choice == 3) {
				Control control = new Control();
				Student student = control.inputOneStudent();
				ControlDatabase controlDatabase = new ControlDatabase();
				controlDatabase.updateStudentInDatabase(student);
			} else if (choice == 4) {
				Control control = new Control();
				System.out.print("Nhap ma sinh vien can xoa: ");
				String maSinhVien = sc.next();
				ControlDatabase controlDatabase = new ControlDatabase();
				controlDatabase.deleteStudentFromDatabase(maSinhVien);
			} else if (choice == 5) {
				ControlDatabase control = new ControlDatabase();
				control.displaySortedStudentsByDiemTrungBinh();
			} else if (choice == 6) {
				String lop = sc.next();
				ControlDatabase control = new ControlDatabase();
				control.displayStudentsByLop(lop);
			} else if (choice == 7) {
				String nganhHoc = sc.next();
				ControlDatabase control = new ControlDatabase();
				control.displayStudentsByNganhHoc(nganhHoc);
			} else if (choice == 8) {
				int thang = sc.nextInt();
				ControlDatabase control = new ControlDatabase();
				control.displayStudentsByThangSinh(thang);
			}
			else {
				System.out.println("Thoat chuong trinh.");
				break;
			}
			System.out.println();
		}
	}

}
