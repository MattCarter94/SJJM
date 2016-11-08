package com.qac.nbgardens.entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.qac.nbgardens.entities.enums.OrderStatus;

//SQL table definition
@Entity
@Table (name = "Customer_Order")
public class CustomerOrder {
	
	@Id //ID is for PK
	@Column (name = "Customer_Order_ID")  
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer customerOrderID;
	
	@OneToOne //For FK.
	@JoinColumn(name="User_ID", nullable = false)
	@NotNull
	private Customer customer;
	
	@Column (name = "Order_Date", nullable = false)
	@NotNull
	private Date orderDate;
	
	@Column (name = "Order_Status", nullable = false, length = 255)
	@NotNull
	private OrderStatus status;
	//End of table definition
	
	// One customer order linked to many order lines
	@OneToMany(cascade=CascadeType.ALL, mappedBy="customer") //TODO Get Explanation
	private List<OrderLine> orderLines;

	
	// Empty constructor can also be used?
	public CustomerOrder() {}

	//New constructor, requires only a customer and an order status
	public CustomerOrder(Customer customer, OrderStatus orderStatus) {
		this.customer = customer;
		this.status = orderStatus;
		this.orderDate = null;
		this.orderLines = new ArrayList<>();
	}
	
	//Alternative constructor
	public CustomerOrder(Customer customer, OrderStatus orderStatus, OrderLine orderLine) {
		this.customer = customer;
		this.status = orderStatus;
		this.orderDate = null;
		this.orderLines = new ArrayList<>();
		this.orderLines.add(orderLine);
	}


	//GETTERS AND SETTERS
	public Integer getCustomerOrderID() {
		return customerOrderID;
	}
	public void setCustomerOrderID(Integer customerOrderID) {
		this.customerOrderID = customerOrderID;
	}
	
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public OrderStatus getStatus() {
		return status;
	}
	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	// There are two of these
	public void addOrderLine(Product product, int quantity) {
//		System.out.println("product in addOrderLine is " + product.getTitle() + " with a quantity of " + quantity);
//		System.out.println("Entered add order line");
		if(orderLines==null) // if order lines does not exist
//			System.out.println("This orders orderLines is empty");
			orderLines = new ArrayList<>(); // create list
//		System.out.println("Attmepting to add new orderLine to this customer order");
		orderLines.add(new OrderLine(this, product, quantity)); // add a new order line object to this customer order. this specifies the current order so they are linked together
//		System.out.println("Successfully added the orderLine to the order");
	}

	public List<OrderLine> getOrderLines() {
		return orderLines;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void addOrderLine(OrderLine orderLine) {
//		System.out.println("Entering second addOrderLine");
//		System.out.println("Does this orderLine have a custOrder ID? " + orderLine.getCustomerOrder().getCustomer().getEmail());
		if(!orderLine.getCustomerOrder().equals(this)) // if the specified order line is not linked to the current customer order...
//			System.out.println("The orderLine is not associated with this order");
			orderLine.setCustomerOrder(this); // link the order line to this customer order
//			System.out.println("Just linked this order with the orderLine");
//		System.out.println("About to add the orderLine to order lines");
		orderLines.add(orderLine); // add the order line we input to the customer order objects list of order lines
//		System.out.println("Added the orderLine to the customer order");
	}


	public void deleteOrderLine(Integer productID) {
		for(int i=0; i<=orderLines.size()-1; i++){
			if(orderLines.get(i).getProduct().getProductID() == productID){
				orderLines.remove(i);
				System.out.println("Removed product " + productID);
			}
		}
	}
	
	public BigDecimal getTotalCost(){
		BigDecimal total = new BigDecimal(0);
		for(int i=0; i<=orderLines.size()-1; i++){
			total = total.add(orderLines.get(i).getPrice().multiply(new BigDecimal(orderLines.get(i).getQuantity())));
		}
		return total;
	}
	
	public int getQuantity(){
		int quantity = 0;
		for(int i=0; i<=orderLines.size()-1; i++){
			quantity = quantity + orderLines.get(i).getQuantity();
		}
		return quantity;
	}
	
	
}



