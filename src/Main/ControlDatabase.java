package Main;

import java.sql.Connection;

public class ControlDatabase {
	public void addStudentToDatabase(Student student) {
		Connection conn = Connector.getConnection();
		if (conn != null) {
			try {
				String sql = "INSERT INTO student (masv, hoten, ngaysinh, nganhhoc, diemtrungbinh, lop) VALUES (?, ?, ?, ?, ?, ?)";
				java.sql.PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, student.getMaSinhVien());
				pstmt.setString(2, student.getTenSinhVien());
				pstmt.setDate(3, new java.sql.Date(student.getNgaySinh().getTime()));
				pstmt.setString(4, student.getNganhHoc());
				pstmt.setFloat(5, student.getDiemTrungBinh());
				pstmt.setString(6, student.getLopHoc());
				pstmt.executeUpdate();
				System.out.println("Student added to database successfully.");
			} catch (Exception e) {
				System.out.println("Failed to add student to database.");
				e.printStackTrace();
			} finally {
				try {
					conn.close();
				} catch (Exception e) {
					System.out.println("Failed to close database connection.");
					e.printStackTrace();
				}
			}
		}
	}
	
	public void displayStudentsFromDatabase() {
		Connection conn = Connector.getConnection();
		if (conn != null) {
			try {
				String sql = "SELECT * FROM student";
				java.sql.Statement stmt = conn.createStatement();
				java.sql.ResultSet rs = stmt.executeQuery(sql);
				while (rs.next()) {
					System.out.println("Ma SV: " + rs.getString("masv"));
					System.out.println("Ten SV: " + rs.getString("hoten"));
					System.out.println("Ngay sinh: " + rs.getDate("ngaysinh"));
					System.out.println("Nganh hoc: " + rs.getString("nganhhoc"));
					System.out.println("Diem TB: " + rs.getFloat("diemtrungbinh"));
					System.out.println("Lop hoc: " + rs.getString("lop"));
					System.out.println("-------------------------");
				}
			} catch (Exception e) {
				System.out.println("Failed to retrieve students from database.");
				e.printStackTrace();
			} finally {
				try {
					conn.close();
				} catch (Exception e) {
					System.out.println("Failed to close database connection.");
					e.printStackTrace();
				}
			}
		}
	}
	
	public void updateStudentInDatabase(Student student) {
		Connection conn = Connector.getConnection();
		if (conn != null) {
			try {
				String sql = "UPDATE student SET hoten = ?, ngaysinh = ?, nganhhoc = ?, diemtrungbinh = ?, lop = ? WHERE masv = ?";
				java.sql.PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, student.getTenSinhVien());
				pstmt.setDate(2, new java.sql.Date(student.getNgaySinh().getTime()));
				pstmt.setString(3, student.getNganhHoc());
				pstmt.setFloat(4, student.getDiemTrungBinh());
				pstmt.setString(5, student.getLopHoc());
				pstmt.setString(6, student.getMaSinhVien());
				pstmt.executeUpdate();
				System.out.println("Student updated in database successfully.");
			} catch (Exception e) {
				System.out.println("Failed to update student in database.");
				e.printStackTrace();
			} finally {
				try {
					conn.close();
				} catch (Exception e) {
					System.out.println("Failed to close database connection.");
					e.printStackTrace();
				}
			}
		}
	}
	
	public void deleteStudentFromDatabase(String maSinhVien) {
		Connection conn = Connector.getConnection();
		if (conn != null) {
			try {
				String sql = "DELETE FROM student WHERE masv = ?";
				java.sql.PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, maSinhVien);
				pstmt.executeUpdate();
				System.out.println("Student deleted from database successfully.");
			} catch (Exception e) {
				System.out.println("Failed to delete student from database.");
				e.printStackTrace();
			} finally {
				try {
					conn.close();
				} catch (Exception e) {
					System.out.println("Failed to close database connection.");
					e.printStackTrace();
				}
			}
		}
	}
	
	public void displaySortedStudentsByDiemTrungBinh() {
		Connection conn = Connector.getConnection();
		if (conn != null) {
			try {
				String sql = "SELECT * FROM student ORDER BY diemtrungbinh DESC";
				java.sql.Statement stmt = conn.createStatement();
				java.sql.ResultSet rs = stmt.executeQuery(sql);
				while (rs.next()) {
					System.out.println("Ma SV: " + rs.getString("masv"));
					System.out.println("Ten SV: " + rs.getString("hoten"));
					System.out.println("Ngay sinh: " + rs.getDate("ngaysinh"));
					System.out.println("Nganh hoc: " + rs.getString("nganhhoc"));
					System.out.println("Diem TB: " + rs.getFloat("diemtrungbinh"));
					System.out.println("Lop hoc: " + rs.getString("lop"));
					System.out.println("-------------------------");
				}
			} catch (Exception e) {
				System.out.println("Failed to retrieve sorted students from database.");
				e.printStackTrace();
			} finally {
				try {
					conn.close();
				} catch (Exception e) {
					System.out.println("Failed to close database connection.");
					e.printStackTrace();
				}
			}
		}
	}
	
	public void displayStudentsByLop(String lopHoc) {
		Connection conn = Connector.getConnection();
		if (conn != null) {
			try {
				String sql = "SELECT * FROM student WHERE lop = ?";
				java.sql.PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, lopHoc);
				java.sql.ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {
					System.out.println("Ma SV: " + rs.getString("masv"));
					System.out.println("Ten SV: " + rs.getString("hoten"));
					System.out.println("Ngay sinh: " + rs.getDate("ngaysinh"));
					System.out.println("Nganh hoc: " + rs.getString("nganhhoc"));
					System.out.println("Diem TB: " + rs.getFloat("diemtrungbinh"));
					System.out.println("Lop hoc: " + rs.getString("lop"));
					System.out.println("-------------------------");
				}
			} catch (Exception e) {
				System.out.println("Failed to retrieve students by class from database.");
				e.printStackTrace();
			} finally {
				try {
					conn.close();
				} catch (Exception e) {
					System.out.println("Failed to close database connection.");
					e.printStackTrace();
				}
			}
		}
	}
	
	public void displayStudentsByNganhHoc(String nganhHoc) {
		Connection conn = Connector.getConnection();
		if (conn != null) {
			try {
				String sql = "SELECT * FROM student WHERE nganhhoc = ?";
				java.sql.PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, nganhHoc);
				java.sql.ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {
					System.out.println("Ma SV: " + rs.getString("masv"));
					System.out.println("Ten SV: " + rs.getString("hoten"));
					System.out.println("Ngay sinh: " + rs.getDate("ngaysinh"));
					System.out.println("Nganh hoc: " + rs.getString("nganhhoc"));
					System.out.println("Diem TB: " + rs.getFloat("diemtrungbinh"));
					System.out.println("Lop hoc: " + rs.getString("lop"));
					System.out.println("-------------------------");
				}
			} catch (Exception e) {
				System.out.println("Failed to retrieve students by major from database.");
				e.printStackTrace();
			} finally {
				try {
					conn.close();
				} catch (Exception e) {
					System.out.println("Failed to close database connection.");
					e.printStackTrace();
				}
			}
		}
	}
	
	public void displayStudentsByThangSinh(int thangSinh) {
		Connection conn = Connector.getConnection();
		if (conn != null) {
			try {
				String sql = "SELECT * FROM student WHERE MONTH(ngaysinh) = ?";
				java.sql.PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, thangSinh);
				java.sql.ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {
					System.out.println("Ma SV: " + rs.getString("masv"));
					System.out.println("Ten SV: " + rs.getString("hoten"));
					System.out.println("Ngay sinh: " + rs.getDate("ngaysinh"));
					System.out.println("Nganh hoc: " + rs.getString("nganhhoc"));
					System.out.println("Diem TB: " + rs.getFloat("diemtrungbinh"));
					System.out.println("Lop hoc: " + rs.getString("lop"));
					System.out.println("-------------------------");
				}
			} catch (Exception e) {
				System.out.println("Failed to retrieve students by birth month from database.");
				e.printStackTrace();
			} finally {
				try {
					conn.close();
				} catch (Exception e) {
					System.out.println("Failed to close database connection.");
					e.printStackTrace();
				}
			}
		}
	}
}
