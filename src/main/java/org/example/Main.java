package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main<T> {
    public static void main(String[] args) {

        List<Integer> nums = new ArrayList<>();

        nums.add(13);
        nums.add(12);
        nums.add(11);
        nums.add(55);
        nums.add(22);

        List<Integer> num = nums.stream().filter(e -> e % 2 == 0).collect(Collectors.toList());
        System.out.println("Количество "+num.size() +", числа "+num);
        Stream<Integer> stream = new ArrayList<>(Arrays.asList(1, 2, 3, 5, 8, 13, 21)).stream();
        findMinMax(
                stream,
                (x, y) -> x.compareTo(y),
                (x, y) -> System.out.println(String.format("min: %s, max: %s", x, y)));

    }

    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {
        List<T> arrayList = new ArrayList<>();
        T min = null;
        T max = null;
        arrayList = stream
                .sorted(order)
                .collect(Collectors.toList());
        if (arrayList.size() != 0) {
            min = arrayList.get(0);
            max = arrayList.get(arrayList.size() - 1);
            minMaxConsumer.accept(min, max);
            if (min == null && max == null) {
                minMaxConsumer.accept(null, null);


            }
        }
    }

}