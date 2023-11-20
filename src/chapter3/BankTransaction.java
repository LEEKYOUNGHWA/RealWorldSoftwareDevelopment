package chapter3;

import java.time.LocalDate;
import java.util.Objects;

/**
 * @author HWA
 * 예제 2-4 입출금내역 도메인클래스
 */
public class BankTransaction {

	private final LocalDate date;
	private final double amount;
	private final String description;
	
	public BankTransaction(final LocalDate date, final double amount, final String description) {
		this.date = date;
		this.amount = amount;
		this.description = description;
	}

	/**
	 * @return the date
	 */
	public LocalDate getDate() {
		return date;
	}

	/**
	 * @return the amount
	 */
	public double getAmount() {
		return amount;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	
	@Override
	public String toString(){
		return "BankTransaction{ date=" + date + ", amount= " + amount + ", description= " + description +  '}' + '\n';
	}
	
	@Override
	public boolean equals(Object o) {
		if(this == o) return true;
		if(o == null || getClass()!= o.getClass()) return false;
		BankTransaction that = (BankTransaction)o;
		return Double.compare(that.amount, amount) == 0 && date.equals(that.date) && description.equals(that.description);
		
	}
	
	@Override
	public int hashCode(){
		return Objects.hash(date, amount, description);
	}
}
