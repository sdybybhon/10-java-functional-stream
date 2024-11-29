package com.example.task02;

import java.util.stream.IntStream;

public class Task02Main {

    public static void main(String[] args) {
        cycleGrayCode(3)
                .limit(50)
                .forEach(System.out::println);
    }

    public static IntStream cycleGrayCode(int n) {
        if (n < 1 || n > 16) {
            throw new IllegalArgumentException("Неверное значение \"n\". Значение должно быть от 1 до 16 включительно.");
        }

        int size = 1 << n;
        return IntStream.iterate(0, i -> (i + 1) % size)
                .map(i -> i ^ (i >> 1));
    }
}
