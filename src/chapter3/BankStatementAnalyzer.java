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
 * 모든 거래 내역의 합 계산하기
 * 예제 2-1 모든 거래내역의 합 계산하기
 * 예제 2-2 1월 입출금 내역 합계 계산하기
 * 예제 2-5 입출금내역 CSV 파서 사용하기
 * 예제 2-8 BankStatementProcessor 클래스를 이용해 입출금 내역 목록 처리
 * 예제 2-12 BankStatementAnalyzer 에서 특정 파서와의 결합 제거
 */
public class BankStatementAnalyzer {
	
	private static final String RESOURCES ="src/main/resources/";
	
	/**
	 * 예제 2-12 BankStatementAnalyzer 에서 특정 파서와의 결합 제거
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
	 * 예제 2-8 BankStatementProcessor 클래스를 이용해 입출금 내역 목록 처리
	 * 예제 3-7 특정 BankTransactionFilter 구현으로 findTransactions()호출
	 * 예제 3-8 람다 표현식으로 BankTransactionFilter 구하기
	 */
	private static void collectSummary(final BankTransactionProcessor bankStatementProcessor) {
		System.out.println("The total for all transaction is " + bankStatementProcessor.calculateTotalAmount());
		System.out.println("Transactions in January " + bankStatementProcessor.calculateTotalInMonth(Month.JANUARY));
		System.out.println("Transactions in Fabuary " + bankStatementProcessor.calculateTotalInMonth(Month.FEBRUARY));
		System.out.println("The total salary received is " + bankStatementProcessor.calculateTotalForCategory("Salary"));
		System.out.println("예제 3-7 " + bankStatementProcessor.findTransactions(new BankTransactionIsInFabuaryAndExpensive()));
		System.out.println("예제 3-8 " + bankStatementProcessor.findTransactions(bankTransaction -> 
			bankTransaction.getDate().getMonth() == Month.FEBRUARY && bankTransaction.getAmount()>=1000)
		);
	}

	/**
	 * @param bankTransactions
	 * @return double
	 * 예제 2-5 입출금내역 CSV 파서 사용하기
	 * @deprecated 예제 2-7 클래스의 계산 연산 그룹화 {@link chapter2.BankTransactionProcessor#calculateTotalAmount()}
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
	 * 예제 2-5 입출금내역 CSV 파서 사용하기
	 * @deprecated 예제 2-7 클래스의 계산 연산 그룹화 {@link chapter2.BankTransactionProcessor#calculateTotalInMonth()}
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
