/**
 * 
 */
package chapter3;

/**
 * @author HWA
 * ���� 3-11 BankTransactionProcessor Ŭ������ �ٽ� ����
 */
public interface BankTransactionSummarizer {
	double summarize(double accumulator, BankTransaction bankTransaction);
}
