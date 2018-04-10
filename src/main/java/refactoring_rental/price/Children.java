package refactoring_rental.price;

public class Children extends Price {
	private static final Children instance = new Children();

	
	public static Children getInstance() {
		return instance;
	}

	private Children() {
	}

	@Override
	public PriceType getPriceCode() {
		return PriceType.CHILDRENS;
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
