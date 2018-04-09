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
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		
		StringBuilder result = new StringBuilder(getName() + "고객님의 대여기록\n");
		
		for(Rental each:rentals) {
			
			frequentRenterPoints += each.getFrequentRentalPoints();
			
			result.append("\t" + each.getMovie().getTitle());
			result.append("\t" +String.valueOf(each.getCharge())+ "\n");
	
		}
		result.append("누적 대여료 : " + String.valueOf(getTotalCharge()) + "\n");
		result.append("적립 포인트 : " + String.valueOf(frequentRenterPoints));
		
		return result.toString();
	}


	private double getTotalCharge() {
		double result = 0;
		for(Rental rental : rentals) {
			result += rental.getCharge();
		}
		return result;
	}
}
