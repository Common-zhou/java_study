package com.geetest.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * @Description:    编写一个prettyPrintApple方法，它接受一个Apple的List，并可以对它参数化，以
 *                  多种方式根据苹果生成一个String输出（有点儿像多个可定制的toString方法）。例如，你
 *                  可以告诉prettyPrintApple 方法， 只打印每个苹果的重量。此外， 你可以让
 *                  prettyPrintApple方法分别打印每个苹果，然后说明它是重的还是轻的。解决方案和我们
 *                  前面讨论的筛选的例子类似。为了帮你上手，我们提供了prettyPrintApple方法的一个粗
 *                  略的框架：
 *
 * @Author: zhou
 * @Date: 2020/3/7
 * @Time 15:41
 */
public class Test2_1 {
    public static void prettyPrintApple(List<Apple> inventory, Function<Apple, Object> function){
        for(Apple apple: inventory) {
            Object output = function.apply(apple);
            System.out.println(output);
        }
    }

    public static void main(String[] args) {
        List<Apple> apples = Arrays.asList(new Apple("green", 150), new Apple("yellow", 190), new Apple("green", 180));

        prettyPrintApple(apples, (apple)->apple.getWeight());
        prettyPrintApple(apples, Apple::getWeight);
    }
}
