package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.ImageService;

/**
 * Servlet acting as the controller
 */
/**
 * Servlet implementation class ImageProcessorServlet
 */
@WebServlet(name = "ImageProcessorServlet", urlPatterns = "/getNewImage")
public class ImageProcessorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public ImageProcessorServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Hello form doPost of ImageProcessorServlet");
		System.out.println("Session id:" + request.getSession().getId());
		int fileCounter;
		if (null != request.getSession().getAttribute("SESSION_ATTRIBUTE_FILE_COUNTER")) {
			fileCounter = (int) request.getSession().getAttribute("SESSION_ATTRIBUTE_FILE_COUNTER");
			fileCounter++;
		} else {
			fileCounter = 1;
		}
		// setting the counter in the session
		request.getSession().setAttribute("SESSION_ATTRIBUTE_FILE_COUNTER", fileCounter);

		String fileName = "D:/image-processor/images/myimage_" + fileCounter + ".jpg";
		
		//creating the object of the image service class and calling the method to generate the image
		ImageService imageService = new ImageService();
		imageService.produceImage(fileName);

		// setting the URL of the image in the request to be used in JSP
		request.getSession().setAttribute("SESSION_ATTRIBUTE_IMAGE_URI", fileName);

		response.sendRedirect("imageProcessor.jsp");
	}

}
