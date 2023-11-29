package Assignment6;

public class Coffee extends Beverage{
	private boolean extraShot;
	private boolean extraSyrup;
	
	public Coffee(String bevName, SIZE size, boolean extraShot, boolean extraSyrup) {
		super(bevName,TYPE.COFFEE,size);
		this.extraShot=extraShot;
		this.extraSyrup = extraSyrup;
	}

	public boolean getExtraSyrup() {
		return extraSyrup;
	}
	
	public boolean getExtraShot() {
		return extraShot;
	}
	
	@Override
	public double calcPrice() {
		final double priceExtraShot = .5;
		final double priceExtraSyrup = .5;
		double price = super.addSizePrice();
		if(this.getExtraShot()) {
			price += priceExtraShot;
		}
		if(this.getExtraSyrup()) {
			price += priceExtraSyrup;
		}
		return price;
	}
	
	@Override
	public boolean equals(Object o) {
		Coffee c = (Coffee) o;
		if(this.getBevName() == c.getBevName()
				&& this.getSize() == c.getSize() && this.getType() == c.getType()
				&& this.getBasePrice() == c.getBasePrice() && this.extraShot == c.extraShot && this.extraSyrup == c.extraSyrup) {
			return true;
		}else {
			return false;
		}
	}
	
	@Override
	public String toString() {
		return super.toString() + "\nExtra Shot: " + this.getExtraShot() + "\nExtra Syrup: " + this.getExtraSyrup() +"\nPrice: " + this.calcPrice();
	}
}
