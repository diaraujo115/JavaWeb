create schema if not exists academyspring default character set utf8;
use academyspring;
drop database academyspring;
-- Tabela Vendedor
CREATE TABLE vendedor (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL
);

-- Tabela Cliente
CREATE TABLE cliente (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    cpf VARCHAR(14) NOT NULL UNIQUE,
    email VARCHAR(255) NOT NULL
);

-- Tabela Venda
CREATE TABLE venda (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome_carro VARCHAR(255) NOT NULL,
    marca_carro VARCHAR(255) NOT NULL,
    preco DECIMAL(10, 2) NOT NULL,
    cliente_id BIGINT NOT NULL,
    vendedor_id BIGINT NOT NULL,
    FOREIGN KEY (cliente_id) REFERENCES cliente(id),
    FOREIGN KEY (vendedor_id) REFERENCES vendedor(id)
);
ALTER TABLE venda MODIFY preco DECIMAL(10,2) DEFAULT 0.00;


select*from vendedor;