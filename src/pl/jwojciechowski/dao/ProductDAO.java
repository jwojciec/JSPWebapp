package pl.jwojciechowski.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pl.jwojciechowski.model.Product;
import pl.jwojciechowski.util.DBUtil;

public class ProductDAO {
	Connection dbConnection;

	public ProductDAO() {
		DBUtil.init();
		dbConnection = DBUtil.getConnection();
	}

	public Product selectProduct(long product_id) {
		Product prod = new Product();
		try {
			String myQuery = "SELECT * FROM t_products WHERE product_id = ?";
			PreparedStatement preparedStmt = dbConnection.prepareStatement(myQuery);
			preparedStmt.setLong(1, product_id);
			System.out.println(preparedStmt);
			ResultSet myRes = preparedStmt.executeQuery();

			if (myRes.next()) {
				prod.setProduct_id(myRes.getLong("product_id"));
				prod.setProduct_name(myRes.getString("product_name"));
				prod.setProduct_price(myRes.getDouble("product_price"));
				prod.setCategory(myRes.getString("category"));
				prod.setDescription(myRes.getString("description"));
				prod.setExpiration_date(myRes.getDate("expiration_date"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return prod;
	}

	public void insertProduct(Product p) {
		try {
			String myQuery = "INSERT INTO t_products(product_name, product_price, category, description, expiration_date) "
					+ "VALUES (?, ?, ?, ?, ?)";
			PreparedStatement preparedStmt = dbConnection.prepareStatement(myQuery);
			preparedStmt.setString(1, p.getProduct_name());
			preparedStmt.setDouble(2, p.getProduct_price());
			preparedStmt.setString(3, p.getCategory());
			preparedStmt.setString(4, p.getDescription());
			preparedStmt.setDate(5, new java.sql.Date(p.getExpiration_date().getTime()));
			System.out.println(preparedStmt);
			preparedStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateProduct(Product p) {
		try {
			String myQuery = "UPDATE t_products "
					+ "SET product_name=?, product_price=?, category=?, description=?, expiration_date=? "
					+ "WHERE product_id = ?";
			PreparedStatement preparedStmt = dbConnection.prepareStatement(myQuery);
			preparedStmt.setString(1, p.getProduct_name());
			preparedStmt.setDouble(2, p.getProduct_price());
			preparedStmt.setString(3, p.getCategory());
			preparedStmt.setString(4, p.getDescription());
			preparedStmt.setDate(5, new java.sql.Date(p.getExpiration_date().getTime()));
			preparedStmt.setLong(6, p.getProduct_id());
			System.out.println(preparedStmt);
			preparedStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteProduct(long product_id) {
		try {
			String myQuery = "DELETE from t_products " + "WHERE product_id = ?";
			PreparedStatement preparedStmt = dbConnection.prepareStatement(myQuery);
			preparedStmt.setLong(1, product_id);
			System.out.println(preparedStmt);
			preparedStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Product> getAllProducts() {
		List<Product> prods = new ArrayList<>();
		try {
			String myQuery = "SELECT * FROM t_products ORDER BY product_id";
			PreparedStatement preparedStmt = dbConnection.prepareStatement(myQuery);
			System.out.println(preparedStmt);
			ResultSet myRes = preparedStmt.executeQuery();

			while (myRes.next()) {
				Product prod = new Product();
				prod.setProduct_id(myRes.getLong("product_id"));
				prod.setProduct_name(myRes.getString("product_name"));
				prod.setCategory(myRes.getString("category"));
				prod.setDescription(myRes.getString("description"));
				prod.setProduct_price(myRes.getDouble("product_price"));
				prod.setExpiration_date(myRes.getDate("expiration_date"));
				prods.add(prod);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return prods;
	}

	public void cleanUp() {
		DBUtil.closeConnection();
	}
}
