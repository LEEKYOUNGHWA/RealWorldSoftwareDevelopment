package chapter3;

/**
 * @author HWA
 * ���� 3-15 Exporter �������̽� ����
 */
public class HtmlExporter implements Exporter {

	@Override
	public String export(SummaryStatistics summaryStatistics) {
		
		String result = "blahblah html source ġ�� ����";
		result += summaryStatistics.getSum();
		result += summaryStatistics.getMax();
		result += summaryStatistics.getMin();
		return result;
	}
}
