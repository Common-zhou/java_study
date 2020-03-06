package com.geetest.java8;

import java.util.Comparator;

/**
 * @Description:
 * @Author: zhou
 * @Date: 2020/3/6
 * @Time 21:47
 */
public class ComparatorTest {
    public static void main(String[] args) {
        Comparator<Apple> comparator = (apple1, apple2)->{
            return apple1.getColor().compareTo(apple2.getColor());
        };

        Apple yellow = new Apple("yellow", 150);
        Apple green = new Apple("green", 150);

        int compare = comparator.compare(yellow, green);
        System.out.println(compare);

    }
}
