package chapter3;

import java.time.Month;

/**
 * @author HWA
 * ���� 3-6 BankTransactionFilter�� �����ϴ� Ŭ���� ����
 */
public class BankTransactionIsInFabuaryAndExpensive implements BankTransactionFilter{

	@Override
	public boolean test(BankTransaction bankTransaction) {
		return bankTransaction.getDate().getMonth() == Month.FEBRUARY && bankTransaction.getAmount() >= 1000;
	}

}
