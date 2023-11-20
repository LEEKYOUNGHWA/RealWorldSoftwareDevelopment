package chapter2;

import java.io.IOException;

/**
 * @author HWA
 * [200] ����� ���� �м��� �䱸����
 * 1. ���� ����� ������ �� ���԰� ������ ���� ���ΰ�? ����� ����ΰ� �����ΰ�?
 * Ư�� �޿� �� ���� ����� ������ �߻��ߴ°�?
 * ������ ���� ���� ���� 10���� �����ΰ�?
 * ���� ���� ���� �Һ��ϴ� �׸��� �����ΰ�?
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
