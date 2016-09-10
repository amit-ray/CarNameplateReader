package com.amit.javaanpr.db;

import java.sql.Connection;
import java.util.List;

import com.amit.javaanpr.model.Car;

public interface Persistence {
	
	public Connection getConnection();
	public void closeConnection();
	public void insertCarList(List<Car> cars);
	public void updateCar();
	public void insertCar(Car car,Connection con);
	public void closeConnection(Connection con);



}
