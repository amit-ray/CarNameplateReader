package com.amit.javaanpr.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import com.amit.javaanpr.model.Car;

public class PersistenceImpl implements Persistence {
	
	
	Connection conn = null;
	
	private String dbName = "caranpr";
	private String dbUser = "root";
	private String dbPassword = ""
;
	public Connection getConnection() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+dbName, dbUser, dbPassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}

	public void closeConnection() {
		// TODO Auto-generated method stub
		
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	
	public void insertCarList(List<Car> cars) {
		
		Connection connection = getConnection();
		Iterator<Car> it = cars.iterator();
		
		while(it.hasNext()){			
			Car car = it.next();			
			insertCar(car,connection);
		}	
		
		closeConnection(connection);
		
		

	}

	public void updateCar() {
		// TODO Auto-generated method stub

	}

	public void insertCar(Car car) {
		// TODO Auto-generated method stub
		
	}

	public void insertCar(Car car, Connection con) {
		
		String sql="insert into car(image_path,image_name,car_plate_no) values(?,?,?)";
		PreparedStatement pstmt ;
		
		try{
		
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, car.getImagePath());
			pstmt.setString(2, car.getImageName());
			pstmt.setString(3, car.getCarPlateNo());
			
			int executeUpdate = pstmt.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void closeConnection(Connection con) {		
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
