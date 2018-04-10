package refactoring_rental.price;

public class NewRelease extends Price {
	private static final NewRelease instance = new NewRelease();
	
	
	public static NewRelease getInstance() {
		return instance;
	}

	private NewRelease() {
	}
	@Override
	public PriceType getPriceCode() {
		return PriceType.NEW_RELEASE;
	}

	@Override
	public double getCharge(int aDaysRented) {
		double result = 0.0;
		result += aDaysRented *3;
		return result;
	}

	@Override
	public int getFrequentRentalPoints(int aDaysRented) {

		return aDaysRented >1 ? 2:1;
	}

}
