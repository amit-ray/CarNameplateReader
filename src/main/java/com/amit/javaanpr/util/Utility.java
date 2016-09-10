package com.amit.javaanpr.util;

import java.io.File;

import net.sf.javaanpr.imageanalysis.CarSnapshot;
import net.sf.javaanpr.intelligence.Intelligence;
import net.sf.javaanpr.jar.Main;

public class Utility {

	public static File[] getFiles(String folderPath) {

		File folder = new File(folderPath);
		File[] listOfFiles = folder.listFiles();
		return listOfFiles;

	}

	public static String getGeneratedCarPlateNo(File imageFile) {
		String recognizedNo = "";
		try {
			CarSnapshot c = new CarSnapshot(imageFile.getAbsolutePath());
			Main.systemLogic = new Intelligence();
			recognizedNo = Main.systemLogic.recognize(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return recognizedNo;

	}

}
