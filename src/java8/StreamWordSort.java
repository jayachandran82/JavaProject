package java8;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamWordSort {
	public static void main(String[] args) {

		String arg = "Hello alan i am here where are you and what are you doing hello are you there";

		/*Map<String, Long> result = Stream.of(arg.split(" ")).map(String::toLowerCase)
				.collect(Collectors.groupingBy(c -> c, Collectors.counting()));
		result.entrySet().forEach(e -> System.out.println(e.getKey() + ":" + e.getValue()));*/

		/*String[] names = { "Sam", "Pamela", "Dave", "Pascal", "Erik", "Enn"};
		List<String> nameList = IntStream.range(0, names.length).filter(i -> names[i].length() <= i)
				.mapToObj(i -> names[i]).collect(toList());
		nameList.forEach(e->System.out.println(e));*/
		
		Map<String, Long> strSplit =Stream.of(arg.split(" ")).map(String::toLowerCase).
				collect(Collectors.groupingBy(st -> st,Collectors.counting()));
		//strSplit.entrySet().forEach(e-> System.out.println("Before Removing Key/Value : "+e.getKey()+"  : "+e.getValue()));
		String[] removeEle = {"are","you","and"};
		for(String str : removeEle) {
			if(strSplit.containsKey(str)) {
				strSplit.remove(str);
			}
		}
		strSplit.entrySet().forEach(e-> System.out.println("Key/Value : "+e.getKey()+"  : "+e.getValue()));
		
		Map<String, Long> result = strSplit.entrySet().stream()
				.filter(map -> map.getValue() >1)
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
		System.out.println(" Result : ");
		result.entrySet().forEach(e-> System.out.println("Key/Value : "+e.getKey()+"  : "+e.getValue()));
	}
	 
}
