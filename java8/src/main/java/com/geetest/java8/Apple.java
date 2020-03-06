package com.geetest.java8;

/**
 * @Description:
 * @Author: zhou
 * @Date: 2020/3/6
 * @Time 17:07
 */
public class Apple {
    private String color;
    private int weight;

    public Apple() {
    }

    public Apple(String color, int weight) {
        this.color = color;
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "color='" + color + '\'' +
                ", weight=" + weight +
                '}';
    }
}
