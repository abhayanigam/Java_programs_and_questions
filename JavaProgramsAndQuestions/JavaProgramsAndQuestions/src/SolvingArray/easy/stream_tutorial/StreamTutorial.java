package SolvingArray.easy.stream_tutorial;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamTutorial {
    public static void main(String[] args){

        // Using List
        List<String> list = Arrays.asList("A","B","C");
        Stream<String> stream = list.stream();

        System.out.println(stream.toList());

        // Using Array
        String[] array = {"A", "B" , "C"};
        Stream<String> stream1 = Arrays.stream(array);

        System.out.println("Stream using Array : " + Arrays.toString(stream1.toArray()));

        // Stream of
        Stream<String> stream2 = Stream.of("A", "B", "C");
        System.out.println("Stream of : " + Arrays.toString(stream2.toArray()));

        // Stream iterator
        Stream<Integer> stream3 = Stream.iterate(0,n-> n+1);
        System.out.println("Stream Iterator : " + stream3.toList());

        stream.sorted((a, b) -> a.length() - b.length());

    }
}
