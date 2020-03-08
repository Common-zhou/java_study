package com.geetest.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * @Description:
 * @Author: zhou
 * @Date: 2020/3/8
 * @Time 10:03
 */
public class StreamTestFlatMap {
    public static void main(String[] args) {
        /**
         * 使用flatMap方法的效果是，各个数组并不是分别映射成一个流，而是映射成流的内容。所
         * 有使用map(Arrays::stream)时生成的单个流都被合并起来，即扁平化为一个流。
         */
        String[] strings = {"Goodbye", "World"};
        List<String> collect = Arrays.stream(strings).map(t -> t.split("")).flatMap(Arrays::stream).distinct().collect(toList());
        System.out.println(collect);

        System.out.println("=====================");
        List<Integer> collect1 = Stream.of(1, 2, 3, 4, 5).map(a -> a * a).collect(toList());
        System.out.println(collect1);

        /**
         * (2) 给定两个数字列表，如何返回所有的数对呢？例如，给定列表[1, 2, 3]和列表[3, 4]，应
         * 该返回[(1, 3), (1, 4), (2, 3), (2, 4), (3, 3), (3, 4)]。为简单起见，你可以用有两个元素的数组来代
         * 表数对。
         */
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<Integer> list2 = Arrays.asList(3, 4);
        List<int[]> collect2 = list1.stream().flatMap(i -> list2.stream().map(j -> new int[]{i, j})).collect(toList());
        collect2.forEach(i -> System.out.println(Arrays.toString(i)));

        System.out.println("==============");
        List<int[]> collect3 = list1.stream().flatMap(i -> list2.stream().filter(j -> (i + j) % 3 == 0).map(j -> new int[]{i, j})).collect(toList());
        collect3.forEach(i-> System.out.println(Arrays.toString(i)));

    }
}
