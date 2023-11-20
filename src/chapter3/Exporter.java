package chapter3;

public interface Exporter {

	/**
	 * @param summaryStatistics
	 * 예제 3-13 Exporter 인터페이스의 나쁜 예
	 * void 반환 형식은 아무 도움이 되지 않고 기능을 파악하기도 어렵다.
	 */
//	void export(SummaryStatistics summaryStatistics);
	
	/**
	 * @param summaryStatistics
	 * @return
	 * 예제 3-14 Exporter 인터페이스의 좋은 예
	 */
	String export(SummaryStatistics summaryStatistics);
}
