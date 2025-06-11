# Gerenciador de Senhas 🔐

Projeto Java simples para gerenciamento de senhas com funcionalidades adicionais como autenticação 2FA, geração de senhas seguras, criptografia AES e verificação de vazamento de credenciais.

## 📁 Estrutura do Projeto

GerenciadorDeSenhas/
 ├── .classpath
 ├── .project
 ├── src/
 │ └── com/
 │ └── gerenciador/
 │ ├── Main.java
 │ ├── modelo/
 │ │ └── Credencial.java
 │ └── servico/
 │ ├── Autenticador2FA.java
 │ ├── CriptografiaAES.java
 │ ├── GeradorSenha.java
 │ └── VerificadorVazamento.java


## 🚀 Funcionalidades

- 🔐 Criptografia de senhas com AES
- 📱 Autenticação em duas etapas (2FA)
- 🔑 Geração de senhas seguras
- 🌐 Verificação de vazamento de credenciais
- 💾 Armazenamento de credenciais (via objeto)

## 🛠️ Requisitos

- Java 8 ou superior
- Eclipse IDE (ou qualquer IDE compatível com Java)

## ✅ Como Executar

1. **Importe o projeto no Eclipse:**
   - `File > Import > Existing Projects into Workspace`
   - Selecione a pasta extraída do projeto

2. **Execute o arquivo `Main.java`**

## 📦 Build

Este projeto **não usa Maven ou Gradle**. O gerenciamento de dependências é feito manualmente (se necessário).

---

Desenvolvido com ☕ por Henry
