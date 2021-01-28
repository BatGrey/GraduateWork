package renameFile;

import java.io.File;
import java.util.List;

public class RenameProcess {
	public static void deal(List<String> AllFile) {
		long num=0;
		String endName = StaticResource.END_NAME;
		if(!endName.startsWith("."))
			endName=new StringBuffer(endName).insert(0, ".").toString();
		for(String filename : AllFile){
			num++;
			if(filename.endsWith(StaticResource.END_NAME)) {
				File tempFile = new File(StaticResource.TARGET_ROUTE+File.separator+filename);
				File destFile = new File(StaticResource.TARGET_ROUTE+File.separator+StaticResource.PRE_NAME+num+endName);
				tempFile.renameTo(destFile);
			}
		}

		
	}
}
