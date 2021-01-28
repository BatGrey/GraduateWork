package dataset;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Scanner;

public class TemplateDeal {
	public static String dealTemplate (String template,String TargetGround,File Targert,BufferedImage img,File next) {
		Scanner sc = new Scanner(TargetGround);
		String ImagePath = Targert.getPath().replaceAll("\\\\", "\\\\\\\\");
		String template_string = template.replaceFirst("img_filename", Targert.getName());
		template_string = template_string.replaceFirst("img_path", ImagePath);
		template_string = template_string.replaceFirst("img_width", img.getWidth()+"");
		template_string = template_string.replaceFirst("img_height", img.getHeight()+"");
		template_string = template_string.replaceFirst("img_name", next.getName());
		double a,b,c,d=0;
		a = Math.round(sc.nextDouble());
		b = Math.round(sc.nextDouble());
		c = Math.round(a + sc.nextDouble());
		d = Math.round(b + sc.nextDouble());
		template_string = template_string.replaceFirst("img_xmin", a+"");
		template_string = template_string.replaceFirst("img_ymin", b+"");
		template_string = template_string.replaceFirst("img_xmax", c+"");
		template_string = template_string.replaceFirst("img_ymax", d+"");
		return template_string;
	}
}
