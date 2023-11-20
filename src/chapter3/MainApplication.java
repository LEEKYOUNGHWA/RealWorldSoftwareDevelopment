package chapter3;

import java.io.IOException;

/**
 * @author HWA
 * [300] 확장된 입출금 내역 분석기 요구사항
 * 1. 특정 입출금 내역을 검색할 수 있는 기능. 예를들어 주어진 날짜 범위 또는 특정 범주의 입출금 내역 얻기.
 * 2. 검색 결과의 요약 통계를 텍스트, HTML 등 다양한 형식으로 만들기
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
