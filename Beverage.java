package Assignment6;

public abstract class Beverage {
	private final double basePrice = 2.0;
	private final double sizePrice = 1.0;
	private TYPE type;
	private SIZE size;
	private String bevName;
	
	public Beverage(String bV, TYPE t, SIZE s) {
		this.bevName = bV;
		this.type = t;
		this.size = s;
	}
	
	public double getBasePrice() {
		return basePrice;
	}
	public double getSizePrice() {
		return sizePrice;
	}
	public TYPE getType() {
		return type;
	}
	public String getBevName() {
		return bevName;
	}
	public SIZE getSize() {
		return size;
	}
	public double addSizePrice() {
		double price = basePrice;
		if(this.getSize() == SIZE.MEDIUM) {
			price += sizePrice;
		}else if(this.getSize() == SIZE.LARGE) {
			price += sizePrice *2;
		}
		return price;
	}
	
	public String toString() {
		String str = "Beverage name: " + this.getBevName() + "\nSize: " + this.getSize();
		return str;
	}
	public boolean equals(Beverage anotherBev) {
		if(this.bevName == anotherBev.getBevName() && this.size == anotherBev.getSize() && this.type == anotherBev.type) {
			return true;
		}else {
			return false;
		}
	}
	
	public abstract double calcPrice();
}