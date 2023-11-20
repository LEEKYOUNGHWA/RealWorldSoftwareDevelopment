package chapter3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;



/**
 * @author HWA
 * ��� �ŷ� ������ �� ����ϱ�
 * ���� 2-1 ��� �ŷ������� �� ����ϱ�
 * ���� 2-2 1�� ����� ���� �հ� ����ϱ�
 * ���� 2-5 ����ݳ��� CSV �ļ� ����ϱ�
 * ���� 2-8 BankStatementProcessor Ŭ������ �̿��� ����� ���� ��� ó��
 * ���� 2-12 BankStatementAnalyzer ���� Ư�� �ļ����� ���� ����
 */
public class BankStatementAnalyzer {
	
	private static final String RESOURCES ="src/main/resources/";
	
	/**
	 * ���� 2-12 BankStatementAnalyzer ���� Ư�� �ļ����� ���� ����
	 */
	public void analyze(final String fileName, final BankStatementParser bankStatementParser) throws IOException {
		final Path path = Paths.get(RESOURCES + fileName);
		final List<String> lines = Files.readAllLines(path);
		final List<BankTransaction> bankTransactions = bankStatementParser.parseLinesFrom(lines);
		final BankTransactionProcessor bankStatementProcessor = new BankTransactionProcessor(bankTransactions);
		collectSummary(bankStatementProcessor);
	}
	
	/**
	 * @param bankStatementProcessor
	 * ���� 2-8 BankStatementProcessor Ŭ������ �̿��� ����� ���� ��� ó��
	 * ���� 3-7 Ư�� BankTransactionFilter �������� findTransactions()ȣ��
	 * ���� 3-8 ���� ǥ�������� BankTransactionFilter ���ϱ�
	 */
	private static void collectSummary(final BankTransactionProcessor bankStatementProcessor) {
		System.out.println("The total for all transaction is " + bankStatementProcessor.calculateTotalAmount());
		System.out.println("Transactions in January " + bankStatementProcessor.calculateTotalInMonth(Month.JANUARY));
		System.out.println("Transactions in Fabuary " + bankStatementProcessor.calculateTotalInMonth(Month.FEBRUARY));
		System.out.println("The total salary received is " + bankStatementProcessor.calculateTotalForCategory("Salary"));
		System.out.println("���� 3-7 " + bankStatementProcessor.findTransactions(new BankTransactionIsInFabuaryAndExpensive()));
		System.out.println("���� 3-8 " + bankStatementProcessor.findTransactions(bankTransaction -> 
			bankTransaction.getDate().getMonth() == Month.FEBRUARY && bankTransaction.getAmount()>=1000)
		);
	}

	/**
	 * @param bankTransactions
	 * @return double
	 * ���� 2-5 ����ݳ��� CSV �ļ� ����ϱ�
	 * @deprecated ���� 2-7 Ŭ������ ��� ���� �׷�ȭ {@link chapter2.BankTransactionProcessor#calculateTotalAmount()}
	 */
	private static double calculateTotalAmount(final List<BankTransaction> bankTransactions) {
		double total = 0d;
		for(final BankTransaction bank : bankTransactions) {
			total += bank.getAmount();
		}
		return total;
	}

	/**
	 * @param bankTransactions
	 * @param month
	 * @return List
	 * ���� 2-5 ����ݳ��� CSV �ļ� ����ϱ�
	 * @deprecated ���� 2-7 Ŭ������ ��� ���� �׷�ȭ {@link chapter2.BankTransactionProcessor#calculateTotalInMonth()}
	 */
	private static List<BankTransaction> selectInMonth(final List<BankTransaction> bankTransactions, final Month month) {
		final List<BankTransaction> bankTransactionsInMonth = new ArrayList<>();
		for(final BankTransaction bankTransaction : bankTransactions) {
			if(bankTransaction.getDate().getMonth() == month) {
				bankTransactionsInMonth.add(bankTransaction);
			}
		}
		return bankTransactionsInMonth;
	}
}
