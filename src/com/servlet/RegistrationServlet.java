package com.servlet;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.user.Address;
import com.user.Customer;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public RegistrationServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Customer customer = new Customer();
		Address address = new Address();
		String FILENAME;

		customer.setFirstName(request.getParameter("firstName"));
		customer.setLastName(request.getParameter("lastName"));
		customer.setEmail(request.getParameter("email"));
		customer.setUserName(request.getParameter("userName"));
		customer.setPassword(request.getParameter("password"));
		customer.setBankName("Great Bank");
		
		address.setStreet(request.getParameter("street"));
		address.setCity(request.getParameter("city"));
		address.setState(request.getParameter("state"));
		address.setZipCode(request.getParameter("zipCode"));
		
		String userName = request.getParameter("userName");
		FILENAME = "C:\\Users\\Nate\\Documents\\Accounts\\" + userName + "_reg.txt";
		File userFile = new File(FILENAME);
		if(userFile.exists()){
			System.out.println(FILENAME+" already exists");
			//todo: loop back to index.jsp
		}else{
		    try
		    {
		       userFile.createNewFile();
		    }
		    catch(IOException ioe)
		    {
		       System.out.println("Error while creating a new empty file :" + ioe);
		    }
			try
			{
				BufferedWriter bw = new BufferedWriter(new FileWriter(FILENAME));
				//write user info
				bw.write(customer.getFirstName()+","+customer.getLastName()+","+customer.getEmail()+","+customer.getPassword()+"\n");
				bw.write(address.getStreet()+","+address.getCity()+","+address.getState()+","+address.getZipCode());
				bw.close();
			} 
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		FILENAME = "C:\\Users\\Nate\\Documents\\Accounts\\" + userName + "_acct.txt";
		File accountFile = new File(FILENAME);
		if(accountFile.exists()){
			System.out.println(FILENAME+" already exists");
			//todo: loop back to index.jsp
		
		}else{
		    try
		    {
			    accountFile.createNewFile();
			}
			catch(IOException ioe)
			{
			    System.out.println("Error while creating a new empty file :" + ioe);
			}
		}

		HttpSession session = request.getSession(true);
		session.setAttribute("customer",customer);
		
		RequestDispatcher rs = request.getRequestDispatcher("account.jsp");
		rs.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
