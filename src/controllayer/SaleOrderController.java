package controllayer;

import modellayer.Product;

public class SaleOrderController{
	
	public String find(String name) throws DataAccessException{
		String Vare = "Ikke fundet";
		if(ProductController.findProductByName(name) != null) {

			System.out.println( ProductController.findProductByName(name));
		}else {
			Vare = "Vare fundet";
		}
		return Vare;
	}

	public Product addProduct(String name) throws DataAccessException {
		Product product = null;
		if (ProductController.findProductByName(name) != null) {
			product = ProductController.findProductByName(name);
		} 
		return product;
	}
	
	
}