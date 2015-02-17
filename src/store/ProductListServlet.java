package store;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * Servlet implementation class ProductListServlet
 */
@WebServlet({"","/products"})
public class ProductListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductListServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext sc = getServletContext();
		DbConnection db = (DbConnection)sc.getAttribute("db");
		ArrayList<Product> pdAr = ProductCatalog.getProducts(db);
		request.setAttribute("products",pdAr);
		RequestDispatcher dispatch = request.getRequestDispatcher("productListJSP.jsp");
		dispatch.forward(request, response);
	}

}
