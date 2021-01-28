package util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class GetAllFile {
 
	public static List<String> getFileName(File f){

		if(!f.isDirectory()) return null;
		List list = new ArrayList<String>();
		for(File t:f.listFiles())
			list.add(t.getName());
		return list;
	}
}
