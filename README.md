<h1 align="center">Sistema de Cursos</h1>

Pequeno sistema que simula a matrícula de estudantes em cursos.

### Sumário
- [Como funciona](#como-funciona)
- [Práticas](#práticas)
- [Tecnologias utilizadas](#tecnologias-utilizadas)

## Como funciona
Os dados do aluno são cadastrados no banco de dados, junto com os dados de sua matrícula e o curso escolhido, as das variáveis se encontram em `domain`.

Seus dados são manipulados com padrão `CRUD` na pasta `dao` (Data Access Object). Como o CRUD é algo padrão entre os objetos, então ele é implementado utilizando Generics em `GenericDAO`.

Utilizando uma instância do `Postgres`, como um contêiner `Docker`, é possível interagir com os dados gerados, eles são manipulados na aplicação utlizando `JPA` com `Hibernate`.

## Práticas
Foi utilizado `TDD`, principalmente na criação das primeiras classes e interfaces. A detecção de erros acelera bastante ao programar utilizando TDD, pois rápidamente se observa quais implementações estão faltando e é possível fazer um "quick start" delas utilizando isso.

Também utlizei a prática de instanciar orientado à interfaces e não à classes concretas (Ex: ```private IRegistrationDAO regDAO;```).

Atomicidade do banco de dados, onde todas as informações são indivisíveis.

A utilização de `Generics` é importantíssima, não apenas por acelerar muito o desenvolvimento de futuros objetos, como também pela boa prática do `DRY` (Don't Repeat Yourself).

## Tecnologias utilizadas
* Java 17
* PostgreSQL
* Hibernate
* Docker