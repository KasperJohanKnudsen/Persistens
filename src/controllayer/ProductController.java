package controllayer;

import databaselayer.ProductDB;
import modellayer.Product;

public class ProductController {
	private static ProductDB productDB;

	public ProductController() throws DataAccessException {
		productDB = new ProductDB();
	}
	
	public Product findProductByID(int id) throws DataAccessException {
		return productDB.findById(id);
	}

	public static Product findProductByName(String name) throws DataAccessException {
		return productDB.findByName(name);
	}
	


}
