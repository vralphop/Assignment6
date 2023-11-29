package Assignment6;

import java.util.Random; 
import java.util.ArrayList;

public class Order implements OrderInterface, Comparable<Order> {
	private ArrayList<Beverage> beverages;
	private Customer cust;
	private int orderTime; 
	private int orderNo;
	private DAY orderDay;
	
	public Order(int orderTime, DAY orderDay, Customer cust){
		this.orderTime = orderTime;
		this.orderDay = orderDay;
		this.cust = new Customer(cust);
		this.beverages = new ArrayList<Beverage>();
		this.orderNo = this.generateOrder();
	}
	
	public void addNewBeverage(String bevName, SIZE size, boolean extraShot, boolean extraSyrup) {
	Coffee coffee = new Coffee(bevName, size, extraShot, extraSyrup);
	beverages.add(coffee);
	
	}
	
	public void addNewBeverage(String bevName, SIZE size) 
    {
	boolean isWeekend = false;
	
	if(orderDay == DAY.SATURDAY || orderDay == DAY.SUNDAY) {
		isWeekend = true;
	}
	Alcohol alcohol = new Alcohol(bevName, size, isWeekend);
	beverages.add(alcohol);
	
	}
	
	
	public void addNewBeverage(String bevName, SIZE size, int numOfFruits, boolean addProtein) {
	Smoothie smoothie = new Smoothie(bevName, size, numOfFruits, addProtein);
	beverages.add(smoothie);
	}
	
	
	public double calcOrderTotal() {
		double price = 0.0;
		for(int i = 0; i < beverages.size(); i++) {
			price += beverages.get(i).calcPrice();
		}
		return price;
	}
	
	@Override
	public int compareTo(Order anotherOrder) {
		if(this.orderNo > anotherOrder.orderNo) {
			return 1;
		}else if(this.orderNo < anotherOrder.orderNo) {
			return -1;
		}
		return 0;
	}
	public int findNumOfBeveType(TYPE type) {
		int count = 0;
		for(int i =0; i < beverages.size(); i++) {
			if(beverages.get(i).getType() == type) {
				count++;
			}
		}
		return count;
	}
	
	public int generateOrder() {
		Random r = new Random(); 
		int randNumGenerator = r.nextInt(90000) + 10000;
		return randNumGenerator;
	}
	
	
	// getter Methods
	public Customer getCustomer() {
		return new Customer(cust);
	}
	public Beverage getBeverage(int itemNo) {
		return beverages.get(itemNo);
	}
	public DAY getDay() {
		return orderDay;
	}
	public DAY getOrderDay() {
		return orderDay;
	}
	public int getOrderTime() {
		return orderTime;
	}
	//can use beverages.size();
	public int getTotalItems() {
		return beverages.size();
	}
	public int getOrderNo() {
		return orderNo;
	}
	public boolean isWeekend() {
		if(orderDay == DAY.SATURDAY || orderDay == DAY.SUNDAY) {
			return true;
		}else {
			return false;
		}
	}
	
	public String toString() {
		String str = "Order Number: " + this.getOrderNo() + "\nTime: " + this.getOrderTime() 
		+"\nDay: "+ this.getDay() + "\nCustomer " + this.getCustomer().toString()
		+"\n";
		for(Beverage b : beverages) {
			str += b.toString();
		}
		str += "\nTotal: " + this.calcOrderTotal();
		return str;
	}
	
	//setter Methods
	public void setCust(Customer cust) {
		this.cust = cust;
	}

	public ArrayList<Beverage> getBeverages() {
		return beverages;
	}
	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}
	public void setOrderTime(int orderTime) {
		this.orderTime = orderTime;
	}
	public void setBeverages(ArrayList<Beverage> beverages) {
		this.beverages = beverages;
	}
	public void setOrderDay(DAY orderDay) {
		this.orderDay = orderDay;
	}
	
}