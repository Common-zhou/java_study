package com.geetest.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

/**
 * @Description:
 * @Author: zhou
 * @Date: 2020/3/7
 * @Time 0:48
 */
public class LambdaUsage2 {

    public static List<Apple> filterByPredicate(List<Apple> apples, Predicate<Apple> predicate) {
        List<Apple> applesList = new ArrayList<>();
        for (Apple apple : apples) {
            if (predicate.test(apple)) {
                applesList.add(apple);
            }
        }
        return applesList;
    }

    public static List<Apple> filterByBiPredicate(List<Apple> apples, BiPredicate<String, Integer> predicate) {
        List<Apple> applesList = new ArrayList<>();
        for (Apple apple : apples) {
            if (predicate.test(apple.getColor(), apple.getWeight())) {
                applesList.add(apple);
            }
        }
        return applesList;
    }


    public static void main(String[] args) {
        List<Apple> appleList = Arrays.asList(new Apple("green", 120),
                new Apple("yellow", 150),
                new Apple("green", 190));

//        List<Apple> byPredicate = filterByPredicate(appleList, (apple) -> "green".equals(apple.getColor()));
//        System.out.println(byPredicate);
//        List<Apple> byBiPredicate = filterByBiPredicate(appleList, (c, w) -> "green".equals(c) && w > 120);
//        System.out.println(byBiPredicate);


    }
}
