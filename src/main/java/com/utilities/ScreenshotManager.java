package com.utilities;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class ScreenshotManager {
	private static final String SCREENSHOT_DIR = "Screenshots/";

	public static String takeScreenshot(String tesecaseName) {
		File tgt = null;
		try {
			Files.createDirectories(Paths.get(SCREENSHOT_DIR));

			String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
			String fileName = SCREENSHOT_DIR + tesecaseName + "_" + timeStamp + ".png";

			File src = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
			tgt = new File(fileName);
			Files.copy(src.toPath(), tgt.toPath());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return tgt.getAbsolutePath();
	}

	public static void cleanFolder() {
		DirectoryStream<Path> stream = null;
		try {
			DirectoryStream<Path> newDirectoryStream = Files.newDirectoryStream(Paths.get(SCREENSHOT_DIR));

			for (Path path : newDirectoryStream) {
				Files.delete(path);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (stream != null) {
				try {
					stream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}
}
