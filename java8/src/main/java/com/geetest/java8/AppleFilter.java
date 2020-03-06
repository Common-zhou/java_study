package com.geetest.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description: 如果有一些苹果  要对其进行筛选 比如按照颜色 按照重量
 * 但是需求变化的很快
 * @Author: zhou
 * @Date: 2020/3/6
 * @Time 17:24
 */
public class AppleFilter {
    /**
     * 1.首先  只想要绿色的苹果
     */
    public static List<Apple> filterGreenApple(List<Apple> apples) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : apples) {
            if ("green".equals(apple.getColor())){
                result.add(apple);
            }
        }
        return result;
    }

    /**
     * 2.如果要寻找黄色的苹果 可以写这种方法  但是不好
     * @param apples
     * @return
     */
    public static List<Apple> filterYellowApple(List<Apple> apples) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : apples) {
            if ("yellow".equals(apple.getColor())){
                result.add(apple);
            }
        }
        return result;
    }

    /**
     * 3.以上两种可以合到一起
     * @param apples
     * @return
     */
    public static List<Apple> filterColorApple(List<Apple> apples, String color) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : apples) {
            if (color.equals(apple.getColor())){
                result.add(apple);
            }
        }
        return result;
    }


    public static void main(String[] args) {
//        List<Apple> apples = filterGreenApple(Arrays.asList(new Apple("green", 150), new Apple("yellow", 190), new Apple("green", 180)));
//        System.out.println(apples);

//        List<Apple> apples = filterYellowApple(Arrays.asList(new Apple("green", 150), new Apple("yellow", 190), new Apple("green", 180)));
//        System.out.println(apples);

       List<Apple> apples = filterColorApple(Arrays.asList(new Apple("green", 150), new Apple("yellow", 190), new Apple("green", 180)), "green");
        System.out.println(apples);


    }
}
