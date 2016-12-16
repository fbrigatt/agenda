create database if not exists agenda;
use agenda;

create table contatos
(
	id       int          not null,
    nome     varchar(100) not null,
	email    varchar(100),
    telefone varchar(15),
    endereco varchar(100),
    
    primary key(id)
);