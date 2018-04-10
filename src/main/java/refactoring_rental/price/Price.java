package refactoring_rental.price;

public abstract class Price {
	
	public abstract int getPriceCode();	
	public abstract double getCharge(int aDaysRented);
	public abstract int getFrequentRentalPoints(int aDaysRented);
	
}
