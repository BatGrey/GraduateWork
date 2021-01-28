package renameFile;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

import util.GainFileString;
import util.GetAllFile;

public class RenameMain {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File targetFile = new File(StaticResource.TARGET_ROUTE);
			List<String> AllFile = GetAllFile.getFileName(targetFile);
			ASCcomparator asCcomparator = new ASCcomparator(true);   //true是正序，false是倒序
			Collections.sort(AllFile, asCcomparator);
			RenameProcess.deal(AllFile);
			System.out.println("操作完成");
		

	}

}
