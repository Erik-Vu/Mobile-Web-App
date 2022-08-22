package controler;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DAO;
import entity.Cart;
import entity.Product;

/**
 * Servlet implementation class CartControl
 */
@WebServlet("/cart")
public class CartControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        try {
	        String id = request.getParameter("id");
	        String action = request.getParameter("action");
	        DAO dao = new DAO();
	        Product p = dao.getProduct(id);
	        HttpSession session = request.getSession(true);
	        if (action.equalsIgnoreCase("add")) {
		        if (session.getAttribute("cart") == null) {
		        	session.setAttribute("cart", new Cart());
		        }
		    	Cart c = (Cart) session.getAttribute("cart");
		    	c.add(p);
		    	session.setAttribute("listC", c.getItems());
		    	session.setAttribute("amount", c.getAmount());
		    	response.getWriter().print("Add to cart is Successful");
	        } else {
	        	int idd = Integer.parseInt(id);
	        	Cart c = (Cart) session.getAttribute("cart");
	        	c.remove(idd);
	        	session.setAttribute("listC", c.getItems());
	        	session.setAttribute("amount", c.getAmount());
	        	response.getWriter().print("1");
	        }
	        
        } catch (Exception ex) {
        	response.getWriter().print(ex);
        }
    }
    
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("cart.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request,response);
	}

}
