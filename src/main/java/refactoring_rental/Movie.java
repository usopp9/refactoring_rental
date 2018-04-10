package refactoring_rental;

import refactoring_rental.price.FactoryPrice;
import refactoring_rental.price.Price;
import refactoring_rental.price.PriceType;

public class Movie {
	
	private String title;
	private Price price;
	
	public Movie(String title, PriceType priceCode) {
		this.title = title;
		setPriceCode(priceCode);
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public PriceType getPriceCode() {
		return price.getPriceCode();
	}
	public void setPriceCode(PriceType priceCode) {
		price = FactoryPrice.createPrice(priceCode);
	}
	double getCharge(int aDaysRented) {
		return price.getCharge(aDaysRented);
	}
	int getFrequentRentalPoints(int aDaysRented) {
		return price.getFrequentRentalPoints(aDaysRented);
	}
	
	
}
