package pl.jwojciechowski.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.jwojciechowski.dao.ProductDAO;
import pl.jwojciechowski.model.Product;

@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductDAO dao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductServlet() {
		super();
		dao = new ProductDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher view;
		String action = (String) request.getParameter("action");
		switch (action) {
		case "selectProducts": {
			view = request.getRequestDispatcher("products.jsp");
			request.setAttribute("products", dao.getAllProducts());
			view.forward(request, response);
			break;
		}
		case "edit": {
			view = request.getRequestDispatcher("form.jsp");
			long id = Long.parseLong(request.getParameter("productId"));
			Product p = dao.selectProduct(id);
			request.setAttribute("product", p);
			view.forward(request, response);
			break;
		}
		case "insert": {
			view = request.getRequestDispatcher("form.jsp");
			view.forward(request, response);
			break;
		}
		case "delete": {
			dao.deleteProduct(Long.parseLong(request.getParameter("productId")));
			view = request.getRequestDispatcher("products.jsp");
			request.setAttribute("products", dao.getAllProducts());
			view.forward(request, response);
			break;
		}
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Product p = new Product();
		String id = request.getParameter("product_id");
		if (id != "")
			p.setProduct_id(Long.parseLong(id));
		p.setProduct_name(request.getParameter("product_name"));
		p.setProduct_price(Double.parseDouble(request.getParameter("product_price")));
		p.setCategory(request.getParameter("category"));
		p.setDescription(request.getParameter("description"));
		try {
			Date exp_date = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("expiration_date"));
			p.setExpiration_date(exp_date);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		if (request.getParameter("product_id") != "") {
			dao.updateProduct(p);
			response.sendRedirect("index.jsp");
		} else {
			dao.insertProduct(p);
			response.sendRedirect("index.jsp");
		}
	}
}
