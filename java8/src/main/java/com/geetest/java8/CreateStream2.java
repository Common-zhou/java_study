package com.geetest.java8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * @Description: 创建流式的几种方法  主要是学习从文件中创建流式的方法
 * @Author: zhou
 * @Date: 2020/3/8
 * @Time 18:46
 */
public class CreateStream2 {
    public static void main(String[] args) {
        try (Stream<String> stream = Files.lines(Paths.get("D:\\workspace\\javaStudy\\java8\\src\\main\\resources\\test.txt"))) {
            List<String> collect = stream.flatMap(t -> Arrays.stream(t.split(" "))).distinct().collect(toList());
            System.out.println(collect);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
