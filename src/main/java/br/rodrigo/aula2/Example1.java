package br.rodrigo.aula2;

public class Example1 {
    public static void main(String[] args) {
        //Explicando funcao de alta ordem
        Calc sum = (a, b) -> a + b;
        Calc mul = (a, b) -> a * b;
        Calc sub = (a, b) -> a - b;

        System.out.println(exec(sum, 2, 4));
        System.out.println(exec(sub, 2, 4));
        System.out.println(exec(mul, 2, 4));
    }

    // exec seria uma funcao de alta ordem, pois recebe outra como parametro
    public static int exec(Calc func, int a, int b) {
        return func.calc(a, b);
    }
}

@FunctionalInterface
interface Calc {
    int calc(int a, int b);
}