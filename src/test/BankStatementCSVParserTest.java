package test;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.Month;

import org.junit.Test;

import chapter2.BankStatementCSVParser;
import chapter2.BankStatementParser;
import chapter2.BankTransaction;
import junit.framework.Assert;

public class BankStatementCSVParserTest {

	private final BankStatementParser statementParser = new BankStatementCSVParser();
	
	@Test
	public void shouldParserOneCorrectLine() throws Exception {
		final String line = "30-01-2017,-50,Tesco";
		final BankTransaction result = statementParser.parseFrom(line);
		
		final BankTransaction expected = new BankTransaction(LocalDate.of(2017, Month.JANUARY, 30),-50, "Tesco");
		final double tolerance = 0.0d;
		Assert.assertEquals(expected.getDate(), result.getDate());
		Assert.assertEquals(expected.getAmount(), result.getAmount());
		Assert.assertEquals(expected.getDescription(), result.getDescription());
	}

}
