package com.geetest.java8;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * @Description:
 * @Author: zhou
 * @Date: 2020/3/8
 * @Time 16:55
 */
public class NumbericStream {
    public static void main(String[] args) {
        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH));

        IntStream intStream = menu.stream().mapToInt(Dish::getCalories);
        int sum = intStream.sum();
        OptionalInt max = menu.stream().mapToInt(Dish::getCalories).max();
        OptionalInt min = menu.stream().mapToInt(Dish::getCalories).min();
        OptionalDouble average = menu.stream().mapToInt(Dish::getCalories).average();

        System.out.println("sum = " + sum);
        max.ifPresent(System.out::println);
        min.ifPresent(System.out::println);
        average.ifPresent(System.out::println);

        Stream<Integer> boxed = menu.stream().mapToInt(Dish::getCalories).boxed();
        boolean match = boxed.allMatch((a) -> a > 800);
        System.out.println(match);

        IntStream.range(1, 100).forEach(System.out::println);
        System.out.println("==========================");

        int a = 9;
        List<int[]> collect = IntStream.rangeClosed(1, 100).filter((b) -> Math.sqrt(a * a + b * b) % 1 == 0).boxed().map((b) -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)}).collect(toList());
        collect.forEach((element) -> System.out.println(Arrays.toString(element)));
        System.out.println("==========================");

        List<int[]> collect1 = IntStream.rangeClosed(1, 100).boxed().flatMap(x ->
                IntStream.rangeClosed(x, 100).filter((y) -> Math.sqrt(x * x + y * y) % 1 == 0)
                        .mapToObj(y -> new int[]{x, y, (int) Math.sqrt(x * x + y * y)})).collect(toList());

        collect1.forEach(x -> System.out.println(Arrays.toString(x)));


    }
}
