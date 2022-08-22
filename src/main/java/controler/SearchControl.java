package controler;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.DAO;
import entity.Product;

/**
 * Servlet implementation class SearchControl
 */
@WebServlet("/search")
public class SearchControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchControl() {
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
		try { 
		response.setContentType("text/html;charset=UTF-8");
	     request.setCharacterEncoding("UTF-8");
	     String info = request.getParameter("search");
	     DAO dao = new DAO();
	     List<Product> list = dao.getSearchProduct(info);
	     PrintWriter out = response.getWriter();
	     if (!list.isEmpty()) {
		     for (Product o: list) {
		    	 out.println("<div class=\"product col-12 col-md-6 col-lg-4\">\n"
	                 +"        <div class=\"card\">\n"
	                 +"            <img class=\"card-img-top\" src=\""+o.getImg()+"\" alt=\"Card image cap\">\n"
	                 +"            <div class=\"card-body\">\n"
	                 +"                <h4 class=\"card-title show_txt\"><a href=\"detail?pid="+o.getId()+"\" title=\"View Product\">"+o.getName()+"</a></h4>\n"
	                 +"                <p class=\"card-text show_txt\">"+o.getType()+"</p>\n"
	                 +"                <div class=\"row\">\n"
	                 +"                     <div class=\"col\">\n"
	                 +"                        <p class=\"btn btn-danger btn-block\">"+o.getPrice()+"</p>\n"
	                 +"                    </div>\n"
	                 +"                    <div class=\"col\">\n"
	                 +"                        <button onclick=\"getMobile("+o.getId()+")\" class=\"btn btn-success btn-block btn-lg\">Add to cart</button>\n"
	                 +"                    </div>\n"
	                 +"                </div>\n"
	                 +"            </div>\n"
	                 +"        </div>\n"
	                 +"    </div>\n"
	                 );
		     }
			} else out.print("<h1>No Result<h1>");
			} catch (Exception ex){
				response.getWriter().print(ex);
			}
		}
}
