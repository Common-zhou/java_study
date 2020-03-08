package com.geetest.java8;

import java.util.Arrays;

/**
 * @Description:
 * @Author: zhou
 * @Date: 2020/3/8
 * @Time 11:44
 */
public class StreamTestReduce {
    public static void main(String[] args) {
        int[] numbers = new int[]{1, 2, 3, 4, 5, 6};
        int reduce = Arrays.stream(numbers).reduce(0, (a, b) -> a + b);
        System.out.println(reduce);

        int reduce1 = Arrays.stream(numbers).reduce(0, Integer::sum);
        System.out.println(reduce1);

//        int reduce2 = Arrays.stream(numbers).reduce(0, Integer::max);
        int reduce2 = Arrays.stream(numbers).reduce(0, (a, b) -> a > b ? a : b);
        System.out.println(reduce2);

        int reduce3 = Arrays.stream(numbers).map(d -> 1).reduce(0, Integer::sum);
        System.out.println(reduce3);
    }
}
