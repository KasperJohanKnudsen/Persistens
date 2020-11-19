package databaselayer;

import controllayer.DataAccessException;
import modellayer.Product;

public interface ProductDBIF {
	 Product findById(int id) throws DataAccessException;
	 Product findByName(String name) throws DataAccessException;
}
