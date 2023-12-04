package com.example.demo.util;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import org.apache.commons.lang3.RandomStringUtils;
import org.eclipse.tags.shaded.org.apache.bcel.generic.NEW;

public class Converter {
	public static File DataURLImagetoFile(String dataURL) throws IOException {
		System.out.print(dataURL);
		File file = File.createTempFile(generateUniqueFileName(), "png");
		byte[] data = java.util.Base64.getDecoder().decode(dataURL.substring(dataURL.indexOf(",") + 1));
		BufferedImage bufferedImage = ImageIO.read(new ByteArrayInputStream(data));
		ImageIO.write(bufferedImage, "png", file);
		return file;
	}
	
	public static String  generateUniqueFileName() {
	    String filename = "";
	    long millis = System.currentTimeMillis();
	    SimpleDateFormat df = new SimpleDateFormat("dd MMM yyyy HH:mm:ss");
	    String datetime = df.format(new Date()) + " GMT";
	    datetime = datetime.replace(" ", "");
	    datetime = datetime.replace(":", "");
	    String rndchars = RandomStringUtils.randomAlphanumeric(16);
	    filename = rndchars + "_" + datetime + "_" + millis;
	    return filename;
	}

}
