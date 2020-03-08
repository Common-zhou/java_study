package com.geetest.java8;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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
        boolean b = boxed.allMatch((a) -> a > 800);
        System.out.println(b);

    }
}
