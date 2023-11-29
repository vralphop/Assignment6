package Assignment6;

public class Alcohol extends Beverage {
	private boolean isWeekend;

	public Alcohol(String bevName, SIZE size, boolean isWeekend) {
		super(bevName,TYPE.ALCOHOL,size);
		this.isWeekend= isWeekend;
	}
	public boolean isWeekend() {
		if(this.isWeekend) {
			return true;
		}else {
			return false;
		}
	}
	
	@Override
	public boolean equals(Object o) {
		Alcohol a = (Alcohol)o;
		if(this.isWeekend == a.isWeekend && this.getBevName() == a.getBevName()
				&& this.getSize() == a.getSize() && this.getType() == a.getType()
				&& this.getBasePrice() == a.getBasePrice()) {
			return true;
		}else {
			return false;
		}
	}
	
	@Override
	public double calcPrice() {
		final double isWeekendPrice = .60;
		double price = super.addSizePrice();
		if(this.isWeekend() == true) {
			price += isWeekendPrice;
		}
		
		return price;
	}
	
	@Override
	public String toString() {
		return super.toString() + "\nWeekend: " + this.isWeekend() +"\nPrice: " + this.calcPrice();
	}
	
}