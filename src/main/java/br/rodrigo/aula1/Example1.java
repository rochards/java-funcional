package br.rodrigo.aula1;

import java.util.function.UnaryOperator;

public class Example1 {
    public static void main(String[] args) {
        UnaryOperator<Integer> calc = value -> value * 30;
        System.out.println("Resultado de lambda: " + calc.apply(2));
    }
}
