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
 * Servlet implementation class pageControl
 */
@WebServlet("/page")
public class PageControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PageControl() {
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
        	String page = request.getParameter("page");
        	int start = (Integer.parseInt(page) - 1) * 6 + 1;
        	DAO dao = new DAO();
        	List<Product> list = dao.getNextProduct(start);
        	PrintWriter out = response.getWriter();
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
        } catch(Exception ex) {
        	response.getWriter().print(ex);
        }
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

}
