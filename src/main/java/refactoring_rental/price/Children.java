package refactoring_rental.price;

import refactoring_rental.Movie;

public class Children extends Price {

	@Override
	public int getPriceCode() {
		return Movie.CHILDRENS;
	}

	@Override
	public double getCharge(int aDaysRented) {
		double result = 0.0;
		result += 1.5;
		if(aDaysRented >3) {
			result +=(aDaysRented-3) *1.5;
		}
		return result;
	}

	@Override
	public int getFrequentRentalPoints(int aDaysRented) {
		return 1;
	}

}
