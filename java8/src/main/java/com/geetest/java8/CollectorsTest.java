package com.geetest.java8;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

/**
 * @Description:
 * @Author: zhou
 * @Date: 2020/3/10
 * @Time 17:49
 */
public class CollectorsTest {
    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");
        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );
//        Map<Integer, List<Transaction>> map = classifyTransaction(transactions);
        Map<Integer, List<Transaction>> map = classifyCollectors(transactions);

        for (Map.Entry<Integer, List<Transaction>> integerListEntry : map.entrySet()) {
            Integer key = integerListEntry.getKey();
            List<Transaction> value = integerListEntry.getValue();
            System.out.println(key);
            value.forEach(System.out::println);
            System.out.println("===========");
        }

        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH));
        System.out.println(menu.stream().collect(Collectors.counting()));
        System.out.println(menu.stream().count());

        //找最大、最小值
        System.out.println(menu.stream().collect(maxBy((a, b) -> a.getCalories() - b.getCalories())));
        menu.stream().max(Comparator.comparing(Dish::getCalories)).ifPresent(System.out::println);
        menu.stream().min(Comparator.comparing(Dish::getCalories)).ifPresent(System.out::println);

        //计算和
        System.out.println(menu.stream().collect(summingInt(Dish::getCalories)));
        System.out.println(menu.stream().collect(averagingDouble(Dish::getCalories)));

        System.out.println("=========================");
        //分组
        Map<Dish.Type, List<Dish>> collect = menu.stream().collect(groupingBy(Dish::getType));
        for (Map.Entry<Dish.Type, List<Dish>> typeListEntry : collect.entrySet()) {
            System.out.println(typeListEntry.getKey());
            System.out.println(typeListEntry.getValue());
        }

        System.out.println("======================");
        //自定义分组
        Map<String, List<Dish>> collect1 = menu.stream().collect(groupingBy(dish -> {
            if (dish.getCalories() < 400) {
                return "HEALTHY";
            } else if (dish.getCalories() < 700) {
                return "NORMAL";
            } else {
                return "FAT";
            }
        }));
        for (Map.Entry<String, List<Dish>> typeListEntry : collect1.entrySet()) {
            System.out.println(typeListEntry.getKey());
            System.out.println(typeListEntry.getValue());
        }

        System.out.println("==========================");

        //首先按照卡路里分组  之后按照类型分组
        Map<Dish.Type, Map<String, List<Dish>>> collect2 = menu.stream().collect(groupingBy(Dish::getType, groupingBy(dish -> {
            if (dish.getCalories() < 400) {
                return "HEALTHY";
            } else if (dish.getCalories() < 700) {
                return "NORMAL";
            } else {
                return "FAT";
            }
        })));
        for (Map.Entry<Dish.Type, Map<String, List<Dish>>> typeMapEntry : collect2.entrySet()) {
            System.out.println(typeMapEntry.getKey());
            System.out.println(typeMapEntry.getValue());
        }


        System.out.println("=====================");
        Map<Dish.Type, Long> collect3 = menu.stream().collect(groupingBy(Dish::getType, counting()));
        for (Map.Entry<Dish.Type, Long> typeLongEntry : collect3.entrySet()) {
            System.out.println(typeLongEntry.getKey());
            System.out.println(typeLongEntry.getValue());
        }


    }

    private static Map<Integer, List<Transaction>> classifyCollectors(List<Transaction> transactions) {
        Map<Integer, List<Transaction>> map =
                transactions.stream().collect(groupingBy(Transaction::getYear));
        return map;
    }

    private static Map<Integer, List<Transaction>> classifyTransaction(List<Transaction> transactionList) {
        Map<Integer, List<Transaction>> map = new HashMap<>();
        for (Transaction transaction : transactionList) {
            List<Transaction> transactions = map.get(transaction.getYear());
            if (transactions == null) {
                transactions = new ArrayList<>();
                map.put(transaction.getYear(), transactions);
            }
            transactions.add(transaction);
        }
        return map;
    }
}
