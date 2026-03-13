package Main;

import java.util.Date;

public class Student {
	private String maSinhVien;
    private String tenSinhVien;
    private Date ngaySinh;
    private String nganhHoc;
    private Float diemTrungBinh;
    private String lopHoc;
    
	public Student(String maSinhVien, String tenSinhVien, Date ngaySinh, String nganhHoc, Float diemTrungBinh,
			String lopHoc) {
		super();
		this.maSinhVien = maSinhVien;
		this.tenSinhVien = tenSinhVien;
		this.ngaySinh = ngaySinh;
		this.nganhHoc = nganhHoc;
		this.diemTrungBinh = diemTrungBinh;
		this.lopHoc = lopHoc;
	}

	public String getMaSinhVien() {
		return maSinhVien;
	}

	public void setMaSinhVien(String maSinhVien) {
		this.maSinhVien = maSinhVien;
	}

	public String getTenSinhVien() {
		return tenSinhVien;
	}

	public void setTenSinhVien(String tenSinhVien) {
		this.tenSinhVien = tenSinhVien;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getNganhHoc() {
		return nganhHoc;
	}

	public void setNganhHoc(String nganhHoc) {
		this.nganhHoc = nganhHoc;
	}

	public Float getDiemTrungBinh() {
		return diemTrungBinh;
	}

	public void setDiemTrungBinh(Float diemTrungBinh) {
		this.diemTrungBinh = diemTrungBinh;
	}

	public String getLopHoc() {
		return lopHoc;
	}

	public void setLopHoc(String lopHoc) {
		this.lopHoc = lopHoc;
	}

	@Override
	public String toString() {
		return "Student [maSinhVien=" + maSinhVien + ", tenSinhVien=" + tenSinhVien + ", ngaySinh=" + ngaySinh
				+ ", nganhHoc=" + nganhHoc + ", diemTrungBinh=" + diemTrungBinh + ", lopHoc=" + lopHoc + "]";
	}
    
    
}
