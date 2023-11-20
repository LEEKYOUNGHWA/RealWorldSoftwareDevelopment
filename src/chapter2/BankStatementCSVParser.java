package chapter2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author HWA
 * 예제 2-3 파싱 로직을 추출해 한 클래스로 만듦.
 * [211] 입출금 내역을 파싱하는 인터페이스 정의. 인터페이스 구현
 */
public class BankStatementCSVParser implements BankStatementParser {
	
	private static final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	
	/**
	 * @param line
	 * @return
	 * @deprecated 2-11 {@link BankStatementCSVParser#parseFrom()}
	 */
	private BankTransaction parseFromCSV(final String line){
		final String[] columns = line.split(",");
		
		final LocalDate date = LocalDate.parse(columns[0], DATE_PATTERN);
		final double amount = Double.parseDouble(columns[1]);
		final String description = columns[2];
		
		return new BankTransaction(date, amount, description);
	}
	
	/**
	 * @param lines
	 * @return
	 * @deprecated 2-11 {@link BankStatementCSVParser#parseLinesFrom()}
	 */
	public List<BankTransaction> parseLinesFromCSV(final List<String> lines) {
		final List<BankTransaction> bankTransactions = new ArrayList<>();
		for (final String line : lines) {
			bankTransactions.add(parseFromCSV(line));
		}
		return bankTransactions;
	}

	@Override
	public BankTransaction parseFrom(String line) {
		final String[] columns = line.split(",");
		
		final LocalDate date = LocalDate.parse(columns[0], DATE_PATTERN);
		final double amount = Double.parseDouble(columns[1]);
		final String description = columns[2];
		
		return new BankTransaction(date, amount, description);
	}

	@Override
	public List<BankTransaction> parseLinesFrom(List<String> lines) {
		final List<BankTransaction> bankTransactions = new ArrayList<>();
		for (final String line : lines) {
			bankTransactions.add(parseFromCSV(line));
		}
		return bankTransactions;
	}

}
