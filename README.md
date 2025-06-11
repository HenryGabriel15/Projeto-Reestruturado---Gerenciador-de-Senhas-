# Gerenciador de Senhas (Java)

Este é um projeto simples de **Gerenciador de Senhas** desenvolvido em Java. A aplicação permite gerenciar credenciais de forma segura com suporte a autenticação 2FA, criptografia AES e verificação de vazamento de senhas.

## Importante

- 🔑 Chave de acesso código 2FA (simulado): 123456

## Funcionalidades

- ✅ Autenticação em dois fatores (2FA)
- 🔐 Armazenamento seguro de senhas com criptografia AES
- 🔍 Verificação de senhas comprometidas
- 🔑 Geração automática de senhas fortes
- 💾 Salvamento e carregamento automático de dados (`senhas.dat`)
- 📋 Interface de linha de comando com menu interativo

## Estrutura do Projeto

```
ProjetoGerenciadorSenhas/
├── src/
│   ├── Main.java
│   ├── modelo/
│   │   └── Credencial.java
│   └── servico/
│       ├── Autenticador2FA.java
│       ├── CriptografiaAES.java
│       ├── GeradorSenha.java
│       └── VerificadorVazamento.java
├── bin/ (arquivos compilados)
├── senhas.dat (arquivo serializado com dados das senhas)
├── .classpath / .project (configuração do Eclipse)
```

## Como Executar

1. Compile os arquivos Java:

```bash
javac -d bin src/**/*.java
```

2. Execute o programa:

```bash
java -cp bin Main
```

## Requisitos

- Java 8 ou superior
- Terminal compatível com UTF-8

## Observações

- O arquivo `senhas.dat` armazena os dados serializados das credenciais.
- O projeto utiliza técnicas de criptografia simétrica (AES) para proteger as senhas localmente.
