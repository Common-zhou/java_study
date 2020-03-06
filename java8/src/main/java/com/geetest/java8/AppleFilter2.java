package com.geetest.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description: 对苹果筛分的另一种方法  一种设计模式(策略设计模式)
 * @Author: zhou
 * @Date: 2020/3/6
 * @Time 17:48
 */
public class AppleFilter2 {
    interface Filter {
        boolean check(Apple apple);
    }

    public static List<Apple> filterApple(List<Apple> apples, Filter filter) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : apples) {
            if (filter.check(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    /**
     * 有的既想要颜色作为判断标准  也想要重量作为判断标准
     */
    public static void main(String[] args) {
//        //匿名内部类
//        List<Apple> apples = filterApple(Arrays.asList(new Apple("green", 150), new Apple("yellow", 190), new Apple("green", 180)), new Filter() {
//            @Override
//            public boolean check(Apple apple) {
//                return "green".equals(apple.getColor()) && apple.getWeight() > 150;
//            }
//        });
//        System.out.println(apples);

        //lambda表达式
        /**
         * 接口中必须 有且只有一个方法
         */
        List<Apple> appleList = Arrays.asList(new Apple("green", 150), new Apple("yellow", 190), new Apple("green", 180));
        List<Apple> apples = filterApple(appleList, (apple) -> { return "green".equals(apple.getColor()) && apple.getWeight() > 150; });
        System.out.println(apples);

    }

}
