create database superMercado;

use superMercado;

create table cliente (
idCliente int not null auto_increment,
nomeCliente varchar (70) not null,
endereco varchar (100) not null,
CPF varchar (50) not null,
telefone varchar (60) not null,
email varchar (100) not null,
sexo varchar (30) not null,
estadoCivil varchar(30) not null,
dataNascimento date not null,
primary key (idCliente)
);

drop table cliente;
select * from cliente;

create table produtos (
id int not null auto_increment,
nomeProduto varchar (70) not null,
precoVenda double not null,
precoCompra double not null,
fornecedor varchar (60) not null,
quant int not null,
primary key (id)
);

select * from  produtos;

