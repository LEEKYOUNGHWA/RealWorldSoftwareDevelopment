package chapter3;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;

/**
 * @author HWA
 * ���� 2-7 Ŭ������ ��� ���� �׷�ȭ
 */
public class BankTransactionProcessor {
	private final List<BankTransaction> bankTransactions;
	
	public BankTransactionProcessor(final List<BankTransaction> bankTransactions) {
		this.bankTransactions = bankTransactions;
	}
	
	/**
	 * @param bankTransactionSummarizer
	 * @return
	 * ���� 3-11 BankTransactionProcessor Ŭ������ �ٽ� ����
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
	 * ���� 3-5 ����/��� ��Ģ�� ������ �� �������� findTransaction() �޼���
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
	 * ���� 3-1 Ư�� �ݾ� �̻��� ���� �ŷ� ���� ã��
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
	 * ���� 3-2 Ư�� ���� ����� ���� ã��
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
	 * ���� 3-3 Ư�� ���̳� �ݾ����� ����� ���� �˻��ϱ�
	 * @deprecated �ڵ尡 ���� ����, �ݺ� ���� => ����Ͻ� ������ ����ϴ� BankTransactionFilter �������̽��� ����� ���� �ذ�
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
	 * �� �������̽� �ȿ� ��� ����� �߰��ϴ� �� �������̽��� ����� ���� ���ؾ� �Ѵ�.
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
	 * ���� 3-11
	 * @deprecated ���� 3-11 {@link #calculateTotalInMonth}
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
