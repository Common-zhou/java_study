package com.geetest.java8;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * @Description:
 * @Author: zhou
 * @Date: 2020/3/7
 * @Time 16:32
 */
public class StreamTest {
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
        List<String> collect = menu.stream().filter((dish) -> {
            System.out.println("Filter stream");
            return dish.getCalories() > 300;
        }).map((dish -> {
            System.out.println("map stream");
            return dish.getName();
        })).limit(3).collect(toList());
        System.out.println(collect);
    }
}
