package com.servlet;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

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
 * Servlet implementation class SigninServlet
 */
@WebServlet("/SigninServlet")
public class SigninServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SigninServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Customer customer = new Customer();
		Address address = new Address();
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String FILENAME;

		FILENAME = "C:\\Users\\Nate\\Documents\\Accounts\\" + userName + "_reg.txt";
		File userFile = new File(FILENAME);
		if(!userFile.exists()){
			System.out.println(FILENAME+" is not a current user");
			//todo: loop back to index.jsp
		}else{			
			try (Scanner scanner = new Scanner(userFile)) {
				String line = scanner.nextLine();
				//parse line
				String user[] = line.split(",");
				if(!user[3].equals(password)){
					System.out.println("Wrong Password");
					//go back to index
				}else{
					customer.setFirstName(user[0]);
					customer.setLastName(user[1]);
					customer.setEmail(user[2]);
					customer.setPassword(user[3]);
					
					line = scanner.nextLine();
					//parse line
					String addr[] = line.split(",");
					address.setStreet(addr[0]);
					address.setCity(addr[1]);
					address.setState(addr[2]);
					address.setZipCode(addr[3]);
				}
			} catch (IOException e){
				e.printStackTrace();
			}
			
		}
		
		HttpSession session = request.getSession(true);
		session.setAttribute("customer",customer);
		
		RequestDispatcher rs = request.getRequestDispatcher("account.jsp");
		rs.forward(request,response);	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
