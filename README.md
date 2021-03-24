# Teste Unitário com JUnit 

Teste unitário é o primeiro nível da camada da pirâmide de testes.

O objetivo do teste unitário é validar toda a lógica de nossa aplicação, garantindo maior confiabilidade ao sistema.

Há diversos conceitos que englobam testes unitários, diversas ferramentas e padrões para desenvolvimento, neste exemplo fazemos uso de uma técnica chamada TDD(Desenvolvimento guiado por testes), assim desenvolvemos primeiro a camada de testes unitários seguido da aplicação.

O framework JUnit, auxilia na execução e montagem dos testes unitários.


Não se esqueça de importar a dependência:

```
<dependency>
    <groupId>junit</groupId>
    <artifactId>junit</artifactId>
    <version>4.13.1</version>
    <scope>test</scope>
</dependency>
```


Para executar os testes através do Maven, use o comando:
> mvn test
