package refactoring_rental.price;

public abstract class Price {
	
	public abstract PriceType getPriceCode();	
	public abstract double getCharge(int aDaysRented);
	public abstract int getFrequentRentalPoints(int aDaysRented);
	
}
