/**
 * 
 */
package chapter3;

/**
 * @author HWA
 * �Լ��� �������̽�(�ڹ�8) : �Ѱ��� �߻� �޼��带 �����ϴ� �������̽� 
 * '@functionalInterface �ֳ����̼��� �̿��Ͽ� �������̽��� �ǵ��� �� ��Ȯ�ϰ� ǥ�� �� �� �ִ�.
 */
@FunctionalInterface
public interface BankTransactionFilter {
	boolean test(BankTransaction bankTransaction);
}
