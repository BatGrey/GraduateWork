package util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class GetImageInfo {
	public static BufferedImage getImageInfo(File f) throws IOException {
		return  ImageIO.read(f);
		
	}
}
