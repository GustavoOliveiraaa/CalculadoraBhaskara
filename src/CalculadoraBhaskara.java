import java.util.InputMismatchException;
import java.util.Scanner;

public class CalculadoraBhaskara {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        System.out.println("Calculadora de Bhaskara");

        while (continuar) {
            try {
                System.out.println("Insira o valor de 'a' (ou 'x' para variável):");
                String inputA = scanner.next();
                double a = 0;

                if (inputA.equalsIgnoreCase("x")) {
                    System.out.println("Insira o valor de 'b':");
                    double b = scanner.nextDouble();

                    System.out.println("Insira o valor de 'c':");
                    double c = scanner.nextDouble();

                    System.out.println("A equação é: x^2 + " + b + "x + " + c + " = 0");
                    System.out.println("Esta versão da calculadora não pode calcular o resultado com variáveis 'x'.");
                } else {
                    a = Double.parseDouble(inputA);

                    if (a == 0) {
                        System.out.println("O valor de 'a' não pode ser igual a zero. Tente novamente.");
                        continue;
                    }

                    System.out.println("Insira o valor de 'b':");
                    double b = scanner.nextDouble();

                    System.out.println("Insira o valor de 'c':");
                    double c = scanner.nextDouble();

                    // Calcula o discriminante (parte dentro da raiz quadrada)
                    double discriminante = b * b - 4 * a * c;

                    if (discriminante > 0) {
                        double raiz1 = (-b + Math.sqrt(discriminante)) / (2 * a);
                        double raiz2 = (-b - Math.sqrt(discriminante)) / (2 * a);
                        System.out.println("As raízes são: x1 = " + raiz1 + " e x2 = " + raiz2);
                    } else if (discriminante == 0) {
                        double raiz = -b / (2 * a);
                        System.out.println("A raiz dupla é: x = " + raiz);
                    } else {
                        System.out.println("As raízes são complexas e não podem ser calculadas neste programa.");
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Valor inválido. Certifique-se de inserir apenas números ou 'x' para variável. Tente novamente.");
                continue;
            } catch (InputMismatchException e) {
                System.out.println("Valor inválido. Certifique-se de inserir apenas números ou 'x' para variável. Tente novamente.");
                scanner.next(); // Limpa o buffer do Scanner após a exceção
                continue;
            }

            // Pergunta ao usuário se deseja calcular novamente
            System.out.println("Deseja calcular para outra equação quadrática? (S/N)");
            String resposta = scanner.next();

            if (!resposta.equalsIgnoreCase("S")) {
                continuar = false;
            }
        }

        System.out.println("Obrigado por usar a Calculadora de Bhaskara. Encerrando o programa...");
        scanner.close();
    }
}
