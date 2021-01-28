package dataset;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.imageio.ImageIO;

import util.GainFileString;
import util.GetAllFile;
import util.GetImageInfo;
import util.OutPutXml;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File baseFile = new File(RouteString.CLASSES_PARENT);
		/**
		 * 处理groundtruth
		 */

		List<String> allClasses = GetAllFile.getFileName(baseFile);   // 获取到所有类别列表
		List<String> otherClasses = new ArrayList<String>();
		for(int i=0;i<allClasses.size();i++) {
			String temp = allClasses.get(i);
			if(temp.startsWith("W"))
				otherClasses.add(temp);
		}

		for(int i=0;i<otherClasses.size();i++) {
			File NextClassFile = new File(RouteString.CLASSES_PARENT+File.separator+otherClasses.get(i)); //target路劲
			System.out.print("开始处理："+NextClassFile.getName());
			File TargetGround = new File(NextClassFile.getPath()+File.separator+"groundtruth_rect.txt"); //获取GroundFile
			String targetGroundString = GainFileString.gainFileString(TargetGround);// 读取Ground所有信息
			/**
			 * 处理对应的Image
			 */
			File baseImageFile = new File(NextClassFile.getPath()+File.separator+"img");
			List<String> TargetImageList = GetAllFile.getFileName(baseImageFile);
			for(int j=0;j<TargetImageList.size();j++) {
				File template_xml = new File(RouteString.TEMPLATTE_PARENT); // 获取模板FIle
				String template_string = GainFileString.gainFileString(template_xml); // 获取模板String
				File TargerImage = new File(baseImageFile.getPath()+File.separator+TargetImageList.get(j)); //获取图片文件
				BufferedImage template_img = GetImageInfo.getImageInfo(TargerImage); //获取图片文件信息类
				template_string = TemplateDeal.dealTemplate(template_string,targetGroundString, TargerImage, template_img,NextClassFile); // 处理模板文件
				OutPutXml.deal(NextClassFile,TargerImage.getName(), template_string);  ///输出
			}
			System.out.println("   已完成");
		}

		
	}

}
