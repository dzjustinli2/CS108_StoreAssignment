package store;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/cart")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		initializeCart(session);
		RequestDispatcher dispatch = request.getRequestDispatcher("cartJSP.jsp");
		dispatch.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		initializeCart(session);
		Cart cart = (Cart)session.getAttribute("cart");
		for (Enumeration<String> e = request.getParameterNames(); e.hasMoreElements();){
			String id = e.nextElement();
			String value = (String)request.getParameter(id);
			int quant = 0;
			try{
				quant = Integer.parseInt(value);
			}catch(Exception ex){}
			if(quant < 0) quant = 0;
			cart.setValue(id,quant);
		}
		RequestDispatcher dispatch = request.getRequestDispatcher("cartJSP.jsp");
		dispatch.forward(request, response);
	}
	
	private void initializeCart(HttpSession session){
		if(session.getAttribute("cart") == null){
			session.setAttribute("cart",new Cart());
		}
	}

}
