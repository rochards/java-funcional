package br.rodrigo.aula2;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Example4 {
    public static void main(String[] args) {

        String[] names = {"John", "Paul", "Oliver", "Java", "Instructor"};
        Integer[] numbers = {1, 2, 5, 2};

        var filteredNames = Arrays.stream(names)
                .filter(name -> name.length() == 4)
                .collect(Collectors.toList());

        var doubleNumbers = Arrays.stream(numbers)
                .map(n -> n * 2)
                .collect(Collectors.toList());

        System.out.println(filteredNames);
        System.out.println(doubleNumbers);
    }
}
