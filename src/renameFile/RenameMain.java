package renameFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

import util.GainFileString;
import util.GetAllFile;

public class RenameMain {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File targetFile = new File(StaticResource.TARGET_ROUTE);
			List<String> AllFile = GetAllFile.getFileName(targetFile);
			RenameProcess.deal(AllFile);
			System.out.println("²Ù×÷Íê³É");
	}

}
