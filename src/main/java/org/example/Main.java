package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Main<T> {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        nums.add(13);
        nums.add(12);
        nums.add(11);
        nums.add(55);
        nums.add(22);

        nums.stream().map(num -> {
            if (num % 2 == 0) {
                System.out.println(num);
            }
            return null;
        }).collect(Collectors.toList());
    }
}