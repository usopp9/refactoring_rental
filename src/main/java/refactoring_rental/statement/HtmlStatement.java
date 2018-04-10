package refactoring_rental.statement;

import refactoring_rental.Customer;
import refactoring_rental.Rental;

public class HtmlStatement extends Statement {
	private static final HtmlStatement instance = new HtmlStatement();
	
	
	public static HtmlStatement getInstance() {
		return instance;
	}

	private HtmlStatement() {
	}

	protected String footerString(Customer aCustomer) {
		return String.format("<p>누적 대여로 : <EM>%s</EM>%n<p>적립 포인트 : <EM>%s</EM><p>", aCustomer.getTotalCharge(),
				aCustomer.getFrequentRenterPoints());
	}

	protected String eachRentalString(Rental each) {
		return String.format("\t%s : %s <br>%n", each.getMovie().getTitle(), each.getCharge());
	}

	protected String headerString(String name) {
		return String.format("<H1><EM>%s 고객님의 대여기록 </EM></H1><p>%n", name);
	}
}
