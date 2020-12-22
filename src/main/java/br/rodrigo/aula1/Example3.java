package br.rodrigo.aula1;

public class Example3 {
    public static void main(String[] args) {

        Function prefix = value -> "Mr. " + value; // esse comportamento fica associado ao metodo da interface
        System.out.println(prefix.generate("Rodrigo"));
    }
}

// interface funcional. Deve ter apenas um método abstrato
@FunctionalInterface // posso colocar ou não
interface Function {
    String generate(String value);
}

