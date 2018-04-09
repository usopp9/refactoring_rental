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
			double thisAmount =amountFor(each);
			frequentRenterPoints++;
			
			if((each.getMovie().getPriceCode() ==Movie.NEW_RELEASE) && each.getDaysRented() >1) 
				frequentRenterPoints++;
			
			result.append("\t" + each.getMovie().getTitle());
			result.append("\t" +String.valueOf(thisAmount)+ "\n");
			
			totalAmount += thisAmount;		
		}
		result.append("누적 대여료 : " + String.valueOf(totalAmount) + "\n");
		result.append("적립 포인트 : " + String.valueOf(frequentRenterPoints));
		
		return result.toString();
	}
	private double amountFor(Rental aRental) {
		double result = 0;
		
		switch (aRental.getMovie().getPriceCode()) {
		case Movie.REGULAR:
			result +=2;
			if(aRental.getDaysRented()>2) {
				result += (aRental.getDaysRented() -2)*1.5;
			}
				break;
		case Movie.NEW_RELEASE:
			result += aRental.getDaysRented() *3;
			break;
		case Movie.CHILDRENS:
			result += 1.5;
			if(aRental.getDaysRented() >3) {
				result +=(aRental.getDaysRented() -3) *1.5;
			}
			break;
		default:
			break;
		}
		return result;
}
}
