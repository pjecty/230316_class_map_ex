package ex;

import java.util.*;

public class MapExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Map<Integer, String> map1 = new HashMap<>();
		// 맵이라는 인터페이스 타입에 Map1이라는 객체를 생성하는데
		// 생성자는 HashMap이라는 생성자를 선언을 했다.
		List<String> list1 = new ArrayList<>();

		map1.put(1, "안녕하세요");
		System.out.println(map1.put(2, "hello"));
		System.out.println(map1.put(2, "ㅎㅎㅎㅎㅎㅎㅎ"));
		System.out.println(map1.get(2));


		String val1 = map1.get(1);
		System.out.println(val1);
		
		map1.remove(2);
		System.out.println(map1.get(2));

	}

}
