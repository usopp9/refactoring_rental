package refactoring_rental.price;

public class Action extends Price {
	private static final Action instance = new Action();

	
	public static Action getInstance() {
		return instance;
	}

	private Action() {
	}

	@Override
	public PriceType getPriceCode() {
		return PriceType.ACTION;
	}

	@Override
	public double getCharge(int aDaysRented) {
		double result = 0.0;
		result += 2;
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
