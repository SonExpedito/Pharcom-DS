-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 31/10/2023 às 01:29
-- Versão do servidor: 10.4.28-MariaDB
-- Versão do PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `pharcom`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `categoria`
--

CREATE DATABASE `pharcom`;

USE `pharcom`;

CREATE TABLE `categoria` (
  `Id _Categoria` int(11) NOT NULL,
  `Descrição` varchar(300) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `cliente`
--

CREATE TABLE `cliente` (
  `Id_Cliente` int(11) NOT NULL,
  `Nome` varchar(200) NOT NULL,
  `DataNasc` date NOT NULL,
  `Usuário` varchar(300) NOT NULL,
  `Senha` varchar(40) NOT NULL,
  `Email` varchar(200) NOT NULL,
  `CPF` varchar(16) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `cliente`
--

INSERT INTO `cliente` (`Id_Cliente`, `Nome`, `DataNasc`, `Usuário`, `Senha`, `Email`, `CPF`) VALUES
(1, 'Alex', '2023-09-04', 'Alex', '123', 'AlexDaDizessete@gmail.com', 'ervqer'),
(2, 'Alexx', '2023-09-04', 'Gojo', '123', 'AlexDaDizessete@gmail.com', 'ervqer');

-- --------------------------------------------------------

--
-- Estrutura para tabela `controle`
--

CREATE TABLE `controle` (
  `ID_Func` int(11) NOT NULL,
  `ID_Remedio` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `funcionário`
--

CREATE TABLE `funcionário` (
  `ID_Func` int(11) NOT NULL,
  `Nome_Func` varchar(50) NOT NULL,
  `Usuário` varchar(50) NOT NULL,
  `Nivel_ID` int(11) NOT NULL,
  `Senha` varchar(30) NOT NULL,
  `Email` varchar(50) NOT NULL,
  `Data_Nasc` date NOT NULL,
  `CPF` varchar(14) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `funcionário`
--

INSERT INTO `funcionário` (`ID_Func`, `Nome_Func`, `Usuário`, `Nivel_ID`, `Senha`, `Email`, `Data_Nasc`, `CPF`) VALUES
(1, 'Alex', 'Alex', 1, '123', 'AlexOPicaDasGalaxias@gmail', '2023-09-11', '12341234213');

-- --------------------------------------------------------

--
-- Estrutura para tabela `nível-restrição`
--

CREATE TABLE `nível-restrição` (
  `Nivel_ID` int(11) NOT NULL,
  `Descrição` varchar(80) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `registro_compra`
--

CREATE TABLE `registro_compra` (
  `Id_Remedio` int(11) NOT NULL,
  `Id_Cliente` int(11) NOT NULL,
  `Data_compra` date NOT NULL,
  `Quantidade` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `registro_compra`
--

INSERT INTO `registro_compra` (`Id_Remedio`, `Id_Cliente`, `Data_compra`, `Quantidade`) VALUES
(2, 2, '2023-10-30', 1);

-- --------------------------------------------------------

--
-- Estrutura para tabela `remedio`
--

CREATE TABLE `remedio` (
  `Id_Rem` int(11) NOT NULL,
  `Nome_Rem` varchar(200) NOT NULL,
  `Categoria_Num` int(11) NOT NULL,
  `Preço` float NOT NULL,
  `Estoque` int(11) NOT NULL,
  `Descrição` varchar(80) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `remedio`
--

INSERT INTO `remedio` (`Id_Rem`, `Nome_Rem`, `Categoria_Num`, `Preço`, `Estoque`, `Descrição`) VALUES
(1, 'Dorflex', 2, 10, 12, 'Analgésico e Relaxante Muscular'),
(2, 'Cetoprofeno', 5, 13, 20, 'anti-inflamatório, analgésico e antitérmico'),
(3, 'Desloratadina', 1, 5, 50, ' anti-histamínico H₁ tricíclico que é usado para tratar alergias'),
(4, 'Merthiolate', 3, 20, 15, ' fungicida , virucida esporicida ');

--
-- Índices para tabelas despejadas
--

--
-- Índices de tabela `categoria`
--
ALTER TABLE `categoria`
  ADD PRIMARY KEY (`Id _Categoria`);

--
-- Índices de tabela `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`Id_Cliente`);

--
-- Índices de tabela `funcionário`
--
ALTER TABLE `funcionário`
  ADD PRIMARY KEY (`ID_Func`);

--
-- Índices de tabela `nível-restrição`
--
ALTER TABLE `nível-restrição`
  ADD PRIMARY KEY (`Nivel_ID`);

--
-- Índices de tabela `remedio`
--
ALTER TABLE `remedio`
  ADD PRIMARY KEY (`Id_Rem`);

--
-- AUTO_INCREMENT para tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `categoria`
--
ALTER TABLE `categoria`
  MODIFY `Id _Categoria` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `cliente`
--
ALTER TABLE `cliente`
  MODIFY `Id_Cliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de tabela `funcionário`
--
ALTER TABLE `funcionário`
  MODIFY `ID_Func` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de tabela `nível-restrição`
--
ALTER TABLE `nível-restrição`
  MODIFY `Nivel_ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `remedio`
--
ALTER TABLE `remedio`
  MODIFY `Id_Rem` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
