package cz.jjaros.funfromboredom.streams;

import org.junit.Test;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class PrimitiveStreamsTest {

    @Test
    public void testCreateIntStream() {
        // The same methods supports java.util.stream.DoubleStream and java.util.stream.LongStream interfaces.

        // int stream with single value
        // result: 5
        IntStream.of(5).forEach(System.out::println);

        // int stream with multiple values
        // result: 12345
        IntStream.of(1, 2, 3, 4, 5).forEach(System.out::print);
        System.out.println();

        // concate two int streams
        // result: 12345
        IntStream.concat(IntStream.of(1, 2, 3, 4), IntStream.of(5)).forEach(System.out::print);
        System.out.println();

        // creates range (exclude end)
        // result: 1234
        IntStream.range(1, 5).forEach(System.out::print);
        System.out.println();

        // creates range (include end)
        // result: 12345
        IntStream.rangeClosed(1, 5).forEach(System.out::print);
        System.out.println();

        // empty int stream
        // result: 0
        System.out.println(IntStream.empty().count());

        // generates five random numbers in range [1..9]
        // result: five random numbers
        IntStream.generate(() ->
                ThreadLocalRandom.current().nextInt(10)
        ).limit(5).forEach(System.out::print);
        System.out.println();

        // creates int stream with builder + add()
        // result: 321
        IntStream.builder()
                .add(3)
                .add(2)
                .add(1)
                .build().forEach(System.out::print);
        System.out.println();

        // creates int stream with builder + accept()
        // result: 321
        IntStream.Builder builder = IntStream.builder();
        builder.accept(3);
        builder.accept(2);
        builder.accept(1);
        builder.build().forEach(System.out::print);
    }

}
