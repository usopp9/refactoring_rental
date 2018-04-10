package refactoring_rental;

import refactoring_rental.price.Action;
import refactoring_rental.price.Children;
import refactoring_rental.price.NewRelease;
import refactoring_rental.price.Price;
import refactoring_rental.price.Regular;

public class Movie {
	public static final int REGULAR = 0;
	public static final int NEW_RELEASE =1;
	public static final int CHILDRENS =2;
	public static final int ACTION =3;
	
	private String title;
	private Price price;
	
	public Movie(String title, int priceCode) {
		this.title = title;
		setPriceCode(priceCode);
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPriceCode() {
		return price.getPriceCode();
	}
	public void setPriceCode(int priceCode) {
		switch (priceCode) {
		case REGULAR:
			price = new Regular();
			break;
		case CHILDRENS:
			price = new Children();
			break;
		case NEW_RELEASE:
			price = new NewRelease();
			break;
		case ACTION:
			price = new Action();
			break;
		default:
			throw new IllegalArgumentException("가격 코드가 잘못되었습니다.");
		}
	}
	double getCharge(int aDaysRented) {
		return price.getCharge(aDaysRented);
	}
	int getFrequentRentalPoints(int aDaysRented) {
		return price.getFrequentRentalPoints(aDaysRented);
	}
	
	
}
