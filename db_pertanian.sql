-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 23 Jul 2021 pada 01.14
-- Versi server: 10.4.20-MariaDB
-- Versi PHP: 8.0.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_pertanian`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `detail_transaksi`
--

CREATE TABLE `detail_transaksi` (
  `ID_Penjualan` varchar(4) NOT NULL,
  `Kode_Tanaman` int(5) NOT NULL,
  `ID_Distributor` int(5) NOT NULL,
  `ID_Admin` int(5) NOT NULL,
  `Jumlah` int(10) NOT NULL,
  `Harga` int(10) NOT NULL,
  `total` int(6) NOT NULL,
  `tgl_transaksi` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Trigger `detail_transaksi`
--
DELIMITER $$
CREATE TRIGGER `hapus_detail` AFTER DELETE ON `detail_transaksi` FOR EACH ROW BEGIN
UPDATE tb_tanaman SET tb_tanaman.Tersedia = tb_tanaman.Tersedia + OLD.Jumlah WHERE tb_tanaman.Kode_Tanaman = OLD.Kode_Tanaman;
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `trigg_detail` AFTER INSERT ON `detail_transaksi` FOR EACH ROW BEGIN

UPDATE tb_tanaman SET tb_tanaman.Tersedia = 	tb_tanaman.Tersedia - NEW.Jumlah WHERE tb_tanaman.Kode_Tanaman = NEW.Kode_Tanaman;

END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_admin`
--

CREATE TABLE `tb_admin` (
  `ID_Admin` int(5) NOT NULL,
  `Nama` varchar(30) NOT NULL,
  `No_HP` varchar(13) NOT NULL,
  `Password` varchar(16) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tb_admin`
--

INSERT INTO `tb_admin` (`ID_Admin`, `Nama`, `No_HP`, `Password`) VALUES
(1, 'Rokhis', '083834860600', '12345'),
(2, 'Adryan', '083834808908', '12345');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_distributor`
--

CREATE TABLE `tb_distributor` (
  `ID_Distributor` int(5) NOT NULL,
  `Nama` varchar(30) NOT NULL,
  `Alamat` varchar(50) NOT NULL,
  `No_HP` varchar(13) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tb_distributor`
--

INSERT INTO `tb_distributor` (`ID_Distributor`, `Nama`, `Alamat`, `No_HP`) VALUES
(10011, 'Labil', 'Jember', '089129928'),
(10012, 'Bella', 'Jombang', '083844321122'),
(10013, 'Kiki', 'Bondowoso', '083844321144'),
(10014, 'Putri', 'Jember', '083844321560');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_penjualan`
--

CREATE TABLE `tb_penjualan` (
  `ID_Penjualan` int(10) NOT NULL,
  `Kode_Tanaman` int(5) NOT NULL,
  `ID_Distributor` int(5) NOT NULL,
  `ID_Admin` int(5) NOT NULL,
  `Jumlah` int(5) NOT NULL,
  `Total_Harga` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_tanaman`
--

CREATE TABLE `tb_tanaman` (
  `Kode_Tanaman` int(5) NOT NULL,
  `Nama` varchar(30) NOT NULL,
  `Jenis` enum('Sayur','Buah') NOT NULL,
  `Tersedia` int(5) NOT NULL,
  `Harga` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tb_tanaman`
--

INSERT INTO `tb_tanaman` (`Kode_Tanaman`, `Nama`, `Jenis`, `Tersedia`, `Harga`) VALUES
(23432, 'Kubis', 'Sayur', 30, '10000'),
(50015, 'Nanas', 'Buah', 31, '5000');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `detail_transaksi`
--
ALTER TABLE `detail_transaksi`
  ADD PRIMARY KEY (`ID_Penjualan`),
  ADD KEY `ID_Penjualan` (`ID_Penjualan`);

--
-- Indeks untuk tabel `tb_admin`
--
ALTER TABLE `tb_admin`
  ADD PRIMARY KEY (`ID_Admin`);

--
-- Indeks untuk tabel `tb_distributor`
--
ALTER TABLE `tb_distributor`
  ADD PRIMARY KEY (`ID_Distributor`);

--
-- Indeks untuk tabel `tb_penjualan`
--
ALTER TABLE `tb_penjualan`
  ADD PRIMARY KEY (`ID_Penjualan`),
  ADD KEY `ID_Admin` (`ID_Admin`),
  ADD KEY `Kode_Tanaman` (`Kode_Tanaman`),
  ADD KEY `ID_Distributor` (`ID_Distributor`);

--
-- Indeks untuk tabel `tb_tanaman`
--
ALTER TABLE `tb_tanaman`
  ADD PRIMARY KEY (`Kode_Tanaman`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `tb_admin`
--
ALTER TABLE `tb_admin`
  MODIFY `ID_Admin` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT untuk tabel `tb_distributor`
--
ALTER TABLE `tb_distributor`
  MODIFY `ID_Distributor` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10015;

--
-- AUTO_INCREMENT untuk tabel `tb_penjualan`
--
ALTER TABLE `tb_penjualan`
  MODIFY `ID_Penjualan` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT untuk tabel `tb_tanaman`
--
ALTER TABLE `tb_tanaman`
  MODIFY `Kode_Tanaman` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=50017;

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `tb_penjualan`
--
ALTER TABLE `tb_penjualan`
  ADD CONSTRAINT `tb_penjualan_ibfk_1` FOREIGN KEY (`ID_Admin`) REFERENCES `tb_admin` (`ID_Admin`),
  ADD CONSTRAINT `tb_penjualan_ibfk_2` FOREIGN KEY (`Kode_Tanaman`) REFERENCES `tb_tanaman` (`Kode_Tanaman`),
  ADD CONSTRAINT `tb_penjualan_ibfk_3` FOREIGN KEY (`ID_Distributor`) REFERENCES `tb_distributor` (`ID_Distributor`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
