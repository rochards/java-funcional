package br.rodrigo.aula2;

import java.util.function.Consumer;

public class Example3 {
    public static void main(String[] args) {
        // Falando sobre consumer

        Consumer<String> print = System.out::println;
        print.accept("Hello home!");
    }
}
