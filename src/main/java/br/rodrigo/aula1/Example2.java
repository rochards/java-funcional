package br.rodrigo.aula1;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Example2 {
    public static void main(String[] args) {

        int[] values = {1, 2, 3, 4};

        var x = Arrays.stream(values)
                .filter(value -> value % 2 == 0)
                .map(value -> value * 2)
                .boxed()
                .collect(Collectors.toList());
//                .forEach(System.out::println);
        System.out.println(x);

    }
}