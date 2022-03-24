package controllers;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.User;
import repositories.Repository;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Repository collection;
	
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		collection = Repository.getInstance();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		
		String personalName = request.getParameter("personal-name");
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		String repeatPassword = request.getParameter("repeat-password");
		
		PrintWriter printWriter = response.getWriter();
		
		if(personalName == null || personalName.isEmpty() ||
			userName == null || userName.isEmpty() ||
			password == null || password.isEmpty() ||
			repeatPassword == null || repeatPassword.isEmpty() || !password.equals(repeatPassword)) {
			
			printWriter.print("<html><body><p> Не са попълнени всички полета или паролите не съвпадат. </p></body></html>");
			RequestDispatcher rd = request.getRequestDispatcher("/RegistrationPage.jsp");
			rd.include(request, response);
			
		}
		else {
			User user = new User(personalName, userName, password);
			if(collection.addUser(user)){
				printWriter.print("<html><body><p> Успешна регистрация. </p></body></html>");
				
				response.sendRedirect("login"); // препращане
				
				
			}
			else {
				printWriter.print("<html><body><p> Потребителското име е заето. </p></body></html>");
				RequestDispatcher rd = request.getRequestDispatcher("/RegistrationPage.jsp");
			}
		}
	}

}
