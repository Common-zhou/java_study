package com.geetest.java8;



import java.util.Optional;

/**
 * @Description:
 * @Author: zhou
 * @Date: 2020/3/9
 * @Time 20:28
 */
public class OptionalTest {
    public static void main(String[] args) {
        Optional<Object> empty = Optional.empty();
        System.out.println(empty.isPresent());

        Optional<String> optional = Optional.of("hello");
        optional.ifPresent(System.out::println);
        System.out.println(optional.isPresent());

        Optional<Object> optional1 = Optional.ofNullable(null);



    }
}
