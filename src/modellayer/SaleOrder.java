package modellayer;

import java.sql.Date;
import java.util.*;
import java.util.List;

public class SaleOrder{
	private int id;
	private Date date;
	private int quantity;
	private String deliveryStatus;
	private Date deliveryDate;
	private String deliveryNote;
	private Date orderDate;
	


	
	public SaleOrder() {
		this.date = date;

	}




	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public Date getDate() {
		return date;
	}




	public void setDate(Date date) {
		this.date = date;
	}




	public int getQuantity() {
		return quantity;
	}




	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}




	public String getDeliveryStatus() {
		return deliveryStatus;
	}




	public void setDeliveryStatus(String deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}




	public Date getDeliveryDate() {
		return deliveryDate;
	}




	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}




	public String getDeliveryNote() {
		return deliveryNote;
	}




	public void setDeliveryNote(String deliveryNote) {
		this.deliveryNote = deliveryNote;
	}




	public Date getOrderDate() {
		return orderDate;
	}




	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	
	
	
}