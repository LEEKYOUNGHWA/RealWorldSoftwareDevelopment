package chapter2;

import java.util.List;

/**
 * @author HWA
 * ���� 2-11 ����� ������ �Ľ��ϴ� �������̽� ����
 */
public interface BankStatementParser {
	BankTransaction parseFrom(String line);
	List<BankTransaction> parseLinesFrom(List<String> lines);
}
