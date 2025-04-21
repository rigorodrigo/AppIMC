# AppIMC

## Sobre o Projeto
Uma aplicação Java para calcular o Índice de Massa Corporal (IMC), armazenar os dados em PostgreSQL e gerenciá-los por interface gráfica.

## Funcionalidades
- Cadastro de pessoas (nome, CPF, peso, altura)
- Cálculo automático do IMC
- Classificações: Magreza, Normalidade, Sobrepeso, Obesidade, Obesidade Grave
- Operações completas: adicionar, visualizar, editar e excluir registros

## Tecnologias
- Java
- Java Swing
- JPA
- PostgreSQL

## Como Usar
1. Certifique-se de ter PostgreSQL instalado com banco `db_appimc`
2. Configure a conexão em `META-INF/persistence.xml` se necessário
3. Execute a classe `AppIMCDesktop` para interface gráfica
4. Ou execute `AppIMC` para versão por linha de comando

## Banco de Dados
A aplicação está configurada para conectar em:
- URL: `jdbc:postgresql://localhost:5432/db_appimc`
- Usuário: `postgres`

