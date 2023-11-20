/**
 * 
 */
package chapter3;

/**
 * @author HWA
 * 함수형 인터페이스(자바8) : 한개의 추상 메서드를 포함하는 인터페이스 
 * '@functionalInterface 애너테이션을 이용하여 인터페이스의 의도를 더 명확하게 표현 할 수 있다.
 */
@FunctionalInterface
public interface BankTransactionFilter {
	boolean test(BankTransaction bankTransaction);
}
