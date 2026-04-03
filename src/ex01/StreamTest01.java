package ex01;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamTest01 {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("grape", "apple", "orange", "banana", "cherry");
		Optional<String> result = 
				list.stream().filter(s -> s.startsWith("a")).findFirst(); 
		if (result.isPresent()) {
			System.out.println(result.get());
		}
	}

}
