package lamda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.IntConsumer;
import java.util.function.LongConsumer;
import java.util.function.ObjDoubleConsumer;
import java.util.function.ObjIntConsumer;
import java.util.function.ObjLongConsumer;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class lamda_Basic {

	@FunctionalInterface
	interface setNumber{
		int max(int a, int b);
	}
	
	//	함수형 인터페이스 
	// 매개변가 없고,리턴값이 없는 람다식 ->  x 
	// 매개변수가 있고,리턴값이 없는 람다식 -> Consumer<T>
	// 매개변수가 없고, 리턴값이 있는 람다식 -> Supplier<T>
	// 매개변수가 있고,리턴값이 있는 람다식  - >Function<T, R>  매개변수 T 반환값 R
	// 매개변수가 있고,리턴값이 있는 람다식  - >Operator 매개변수를 넣으면 연산해서 반환한 
	// 매개변수가 있고,리턴값이 있는 람다식  - >Predicate 매개변수를 조사 한 후 논리 값 변
	
	
	 
	// function 인터페이스 
	
	// Consumer 매개값 o 리턴값 x 
	Consumer<String>c1 = a->System.out.println("##입력값?"+a);
	BiConsumer<String, Integer> c2 =  (a, b) -> System.out.println("입력값1 : "+ a+ " 입력값2 : "+ b);
    
    IntConsumer c3 = a -> System.out.println("입력값 : "+ a);
    
    DoubleConsumer c4 = a -> System.out.println("입력값 : "+ a);
    
    LongConsumer c5 = a -> System.out.println("입력값 : "+ a);
    
    ObjIntConsumer<Student> c6 = (a, b) -> System.out.println("이름 : "+ a.name+ " 숫자 : "+ b);
    
    ObjDoubleConsumer<Student> c7 = (a, b) -> System.out.println("이름 : "+ a.name+ " 숫자 : "+ b);
    
    ObjLongConsumer<Student> c8 = (a, b) -> System.out.println("이름 : "+ a.name+ " 숫자 : "+ b);


    
    @FunctionalInterface
    interface LamdaTest{
    	int min(int x, int y);
    }
    
    @FunctionalInterface
    interface FunctionalTest<T, R>{

    	R apply(T t);
    
    	
    }
    
    class Student{
        private String name;
        Student(String name){this.name = name;};
    }

	// f
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		// 매개변수 x 반환값
		Supplier<List<lamda_to>> s4= ()->{
			List<lamda_to> list = new ArrayList<lamda_to>();
			list.add(new lamda_to("111",10));
			list.add(new lamda_to("222",20));
			list.add(new lamda_to("333",30));
			
			return list;
		};
		
		
		for(lamda_to to : s4.get()) {
			System.out.println("##"+to.getName()+"##"+to.getAge());
		}
		
		LamdaTest test = (x,y) -> x < y ? x:y;
		System.err.println(test.min(3, 4));
		
		
		Consumer<Integer> c3 = count -> {

			for (int i = 0; i < count; i++) {

				System.out.println(i);

			}

		};

		c3.accept(10); 
		
		Consumer<String> consumer = str -> System.out.println(str+"8");
		consumer.accept("java");
		consumer.andThen(consumer);

		
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
