package chapter3;

import java.util.ArrayList;
import java.util.List;

/**
 * @author HWA
 * [320] ������ �����ϴ� ������ Ŭ���� Notification
 * ��Ƽ�����̼� ������ �ʹ� ���� ��Ȯ�� ���ܸ� ����ϴ� ��Ȳ�� ������ �ذ�å�� �����Ѵ�. 
 * �� ���Ͽ����� ������ Ŭ������ ������ �����Ѵ�.
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
