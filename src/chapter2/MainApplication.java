package chapter2;

import java.io.IOException;

/**
 * @author HWA
 * [200] 입출금 내역 분석기 요구사항
 * 1. 은행 입출금 내역의 총 수입과 지출은 각각 얼마인가? 결과가 양수인가 음수인가?
 * 특정 달엔 몇 건의 입출금 내역이 발생했는가?
 * 지출이 가장 높은 상위 10건은 무엇인가?
 * 돈을 가장 많이 소비하는 항목은 무엇인가?
 */
public class MainApplication {

	/**
	 * @param args
	 * @throws IOException
	 * 예제 2-13 메인 응용 프로그램
	 * bankStatementAnalyzer 클래스가 더이상 특정 구현에 종속되지 않음.
	 */
	public static void main(String[] args) throws IOException {
		final BankStatementAnalyzer bankStatementAnalyzer = new BankStatementAnalyzer();
		final BankStatementParser bankStatementParser = new BankStatementCSVParser();
		
		bankStatementAnalyzer.analyze(args[0], bankStatementParser);	

	}

}
