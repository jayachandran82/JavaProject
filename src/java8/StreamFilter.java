package java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.*;

public class StreamFilter {
	public static void main(String[] args) {
		List<String> ls = new ArrayList<>();
		ls.add("Jayachandran");
		ls.add("KUMAR");
		ls.add("SIVA");
		ls.add("Prem");
		ls.add("Jayathi");
		ls.add("Priya");
		ls.add("murugan");
		ls.add("Mani");

		// Map<String , Long> map=
		// ls.stream().map(String::toLowerCase).collect(Collectors.groupingBy(st ->
		// st,Collectors.counting()));
		// map.entrySet().forEach(s->System.out.println("Key and Value
		// "+s.getKey()+":"+s.getValue()));

		List<String> filtResult = ls.stream().filter(s -> s.startsWith("J")).collect(Collectors.toList());
		filtResult.forEach(System.out::println);

		// findAny() and orElse()
		String findAnyorElse = ls.stream().filter(s -> s.startsWith("Ma")).findAny().orElse("No Data Found");
		System.out.println("findAny() orElse()    : " + findAnyorElse);

		ls.stream().sorted((s1, s2) -> {
			System.out.printf("sort: %s; %s\n", s1, s2);
			return s1.compareTo(s2);
		}).map(s -> s.toUpperCase()).forEach(s -> System.out.println("forEach: " + s));

	}

}
