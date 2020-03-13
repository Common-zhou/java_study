package com.geetest.java8;

import java.util.*;
import java.util.concurrent.ConcurrentMap;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

/**
 * @Description:
 * @Author: zhou
 * @Date: 2020/3/10
 * @Time 23:16
 */
public class CollectorsTest2 {
    static List<Dish> menu = Arrays.asList(
            new Dish("pork", false, 800, Dish.Type.MEAT),
            new Dish("beef", false, 700, Dish.Type.MEAT),
            new Dish("chicken", false, 400, Dish.Type.MEAT),
            new Dish("french fries", true, 530, Dish.Type.OTHER),
            new Dish("rice", true, 350, Dish.Type.OTHER),
            new Dish("season fruit", true, 120, Dish.Type.OTHER),
            new Dish("pizza", true, 550, Dish.Type.OTHER),
            new Dish("prawns", false, 300, Dish.Type.FISH),
            new Dish("salmon", false, 450, Dish.Type.FISH));

    public static void main(String[] args) {
        //	averagingDouble(ToDoubleFunction<? super T> mapper)
        //  averagingInt(ToIntFunction<? super T> mapper)
        //  averagingLong(ToLongFunction<? super T> mapper)
        testAveragingDouble();

        //  collectingAndThen(Collector<T,A,R> downstream, Function<R,RR> finisher)

        //  counting()
        testCounting();

        //  groupingBy(Function<? super T,? extends K> classifier)
        //  groupingBy(Function<? super T,? extends K> classifier, Collector<? super T,A,D> downstream)
        testGroupingBy();

        System.out.println("=================================");
        //groupingByConcurrent(Function<? super T,? extends K> classifier)
        testGroupingByConcurrent();

        System.out.println("============================");
        //joining()
        testJoining();

        System.out.println("===============================");
        //	mapping(Function<? super T,? extends U> mapper, Collector<? super U,A,R> downstream)
        testMapping();

        System.out.println("===============================");
        //	maxBy(Comparator<? super T> comparator)
        //  minBy(Comparator<? super T> comparator)
        testMaxBy();

        System.out.println("==============================");
        //	partitioningBy(Predicate<? super T> predicate)
        testPartitioningBy();

        System.out.println("=============================");
        //  reducing(BinaryOperator<T> op)
        testReducing();

        System.out.println("=============================");
        testSummarizing();

        System.out.println("=============================");
        testToCollection();
    }

    private static void testAveragingDouble() {
        System.out.println(menu.stream().collect(Collectors.averagingDouble(Dish::getCalories)));
        System.out.println(menu.stream().collect(Collectors.averagingInt(Dish::getCalories)));
        System.out.println(menu.stream().collect(Collectors.averagingLong(Dish::getCalories)));
    }

    //TODO
    private static void testCollectingAndThen() {
//        menu.stream().collect(Collectors.collectingAndThen(Collectors.averagingInt(Dish::getCalories), ))
    }

    private static void testCounting() {
        System.out.println(menu.stream().collect(Collectors.counting()));
    }

    //TODO
    private static void testGroupingBy() {
        Map<Dish.Type, List<Dish>> collect = menu.stream().collect(Collectors.groupingBy(Dish::getType));
        for (Map.Entry<Dish.Type, List<Dish>> stringListEntry : collect.entrySet()) {
            System.out.println(stringListEntry.getKey());
            System.out.println(stringListEntry.getValue());
        }

        //  groupingBy(Function<? super T,? extends K> classifier, Collector<? super T,A,D> downstream)
        Map<Dish.Type, Long> collect1 = menu.stream().collect(Collectors.groupingBy(Dish::getType, Collectors.counting()));
        System.out.println(collect1);

        //  groupingBy(Function<? super T,? extends K> classifier, Supplier<M> mapFactory, Collector<? super T,A,D> downstream)
//        menu.stream().collect(Collectors.groupingBy(Dish::getType, ))
    }

    private static void testGroupingByConcurrent() {
        ConcurrentMap<Dish.Type, List<Dish>> collect = menu.stream().collect(Collectors.groupingByConcurrent(Dish::getType));
        for (Map.Entry<Dish.Type, List<Dish>> typeListEntry : collect.entrySet()) {
            System.out.println(typeListEntry.getKey());
            System.out.println(typeListEntry.getValue());
        }
    }

