package modellayer;

public class Product{
	private int id;
	private String name;
	private int barcode;
	private double purchasePrice;
	private double salesPrice;
	private String origin;
	private int stock;
	private String size;
	private String description;
	
	public Product(int id, String name, int barcode, double purchasePrice, double salesPrice, String origin, int stock, String size,
			String description) {
		this.id = id;
		this.name = name;
		this.barcode = barcode;
		this.purchasePrice = purchasePrice;
		this.salesPrice = salesPrice;
		this.origin = origin;
		this.stock = stock;
		this.size = size;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public int getBarcode() {
		return barcode;
	}

	public void setBarcode(int barcode) {
		this.barcode = barcode;
	}

	public double getSalesPrice() {
		return salesPrice;
	}

	public void setSalesPrice(double salesPrice) {
		this.salesPrice = salesPrice;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	
	
	
	
}