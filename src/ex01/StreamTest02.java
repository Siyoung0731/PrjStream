package ex01;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest02 {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("apple", "banana", "cherry");
		// collect() : 스트림에서 추출한 요소를 컬렉션에 다시 수집
		// Collectors.toList() : 리스트로 수집
		List<String> result = list.stream().filter(s -> s.contains("a")).collect(Collectors.toList());
		System.out.println(result);
	}

}
