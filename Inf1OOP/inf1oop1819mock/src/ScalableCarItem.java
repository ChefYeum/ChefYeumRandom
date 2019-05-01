
public class ScalableCarItem extends CarItem{
	private double scaledPrice;
	private int sales;
	
	public ScalableCarItem(String brand, String model, double price) {
		super(brand, model, price);
		this.sales = 0;
		this.scaledPrice = price;
	}
	

	public double getPrice() {return this.scaledPrice;}

	public void updateSales(int sold) {
		if (sold <= 0) throw new IllegalArgumentException("Invalid number of sold cars");
		else {
			sales += sold;
			scaledPrice = super.price + 0.01*super.price*sales;

			//rounding
			scaledPrice = Math.round(scaledPrice*100)/100.0;
		}
	}
	
	public String toString() {
		
		return String.format("%s\nsales: %s\nscaled price: %s GBP\n",
								super.toString(), this.sales, this.scaledPrice ).toString();	
	}
	
	
}
