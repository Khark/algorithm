package lamda;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class lamda_Basic {

	@FunctionalInterface
	interface setNumber{
		int max(int a, int b);
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		setNumber aa = (int a , int b ) -> a >  b ? a : b ;
		aa.max(3, 5);
	
		//Stream<Integer> streamNumber = Stream.generate(Math :: random ).limit(6);
		Random random = new Random();
		IntStream.generate(() -> random.nextInt(45)+1).limit(6).forEach(num->System.out.println("##"+num));
		

		Stream<String> stream = Stream.of("", "","");
		
		List<String> list =
		        Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10" );
		Stream<String> stream3 = list.stream().skip(5);
		stream3.forEach(t -> System.out.println("##"+t) );
		
		
		
	}

}
