package com.geetest.java8;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * @Description:
 * @Author: zhou
 * @Date: 2020/3/8
 * @Time 11:25
 */
public class StreamTestFind {
    public static void main(String[] args) {
        //findAny
        Optional<Integer> any = Stream.of(1, 2, 3).findAny();
        System.out.println(any.isPresent());
        System.out.println(any.orElse(18));

        any.ifPresent(t -> System.out.println(t));
        System.out.println(any.get());

        Optional<Integer> first = Stream.of(1, 2, 3).filter(i -> i > 2).findFirst();
        System.out.println(first.isPresent());
        first.ifPresent(t -> System.out.println("This first exists"));
        System.out.println(first.orElse(18));
    }
}
