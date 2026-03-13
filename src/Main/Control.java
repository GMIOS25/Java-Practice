package Main;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.Locale;

public class Control {
	ArrayList<Student> listStudent = new ArrayList<Student>();
	
	Scanner sc = new Scanner(System.in);
	
	public void input() {
		System.out.println("Nhap so luong sinh vien: ");
		int n = readIntMin(1);

		for (int i = 0; i < n; i++) {
			System.out.println("Nhap thong tin sinh vien thu " + (i + 1) + ": ");

			String nganhHoc = readMajor();
			String maSinhVien = readStudentId(nganhHoc);
			String tenSinhVien = readNormalizedName();
			Date ngaySinh = readBirthDate();
			Float diemTrungBinh = readFloatInRange(0.0f, 10.0f);
			System.out.print("Lop hoc: ");
			String lopHoc = readNonEmptyLine();

			Student student = new Student(maSinhVien, tenSinhVien, ngaySinh, nganhHoc, diemTrungBinh, lopHoc);
			addStudent(student);
		}
	}
	
	public Student inputOneStudent() {
		String nganhHoc = readMajor();
		String maSinhVien = readStudentId(nganhHoc);
		String tenSinhVien = readNormalizedName();
		Date ngaySinh = readBirthDate();
		Float diemTrungBinh = readFloatInRange(0.0f, 10.0f);
		String lopHoc = readNonEmptyLine();
		return new Student(maSinhVien, tenSinhVien, ngaySinh, nganhHoc, diemTrungBinh, lopHoc);
	}
	
	public void display() {
		System.out.println("Danh sach sinh vien:");
		for (Student student : listStudent) {
			System.out.println("Ma SV: " + student.getMaSinhVien());
			System.out.println("Ten SV: " + student.getTenSinhVien());
			System.out.println("Ngay sinh: " + student.getNgaySinh());
			System.out.println("Nganh hoc: " + student.getNganhHoc());
			System.out.println("Diem TB: " + student.getDiemTrungBinh());
			System.out.println("Lop hoc: " + student.getLopHoc());
			System.out.println("-------------------------");
		}
	}
	
	public void addStudent(Student student) {
		listStudent.add(student);
	}
	
	private int readIntMin(int minValue) {
		while (true) {
			String raw = sc.nextLine().trim();
			try {
				int value = Integer.parseInt(raw);
				if (value >= minValue) {
					return value;
				}
			} catch (NumberFormatException ex) {
				// ignore and re-prompt
			}
			System.out.print("Gia tri khong hop le, vui long nhap lai: ");
		}
	}

	private String readNonEmptyLine() {
		while (true) {
			String line = sc.nextLine().trim();
			if (!line.isEmpty()) {
				return line;
			}
			System.out.print("Khong duoc de trong, vui long nhap lai: ");
		}
	}

	private String readMajor() {
		while (true) {
			System.out.print("Nganh hoc (CNTT/KTPM): ");
			String value = sc.nextLine().trim().toUpperCase(Locale.ROOT);
			if (value.equals("CNTT") || value.equals("KTPM")) {
				return value;
			}
			System.out.println("Nganh hoc chi co the la CNTT hoac KTPM.");
		}
	}

	private String readStudentId(String major) {
		String prefix = major.equals("CNTT") ? "465105" : "465109";
		while (true) {
			System.out.print("Ma sinh vien (" + prefix + "xxxx): ");
			String value = sc.nextLine().trim();
			if (value.length() == 10 && value.startsWith(prefix) && value.chars().allMatch(Character::isDigit)) {
				return value;
			}
			System.out.println("Ma sinh vien phai co 10 chu so va bat dau bang " + prefix + ".");
		}
	}

	private String readNormalizedName() {
		System.out.print("Ten sinh vien: ");
		String raw = readNonEmptyLine();
		String[] parts = raw.trim().toLowerCase(Locale.forLanguageTag("vi-VN")).split("\\s+");
		StringBuilder builder = new StringBuilder();
		for (String part : parts) {
			if (part.isEmpty()) {
				continue;
			}
			builder.append(Character.toUpperCase(part.charAt(0)))
					.append(part.substring(1))
					.append(' ');
		}
		return builder.toString().trim();
	}

	private Date readBirthDate() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/uuuu")
				.withResolverStyle(ResolverStyle.STRICT);
		while (true) {
			System.out.print("Ngay sinh (dd/MM/yyyy): ");
			String input = sc.nextLine().trim();
			try {
				LocalDate birthDate = LocalDate.parse(input, formatter);
				int age = Period.between(birthDate, LocalDate.now()).getYears();
				if (age >= 15 && age <= 110) {
					return Date.from(birthDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
				}
				System.out.println("Tuoi phai trong khoang 15 - 110.");
			} catch (DateTimeParseException ex) {
				System.out.println("Ngay sinh khong hop le.");
			}
		}
	}

	private Float readFloatInRange(float minValue, float maxValue) {
		while (true) {
			System.out.print("Diem trung binh (0.0 - 10.0): ");
			String raw = sc.nextLine().trim();
			try {
				float value = Float.parseFloat(raw);
				if (value >= minValue && value <= maxValue) {
					return value;
				}
			} catch (NumberFormatException ex) {
			}
			System.out.println("Diem trung binh phai trong khoang 0.0 - 10.0.");
		}
	}

}