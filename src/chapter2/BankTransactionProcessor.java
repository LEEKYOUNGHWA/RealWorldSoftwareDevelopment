package chapter2;

import java.time.Month;
import java.util.List;

/**
 * @author HWA
 * 예제 2-7 클래스의 계산 연산 그룹화
 */
public class BankTransactionProcessor {
	private final List<BankTransaction> bankTransactions;
	
	public BankTransactionProcessor(final List<BankTransaction> bankTransactions) {
		this.bankTransactions = bankTransactions;
	}
	
	public double calculateTotalAmount(){
		double total = 0;
		for(final BankTransaction bankTransaction: bankTransactions) {
			total += bankTransaction.getAmount();
		}
		return total;
	}
	
	public double calculateTotalInMonth(final Month month){
		double total = 0;
		for(final BankTransaction bankTransaction: bankTransactions){
			if(bankTransaction.getDate().getMonth() == month){
				total += bankTransaction.getAmount();
			}
		}
		return total;
	}
	
	public double calculateTotalForCategory(final String category) {
		double total = 0;
		for(final BankTransaction bankTransaction: bankTransactions) {
			if(bankTransaction.getDescription().equals(category)){
				total+= bankTransaction.getAmount();
			}
		}
		return total;
	}
}
