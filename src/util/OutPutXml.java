package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class OutPutXml {
	public static void deal(File next,String name ,String template) throws IOException {
		File BornXmldir = new File(next.getPath()+File.separator+"borxml");
		BornXmldir.mkdir();
		name = name.replace(".jpg", "");
		FileOutputStream fileOutputStream = new FileOutputStream(new File(BornXmldir.getPath()+File.separator+name+".xml"));
		fileOutputStream.write(template.getBytes());
	}
}
