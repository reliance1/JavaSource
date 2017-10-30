package service;

public class CalculateService {
	private static CalculateService instance;

	private CalculateService() {
	}

	public static CalculateService getInstance() {
		if (instance == null)
			instance = new CalculateService();
		return instance;
	}
	// 사칙연산 계산을 처리하는 메소드 - Business logic
	//UI하고 BL을 분리
	public String calculate(int value1, String cal, int value2) {
		int result = 0;//계산결과를 담을 변수.
		if (cal.equals("+")) {
			result = value1 + value2;
		} else if (cal.equals("-")) {
			result = value1 - value2;
		} else if (cal.equals("*")) {
			result = value1 * value2;
		} else if (cal.equals("/")) {
			result = value1 / value2;
		}
		return String.format("%d %s %d = %d", value1, cal, value2, result);
	}
}
