package com.geetest.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

/**
 * @Description:
 * @Author: zhou
 * @Date: 2020/3/8
 * @Time 15:41
 */
public class Exercise5_5 {
    public static void main(String[] args) {
        //Trader  交易者
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
        /**
         * (1) 找出2011年发生的所有交易，并按交易额排序（从低到高）。
         * (2) 交易员都在哪些不同的城市工作过？
         * (3) 查找所有来自于剑桥的交易员，并按姓名排序。
         * (4) 返回所有交易员的姓名字符串，按字母顺序排序。
         * (5) 有没有交易员是在米兰工作的？
         * (6) 打印生活在剑桥的交易员的所有交易额。
         * (7) 所有交易中，最高的交易额是多少？
         * (8) 找到交易额最小的交易。
         */

        //(1) 找出2011年发生的所有交易，并按交易额排序（从低到高）。
        List<Transaction> collect1 = transactions.stream()
                .filter(transaction -> transaction.getYear() == 2011).sorted((a, b) -> a.getValue() - b.getValue())
                .collect(toList());
        System.out.println(collect1);

        //(2) 交易员都在哪些不同的城市工作过？
        List<String> collect2 = transactions.stream().map(Transaction::getTrader).map(Trader::getCity).distinct().collect(toList());
        System.out.println(collect2);

        //(3) 查找所有来自于剑桥的交易员，并按姓名排序。
        List<Trader> collect3 = transactions.stream().map(Transaction::getTrader)
                .filter(trader -> "Cambridge".equals(trader.getCity()))
                .distinct()
                .sorted((trader1, trader2) -> trader1.getName().compareTo(trader2.getName()))
                .collect(toList());
        System.out.println(collect3);

        //(4) 返回所有交易员的姓名字符串，按字母顺序排序。
        List<String> collect4 = transactions.stream().map(Transaction::getTrader).map(Trader::getName).distinct().sorted(String::compareTo).collect(toList());
        System.out.println(collect4);

        //(5) 有没有交易员是在米兰工作的？
        List<Trader> collect5 = transactions.stream().map(Transaction::getTrader)
                .distinct()
                .filter((trader -> "Milan".equals(trader.getCity()))).collect(toList());
        System.out.println(collect5);

        //(6) 打印生活在剑桥的交易员的所有交易额。
        Integer sumTransactionInCambridge = transactions.stream().filter((transaction) -> "Cambridge".equals(transaction.getTrader().getName()))
                .map(Transaction::getValue).reduce(0, Integer::sum);
        System.out.println(sumTransactionInCambridge);

        //(7) 所有交易中，最高的交易额是多少？
        Optional<Integer> reduce = transactions.stream().map(a -> a.getValue()).reduce(Integer::max);
        reduce.ifPresent(System.out::println);

        //(8) 找到交易额最小的交易。
        Optional<Integer> reduce2 = transactions.stream().map(a -> a.getValue()).reduce(Integer::min);
        reduce2.ifPresent(System.out::println);
    }
}
