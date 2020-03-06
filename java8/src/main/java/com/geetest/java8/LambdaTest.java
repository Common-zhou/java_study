package com.geetest.java8;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @Description:
 * @Author: zhou
 * @Date: 2020/3/6
 * @Time 21:00
 */
public class LambdaTest {
    public static void main(String[] args) {
        /**
         * Function		有进有出
         * Concumer		有进无出
         * Supplier		无进有出
         * Predicate	有进有出(出为boolean)
         */
        Function<Integer, Integer> functionTest = (a) -> a + 45;
        Integer apply = functionTest.apply(15);
        System.out.println(apply);

        Predicate<String> predicate = a -> "test".equals(a);
        System.out.println(predicate.test("test"));

        Supplier<String> supplier = ()->{return "hello world";};
        System.out.println(supplier.get());

        Consumer<String> consumer = (in)->{
            System.out.println(in);
        };

        consumer.accept("hello");
    }
}
