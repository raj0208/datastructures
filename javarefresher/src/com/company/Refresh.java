package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Refresh {
    public static void main(String[] args) {
        streamCreation();
        streamIteration();
        streamFiltering();
        streamReduction();
        streamCollect();
    }

    private static void streamCreation (){
        String[] arr = { "a", "b", "c"};
        Stream<String> stream = Arrays.stream(arr);
        long count = stream.distinct().count();
        System.out.println("Distinct " + count);
    }

    private static void streamIteration() {
        String[] arr = { "a", "b", "c"};
        Stream<String> stream = Arrays.stream(arr);

        for (String s : arr) {
            if (s.contains("a")) {
                System.out.println("A is there");
            }
        }
        // Simplified
        System.out.println(stream.anyMatch(x -> x.contains("a")));
    }


    private static void streamFiltering() {
        ArrayList<String> list = getStrings();

        Stream<String> stream = list.stream().filter(x -> x.toLowerCase().contains("d"));
        stream.forEach(System.out::println);
    }

    private static ArrayList<String> getStrings() {
        ArrayList<String> list = new ArrayList<>();
        list.add("One");
        list.add("OneAndOnly");
        list.add("Derek");
        list.add("Change");
        list.add("factory");
        list.add("justBefore");
        list.add("Italy");
        list.add("Italy");
        list.add("Thursday");
        return list;
    }

    private static void streamReduction() {
        List<Integer> integers = Arrays.asList(1, 1, 1);
        Integer reduced = integers.stream().reduce(23, (a, b) -> a + b);
        System.out.println("reduced no is : " + reduced );
    }

    private static void streamCollect() {
        System.out.println("streamCollect() ==============");
        List<String> resultList
                = getStrings().stream().map(element -> element.toUpperCase()).collect(Collectors.toList());
        resultList.forEach(System.out::println);
    }
}
