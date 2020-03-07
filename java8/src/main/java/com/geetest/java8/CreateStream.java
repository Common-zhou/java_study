package com.geetest.java8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

/**
 * @Description:
 * @Author: zhou
 * @Date: 2020/3/7
 * @Time 11:45
 */
public class CreateStream {
    public static void main(String[] args) {
//        createStreamFromCollection().forEach(System.out::println);
//        createStreamFromValues().forEach(System.out::println);
//        createStreamFromArrays().forEach(System.out::println);
//        createStreamFromFile();
//        createStreamFromIterator().forEach(System.out::println);
        createStreamFromGenerate().forEach(System.out::println);
    }

    private static Stream<String> createStreamFromCollection() {
        List<String> stringList = Arrays.asList("hello", "world", "zhangsan", "zhoubing");
        return stringList.stream();
    }

    private static Stream<String> createStreamFromValues() {
        return Stream.of("hello", "world", "zhangsan", "zhoubing");
    }

    private static Stream<String> createStreamFromArrays(){
        return Arrays.stream(new String[]{"hello", "world", "zhangsan", "zhoubing"});
    }

    private static Stream<String> createStreamFromFile(){
        Path path = Paths.get("D:\\workspace\\javaStudy\\java8\\src\\main\\java\\com\\geetest\\java8\\CreateStream.java");
        try(Stream<String> stringStream = Files.lines(path)){
            stringStream.forEach(System.out::println);
            return stringStream;
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    private static Stream<Integer> createStreamFromIterator(){
        Stream<Integer> iterate = Stream.iterate(10, n -> n + 2).limit(10);
        return iterate;
    }

    private static Stream<Double> createStreamFromGenerate(){
        Stream<Double> generate = Stream.generate(Math::random);
        return generate;
    }
}
