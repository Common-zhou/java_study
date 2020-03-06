package com.geetest.java8;

/**
 * @Description:
 * @Author: zhou
 * @Date: 2020/3/6
 * @Time 23:00
 */
public class LambdaUsage {

    @FunctionalInterface
    public interface Adder {
        int add(int a, int b);
    }

    // @FunctionalInterface
    public interface DoubleAddr extends Adder{
        long add(long a, long b);
    }

    public static void main(String[] args) {
        Runnable r1 = ()->{
            System.out.println("Hello r1");
        };

        Runnable r2 = ()-> System.out.println("Hello r2");

        Runnable r3 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello r3");
            }
        };

        process(r1);
        process(r2);
        process(r3);

        process(()->{
            System.out.println("Hello r4");
        });



    }

    private static void process(Runnable r){
        r.run();
    }
}
