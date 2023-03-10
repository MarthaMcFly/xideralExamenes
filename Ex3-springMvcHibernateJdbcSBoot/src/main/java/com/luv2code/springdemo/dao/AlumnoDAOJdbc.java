package com.luv2code.springdemo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.Alumno;

@Repository
public class AlumnoDAOJdbc implements AlumnoDAO {

	@Autowired
	DataSource dataSource;

	@Override
	public List<Alumno> getAlumnos() {

		System.out.println("PASO POR AlumnoDAOJdbc");
		List<Alumno> alumnos = new ArrayList<>();

		// create sql statement
		String sql = "select * from alumno order by apellido";

		try (Connection myConn = dataSource.getConnection();
				Statement myStmt = myConn.createStatement();
				ResultSet myRs = myStmt.executeQuery(sql)) {

			// process result set
			while (myRs.next()) {

				// retrieve data from result set row
				int id = myRs.getInt("id");
				String nombre = myRs.getString("nombre");
				String apellido = myRs.getString("apellido");
				String grupo = myRs.getString("grupo");
				float calificacion = myRs.getFloat("calificacion");

				// create new student object
				Alumno tempAlumno = new Alumno(id, nombre, apellido, grupo, calificacion);

				// add it to the list of students
				alumnos.add(tempAlumno);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return alumnos;

	}

	@Override
	public void saveAlumno(Alumno _alumno) {
		
		String sql = null;
		if(_alumno.getId() == 0)
			sql = "insert into alumno " + "(nombre, apellido, grupo, calificacion) " + "values (?, ?, ?, ?)";
		else
			sql = "update alumno " + "set nombre=?, apellido=?, grupo=?, calificacion=? " + "where id=?";

		try (Connection myConn = dataSource.getConnection(); 
			PreparedStatement ps = myConn.prepareStatement(sql)) {

			ps.setString(1, _alumno.getNombre());
			ps.setString(2, _alumno.getApellido());
			ps.setString(3, _alumno.getGrupo());
			ps.setFloat(4, _alumno.getCalificacion());
			
			//id para where del update
			if(_alumno.getId() != 0)
				ps.setInt(4, _alumno.getId());

			ps.execute();
			
		}catch (SQLException e){
			e.printStackTrace();
		}

	}

	@Override
	public Alumno getAlumno(int theId) {
		Alumno _alumno = null;

		try (Connection myConn = dataSource.getConnection();
				PreparedStatement myStmt = crearStatementGetCustomer(myConn, theId);
				ResultSet myRs = myStmt.executeQuery()) {

			// retrieve data from result set row
			if (myRs.next()) {
				String nombre = myRs.getString("nombre");
				String apellido = myRs.getString("apellido");
				String grupo = myRs.getString("grupo");
				Float calificacion = myRs.getFloat("calificacion");

				// use the studentId during construction
				_alumno = new Alumno(theId, nombre, apellido, grupo, calificacion);
			} else {
				System.out.println("Could not find alumno id: " + theId);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return _alumno;
	}

	private PreparedStatement crearStatementGetCustomer(Connection myConn, int alumnoId) throws SQLException {
		String sql = "select * from alumno where id=?";
		PreparedStatement ps = myConn.prepareStatement(sql);
		ps.setInt(1, alumnoId);
		return ps;
	}

	@Override
	public void deleteAlumno(int theId) {

		// create sql to delete alumno
		String sql = "delete from alumno where id=?";

		try (Connection myConn = dataSource.getConnection(); 
				PreparedStatement myStmt = myConn.prepareStatement(sql);) {

			// set params
			myStmt.setInt(1, theId);

			// execute sql statement
			myStmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
