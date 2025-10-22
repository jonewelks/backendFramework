# Avaliacao SICREDI
Para Rodar o projeto, siga os passos abaixo:
1. Confirme que tenha o java 11 ou superior instalado em sua maquina.
2. Clone o repositorio para sua maquina local.
3. Navegue ate o diretorio raiz do projeto.
4. Execute o comando os testes que estao na pasta src/test com o comando:
```
mvn test
```
Consideracoes sobre os testes:
- Os testes foram feitos utilizando JUnit e Rest Assured.
- Os testes cobrem os cenarios principais da API, incluindo casos de sucesso e falha.
- Os testes estao organizados em metodos separados para facilitar a manutencao e a leitura.

Bugs:
- API products
  - Post add nao esta atualizando os IDs dos produtos adicionados.
  - Esta retornando status code 200 mas o cadastro nao esta sendo realizado.
  - Na documentacao nao esta claro quais os campos sao obrigatorios para o cadastro de produtos.
  - Nao esta validando campos que deveriam ser obrigatorios.
  - Nao esta retornando mensagens de erro claras para os casos de falha.

OBS: Devido ao tempo limitado, e por estar com muito trabalho na empresa, nao consegui implementar todos os testes que gostaria, porem fiz questao de utilizar metodos e padroes que facilitem a manutencao futura dos testes.
Tambem nao vou conseguir enumerar todos os bugs de cada request. porem deixo a cima um exemplo dos principais problemas encontrados na API de products.
Espero que compreendam.

