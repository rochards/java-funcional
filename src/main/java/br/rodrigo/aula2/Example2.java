package br.rodrigo.aula2;

import java.util.function.Function;

public class Example2 {
    public static void main(String[] args) {

        //- dentro da interface Function ha um metodo abstrato que sera associado
        // a expressao lambda definida abaixo.
        Function<String, String> reverseString = text -> new StringBuilder(text).reverse().toString();
        System.out.println(reverseString.apply("Rodrigo"));

        Function<String, Integer> stringLength = String::length;
        //Function<String, Integer> stringLength = text -> text.length();
        System.out.println(stringLength.apply("Rodrigo"));
    }
}
