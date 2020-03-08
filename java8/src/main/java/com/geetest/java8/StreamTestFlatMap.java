package com.geetest.java8;

import java.util.Arrays;
import java.util.List;

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
    }
}
