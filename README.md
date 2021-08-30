# API - Condominio

## Description

Durante o BOOTCAMP da DIO, o pessoal da EVERIS criou uma API para gerenciar visitantes em um condominio.
Inicialmente, era somente para cadastrar uma pessoa em um sistema qualquer, tanto que foi criado somente um EndPoint (até por questão de tempo)
Com isso, tive a ideia de implementar algumas coisas a mais como: cadastrar um visitante, um morador, o apartamento no qual o visitante vai e o morador reside e o condominio que este apartamento está localizado

- No visitante cadastramos: Nome, Documento, Apartamento, Data e Horário de entrada e Saída
- No morador cadastramos: Nome, Documento, Apartamento
- No apartamento cadastramos: Bloco e Numero
- No documento cadastramos: Tipo de Documento e o numero
- No condominio cadastramos: Nome e os Apartamentos

## Features

- Cadastrar e manter todos os visitantes, moradores, apartamentos, documentos e condominios
- Basicamente, é um CRUD para todas as entidades presentes na aplicação

## Tech

As tecnologias usadas nessa API: 

- [Java 11] - Todo Backend foi desenvolvido na versão 11 do Java
- [Spring Boot] - FrameWork para facilitar o desenvolvimento
- [Spring Data] - CRUD Básico
- [H2] - Banco de dados em memória 
- [MariaDB] - Banco de dados (apenas localhost)
- [Maven] - Controle de dependências
- [TestNG / EasyMock] - Testes Unitários
- [Jacoco/Sonar] - Relatório de Testes
- [Lombok] - Para um código "mais limpo"

## Installation

- Baixe a aplicação no seu computador e use a IDE de sua preferência. No meu caso, eu usei o IntelliJ Community para desenvolver esta API

- Rode os testes unitários com o comando:
```
mvn clean install
```

- Execute o script "start.sh". Escolha o ambiente H2 para subir a aplicação 
- Default porta 8080
- Debug na porta 5005
```
bash start.sh
```

## EndPoints

##### Apartamento
- Novo Apartamento
```
localhost:8080/api/condominio/apartamento/novo
{
    "bloco": "",
    "numero": ""
}
```
- Buscar Apartamento
```
localhost:8080/api/condominio/apartamento/buscarID/{id}
```
- Excluir Apartamento
```
localhost:8080/api/condominio/apartamento/excluir/{id}
```
- Buscar Todos os Apartamentos
```
localhost:8080/api/condominio/apartamento/buscarTodos
```
- Buscar Pelo Bloco e Numero do Apartamento
```
localhost:8080/api/condominio/apartamento/buscarBlocoNumero/{bloco}/{numero}
```

##### Documento
- Novo Documento
```
localhost:8080/api/condominio/documento/novo
{
    "tipoDocumento": "", 
    "numero": ""
}
```
- Buscar Documento
```
localhost:8080/api/condominio/documento/buscarID/{id}
```
- Excluir Documento
```
localhost:8080/api/condominio/documento/excluir{id}
```
- Buscar Todos os Documentos
```
localhost:8080/api/condominio/documento/buscarTodos
```
- Buscar pelo número do documento
```
localhost:8080/api/condominio/documento/buscarNumero/{numero}
```

##### Condominio
- Novo Condominio
```
localhost:8080/api/condominio/condominio/novo
{
    "nome": "",
    "apartamento": [
        {
            "bloco": ""
            "numero": ""
        }
    ]
}
```
- Buscar Condominio
```
localhost:8080/api/condominio/condominio/buscarID/{id}
```
- Excluir Condominio
```
localhost:8080/api/condominio/condominio/excluir/{id}
```
- Buscar todos os condominios
```
localhost:8080/api/condominio/condominio/buscarTodos
```
- Buscar condominio por nome
```
localhost:8080/api/condominio/condominio/buscarNome/{nome}
```
- Buscar condominio por Apartamento
```
localhost:8080/api/condominio/condominio/buscarCondominioApartamento
{
    "bloco": ""
    "numero": ""
}
``` 
##### Morador
- Novo Morador
```
localhost:8080/api/condominio/morador/novo 
{
    "nome": "",
    "documento":[
                    {
                        "tipoDocumento": "", 
                        "numero": ""
                    }
                ],
   "apartamento":[
                    {
                        "bloco": "",
                        "numero": ""
                    }
                ]
}
``` 
- Buscar morador
```
localhost:8080/api/condominio/morador/buscarID{id}
```
- Excluir Morador
```
localhost:8080/api/condominio/morador/excluir{id}
```
- Buscar todos os Moradores
```
localhost:8080/api/condominio/morador/buscarTodos
```
- Buscar Moradores por nome
```
localhost:8080/api/condominio/morador/buscarNome/{nome}
```

##### Visitante
- Novo visiante
```
localhost:8080/api/condominio/visitante/novo
{
    "nome": "",
    "entrada": "",
    "sainda": "",
    "documento":[
                    {
                        "tipoDocumento": "", 
                        "numero": ""
                    }
                ],
   "apartamento":[
                    {
                        "bloco": "",
                        "numero": ""
                    }
                ]
}
```
- Buscar visitante
```
localhost:8080/api/condominio/visitante/buscarID/{id}
```
- Excluir Visitante
```
localhost:8080/api/condominio/visitante/excluir/{id}
```
- Buscar todos os visitantes
```
localhost:8080/api/condominio/visitante/buscarTodos
```
- Buscar Visitantes por nome
```
localhost:8080/api/condominio/visitante/buscarNome/{nome}
```

##### PS

- Este projeto foi apenas para fins de aprendizado.
