package store;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/show-product")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext sc = getServletContext();
		DbConnection db = (DbConnection)sc.getAttribute("db");
		String productId = request.getParameter("id");
		Product pd = ProductCatalog.getOneProduct(db,productId);
		if(pd == null){
			//The id isn't actually an id
			response.sendRedirect("/StoreAssignment/products");
			return;
		}
		request.setAttribute("product",pd);
		RequestDispatcher dispatch = request.getRequestDispatcher("productJSP.jsp");
		dispatch.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		initializeCart(session);
		ServletContext sc = getServletContext();
		DbConnection db = (DbConnection)sc.getAttribute("db");
		String productId = request.getParameter("productID");
		Product pd = ProductCatalog.getOneProduct(db,productId);
		if(pd == null){
			//The id isn't actually an id
			response.sendRedirect("/StoreAssignment/products");
			return;
		}
		Cart cart = (Cart)session.getAttribute("cart");
		cart.addProduct(pd);
		RequestDispatcher dispatch = request.getRequestDispatcher("cartJSP.jsp");
		dispatch.forward(request, response);
	}

	private void initializeCart(HttpSession session){
		if(session.getAttribute("cart") == null){
			session.setAttribute("cart",new Cart());
		}
	}
}
