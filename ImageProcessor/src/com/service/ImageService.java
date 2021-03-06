package com.service;


import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Service class for generating the Images
 * @author Hussain
 *
 */
public class ImageService {

	/**
	 * This method generates the image on a given path
	 * @param fileName
	 * @throws IOException
	 */
	public void produceImage(String fileName) throws IOException {
		System.out.println("start of the produceImage");
		int width = 500;
	    int height = 500;

	    // Constructs a BufferedImage of one of the predefined image types.
	    BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

	    // Create a graphics which can be used to draw into the buffered image
	    Graphics2D g2d = bufferedImage.createGraphics();

	    // fill all the image with white
	    g2d.setColor(Color.white);
	    g2d.fillRect(0, 0, width, height);

	    // create a circle with black
	    g2d.setColor(Color.black);
	    g2d.fillOval(0, 0, width, height);

	    // create a string with yellow
	    g2d.setColor(Color.yellow);
	    g2d.drawString("My Image :"+fileName, 5, 250);

	    // Disposes of this graphics context and releases any system resources that it is using. 
	    g2d.dispose();

	    // Save as JPEG
	    //File file = new File("D:/image-processor/images/myimage.jpg");
	    File file = new File(fileName);
	    ImageIO.write(bufferedImage, "jpg", file);
	    System.out.println("End of the produceImage");

	}

}