package chapter3;

/**
 * @author HWA
 * 예제 3-12 요약 정보를 저장하는 도메인 객체
 */
public class SummaryStatistics {
	private final double sum;
	private final double max;
	private final double min;
	private final double average;
	
	public SummaryStatistics(double sum, double max, double min, double average) {
		this.sum = sum;
		this.max = max;
		this.min = min;
		this.average = average;
	}

	/**
	 * @return the sum
	 */
	public double getSum() {
		return sum;
	}

	/**
	 * @return the max
	 */
	public double getMax() {
		return max;
	}

	/**
	 * @return the min
	 */
	public double getMin() {
		return min;
	}

	/**
	 * @return the average
	 */
	public double getAverage() {
		return average;
	}
	
	
	
}
