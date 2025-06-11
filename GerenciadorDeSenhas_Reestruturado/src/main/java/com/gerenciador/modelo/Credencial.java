package modelo;

import java.io.Serializable;

/**
 * Representa uma credencial de acesso a um serviço.
 */
public class Credencial implements Serializable {
    private String servico;
    private String usuario;
    private String senha;

    public Credencial(String servico, String usuario, String senha) {
        this.servico = servico;
        this.usuario = usuario;
        this.senha = senha;
    }

    public String getServico() { return servico; }
    public String getUsuario() { return usuario; }
    public String getSenha() { return senha; }

    @Override
    public String toString() {
        return "Serviço: " + servico + ", Usuário: " + usuario + ", Senha: " + senha;
    }
}
