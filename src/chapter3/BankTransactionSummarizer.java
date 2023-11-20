/**
 * 
 */
package chapter3;

/**
 * @author HWA
 * 예제 3-11 BankTransactionProcessor 클래스의 핵심 연산
 */
public interface BankTransactionSummarizer {
	double summarize(double accumulator, BankTransaction bankTransaction);
}
