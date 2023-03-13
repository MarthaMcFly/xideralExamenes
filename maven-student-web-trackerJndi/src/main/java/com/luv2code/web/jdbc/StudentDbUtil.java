package com.luv2code.web.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class StudentDbUtil {

	private DataSource dataSource;

	public StudentDbUtil(DataSource theDataSource) {
		dataSource = theDataSource;
	}

	public List<Student> getStudents(){

		List<Student> students = new ArrayList<>();

		// create sql statement
		String sql = "select * from student order by last_name";

		try (Connection myConn = dataSource.getConnection();
				Statement myStmt = myConn.createStatement();
				ResultSet myRs = myStmt.executeQuery(sql)) {

			// process result set
			while (myRs.next()) {

				// retrieve data from result set row
				int id = myRs.getInt("id");
				String firstName = myRs.getString("first_name");
				String lastName = myRs.getString("last_name");
				String email = myRs.getString("email");

				// create new student object
				Student tempStudent = new Student(id, firstName, lastName, email);

				// add it to the list of students
				students.add(tempStudent);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return students;

	}

	public void addStudent(Student theStudent) throws Exception {

		String sql = "insert into student " + "(first_name, last_name, email) " + "values (?, ?, ?)";

		try (Connection myConn = dataSource.getConnection(); PreparedStatement ps = myConn.prepareStatement(sql);) {

			ps.setString(1, theStudent.getFirstName());
			ps.setString(2, theStudent.getLastName());
			ps.setString(3, theStudent.getEmail());

			ps.execute();
		}
	}

// NO ES NECESARIO PORQUE NO SE UTILIZA UN TERCER RECURSO COMO EN getStudent
//	public void addStudent(Student theStudent) throws Exception {
//
//		try (Connection myConn = dataSource.getConnection();
//			 PreparedStatement ps = crearStatementAddStudent(myConn, theStudent);) {
//			
//			ps.execute();
//		}
//	}

//	private PreparedStatement crearStatementAddStudent(Connection myConn, Student theStudent) throws SQLException {
//		String sql = "insert into student " + "(first_name, last_name, email) " + "values (?, ?, ?)";
//		PreparedStatement ps = myConn.prepareStatement(sql);
//		// set the param values for the student
//		ps.setString(1, theStudent.getFirstName());
//		ps.setString(2, theStudent.getLastName());
//		ps.setString(3, theStudent.getEmail());
//		return ps;
//	}

	public Student getStudent(String theStudentId) throws Exception {

		Student theStudent = null;
		int studentId = Integer.parseInt(theStudentId);

		try (Connection myConn = dataSource.getConnection();
				PreparedStatement myStmt = crearStatementGetStudent(myConn, studentId);
				ResultSet myRs = myStmt.executeQuery()) {

			// retrieve data from result set row
			if (myRs.next()) {
				String firstName = myRs.getString("first_name");
				String lastName = myRs.getString("last_name");
				String email = myRs.getString("email");

				// use the studentId during construction
				theStudent = new Student(studentId, firstName, lastName, email);
			} else {
				throw new Exception("Could not find student id: " + studentId);
			}

			return theStudent;
		}
	}

	private PreparedStatement crearStatementGetStudent(Connection myConn, int studentId) throws SQLException {
		String sql = "select * from student where id=?";
		PreparedStatement ps = myConn.prepareStatement(sql);
		ps.setInt(1, studentId);
		return ps;
	}

	public void updateStudent(Student theStudent) throws Exception {

		// create SQL update statement
		String sql = "update student " + "set first_name=?, last_name=?, email=? " + "where id=?";

		try (Connection myConn = dataSource.getConnection();
			 PreparedStatement myStmt = myConn.prepareStatement(sql);) { 
			
			// set params
			myStmt.setString(1, theStudent.getFirstName());
			myStmt.setString(2, theStudent.getLastName());
			myStmt.setString(3, theStudent.getEmail());
			myStmt.setInt(4, theStudent.getId());

			// execute SQL statement
			myStmt.execute();
		} 
	}

	public void deleteStudent(String theStudentId) throws Exception {

		// create sql to delete student
		String sql = "delete from student where id=?";

		try (Connection myConn = dataSource.getConnection();
			 PreparedStatement myStmt = myConn.prepareStatement(sql);) {
			
			// convert student id to int
			int studentId = Integer.parseInt(theStudentId);

			// set params
			myStmt.setInt(1, studentId);

			// execute sql statement
			myStmt.execute();
		} 
	}
}
