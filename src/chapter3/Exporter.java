package chapter3;

public interface Exporter {

	/**
	 * @param summaryStatistics
	 * ���� 3-13 Exporter �������̽��� ���� ��
	 * void ��ȯ ������ �ƹ� ������ ���� �ʰ� ����� �ľ��ϱ⵵ ��ƴ�.
	 */
//	void export(SummaryStatistics summaryStatistics);
	
	/**
	 * @param summaryStatistics
	 * @return
	 * ���� 3-14 Exporter �������̽��� ���� ��
	 */
	String export(SummaryStatistics summaryStatistics);
}
