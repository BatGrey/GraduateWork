package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class GainFileString {
	public static String gainFileString(File f) throws IOException {
		FileInputStream fileInputStream = new FileInputStream(f);
		//FileOutputStream fileOutputStream = new FileOutputStream(template_xml);
		byte [] template_byte = new byte [80000];
		fileInputStream.read(template_byte);
		String template_string = new String(template_byte);
		
		fileInputStream.close();
		return template_string.trim();
	}

}
