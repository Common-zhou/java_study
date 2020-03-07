package com.geetest.java8;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * @Description:
 * @Author: zhou
 * @Date: 2020/3/7
 * @Time 9:37
 */
public class MethodReference {
    public static void main(String[] args) {
        Consumer<String> consumer = string -> {
            System.out.println(string);
        };
        Consumer<String> consumer2 = string -> System.out.println(string);
        useConsumer(consumer, "Hello Zhou");
        System.out.println("======================");
        useConsumer(System.out::println, "Hello Pang");

        System.out.println("======================");

        Comparator<Apple> comparator1 = new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getColor().compareTo(o2.getColor());
            }
        };

        Comparator<Apple> comparator2 = (o1,o2)-> o1.getColor().compareTo(o2.getColor());



    }

    public static <T> void useConsumer(Consumer<T> consumer, T t) {
        consumer.accept(t);
        consumer.accept(t);

    }
}
