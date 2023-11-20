package chapter3;

import java.time.Month;

/**
 * @author HWA
 * 예제 3-6 BankTransactionFilter를 구현하는 클래스 선언
 */
public class BankTransactionIsInFabuaryAndExpensive implements BankTransactionFilter{

	@Override
	public boolean test(BankTransaction bankTransaction) {
		return bankTransaction.getDate().getMonth() == Month.FEBRUARY && bankTransaction.getAmount() >= 1000;
	}

}
