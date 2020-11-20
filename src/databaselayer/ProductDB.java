package databaselayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import controllayer.DataAccessException;

import modellayer.*;

public class ProductDB implements ProductDBIF {

	private static final String FIND_BY_ID = "select * from Product where id = ?";
	private static final String FIND_BY_NAME = "select * from Product where name = ?";
	private static final String DBTEST = "select * from Product"; // fjern

	private PreparedStatement findById;
	private PreparedStatement findByName;
	private PreparedStatement dbTest; // fjern

	public ProductDB() throws DataAccessException {
		init();
	}

	public void init() throws DataAccessException {
		Connection con = DBConnection.getInstance().getConnection();
		try {
			findById = con.prepareStatement(FIND_BY_ID);
			findByName = con.prepareStatement(FIND_BY_NAME);
			dbTest = con.prepareStatement(DBTEST); // fjern
		} catch (SQLException e) {
			throw new DataAccessException(DBMessages.COULD_NOT_PREPARE_STATEMENT, e);
		}
	}

	@Override
	public Product findById(int id) throws DataAccessException {
		Product r = null;
		try {
			findById.setInt(1, id);
			ResultSet rs = findById.executeQuery();
			if (rs.next()) {
				r = buildObject(rs);
			}
		} catch (SQLException e) {
			throw new DataAccessException(DBMessages.COULD_NOT_BIND_OR_EXECUTE_QUERY, e);
		}
		return r;
	}

	public Product findByName(String name) throws DataAccessException {
		Product r = null;
		try {
			findByName.setString(1, name);
			;
			ResultSet rs = findByName.executeQuery();
			if (rs.next()) {
				r = buildObject(rs);
			}
		} catch (SQLException e) {
			throw new DataAccessException(DBMessages.COULD_NOT_BIND_OR_EXECUTE_QUERY, e);

		}
		return r;
	}

	private Product buildObject(ResultSet rs) throws DataAccessException {
		Product product = new Product();
		try {
			product.setId(rs.getInt("id"));
			product.setName(rs.getString("name"));
			product.setBarcode(rs.getInt("barcode"));
			product.setPurchasePrice(rs.getDouble("purchasePrice"));
			product.setSalesPrice(rs.getDouble("salesPrice"));
			product.setOrigin(rs.getString("origin"));
			product.setStock(rs.getInt("stock"));
			product.setSize(rs.getString("size"));
			product.setDescription(rs.getString("description"));
		} catch (SQLException e) {
			throw new DataAccessException(DBMessages.COULD_NOT_READ_RESULTSET, e);
		}
		return product;
	}

}