    private static void testJoining() {

        System.out.println(menu.stream().map(Dish::getName).collect(Collectors.joining()));
        System.out.println(menu.stream().map(Dish::getName).collect(Collectors.joining(",")));
        System.out.println(menu.stream().map(Dish::getName).collect(Collectors.joining(",", "(", ")")));
    }

    private static void testMapping() {
        //	mapping(Function<? super T,? extends U> mapper, Collector<? super U,A,R> downstream)
        System.out.println(menu.stream().collect(Collectors.mapping(Dish::getName, Collectors.toList())));
    }

    private static void testMaxBy() {
        Optional<Dish> collect = menu.stream().collect(Collectors.maxBy((a, b) -> a.getCalories() - b.getCalories()));
        collect.ifPresent(System.out::println);

        Optional<Dish> collect1 = menu.stream().collect(Collectors.minBy((a, b) -> a.getCalories() - b.getCalories()));
        collect1.ifPresent(System.out::println);
    }

    private static void testPartitioningBy() {
        //	partitioningBy(Predicate<? super T> predicate)
        Map<Boolean, List<Dish>> collect = menu.stream().collect(Collectors.partitioningBy(Dish::isVegetarian));
        for (Map.Entry<Boolean, List<Dish>> booleanListEntry : collect.entrySet()) {
            System.out.println(booleanListEntry.getKey());
            System.out.println(booleanListEntry.getValue());
        }

        System.out.println("=======================================");
        Map<Boolean, List<Dish>> collect1 = menu.stream().collect(Collectors.partitioningBy(dish -> dish.getCalories() > 500));
        for (Map.Entry<Boolean, List<Dish>> booleanListEntry : collect1.entrySet()) {
            System.out.println(booleanListEntry.getKey());
            System.out.println(booleanListEntry.getValue());
        }

        System.out.println("=========================================");
        Map<Boolean, Long> collect2 = menu.stream().collect(Collectors.partitioningBy(dish -> dish.getCalories() > 500, Collectors.counting()));
        for (Map.Entry<Boolean, Long> booleanLongEntry : collect2.entrySet()) {
            System.out.println(booleanLongEntry.getKey() + " " + booleanLongEntry.getValue());
        }
    }

    //TODO
    private static void testReducing() {
        //  reducing(BinaryOperator<T> op)
        menu.stream().collect(Collectors.reducing(BinaryOperator.maxBy((a, b) -> a.getCalories() - b.getCalories()))).ifPresent(System.out::println);
    }

    //summarizingDouble(ToDoubleFunction<? super T> mapper)
    private static void testSummarizing() {
        System.out.println(menu.stream().collect(Collectors.summingInt(Dish::getCalories)));
        System.out.println(menu.stream().collect(Collectors.summingDouble(Dish::getCalories)));
        System.out.println(menu.stream().collect(Collectors.summingLong(Dish::getCalories)));

        System.out.println("==========summarizingDouble==========");
        System.out.println(menu.stream().collect(Collectors.summarizingDouble(Dish::getCalories)));
        DoubleSummaryStatistics collect = menu.stream().collect(Collectors.summarizingDouble(Dish::getCalories));
        System.out.println("collect.getMax() = " + collect.getMax());
        System.out.println("collect.getMin() = " + collect.getMin());
        System.out.println("collect.getAverage() = " + collect.getAverage());
        System.out.println("collect.getCount() = " + collect.getCount());
        System.out.println("collect.getSum() = " + collect.getSum());
    }

    //	toCollection(Supplier<C> collectionFactory)
    private static void testToCollection() {
        ArrayList<Dish> collect = menu.stream().collect(Collectors.toCollection(ArrayList::new));
        System.out.println(collect);

        HashSet<Dish> collect1 = menu.stream().collect(Collectors.toCollection(HashSet::new));
        System.out.println(collect1);


        //toConcurrentMap(Function<? super T,? extends K> keyMapper, Function<? super T,? extends U> valueMapper)
        ConcurrentMap<String, Dish.Type> collect2 = menu.stream().collect(Collectors.toConcurrentMap(Dish::getName, Dish::getType));
        for (Map.Entry<String, Dish.Type> typeStringEntry : collect2.entrySet()) {
            System.out.println(typeStringEntry.getKey() + ":" + typeStringEntry.getValue());
        }

        //toConcurrentMap(Function<? super T,? extends K> keyMapper, Function<? super T,? extends U> valueMapper, BinaryOperator<U> mergeFunction)
//        menu.stream().collect(Collectors.toConcurrentMap(dish->dish.getName(), dish->dish.getType(), ))
    }
}
