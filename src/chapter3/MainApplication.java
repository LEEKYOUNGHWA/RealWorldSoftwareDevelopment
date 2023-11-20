package chapter3;

import java.io.IOException;

/**
 * @author HWA
 * [300] Ȯ��� ����� ���� �м��� �䱸����
 * 1. Ư�� ����� ������ �˻��� �� �ִ� ���. ������� �־��� ��¥ ���� �Ǵ� Ư�� ������ ����� ���� ���.
 * 2. �˻� ����� ��� ��踦 �ؽ�Ʈ, HTML �� �پ��� �������� �����
 */
public class MainApplication {

	/**
	 * @param args
	 * @throws IOException
	 * ���� 2-13 ���� ���� ���α׷�
	 * bankStatementAnalyzer Ŭ������ ���̻� Ư�� ������ ���ӵ��� ����.
	 */
	public static void main(String[] args) throws IOException {
		final BankStatementAnalyzer bankStatementAnalyzer = new BankStatementAnalyzer();
		final BankStatementParser bankStatementParser = new BankStatementCSVParser();
		
		bankStatementAnalyzer.analyze(args[0], bankStatementParser);	

	}

}
