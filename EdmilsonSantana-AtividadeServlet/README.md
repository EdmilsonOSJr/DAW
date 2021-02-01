# Exercícios sobre Servlets
Esse repositório é destinado a resolução de uma lista de exercícios sobre servlets. São realizados os seguintes exercícios:

1. Crie um servlet que imprima, em uma tabela, todos os nomes de parâmetros enviados e
seus valores.
    * O servlet deve suportar tanto GET como POST
    * Use request.getParameterNames() e getParameterValues(String)

2. Crie um servlet que imprima, em uma tabela, todos os nomes de cabeçalhos HTTP da
requisição e seus valores
    * O servlet deve suportar tanto GET como POST
    * Use request.getHeaderNames()e getHeaders(String)

3. Escreva um servlet simples que devolva uma página contendo o dia, mês, ano e hora.

4. Escreva um servlet que gere uma tabela HTML com a lista de fatoriais entre 0 e 10

5. Altere o exercício 4 para que o servlet verifique a existência de um parâmetro chamado
"maximo". Se ele não for null, converta-o em int e use-o como limite para gerar a tabela de
fatoriais. Passe parâmetro algo como: http://localhost:8080/projeto/servlet?maximo=5

6. Escreva uma servlet que calcule o IMC de uma pessoa e exiba as seguintes mensagens com
base no resultado final do IMC encontrado:
    * imc < 18.5 => Cuidado! Você está muito abaixo do peso!
    * 18.5 <= imc < 25.0 => Parabéns! Você está em seu peso ideal!
    * 25.0 <= imc < 30.0 => Atenção! Você está acima de seu peso ideal!
    * 30.0 <= imc < 35.0 => Atenção! Obesidade grau 1!
    * 35.0 <= imc < 40.0 => Cuidado! Obesidade grau 2!
    * 40.0 <= imc => Cuidado! Obesidade grau 3
    
7. Crie uma agenda de contatos.
    * Crie a classe modelo.Contato.java com os seguintes atributos: nome, email e
    telefone.
    * Crie a classe modelo.AgendaContatos.java, tendo como atributo um ArrayList<Contato>. Esta classe deve adicionar um contato, listar contatos, remover
    um contato e pesquisar um contato.
    * Crie uma página HTML com as funcionalidades da Agenda de Contatos.
    * Devemos ter uma servlet para tratar cada uma das funcionalidades da Agenda.
    * Não permitir que Contatos com o mesmo nome sejam adicionado.
