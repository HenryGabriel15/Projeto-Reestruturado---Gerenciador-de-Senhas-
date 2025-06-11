package servico;

import java.util.Scanner;

/**
 * Simula a autenticação de dois fatores (2FA).
 */
public class Autenticador2FA {
    private static final String CODIGO_FIXO = "123456"; // Código fixo de exemplo

    public static boolean autenticar() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o código 2FA (simulado): ");
        String entrada = scanner.nextLine();
        return CODIGO_FIXO.equals(entrada);
    }
}
