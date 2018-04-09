package refactoring_rental;

import java.util.ArrayList;
import java.util.List;

public class Customer {
	private String name;
	private List<Rental> rentals = new ArrayList<>();
	
	
	public Customer(String aName) {
		this.name = aName;
	}


	public void addRental (Rental aRental) {
		this.rentals.add(aRental);
	}


	public String getName() {
		return name;
	}
	
	public String statement() {
	
		StringBuilder result = new StringBuilder(getName() + "고객님의 대여기록\n");
		
		for(Rental each:rentals) {
			
			result.append("\t" + each.getMovie().getTitle());
			result.append("\t" +String.valueOf(each.getCharge())+ "\n");
	
		}
		result.append("누적 대여료 : " + String.valueOf(getTotalCharge()) + "\n");
		result.append("적립 포인트 : " + String.valueOf(getFrequentRenterPoints()));
		
		return result.toString();
	}
	public String htmlStatement() {
		
		StringBuilder result = new StringBuilder("<H1><EM>" + getName() + "고객님의 대여기록 </EM></H1><p>\n");
		
		for(Rental each:rentals) {
			
			result.append(each.getMovie().getTitle() + ": ");
			result.append(String.valueOf(each.getCharge())+ "<br>\n");
	
		}
		result.append("<p>누적 대여료 : <EM>");
		result.append(String.valueOf(getTotalCharge()) + "</EM>\n");
		result.append("<p>적립 포인트 : <EM>");
		result.append(String.valueOf(getFrequentRenterPoints())+"</EM><p>");
		
		return result.toString();
	}

	private int getFrequentRenterPoints() {
		int result = 0;
		for(Rental rental : rentals) {
			result += rental.getFrequentRentalPoints();
		}
		return result;
	}


	private double getTotalCharge() {
		double result = 0;
		for(Rental rental : rentals) {
			result += rental.getCharge();
		}
		return result;
	}
}
