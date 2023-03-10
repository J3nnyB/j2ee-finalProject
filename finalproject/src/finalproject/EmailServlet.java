/*
	Name: Jennifer Byrne
	Date: March 29, 2020
	Notes: ENTD481 Final Project - Email servlet that gets parameters from email.html and 
		   calls GmailUtil to send it. Then relays a message to message.jsp.
 */
// Package statement
package finalproject;

//Imports the following Java libraries
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

//Class declaration
public class EmailServlet extends HttpServlet {
	// Default serialVersionUID
	private static final long serialVersionUID = 1L;
	// doPost method
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String to = request.getParameter("to");				// Sets value of "to"
		String from = request.getParameter("from");			// Sets value of "from"
		String subject = request.getParameter("subject");	// Sets value of "subject"
		String body = request.getParameter("body");			// Sets value of "body"
		String sendMessage = "";							// Sets initial value of sendMessage
		
		// Try statement
		try {
			// Calls sendMail method from class GmailUtil
			GmailUtil.sendMail(to, from, subject, body);
			// Sets new value of sendMessage if it works
			sendMessage = "Email was sent successfully.";
		}
		// Catch block
		catch (Exception e) {
			e.printStackTrace();
			// Sets new value of sendMessage if exception occurs
			sendMessage = "Something went wrong. Email was not sent.";
		}
		finally {
			// System redirects to message.jsp and prints statement based on if the email was sent or not
			request.setAttribute("Message", sendMessage);
			getServletContext().getRequestDispatcher("/message.jsp").forward(request, response);
		}	
		
	}
	
}