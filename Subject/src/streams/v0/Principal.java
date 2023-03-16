package streams.v0;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Principal {
	public static void main(String[] args) {
		//FORMAS DE CREAR STREAMS:
		
		Stream<String> streamEmpty = Stream.empty();
		
		List<String> collection = Arrays.asList("a", "b", "c");
		Stream<String> streamOfCollection = collection.stream();
		
		Stream<String> streamOfArray = Stream.of("a", "b", "c");
		
		//------con array
		String[] arr = new String[]{"a", "b", "c"};
		Stream<String> streamOfArrayFull = Arrays.stream(arr);
		Stream<String> streamOfArrayPart = Arrays.stream(arr, 1, 3);
		
		//------streamBuilder
		Stream<String> streamBuilder =
				  Stream.<String>builder().add("a").add("b").add("c").build();
		
		//------stream de streams: stream.generate
		Stream<String> streamGenerated =
				  Stream.generate(() -> "element").limit(10); //lambda suplier
		
		//------stream.iterate
		Stream<Integer> streamIterated = 
				Stream.iterate(40, n -> n + 2).limit(20); //crea veinte elementos desde el 40 de 2 en 2
		
		//------primitivos
		IntStream intStream = IntStream.range(1, 5);
		LongStream longStream = LongStream.rangeClosed(1, 5);
		//longStream.forEach(System.out::println);
		
		IntSummaryStatistics intSum = intStream.summaryStatistics();
		//System.out.println(intSum.getCount()); //obtiene la cuenta
		//System.out.println(intSum.getAverage());
		//System.out.println(intSum.getMax()); //obtiene el valor máximo
	
		//-------con random- regresa un double entre 0 y 1
		Random random = new Random();
		DoubleStream doubleStream = random.doubles(1.0,5.0).limit(5);
		//doubleStream.forEach(System.out::println);
		
		//-------char
		IntStream streamOfChars = "abc".chars(); //regresa los valores del codigo asqk
		//streamOfChars.forEach(System.out::println);
		
		//-------- Stream de strings
		Stream<String> streamOfString =
				  Pattern.compile(", ").splitAsStream("a, b, c");
		streamOfString.forEach(System.out::println);
		
		
	}
	
	
	public Stream<String> streamOf(List<String> list){
		return list == null
				|| list.isEmpty() ? Stream.empty() : list.stream();
	}
	
}
