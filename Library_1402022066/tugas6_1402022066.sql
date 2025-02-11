-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 12, 2023 at 06:43 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `tugas6_1402022066`
--

-- --------------------------------------------------------

--
-- Table structure for table `data`
--

CREATE TABLE `data` (
  `ID` int(10) UNSIGNED NOT NULL,
  `username` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  `roles` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `data`
--

INSERT INTO `data` (`ID`, `username`, `password`, `roles`) VALUES
(1, 'adminKomang', '12345678', 'Admin'),
(2, 'userKomang', '12345678', 'User'),
(3, 'fattah', 'fattah27', 'User'),
(4, 'anakbaru', '11223344', 'Admin'),
(5, 'userBaru', '12345678', 'User'),
(6, 'lahridobau@gmail.com', '123fghjk78', 'User'),
(7, 'tes', '12345678', 'Admin');

-- --------------------------------------------------------

--
-- Table structure for table `datapeminjamanbuku`
--

CREATE TABLE `datapeminjamanbuku` (
  `ID` int(3) NOT NULL,
  `tanggal` date NOT NULL,
  `nama` varchar(30) NOT NULL,
  `npm` varchar(30) NOT NULL,
  `judulBuku` varchar(30) NOT NULL,
  `pengarang` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `datapeminjamanbuku`
--

INSERT INTO `datapeminjamanbuku` (`ID`, `tanggal`, `nama`, `npm`, `judulBuku`, `pengarang`) VALUES
(1, '2023-05-17', 'komangAbi', '65879098', 'nnaklsnsalk', 'lbjakbdjksb'),
(2, '2023-05-17', 'mjbjabjkbaskj', '6587909898', 'nnaklsnsalksaas', 'saaslbjakbdjksb'),
(3, '2023-05-10', 'sdakjsadjkdasdsa', '91208390213123', 'kasndjkasnkasdas', 'jkascjkasdasdas'),
(4, '2023-05-04', 'adgfegeer', '123321213', 'kasndjkasnkasdas', 'jkascjkasdasdas'),
(5, '2023-05-23', 'adgfegeer', '1', 'kasndjkasnkasdas', 'jkascjkasdasdas'),
(6, '2023-05-20', 'adgfegeer', '123321213', 'kasndjkasnkasdas', 'jkascjkasdasdas'),
(7, '2023-05-21', 'adgfegeerdsdsf', '12332142124', 'kasndjkasnkasdas', 'jkascjkasdasdasqwe');

-- --------------------------------------------------------

--
-- Table structure for table `formpeminjamanbuku`
--

CREATE TABLE `formpeminjamanbuku` (
  `ID` int(10) UNSIGNED NOT NULL,
  `tanggal` date NOT NULL,
  `nama` varchar(30) NOT NULL,
  `npm` varchar(30) NOT NULL,
  `judulBuku` varchar(30) NOT NULL,
  `pengarang` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `formpeminjamanbuku`
--

INSERT INTO `formpeminjamanbuku` (`ID`, `tanggal`, `nama`, `npm`, `judulBuku`, `pengarang`) VALUES
(1, '2023-05-17', 'komangAbi', '65879098', 'nnaklsnsalk', 'lbjakbdjksb'),
(2, '2023-05-17', 'mjbjabjkbaskj', '6587909898', 'nnaklsnsalksaas', 'saaslbjakbdjksb'),
(3, '2023-05-10', 'sdakjsadjkdasdsa', '91208390213123', 'kasndjkasnkasdas', 'jkascjkasdasdas'),
(4, '2023-05-04', 'adgfegeer', '123321213', 'kasndjkasnkasdas', 'jkascjkasdasdas'),
(5, '2023-05-23', 'adgfegeer', '1', 'kasndjkasnkasdas', 'jkascjkasdasdas'),
(6, '2023-05-20', 'adgfegeer', '123321213', 'kasndjkasnkasdas', 'jkascjkasdasdas'),
(7, '2023-05-21', 'adgfegeerdsdsf', '12332142124', 'kasndjkasnkasdas', 'jkascjkasdasdasqwe');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `data`
--
ALTER TABLE `data`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `datapeminjamanbuku`
--
ALTER TABLE `datapeminjamanbuku`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `formpeminjamanbuku`
--
ALTER TABLE `formpeminjamanbuku`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `data`
--
ALTER TABLE `data`
  MODIFY `ID` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `datapeminjamanbuku`
--
ALTER TABLE `datapeminjamanbuku`
  MODIFY `ID` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `formpeminjamanbuku`
--
ALTER TABLE `formpeminjamanbuku`
  MODIFY `ID` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
