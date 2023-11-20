package chapter3;

import java.util.ArrayList;
import java.util.List;

/**
 * @author HWA
 * [320] 오류를 수집하는 도메인 클래스 Notification
 * 노티피케이션 패턴은 너무 많은 미확인 예외를 사용하는 상황에 적합한 해결책을 제공한다. 
 * 이 패턴에서는 도메인 클래스로 오류를 수집한다.
 */
public class Notification {

	private final List<String> errors = new ArrayList<>();
	
	public void addError(final String message) {
		errors.add(message);
	}
	
	public boolean hasErrors(){
		return !errors.isEmpty();
	}
	
	public String errorMessage(){
		return errors.toString();
	}
	
	public List<String> getErrors(){
		return this.errors;
	}
}
