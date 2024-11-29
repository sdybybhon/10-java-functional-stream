package com.example.task03;

import java.util.Comparator;
import java.util.Iterator;
import java.util.function.BiConsumer;
import java.util.stream.Stream;

public class Task03Main {

    public static void main(String[] args) {
        findMinMax(
                Stream.of(2, 9, 5, 4, 8, 1, 3),
                Integer::compareTo,
                (min, max) ->
                        System.out.println("min: " + min + " / max: " + max)
        );
    }

    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {

        if (stream == null || order == null || minMaxConsumer == null) {
            throw new NullPointerException();
        }

        Iterator<? extends T> iterator = stream.iterator();

        if (!iterator.hasNext()) {
            minMaxConsumer.accept(null, null);
            return;
        }

        T min = null;
        T max = null;


        if (iterator.hasNext()) {
            min = iterator.next();
            max = iterator.next();

            while (iterator.hasNext()) {
                T element = iterator.next();

                if (min == null || order.compare(element, min) < 0) {
                    min = element;
                }

                if (max == null || order.compare(element, max) > 0) {
                    max = element;
                }
            }
        }
        minMaxConsumer.accept(min, max);
    }
}
