package br.rodrigo.aula3;

public class Example1 {
    public static void main(String[] args) {

        Thread pdf = new GeradorDePDF();
        Thread barra = new BarraDeCarregamento(pdf);

        pdf.start();
        barra.start();
    }
}

class GeradorDePDF extends Thread {

    @Override
    public void run() {
        System.out.println("Gerando PDF...");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("PDF gerado...");
    }
}

class BarraDeCarregamento extends Thread {

    private Thread pdf;

    public BarraDeCarregamento(Thread pdf) {
        this.pdf = pdf;
    }

    @Override
    public void run() {
        while(pdf.isAlive()) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Carregando...");
        }

    }
}