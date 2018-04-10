package refactoring_rental.price;

public class FactoryPrice {
	
	public static Price createPrice(PriceType type) {
		switch (type) {
		case REGULAR:
			return Regular.getInstance();
		case CHILDRENS:
			return Children.getInstance();
		case NEW_RELEASE:
			return NewRelease.getInstance();
		case ACTION:
			return Action.getInstance();
		default:
			throw new IllegalArgumentException("가격 코드가 잘못되었습니다.");
		}
	}
}
