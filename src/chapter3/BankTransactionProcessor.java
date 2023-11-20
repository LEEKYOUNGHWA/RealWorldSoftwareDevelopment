package chapter3;

import java.time.Month;
import java.util.ArrayList;
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
	
	/**
	 * @param bankTransactionSummarizer
	 * @return
	 * 예제 3-11 BankTransactionProcessor 클래스의 핵심 연산
	 */
	public double summarizeTransactions(final BankTransactionSummarizer bankTransactionSummarizer) {
		double result = 0;
		for(final BankTransaction bankTransaction: bankTransactions) {
			result = bankTransactionSummarizer.summarize(result, bankTransaction);
		}
		return result;
	}
	
	public double calculateTotalInMonth(final Month month) {
		return summarizeTransactions((acc,bankTransaction) -> 
			bankTransaction.getDate().getMonth() == month ? acc + bankTransaction.getAmount() : acc
		);
	}
	
	/**
	 * @param bankTransactionFilter
	 * @return
	 * 예제 3-5 개방/폐쇄 원칙을 적용한 후 유연해진 findTransaction() 메서드
	 */
	public List<BankTransaction> findTransactions(final BankTransactionFilter bankTransactionFilter){
		final List<BankTransaction> result = new ArrayList<>();
		for(final BankTransaction bankTransaction: bankTransactions) {
			if(bankTransactionFilter.test(bankTransaction)){
				result.add(bankTransaction);
			}
		}
		return bankTransactions;
	}
	
	public List<BankTransaction> findTransactionsGreaterThanEqual(final int amount){
		return findTransactions(bankTransaction -> bankTransaction.getAmount()>=amount);
	}
	/**
	 * @param amount
	 * @return
	 * 예제 3-1 특정 금액 이상의 은행 거래 내역 찾기
	 * @deprecated 
	 * {@link #findTransactionsGreaterThanEqual()}
	 */
	public List<BankTransaction> findTransactionsGreaterThanEqualDeprecated(final int amount){
		final List<BankTransaction> result = new ArrayList<>();
		for(final BankTransaction bankTransaction: bankTransactions){
			if(bankTransaction.getAmount()>=amount){
				result.add(bankTransaction);
			}
		}
		return result;
	}
	
	/**
	 * @param month
	 * @return
	 * 예제 3-2 특정 월의 입출금 내역 찾기
	 * @deprecated
	 */
	public List<BankTransaction> findTransactionInMonth(final Month month){
		final List<BankTransaction> result = new ArrayList<>();
		for(final BankTransaction bankTransaction: bankTransactions) {
			if(bankTransaction.getDate().getMonth() == month) {
				result.add(bankTransaction);
			}
		}
		return result;
	}
	
	/**
	 * @param month
	 * @param amount
	 * @return
	 * 예제 3-3 특정 월이나 금액으로 입출금 내역 검색하기
	 * @deprecated 코드가 점점 복잠, 반복 로직 => 비즈니스 로직을 담당하는 BankTransactionFilter 인터페이스를 만들어 문제 해결
	 * {@link BankTransactionFilter#test(BankTransaction)}
	 * {@link #findTransaction(BankTransactionFilter)}
	 */
	public List<BankTransaction> findTransactionsInMonthAndGreater(final Month month, final int amount) {
		final List<BankTransaction> result = new ArrayList<>();
		for(final BankTransaction bankTransaction: bankTransactions) {
			if(bankTransaction.getDate().getMonth()==month && bankTransaction.getAmount()>=amount){
				result.add(bankTransaction);
			}
		}
		return result;
	}
	
	/**
	 * 한 인터페이스 안에 모든 기능을 추가하는 갓 인터페이스를 만드는 일은 피해야 한다.
	 * @return
	 */
	public double calculateTotalAmount(){
		double total = 0;
		for(final BankTransaction bankTransaction: bankTransactions) {
			total += bankTransaction.getAmount();
		}
		return total;
	}
	
	
	/**
	 * @param month
	 * @return
	 * 예제 3-11
	 * @deprecated 예제 3-11 {@link #calculateTotalInMonth}
	 */
	public double calculateTotalInMonthDeprecated(final Month month){
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
