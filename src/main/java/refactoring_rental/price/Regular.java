package refactoring_rental.price;

import refactoring_rental.Movie;

public class Regular extends Price {

	@Override
	public int getPriceCode() {
		return Movie.REGULAR;
	}

	@Override
	public double getCharge(int aDaysRented) {
		double result = 0.0;
		result +=2;
		if(aDaysRented>2) 
			result += (aDaysRented -2)*1.5;
		return result;
	}

	@Override
	public int getFrequentRentalPoints(int aDaysRented) {
		return 1;
	}

}
