package com.amit.javaanpr;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.UIManager;

import com.mysql.jdbc.Util;

import net.sf.javaanpr.gui.windows.FrameComponentInit;
import net.sf.javaanpr.gui.windows.FrameMain;
import net.sf.javaanpr.imageanalysis.CarSnapshot;
import net.sf.javaanpr.intelligence.Intelligence;
import net.sf.javaanpr.jar.Main;

import com.amit.javaanpr.db.*;
import com.amit.javaanpr.model.Car;
import com.amit.javaanpr.util.*;


public class App {
	public static void main(String[] args) throws Exception {
		run();
		
	}

	public static void run() {

		File[] files = Utility.getFiles("C:\\source_image");
		List<Car> cars = new ArrayList<Car>();

		for (File f : files) {
			
			String generatedCarPlateNo = Utility.getGeneratedCarPlateNo(f);
			
			Car car = new Car();
			car.setImageName(f.getName());
			car.setImagePath(f.getAbsolutePath());
			car.setCarPlateNo(generatedCarPlateNo);			
			cars.add(car);

		}

		Persistence persistence = new PersistenceImpl();
		persistence.insertCarList(cars);

	}
}
