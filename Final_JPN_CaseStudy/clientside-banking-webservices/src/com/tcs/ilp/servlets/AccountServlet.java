package com.tcs.ilp.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tcs.ilp.bean.UserDetails;
import com.tcs.ilp.bean.Users;
import com.tcs.ilp.services.Service;

/**
 * Servlet implementation class AccountServlet
 */
@WebServlet({"/AccountServlet","/account"})
public class AccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String actionn = (String) request.getAttribute("actionn");
		String action = (String) request.getParameter("action");
		System.out.println(action);
		Service s = new Service();
		if("getDetails".equals(actionn) || "getDetails".equals(action)){
			 HttpSession session=request.getSession();  
			UserDetails user = s.getDetails((String)session.getAttribute("sid"), (String)session.getAttribute("username"), (String)session.getAttribute("password"));
			System.out.println("user"+user);
			request.setAttribute("user", user);
			
			RequestDispatcher rd = request.getRequestDispatcher("details.jsp");
			rd.forward(request, response);
			return;
		}
		
		else if("logout".equals(action)){
			 HttpSession session=request.getSession();  
			 System.out.println("logged out");
				session.invalidate();
				response.sendRedirect("index.jsp");
				return;
		}else 
		response.sendRedirect("index.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("post");
		if(request.getParameter("action") == null){
			System.out.println("hello");
		}else if(request.getParameter("action").equals("login")){
			String username=request.getParameter("phone");
			System.out.println(username);
			String password=request.getParameter("password");
			Service s = new Service();
			String sid = s.login(username, password);
			if(!"0".equals(sid)){
				 HttpSession session=request.getSession();  
			        session.setAttribute("sid", sid);
			        session.setAttribute("username", username);
			        session.setAttribute("password", password);
			        System.out.println(sid);
			        request.setAttribute("actionn", "getDetails");
			       doGet(request, response);
			}else{
				request.setAttribute("error", "Invalid username or password.");
				request.getRequestDispatcher("login.jsp").forward(request, response);
				return;
			}
		}else if("update".equals(request.getParameter("action"))){
			boolean res=false;
			Service s= new Service();
			 HttpSession session=request.getSession(); 
			res = s.updateUser((String)session.getAttribute("username"), (String)session.getAttribute("password"), (String)session.getAttribute("sid"),request.getParameter("addr"));
			if(res){
				request.setAttribute("success", "Updation successful.");
				System.out.println("success");
			}else{
				request.setAttribute("error", "Couldn't update details.");
				System.out.println("error");
			}
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

}
