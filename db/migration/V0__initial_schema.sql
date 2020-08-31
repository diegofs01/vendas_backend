-- MySQL8

CREATE TABLE `cliente` (
  `cpf` varchar(11) NOT NULL,
  `ativo` bit(1) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `saldo` double NOT NULL,
  `bairro` varchar(255) NOT NULL,
  `cep` varchar(8) NOT NULL,
  `cidade` varchar(255) NOT NULL,
  `complemento` varchar(255) DEFAULT NULL,
  `data_nascimento` date NOT NULL,
  `logradouro` varchar(255) NOT NULL,
  `numero` int NOT NULL,
  `sexo` varchar(9) NOT NULL,
  `uf` varchar(2) NOT NULL,
  PRIMARY KEY (`cpf`)
); 

CREATE TABLE `produto` (
  `codigo` varchar(255) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `unidade` varchar(255) NOT NULL,
  `valor` double NOT NULL,
  PRIMARY KEY (`codigo`)
);

CREATE TABLE `venda` (
  `id` int NOT NULL AUTO_INCREMENT,
  `data_venda` datetime(6) NOT NULL,
  `valor_total` double NOT NULL,
  `cliente_cpf` varchar(11) NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`cliente_cpf`) REFERENCES `cliente` (`cpf`)
); 

CREATE TABLE `item` (
  `id_item` int NOT NULL AUTO_INCREMENT,
  `id_venda` int NOT NULL,
  `quantidade` int NOT NULL,
  `produto_codigo` varchar(255) NOT NULL,
  PRIMARY KEY (`id_item`),
  FOREIGN KEY (`produto_codigo`) REFERENCES `produto` (`codigo`),
  FOREIGN KEY (`id_venda`) REFERENCES `venda` (`id`)
); 

CREATE TABLE `user` (
  `username` varchar(255) NOT NULL UNIQUE,
  `password` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `role` varchar(255) NOT NULL
);

INSERT INTO `user` (`username`, `password`, `email`, `role`) VALUES ('admin', '$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6', 'email@example.com', 'admin');