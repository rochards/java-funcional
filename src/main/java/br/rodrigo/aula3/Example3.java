package br.rodrigo.aula3;

import java.util.stream.IntStream;

public class Example3 {
    public static void main(String[] args) {
        long begin = System.currentTimeMillis();
        IntStream.range(1, 100000).forEach(Example3::fat);
        long end = System.currentTimeMillis();
        System.out.println("Calculo sequencial.");
        System.out.println("Tempo de execucao (ms): " + (end - begin));

        begin = System.currentTimeMillis();
        IntStream.range(1, 100000).parallel().forEach(Example3::fat);
        end = System.currentTimeMillis();
        System.out.println("Calculo paralelo.");
        System.out.println("Tempo de execucao (ms): " + (end - begin));
    }

    public static long fat(int num) {
        long aux = 1;
        for (int i = 2; i <= num; i++) {
            aux *= i;
        }
        return  aux;
    }
}
