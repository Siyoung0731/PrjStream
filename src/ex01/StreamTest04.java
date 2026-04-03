package ex01;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Person {
	private String name;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
}

public class StreamTest04 {

	public static void main(String[] args) {
		
		//int[]
		// -> IntStream : Arrays.stream(arr) 	int type 의 Stream
		// -> Stream<Integer> : .boxed() 		int -> Integer 변환 : primitive type => class type
		// -> List<Integer> : .toList() 		
		
		// 1. int[] 배열
		int [] arr = {1,2,3,4,5};
		
		// 2. int[] -> List<Integer> 
		List<Integer> list = Arrays.stream(arr).boxed().toList();
		System.out.println("원본 List: " + list);
		
		// 3) 전체 합계 
		// mapToInt : Stream 안에 있는 내용을 하나씩 꺼내서 변경 작업
		// Integer::intValue : Integer -> int
		// Integer.valueOf(int)			 : int -> Integer
		int sum = list.stream().mapToInt(Integer::intValue).sum(); 
		System.out.println("합계 sum: " + sum);
		
		// 4) filter : 짝수만 추출
		List<Integer> evenList = list.stream().filter(n -> n % 2==0).toList();
		System.out.println("짝수 목록" + evenList);
		
		// 5) map : 모든 데이터를 10배로 변환
		List<Integer> mappedList = list.stream().map(n -> n * 10).toList(); // stream list -> arraylist 변환
		System.out.println("배열 10배: " + mappedList);
		
		// 6) filter + map + sum 
		int result = list.stream()
				.filter(n -> n >= 3)
				.map(n -> n * n)
				.mapToInt(Integer::intValue) // sum() 할려고 Integer -> int
				.sum(); // 결과는 int 
		
		// 6-1) 평균값
		double result1 = list.stream()
				.filter(n -> n >= 3)
				.map(n -> n * n)
				.mapToDouble(Integer::doubleValue) // 50.0
				.average() //50.0 / 3.0
				.orElse(0.0); 
		// Optional<Double> : 결과가 null 될 수 없음
		// 만약 null -> .orElse(0.0) 추가해서 0.0으로 만들어줘야함 
		System.out.println("결과값: " + result);
		System.out.println("결과값: " + result1);
		
		// 7) forEach()
		//Stream<String> stream = Stream.of("apple", "banana", "cherry", "durian");
//		stream.forEach(fruit -> System.out.println(fruit.toUpperCase()));
		String[] fruits = {"cherry", "banana","apple", "durian"};
		List<String> fruitList = Arrays.asList(fruits);
		fruitList.stream().sorted().forEach(fruit -> System.out.println(fruit.toUpperCase() + " "));
		
		// 8) distinct
		int[] nums = {10, 10, 30, 30, 40, 40, 20, 20};
		List<Integer> numList = Arrays.stream(nums).distinct().boxed().toList();
		System.out.println(numList);
		
		// 9) 
		List<Person> people = Arrays.asList(
				new Person("John", 25),
				new Person("Jane", 30),
				new Person("Bob", 25),
				new Person("Alice", 30)
				);
		System.out.println();
		Map<Integer, List<Person>> rs = people.stream().collect(Collectors.groupingBy(Person::getAge));
		System.out.println(rs);
	}

}
