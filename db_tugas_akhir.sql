-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Dec 22, 2022 at 05:35 AM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_tugas_akhir`
--

-- --------------------------------------------------------

--
-- Table structure for table `tb_anggota_keluarga`
--

CREATE TABLE `tb_anggota_keluarga` (
  `id` int(11) NOT NULL,
  `agama` varchar(255) DEFAULT NULL,
  `id_kk` int(11) NOT NULL,
  `jenis_kelamin` varchar(255) DEFAULT NULL,
  `kepala_keluarga` varchar(255) DEFAULT NULL,
  `nama` varchar(255) DEFAULT NULL,
  `nik` bigint(20) DEFAULT NULL,
  `pendidikan` varchar(255) DEFAULT NULL,
  `tanggal_lahir` varchar(255) DEFAULT NULL,
  `tempat_lahir` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `tb_kartu_keluarga`
--

CREATE TABLE `tb_kartu_keluarga` (
  `id` int(11) NOT NULL,
  `alamat` varchar(255) DEFAULT NULL,
  `desa_kelurahan` varchar(255) DEFAULT NULL,
  `kabupaten_kota` varchar(255) DEFAULT NULL,
  `kecamatan` varchar(255) DEFAULT NULL,
  `kode_pos` int(11) NOT NULL,
  `nomor_kk` bigint(20) DEFAULT NULL,
  `provinsi` varchar(255) DEFAULT NULL,
  `rt` tinyint(4) NOT NULL,
  `rw` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `tb_user`
--

CREATE TABLE `tb_user` (
  `id` bigint(20) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nama` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_user`
--

INSERT INTO `tb_user` (`id`, `email`, `nama`, `password`) VALUES
(1, 'ikhsan@gmail.com', 'Nur Ikhsan Ramdhani', '123'),
(14, 'adhan@gmail.com', 'adhan', 'password');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tb_anggota_keluarga`
--
ALTER TABLE `tb_anggota_keluarga`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_bywkdjskykb96hmh9lcryewxy` (`nik`);

--
-- Indexes for table `tb_kartu_keluarga`
--
ALTER TABLE `tb_kartu_keluarga`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_l5a9ni4xb6scxv4kmb7aa8csw` (`nomor_kk`);

--
-- Indexes for table `tb_user`
--
ALTER TABLE `tb_user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_4vih17mube9j7cqyjlfbcrk4m` (`email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tb_anggota_keluarga`
--
ALTER TABLE `tb_anggota_keluarga`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT for table `tb_kartu_keluarga`
--
ALTER TABLE `tb_kartu_keluarga`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT for table `tb_user`
--
ALTER TABLE `tb_user`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
