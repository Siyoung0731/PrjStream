package ex01;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamTest03 {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
		System.out.println(numbers);
		// reduce() 메서드는 스트림에서 연산할 수 있음
		//Integer::sum - Integer.sum(int a, int b) 호출
		int sum1 = numbers.stream().reduce(0, Integer::sum); // Integer::sum -> 정적 메소드 호출 
		// Integer 클래스의 정적 메서드 sum(int a, int b) : Integer.sum(int a, int b)
		System.out.println(sum1);
		
		List<Integer> list = Arrays.asList(6, 7, 8, 9, 10);
		// 람다식 (a,b) -> a + b
		int sum2 = list.stream().reduce(0, (a,b) -> a + b); // 초기값 : 0, 람다식
		System.out.println(sum2);
	}

}
