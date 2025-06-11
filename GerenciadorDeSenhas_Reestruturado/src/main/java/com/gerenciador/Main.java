import modelo.Credencial;
import servico.*;

import java.io.*;
import java.util.*;

/**
 * Classe principal do Gerenciador de Senhas.
 */
public class Main {
    private static final List<Credencial> credenciais = new ArrayList<>();
    private static final String ARQUIVO = "senhas.dat";

    public static void main(String[] args) {
        // Autenticação 2FA simulada
        if (!Autenticador2FA.autenticar()) {
            System.out.println("Autenticação 2FA falhou.");
            return;
        }

        carregarDados(); // Carrega credenciais previamente salvas

        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n--- Gerenciador de Senhas ---");
            System.out.println("1. Adicionar credencial");
            System.out.println("2. Listar credenciais");
            System.out.println("3. Gerar senha segura");
            System.out.println("4. Sair");
            System.out.print("Escolha: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Por favor, digite um número válido.");
                scanner.next();
            }

            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer

            switch (opcao) {
                case 1 -> adicionarCredencial(scanner);
                case 2 -> listarCredenciais();
                case 3 -> System.out.println("Senha sugerida: " + GeradorSenha.gerarSenha(12));
                case 4 -> salvarDados();
                default -> System.out.println("Opção inválida.");
            }
        } while (opcao != 4);

        scanner.close();
    }

    private static void adicionarCredencial(Scanner scanner) {
        try {
            System.out.print("Serviço: ");
            String servico = scanner.nextLine().trim();

            System.out.print("Usuário: ");
            String usuario = scanner.nextLine().trim();

            System.out.print("Senha: ");
            String senha = scanner.nextLine();

            if (servico.isEmpty() || usuario.isEmpty() || senha.isEmpty()) {
                System.out.println("Todos os campos devem ser preenchidos.");
                return;
            }

            if (VerificadorVazamento.verificarSenha(senha)) {
                System.out.println("Aviso: Esta senha já foi vazada anteriormente!");
            }

            String senhaCriptografada = CriptografiaAES.criptografar(senha);
            credenciais.add(new Credencial(servico, usuario, senhaCriptografada));
            System.out.println("Credencial salva com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao salvar credencial: " + e.getMessage());
        }
    }

    private static void listarCredenciais() {
        System.out.println("\nCredenciais armazenadas:");
        if (credenciais.isEmpty()) {
            System.out.println("Nenhuma credencial cadastrada.");
            return;
        }

        for (Credencial c : credenciais) {
            try {
                String senhaDescriptografada = CriptografiaAES.descriptografar(c.getSenha());
                System.out.println(c.getServico() + " - " + c.getUsuario() + " - " + senhaDescriptografada);
            } catch (Exception e) {
                System.out.println("Erro ao descriptografar senha.");
            }
        }
    }

    private static void salvarDados() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARQUIVO))) {
            oos.writeObject(credenciais);
            System.out.println("Dados salvos com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao salvar arquivo.");
        }
    }

    @SuppressWarnings("unchecked")
    private static void carregarDados() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARQUIVO))) {
            List<Credencial> carregadas = (List<Credencial>) ois.readObject();
            credenciais.addAll(carregadas);
        } catch (Exception e) {
            System.out.println("Nenhum dado anterior encontrado.");
        }
    }
}
