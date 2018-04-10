package refactoring_rental.statement;

import refactoring_rental.Customer;
import refactoring_rental.Rental;

public class TextStatement extends Statement {
	private static final TextStatement instance = new TextStatement();
	
	public static TextStatement getInstance() {
		return instance;
	}
	private TextStatement() {
	}

	@Override
	protected String footerString(Customer aCustomer) {
		return String.format("누적 대여로 : %s%n적립 포인트 : %s", aCustomer.getTotalCharge(),
				aCustomer.getFrequentRenterPoints());
	}

	@Override
	protected String eachRentalString(Rental each) {
		return String.format("\t%-20s\t%s%n", each.getMovie().getTitle(), each.getCharge());
	}

	@Override
	protected String headerString(String name) {
		return String.format("%s 고객님의 대여기록\n", name);
	}
}
