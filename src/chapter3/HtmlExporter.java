package chapter3;

/**
 * @author HWA
 * 예제 3-15 Exporter 인터페이스 구현
 */
public class HtmlExporter implements Exporter {

	@Override
	public String export(SummaryStatistics summaryStatistics) {
		
		String result = "blahblah html source 치기 귀찮";
		result += summaryStatistics.getSum();
		result += summaryStatistics.getMax();
		result += summaryStatistics.getMin();
		return result;
	}
}
