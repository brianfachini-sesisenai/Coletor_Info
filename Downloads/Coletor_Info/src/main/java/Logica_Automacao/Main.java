package Logica_Automacao;
import java.util.Random;
/*
    PROJETO: Coletor de Dados de Automação
    OBJETIVO: Exemplificar:
               - Coleta;
               - Tratamento;
               - Validação de Dados Indústriais.
 */
public class Main {
    //O metodo "Main" é o ponto de partida. Tudo começa aqui!
    public static void main(String[] args) {
        //Exibição do Cabeçalho: Simula a inicialização de um sistema de informação
        System.out.println("=============================================");
        System.out.println("| SISTEMA DE MONITORAMENTO INDÚSTRIAL - V01 |");
        System.out.println("=============================================");

        //Criamos um laço (loop) para repetir a coleta 5 vezes.
        // Isso é somente uma simulação, na vida real isso rodaria infinitamente para monitorar a máquina

        for (int ciclo = 1; ciclo <= 5; ciclo++) {
            System.out.println("[INFO] Ciclo atual: " + ciclo);

            // 1. COLETA DE DADOS
            double valorTemperatura = lerSensor("Temperatura_Forno_01");

            // 2/3. TRATAMENTO E VALIDAÇÃO
            validarDadosSeg("Temperatura", valorTemperatura, 20, 80);

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("ERRO NO TEMPORIZADOR");
            }
        }
        System.out.println("=============================================");
        System.out.println("|             COLETA FINALIZADA             |");
        System.out.println("=============================================");
    }
    // METODO ESPECIAL
    public static double lerSensor (String tag){
        Random gerador = new Random();

        //Gerar de fato um numero entre 10.0 e 100 para simular a variação de temperatura real
        double valorLido = 10 + (100 - 10) * gerador.nextDouble();

        return valorLido;
    }
    // METODO ESPECIAL 2
    public static void validarDadosSeg(String nomeSensor, double valor, double min, double max) {
        System.out.printf("Sensor: %s | Valor Atual: %.2f°C ", nomeSensor, valor);
        // Lógica de Programação
        if (valor >= min && valor <= max) {
            System.out.println(" >> OPERAÇÃO NORMAL << ");
        } else {
            System.out.println(" >> FORA DOS NÍVEIS DE SEGURANÇA << ");
        }
    }
}