package Assignment6;

import java.util.ArrayList;

public class BevShop implements BevShopInterfce {
	private ArrayList <Order> orders = new ArrayList<Order>();
	private int currentOrderIndex;
	private int numAlcoholInOrder;
	
	
		public BevShop() {
			currentOrderIndex = 0;
			numAlcoholInOrder = 0;
		}
	
	
	
	public boolean validTime(int time) {
		return (time >= MIN_TIME && time <= MAX_TIME);
	}
	
	
	public boolean isMaxFruit(int numOfFruits) {
		return (numOfFruits > MAX_FRUIT);
	}
	
	public boolean eligibleForMore() {
		if(this.getNumOfAlcoholDrink() > MAX_ORDER_FOR_ALCOHOL) {
			return false;
		}
		else 
		{
			return true;
		}
	}

	public int getMinAgeForAlcohol() {
		return MIN_AGE_FOR_ALCOHOL;
	}
	
	public int getMaxNumOfFruits() {
		return MAX_FRUIT;
	}
	
	public int getNumOfAlcoholDrink() {
		return numAlcoholInOrder;
	}
	
	public int getMaxOrderForAlcohol() {
		return MAX_ORDER_FOR_ALCOHOL;
	}
	
	public Order getCurrentOrder() {
		int x = this.orders.size() -1;
		return this.orders.get(x);
	}
	
	public boolean validAge(int age) {
		if(age > MIN_AGE_FOR_ALCOHOL) {
			return true;
		}else {
			return false;
		}
	}
	
	public Order getOrderAtIndex(int index) {
		return orders.get(index);
	}
	
	public double totalOrderPrice(int orderNo) {
		double price = 0.0;
		for(int i = 0; i < orders.size(); i++) {
			if(orders.get(i).getOrderNo() == orderNo) {
				price = orders.get(i).calcOrderTotal();
			}
			
		}
		return price;
	}
	
	public void processSmoothieOrder(String bevName, SIZE size, int numOfFruits, boolean addProtein) {
		getCurrentOrder().addNewBeverage(bevName, size, numOfFruits, addProtein);
	}

	public void processAlcoholOrder(String bevName, SIZE size) {
		if(this.eligibleForMore()) {
			getCurrentOrder().addNewBeverage(bevName, size);
			this.numAlcoholInOrder++;
		}
	}
	
	public void startNewOrder(int time, DAY day, String customerName, int customerAge) {
		Customer customer = new Customer(customerName,customerAge);
		Order tempOrder = new Order(time,day,customer);
		orders.add(tempOrder);
		numAlcoholInOrder = 0;
		currentOrderIndex = 0;
	}
	public void processCoffeeOrder(String bevName, SIZE size, boolean extraShot, boolean extraSyrup) {
		getCurrentOrder().addNewBeverage(bevName,size,extraShot,extraSyrup);
	}
	
	public int findOrder(int orderNo) {
		int indexFound = -1;
		for(int i = 0; i < orders.size(); i++) {
			if(orders.get(i).getOrderNo() == orderNo) {
				indexFound = i;
			}
		}
		return indexFound;
	}

	public int totalNumOfMonthlyOrders() {
		return orders.size();
	}
	
	public double totalMonthlySale() {
		double total = 0.0;
		for(Order o: orders) {
			total += o.calcOrderTotal();
		}
		
		return total;
	}

	
	
	public void sortOrders() {
		
		for(int i = 0; i < orders.size(); i++) {
			for(int j =orders.size()- 1; j > i;j--) {
				if(orders.get(i).compareTo(orders.get(j)) == 1) {
					
					Order temp = orders.get(i);
					orders.set(i, orders.get(j));
					orders.set(j, temp);
				}
			}
		}
	}
	@Override
	public String toString() {
		String str = "";
		for(Order o : orders) {
			str += o.toString();
		}
		str += "\n Monthly Sale: " +this.totalMonthlySale();
		return str;
	}

	
}