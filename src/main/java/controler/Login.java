package controler;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import entity.Account;

import java.io.IOException;

import dao.DAO;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		try {
			request.getSession(true).invalidate();
			//make sure that email is valid
			String regexMail = "^[A-Z0-9_a-z]+@[A-Z0-9\\.a-z]+\\.[A-Za-z]{2,6}$";
			String regex = "[a-zA-Z0-9_!@#$%^&*]+";
			//collect data from a login form
			String user = request.getParameter("user");
			String pass = request.getParameter("pass");
			DAO dao = new DAO();
			Account acc = dao.login(user, pass);
			HttpSession session = request.getSession(true);
			if (!pass.matches(regex) || !user.matches(regexMail)) {
				response.getWriter().print("1");
			}
			//check account - use validate code in assignment 1 to valid user
			if(acc != null) {
				if (acc.getRole() == 1) 
				response.getWriter().print("2");
				else response.getWriter().print("Welcome " + acc.getUsr());
				//set session
				session.setAttribute("name", acc.getName());
				//set cookie
				Cookie username = new Cookie("user",user);
				Cookie password = new Cookie("pass",pass);
				username.setMaxAge(60*60*24);
				password.setMaxAge(60*60*24);
				response.addCookie(username);
				response.addCookie(password);
			}
			else response.getWriter().print("3");
		} catch (Exception ex) {
			response.getWriter().println(ex);
		}
	}

}
