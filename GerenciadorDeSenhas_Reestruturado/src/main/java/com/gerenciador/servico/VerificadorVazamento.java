package servico;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

/**
 * Verifica se uma senha foi vazada usando a API Have I Been Pwned.
 */
public class VerificadorVazamento {

    public static boolean verificarSenha(String senha) {
        try {
            // Gera hash simples (substitua por SHA-1 para uso real)
            String hash = Integer.toHexString(senha.hashCode()).toUpperCase();

            // A API trabalha com os primeiros 5 caracteres do hash
            URL url = new URL("https://api.pwnedpasswords.com/range/" + hash.substring(0, 5));
            HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
            conexao.setRequestMethod("GET");

            Scanner scanner = new Scanner(conexao.getInputStream());
            while (scanner.hasNext()) {
                if (scanner.nextLine().contains(hash.substring(5))) {
                    return true; // senha vazada
                }
            }
        } catch (Exception e) {
            System.out.println("Erro ao verificar vazamento: " + e.getMessage());
        }
        return false;
    }
}
