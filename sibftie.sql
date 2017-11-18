-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jun 14, 2017 at 05:08 AM
-- Server version: 10.1.16-MariaDB
-- PHP Version: 7.0.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `sibftie`
--

-- --------------------------------------------------------

--
-- Table structure for table `t_akun`
--

CREATE TABLE `t_akun` (
  `id` bigint(20) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `t_mahasiswa_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `t_akun`
--

INSERT INTO `t_akun` (`id`, `email`, `password`, `t_mahasiswa_id`) VALUES
(1, 'iss14008@students.del.ac.id', '$2a$10$ZcbPJ6WDmV.1NZ3S77NQnuv6kYS7g2Vgd5fAJozFSV3xv/J10Z976', 1),
(2, 'iss14027@students.del.ac.id', '$2a$10$AmlgFNOGIckbVOU7vyRFFetUKMY1TiGmjt.Q3DaxzFRkbi6aRU0Am', 2),
(3, 'iss14017@students.del.ac.id', '$2a$10$VRuSOIFpu1qBFhZH0ycd2.By4Cgq3cz/GqEy2O.qRG1lrFCfftBDe', 3),
(4, 'iss14023@students.del.ac.id', '$2a$10$GvIOUkVpHo4Q19RyXtG7yOH4xADO8O3WU7//B/U.E6McdvizMJmom', 4),
(5, 'iss14030@students.del.ac.id', '$2a$10$wo3HnscRpjUCNw6LCHxJQOF7WicqOcXdx.V8I7Prtu249AI37FSWi', 5),
(6, 'iss14006@students.del.ac.id', '$2a$10$OylR3Fqgx2tyMlu7eY3SzuaqGgw/1FZA3bYA1i8ZGemUUP3hwlDJS', 6),
(7, 'iss14005@students.del.ac.id', '$2a$10$Qd15WA2Ob0QaU9eFd.Znk.Fn1MQsBLKdlWSY095flsmfPvKsQH4FS', 7);

-- --------------------------------------------------------

--
-- Table structure for table `t_aspirasi`
--

CREATE TABLE `t_aspirasi` (
  `id` bigint(20) NOT NULL,
  `isi_aspirasi` varchar(5000) NOT NULL,
  `judul_aspirasi` varchar(255) NOT NULL,
  `tgl_dibuat` datetime DEFAULT NULL,
  `t_mahasiswa_id` bigint(20) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `t_aspirasi`
--

INSERT INTO `t_aspirasi` (`id`, `isi_aspirasi`, `judul_aspirasi`, `tgl_dibuat`, `t_mahasiswa_id`, `status`) VALUES
(4, 'Mahasiswa News | Sudah lebih dari 1 setengah tahun Universitas Negeri Jakarta yang dipimpin oleh Prof. Dr. Djaali menuai banyak tantangan dalam kepemimpinannya. Kepemimpinan Prof. Dr. Djaali terlihat semakin minus, terlebih dalam berbagai persoalan seperti; carut-marutnya pelaksanaan KKN/KKL, isu UKT, permasalahan perparkiran UNJ, isu kepindahan FMIPA UNJ, pemaksaan sistem BEM Prodi, hingga ingkarnya janji rektorat UNJ pada mahasiswa terhadap kasus pelecehan seksual yang dilakukan oleh oknum dosen FIS. Rentetan permasalah kampus ini tentu saja tidak bisa dibiarkan begitu saja. Terlebih, hal ini telah membawa implikasi yang langsung terhadap mahasiswa UNJ, yang ujung-ujungnya, mahasiswa juga yang akan dirugikan. ', 'Ini Tujuh Tuntutan Aspirasi Mahasiswa UNJ Kepada Rektor', '2017-06-06 00:10:21', 1, 'Sudah dirapatkan'),
(5, 'MELALUI Senat Mahasiswa Sekolah Tinggi Agama Islam (STAI) Siliwangi Bandung, telah banyak aspirasi mahasiswa diolah bersama dan menghasilkan ide-ide segar dan kreatif.\r\n\r\nPada 2006, civitas academica STAI Siliwangi Bandung di Jalan Terusan Jenderal Sudirman, Kebonrumput Kota Cimahi ini sepakat, membentuk organisasi kemahasiswaan yang diberi nama Senat Mahasiswa STAI Siliwangi Bandung.\r\n\r\nKehadiran organisasi ini tak lain untuk mewadahi segala bentuk aspirasi mahasiswa STAI Siliwangi Bandung, mulai dari keluhan mahasiswa terkait kebijakan kampus atau hanya sekadar memberikan beberapa masukan agar kampus mereka dapat terus berkembang jauh lebih baik lagi.\r\n\r\nLebih dari 20 mahasiswa STAI Siliwangi Bandung yang tercatat sebagai anggota maupun pengurus Senat STAI Siliwangi Bandung, kerap berkumpul di sekretariat. Pertemuan ini digelar setiap Sabtu sore setelah kegiatan kuliah selesai. ', ' Jembatan Aspirasi Seluruh Mahasiswa', '2017-06-06 00:11:33', 2, 'Sudah dirapatkan'),
(6, 'Wadah maksudnya adalah tempat. Jadi artinya tempat  mahasiswa menyalurkan aspirasinya. BEM UIN SUSKA Adalah sebuah organisasi dengan salah satu wadah aspirasi mahasiswa. BEM selalu membantu keluhan mahasiswa selagi masih di jalur yang tepat dan tujuan untuk yang lebih baik kedepannya.\r\n\r\nKetika seseorang mengatakan “ BEM hanyalah sebuah organisasi kampus yang kegiatannya hanya melaksanakan kegiatan lomba dan lomba dan lomba sepanjang periodenya”. Pemikiran ini sangat lah jauh dari kenyataan. Sebenarnya BEm telah banyak melakukan hal-hal yang menjadi aspirasi mahasiswa, selain itu BEM UIN SUSKA telah banyak melakukan hal-hal social untuk mahasiswa maupun masyarakat sekitar. Mungkin berita seperti ini belum terdengar oleh orang-orang yang berpikiran jelek tentang BEM.', 'Wadah Aspirasi Mahasiswa', '2017-06-06 00:12:55', 1, 'Sudah dirapatkan'),
(7, 'contoh', 'contoh', '2017-06-06 00:40:06', 4, 'Sudah dirapatkan'),
(8, 'Contoh', 'Conoth', '2017-06-06 03:23:40', 3, 'Sudah dirapatkan'),
(9, 'Sebaiknya tutorial dilaksanakan seminggu sekali', 'Terkait Tutorial Madas', '2017-06-06 09:44:04', 6, 'Sudah dirapatkan');

-- --------------------------------------------------------

--
-- Table structure for table `t_diskusi`
--

CREATE TABLE `t_diskusi` (
  `id` bigint(20) NOT NULL,
  `isi_diskusi` varchar(255) DEFAULT NULL,
  `judul_diskusi` varchar(255) DEFAULT NULL,
  `tgl_dibuat` datetime DEFAULT NULL,
  `time_stamp` datetime DEFAULT NULL,
  `t_kategori_id` bigint(20) DEFAULT NULL,
  `t_mahasiswa_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `t_dokumen`
--

CREATE TABLE `t_dokumen` (
  `id` bigint(20) NOT NULL,
  `deskripsi` varchar(255) DEFAULT NULL,
  `jdl_dokumen` varchar(255) NOT NULL,
  `jml_spam` int(11) DEFAULT NULL,
  `path` varchar(255) DEFAULT NULL,
  `tgl_dibuat` datetime DEFAULT NULL,
  `t_mahasiswa_id` bigint(20) DEFAULT NULL,
  `file_name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `t_dokumen`
--

INSERT INTO `t_dokumen` (`id`, `deskripsi`, `jdl_dokumen`, `jml_spam`, `path`, `tgl_dibuat`, `t_mahasiswa_id`, `file_name`) VALUES
(9, 'java, Spring boot, tutorial', 'Spring Boot Reference', 0, '\\user\\12s14023\\dokumen\\spring-boot-reference.pdf', '2017-06-05 09:30:55', 4, 'spring-boot-reference.pdf'),
(10, 'Jquery;  javascript; java script', 'JQuery Tutorial', 0, '\\user\\12s14008\\dokumen\\jquery_tutorial.pdf', '2017-06-05 09:45:03', 1, 'jquery_tutorial.pdf');

-- --------------------------------------------------------

--
-- Table structure for table `t_event`
--

CREATE TABLE `t_event` (
  `id` bigint(20) NOT NULL,
  `deskripsi` varchar(255) DEFAULT NULL,
  `nama_kegiatan` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `t_jabatan`
--

CREATE TABLE `t_jabatan` (
  `id` bigint(20) NOT NULL,
  `deskripsi` varchar(255) DEFAULT NULL,
  `nama_jabatan` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `t_jabatan`
--

INSERT INTO `t_jabatan` (`id`, `deskripsi`, `nama_jabatan`) VALUES
(1, 'Anggota', 'ANGGOTA'),
(2, 'Ketua Divisi', 'KETUADIVISI'),
(3, 'Bendahara', 'BENDAHARA'),
(4, 'Sekretaris', 'SEKRETARIS'),
(5, 'Ketua BEM', 'KETUABEM');

-- --------------------------------------------------------

--
-- Table structure for table `t_kategori_diskusi`
--

CREATE TABLE `t_kategori_diskusi` (
  `id` bigint(20) NOT NULL,
  `deskripsi_kategori` varchar(255) DEFAULT NULL,
  `nama_kategori` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `t_kategori_pengumuman`
--

CREATE TABLE `t_kategori_pengumuman` (
  `id` bigint(20) NOT NULL,
  `deskripsi_kategori` varchar(255) DEFAULT NULL,
  `nama_kategori` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `t_kategori_pengumuman`
--

INSERT INTO `t_kategori_pengumuman` (`id`, `deskripsi_kategori`, `nama_kategori`) VALUES
(1, NULL, 'Berita'),
(2, NULL, 'Pengumuman');

-- --------------------------------------------------------

--
-- Table structure for table `t_kelas`
--

CREATE TABLE `t_kelas` (
  `id` bigint(20) NOT NULL,
  `deskripsi` varchar(255) NOT NULL,
  `kode_kelas` varchar(255) DEFAULT NULL,
  `t_prodi_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `t_kelas`
--

INSERT INTO `t_kelas` (`id`, `deskripsi`, `kode_kelas`, `t_prodi_id`) VALUES
(1, 'Kelas SI Tingkat 1-a', '12S101', 1);

-- --------------------------------------------------------

--
-- Table structure for table `t_komentar`
--

CREATE TABLE `t_komentar` (
  `id` bigint(20) NOT NULL,
  `file_path` varchar(255) DEFAULT NULL,
  `isi_komentar` varchar(255) DEFAULT NULL,
  `rating` int(11) DEFAULT NULL,
  `tgl_dibuat` datetime DEFAULT NULL,
  `t_diskusi_id` bigint(20) DEFAULT NULL,
  `t_mahasiswa_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `t_mahasiswa`
--

CREATE TABLE `t_mahasiswa` (
  `id` bigint(20) NOT NULL,
  `alamat` varchar(255) DEFAULT NULL,
  `jns_kelamin` varchar(255) DEFAULT NULL,
  `nama_lengkap` varchar(255) NOT NULL,
  `nim` varchar(9) DEFAULT NULL,
  `tgl_lahir` datetime DEFAULT NULL,
  `t_kelas_id` bigint(20) DEFAULT NULL,
  `path` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `t_mahasiswa`
--

INSERT INTO `t_mahasiswa` (`id`, `alamat`, `jns_kelamin`, `nama_lengkap`, `nim`, `tgl_lahir`, `t_kelas_id`, `path`) VALUES
(1, 'Simorangkir', 'Laki-Laki', 'Surya Dharma Simorangkir', '12s14008', '1996-01-21 00:00:00', 1, 'user.png'),
(2, 'Samosir', 'Laki-Laki', 'Hottua Gultom', '12s14027', '1996-01-07 00:00:00', 1, 'user.png'),
(3, 'Medan', 'Laki-Laki', 'Tommy Harlis Manurung', '12s14017', '1996-01-01 00:00:00', 1, 'user.png'),
(4, 'Medan', 'Perempuan', 'Sahala Zico Simamora', '12s14023', '2017-06-02 00:00:00', 1, 'user.png'),
(5, 'Medan', 'Laki-Laki', 'Albert Kelvin Hutapea', 'iss14030', '2017-05-10 00:00:00', 1, 'user.png'),
(6, 'Samosir', 'Perempuan', 'Martha Pardede', '12s14006', '1996-02-13 00:00:00', 1, 'user.png'),
(7, 'Medan', 'Laki-Laki', 'asdfasdf', '12s14005', '2009-01-04 00:00:00', 1, 'user.png');

-- --------------------------------------------------------

--
-- Table structure for table `t_mahasiswa_jabatan`
--

CREATE TABLE `t_mahasiswa_jabatan` (
  `mahasiswa_jabatan_id` bigint(20) NOT NULL,
  `end` datetime DEFAULT NULL,
  `periode_jabatan` varchar(255) DEFAULT NULL,
  `start` datetime DEFAULT NULL,
  `t_jabatan_id` bigint(20) DEFAULT NULL,
  `t_mahasiswa_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `t_mahasiswa_jabatan`
--

INSERT INTO `t_mahasiswa_jabatan` (`mahasiswa_jabatan_id`, `end`, `periode_jabatan`, `start`, `t_jabatan_id`, `t_mahasiswa_id`) VALUES
(1, '2017-05-02 00:00:00', '2017/2018', '2017-02-01 00:00:00', 1, 1),
(2, '2017-05-29 00:00:00', '2017/2018', '2017-05-30 00:00:00', 1, 2),
(3, '2017-05-29 00:00:00', '2017/2018', '2017-05-29 00:00:00', 2, 3),
(4, '2017-05-30 00:00:00', '2017/2018', '2017-05-30 00:00:00', 5, 4),
(5, '2017-05-29 00:00:00', '2017/2018', '2017-05-30 00:00:00', 4, 5),
(6, '2017-07-07 00:00:00', '2017/2018', '2017-06-06 00:00:00', 1, 6),
(7, '2017-06-22 00:00:00', '2017/2018', '2017-06-18 00:00:00', 1, 7);

-- --------------------------------------------------------

--
-- Table structure for table `t_pengeluaran`
--

CREATE TABLE `t_pengeluaran` (
  `id` bigint(20) NOT NULL,
  `jml_pengeluaran` decimal(19,2) DEFAULT NULL,
  `periode` datetime DEFAULT NULL,
  `tgl_pengeluaran` datetime DEFAULT NULL,
  `time_stamp` datetime DEFAULT NULL,
  `t_event_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `t_pengumuman`
--

CREATE TABLE `t_pengumuman` (
  `id` bigint(20) NOT NULL,
  `isi_pengumuman` varchar(7000) DEFAULT NULL,
  `judul` varchar(255) DEFAULT NULL,
  `path_file` varchar(255) DEFAULT NULL,
  `tgl_dibuat` datetime DEFAULT NULL,
  `time_stamp` datetime DEFAULT NULL,
  `t_kategori_pengumuman_id` bigint(20) DEFAULT NULL,
  `t_mahasiswa_id` bigint(20) DEFAULT NULL,
  `t_privasi_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `t_pengumuman`
--

INSERT INTO `t_pengumuman` (`id`, `isi_pengumuman`, `judul`, `path_file`, `tgl_dibuat`, `time_stamp`, `t_kategori_pengumuman_id`, `t_mahasiswa_id`, `t_privasi_id`) VALUES
(20, '<p><strong>Dear Students,.</strong></p>\r\n\r\n<p><strong>Diharapkan kehadirannya untuk mendengarkan sharing session, sumbangan pemikiran mengenai permasalahan di sekitar Toba Samosir dilihat dari sudut pandang berpikir sistem yang akan di adakan pada :</strong></p>\r\n\r\n<p><strong>Hari/Tanggal : Selasa, 6 Juni 2017</strong></p>\r\n\r\n<p><strong>Pukul : 14.00 - 17.00 WIB</strong></p>\r\n\r\n<p><strong>Tempat : Auditorium Institut Teknologi Del</strong></p>\r\n\r\n<p><strong>Kegiatan :<em>&nbsp;Sharing session</em>&nbsp;mengenai perilaku berkendaraan di Toba Samosir, Tingginya penderita HIV Aids, Fenomena Malaria, Transportasi di Toba Samosir dll.</strong></p>\r\n\r\n<p><strong>Sharing session ini akan disampaikan dalam bentuk acara yang&nbsp;<em>Fun</em>&nbsp;dan&nbsp;<em>Relax</em>, ditunggu kehadirannya.&nbsp;</strong></p>\r\n\r\n<p>&nbsp;</p>\r\n\r\n<p><strong>Salam,.&nbsp;</strong></p>\r\n\r\n<p>&nbsp;</p>\r\n\r\n<p><strong><img alt="" src="https://localhost:8443/pengumuman/publik/Berpikir_Sistem_iklan.jpg" style="height:294px; width:700px" /></strong></p>\r\n', 'Sharing Session Berpikir Sistem', NULL, '2017-06-06 03:46:15', '2017-06-06 03:46:15', 2, 4, 1),
(21, '<p>Dear students,</p>\r\n\r\n<p>Tugas makalah (untuk semua kelompok) dan/atau tugas individual PAM dikumpulkan pada hari Rabu, 7 Mei 2017, sebelum pukul 16.00 WIB kepada saya. Teknis pengumpulan adalah semua dokumen dikumpulkan ke ketua kelas masing-masing, dan kemudian ketua kelas memberikan kepada saya via USB flashdisk di kantor.</p>\r\n\r\n<p>Terima kasih.</p>\r\n\r\n<p>Salam,</p>\r\n', '[PAM]Pengumpulan Makalah Dan Tugas Individual', NULL, '2017-06-06 03:57:34', '2017-06-06 03:57:34', 2, 4, 1),
(22, '<p><img alt="" src="https://localhost:8443/pengumuman/publik/gemastik.PNG" style="height:298px; width:650px" /></p>\r\n\r\n<p>Gemastik atau Pagelaran Mahasiswa Nasional Bidang Teknologi Informasi dan Komunikasi merupakan kegiatan yang bertujuan untuk meningkatkan kualitas peserta didik dalam memajukan TIK dan pemanfaatannya di Indonesia.</p>\r\n\r\n<p>Dalam delapan tahun terakhir, Gemastik telah dilaksanakan secara berkesinambungan di bawah Direktorat Penelitian dan Pengabdian kepada Masyarakat (DP2M) DIKTI. Kegiatan ini merupakan media penyalur kreativitas mahasiswa dalam pengembangan Teknologi Informasi dan Komunikasi di tingkat nasional. Mahasiswa sebagai pilar penting dalam pembangunan Negara, diharapkan dapat meningkatkan kemampuannya dalam penguasaan TIK dan dapat mengembangkan potensi besarnya sebagai agen perubahan melalui pengembangan IPTEK di masa kini dan masa yang akan datang.</p>\r\n\r\n<p>Pada tahun 2016 ini, Gemastik kembali diselenggarakan. Universitas Indonesia bertindak sebagai host dan Fakultas Ilmu Komputer Universitas Indonesia (Fasilkom UI) sebagai co-host. Ini merupakan tahun ke-9 kegiatan Gemastik sejak pertama kali diselenggarakan pada tahun 2007. Pada tahun ini, Gemastik 9 mengusung tema&nbsp;<strong>&quot;Enabling Smart Society through ICT&quot;</strong>. Acara puncak Gemastik 9 akan dilaksanakan pada tanggal 27-29 Oktober 2016 di Kampus Universitas Indonesia, Depok. Rangkaian acara dalam Gemastik 9 terdiri dari Perlombaan di bidang TIK, Seminar, Pameran hasil karya Finalis Gemastik 9 dan sponsor, serta Pentas Budaya dan Keseniaan.</p>\r\n', 'GEMASTIK 9', 'https://localhost:8443/pengumuman/publik/gemastik.PNG', '2017-06-06 04:06:04', '2017-06-06 04:06:04', 1, 4, 1),
(23, '<p>Rabu 17 mei 2017 bertempat di Gedung Serba Guna (GSG) Del diadakan sosialisasi Gerakan Aksi Bersih dengan tema &ldquo; Edukasi Budaya Bersih dan Senyum Mendukung Program Indonesia Bersih&rdquo; yang diberikan oleh Asosiasi Pemuda Maritim Indonesia (APMI).</p>\r\n\r\n<p>Acara ini dihadiri oleh seluruh mahasiswa IT Del, Bapak Rektor beserta dosen staff IT Del. Sebelumnya tim kemaritiman juga telah memberikan sosialisasi kepada SMA Unggul Del. Tim kemaritiman ini &nbsp;terdiri dari Bapak Edi Susilo , S.Pi., M. Si, Drs. Sudradjat Rasyid, MA dan Kaisar Akhir , SIK. Sebelumnya Kementerian Koordinator Bidang Kemaritiman (Kemenko Maritim) mengadakan kegiatan Gerakan Indonesia Bersih serentak di 10 lokasi di Jakarta. Salah satunay di derah Banjir Kanal Timur (BKT), Cilincing, Jakarta Utara. Dengan harapan kegiatan seperti ini juga bisa dilakukan di Toba Samosir.</p>\r\n\r\n<p>Acara pertama dari sosialisasi ini merupakan ucapan selamat datang dan terimakasih IT Del yang disampaikan oleh Bapak Prof.Ir. Togar M. Simatupang, M. Tech., Ph.D selaku Rektor IT Del atas kesediaan tim dari Kemenko Maritim memberikan pemaparan tentang pentingnya kebersihan kepada keluarga IT Del.</p>\r\n\r\n<p>Dengan memberikan pemaparan tentang kebersihan tim Kemaritiman berharap Mahasiswa nantinya dapat berperan aktif dalam rangka menyukseskan Indonesia yang lebih bersih. Mengingat Indonesia merupakan Negara penghasil sampah terbesar kedua setelah cina dengan kondisi sampah yang mengerikan baik itu disungai, didarat dan dilaut diharapkan budaya bersih dan senyum ini dapat membantu Indonesia dalam mengurangi sampah yang ada.</p>\r\n\r\n<p>Dengan berkurangnya sampah yang ada dilingkungan kita maka tingkat kesehatan masyakarat kita pun dapat lebih baik. Maka dari itu, sangat diharapkan masa depan negeri ini tergantung pada kita, tidak hanya pada program Indonesai bersih saja tapi pada semua program untuk Indonesia bersih.</p>\r\n\r\n<p>Dan terutama bagi muda-mudi Indonesia sebagai Agent of Change, sangat diharapkan untuk memberikan ide-ide kreatif demi kebersihan kita bersama.</p>\r\n\r\n<p>Dengan program aksi bersih ini sangat diharapkan bisa memberikan dorongan agar masyarakat bisa bergerak dan mulai menyadari sampah ini merupakan tantangan bersama bukan sebagian orang saja. Dan kita sebagai masyakarat Indonesia tentunya kaum muda-mudi seperti mahasiswa sadar bahwa hidup bersih dan sehat itu penting.</p>\r\n\r\n<p><br />\r\n<img alt="" src="https://localhost:8443/pengumuman/publik/DSC_0273.jpg" style="height:298px; width:448px" /></p>\r\n', 'SOSIALISASI GERAKAN AKSI BERSIH OLEH KEMENTRIAN KOORDINATOR KEMARITIMAN DI IT DEL', 'https://localhost:8443/pengumuman/publik/DSC_0273.jpg', '2017-06-06 04:56:13', '2017-06-06 04:56:13', 1, 4, 1),
(24, '<p>Tutorial akan dilaksanakan pada :</p>\r\n\r\n<p>hari: sabtu</p>\r\n\r\n<p>Tempat: Gd 712</p>\r\n', 'Tutorial Madas hari Sabtu', '', '2017-06-06 09:48:29', '2017-06-06 09:48:29', 2, 4, 1),
(25, '<p><img alt="" src="https://localhost:8443/pengumuman/publik/aa.PNG" style="height:615px; width:1320px" /></p>\r\n', 'Judul', 'https://localhost:8443/pengumuman/publik/aa.PNG', '2017-06-06 11:24:39', '2017-06-06 11:24:39', 1, 4, 1),
(26, '<h1>Judul 1</h1>\r\n\r\n<hr />\r\n<h2>Sub Judul<img alt="" src="https://localhost:8443/pengumuman/publik/Berpikir_Sistem_iklan.jpg" style="float:left; height:199px; width:473px" /></h2>\r\n\r\n<p>Paragraph</p>\r\n\r\n<h2 style="font-style:italic;">italic</h2>\r\n\r\n<h2><strong>BOLT</strong></h2>\r\n\r\n<pre>\r\n\r\n\r\n\r\nList</pre>\r\n\r\n<ol>\r\n	<li>\r\n	<pre>\r\nList 1 </pre>\r\n	</li>\r\n	<li>\r\n	<pre>\r\nList 2</pre>\r\n	</li>\r\n	<li>List 3</li>\r\n</ol>\r\n\r\n<blockquote>\r\n<p>Block Quote</p>\r\n\r\n<p>Example of block quote</p>\r\n</blockquote>\r\n\r\n<p>&nbsp;</p>\r\n\r\n<p>&nbsp;</p>\r\n', 'Judul', '', '2017-06-07 22:58:52', '2017-06-07 22:58:52', 1, 4, 1);

-- --------------------------------------------------------

--
-- Table structure for table `t_privasi`
--

CREATE TABLE `t_privasi` (
  `id` bigint(20) NOT NULL,
  `nama_privasi` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `t_privasi`
--

INSERT INTO `t_privasi` (`id`, `nama_privasi`) VALUES
(1, 'PUBLIC'),
(2, 'PRIVATE');

-- --------------------------------------------------------

--
-- Table structure for table `t_prodi`
--

CREATE TABLE `t_prodi` (
  `id` bigint(20) NOT NULL,
  `kode_prodi` varchar(255) DEFAULT NULL,
  `nama_prodi` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `t_prodi`
--

INSERT INTO `t_prodi` (`id`, `kode_prodi`, `nama_prodi`) VALUES
(1, 'S1-SI', 'Sarjana Sistem Informasi');

-- --------------------------------------------------------

--
-- Table structure for table `t_proposal`
--

CREATE TABLE `t_proposal` (
  `id` bigint(20) NOT NULL,
  `judul_dokumen` varchar(255) NOT NULL,
  `path_dokument` varchar(255) NOT NULL,
  `status` varchar(255) NOT NULL,
  `time_stamp` datetime DEFAULT NULL,
  `t_mahasiswa_id` bigint(20) DEFAULT NULL,
  `file_name` varchar(255) DEFAULT NULL,
  `tgl_dibuat` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `t_proposal`
--

INSERT INTO `t_proposal` (`id`, `judul_dokumen`, `path_dokument`, `status`, `time_stamp`, `t_mahasiswa_id`, `file_name`, `tgl_dibuat`) VALUES
(2, 'Proposal Kegiatan FTIE Kompetisi', '\\publik\\12s14017\\proposal\\PROPOSAL KEGIATAN FTIE Competition.pdf', 'Baru', '2017-06-06 08:16:03', 3, 'PROPOSAL KEGIATAN FTIE Competition.pdf', '2017-06-06 08:16:03'),
(3, 'Proposal keuangan BEM FTIE', '\\publik\\12s14017\\proposal\\PROPOSAL KEGIATAN FTIE Competition.pdf', 'Baru', '2017-06-06 09:57:54', 3, 'PROPOSAL KEGIATAN FTIE Competition.pdf', '2017-06-06 09:57:54');

-- --------------------------------------------------------

--
-- Table structure for table `t_transaksi`
--

CREATE TABLE `t_transaksi` (
  `id` bigint(20) NOT NULL,
  `saldo` decimal(19,2) DEFAULT NULL,
  `time_stamp` datetime DEFAULT NULL,
  `t_pengeluaran_id` bigint(20) DEFAULT NULL,
  `t_uang_kas_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `t_uang_kas`
--

CREATE TABLE `t_uang_kas` (
  `id` bigint(20) NOT NULL,
  `status` bit(1) DEFAULT NULL,
  `jml_hutang` decimal(19,2) DEFAULT NULL,
  `jml_pembayaran` decimal(19,2) DEFAULT NULL,
  `jml_penyetoran` decimal(19,2) DEFAULT NULL,
  `tgl_penyetoran` datetime DEFAULT NULL,
  `time_stamp` datetime DEFAULT NULL,
  `t_kelas_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `t_akun`
--
ALTER TABLE `t_akun`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_qprhbhs9qedxev23lb997058o` (`email`),
  ADD KEY `FK1s41qj97mhhdt61wuc8orqbo2` (`t_mahasiswa_id`);

--
-- Indexes for table `t_aspirasi`
--
ALTER TABLE `t_aspirasi`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK9425ae4frbe9e6xcpckv8at67` (`t_mahasiswa_id`);

--
-- Indexes for table `t_diskusi`
--
ALTER TABLE `t_diskusi`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKsq5twljmw3h2nljac0wsatrjj` (`t_kategori_id`),
  ADD KEY `FK2ofn692q0bdepsemnll5gsdv1` (`t_mahasiswa_id`);

--
-- Indexes for table `t_dokumen`
--
ALTER TABLE `t_dokumen`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK5h70w77plxsqw66okcx9htu02` (`t_mahasiswa_id`);

--
-- Indexes for table `t_event`
--
ALTER TABLE `t_event`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `t_jabatan`
--
ALTER TABLE `t_jabatan`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_ml3olxc9hl8inpoad111r1a2a` (`nama_jabatan`);

--
-- Indexes for table `t_kategori_diskusi`
--
ALTER TABLE `t_kategori_diskusi`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `t_kategori_pengumuman`
--
ALTER TABLE `t_kategori_pengumuman`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `t_kelas`
--
ALTER TABLE `t_kelas`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_2fxykkqvxopxdrt0kij5nm2ks` (`kode_kelas`),
  ADD KEY `FK2ags1kpeq72jnern8xq93crd6` (`t_prodi_id`);

--
-- Indexes for table `t_komentar`
--
ALTER TABLE `t_komentar`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKsywqa1u9drxf5kt0qmocj5yqf` (`t_diskusi_id`),
  ADD KEY `FKshmvij6bghf8kuhchvcgv50iu` (`t_mahasiswa_id`);

--
-- Indexes for table `t_mahasiswa`
--
ALTER TABLE `t_mahasiswa`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_9mhw7rky9wihunvlu5jg1fqe6` (`nim`),
  ADD KEY `FKgkyl5rntm78ga9j80fm7h11ac` (`t_kelas_id`);

--
-- Indexes for table `t_mahasiswa_jabatan`
--
ALTER TABLE `t_mahasiswa_jabatan`
  ADD PRIMARY KEY (`mahasiswa_jabatan_id`),
  ADD KEY `FK2hih7po6e37as3bylyna0ypre` (`t_jabatan_id`),
  ADD KEY `FK7r0eogyliastn7gbe1ummrn9m` (`t_mahasiswa_id`);

--
-- Indexes for table `t_pengeluaran`
--
ALTER TABLE `t_pengeluaran`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK39i2dhase3jfgeacthgg1chf0` (`t_event_id`);

--
-- Indexes for table `t_pengumuman`
--
ALTER TABLE `t_pengumuman`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK2nrfgluvtesbmrco2reqytski` (`t_kategori_pengumuman_id`),
  ADD KEY `FK8yj4rrm6yvw31gbv6aknmaj1f` (`t_mahasiswa_id`),
  ADD KEY `FK2fs11yr4hd7tsrvlxfphcgq96` (`t_privasi_id`);

--
-- Indexes for table `t_privasi`
--
ALTER TABLE `t_privasi`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `t_prodi`
--
ALTER TABLE `t_prodi`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_hkdcdbrqybor0h62m8x5ntibg` (`kode_prodi`);

--
-- Indexes for table `t_proposal`
--
ALTER TABLE `t_proposal`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKsjabynpnvmu99w3xfo4kmuo51` (`t_mahasiswa_id`);

--
-- Indexes for table `t_transaksi`
--
ALTER TABLE `t_transaksi`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKr7ugtlsyis0heivl95fehvusm` (`t_pengeluaran_id`),
  ADD KEY `FKmmn6oqctropc5f4h0bqy4sjcl` (`t_uang_kas_id`);

--
-- Indexes for table `t_uang_kas`
--
ALTER TABLE `t_uang_kas`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKptlslynmqv4ml73008scv22ma` (`t_kelas_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `t_akun`
--
ALTER TABLE `t_akun`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT for table `t_aspirasi`
--
ALTER TABLE `t_aspirasi`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT for table `t_diskusi`
--
ALTER TABLE `t_diskusi`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `t_dokumen`
--
ALTER TABLE `t_dokumen`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT for table `t_event`
--
ALTER TABLE `t_event`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `t_jabatan`
--
ALTER TABLE `t_jabatan`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `t_kategori_diskusi`
--
ALTER TABLE `t_kategori_diskusi`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `t_kategori_pengumuman`
--
ALTER TABLE `t_kategori_pengumuman`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `t_kelas`
--
ALTER TABLE `t_kelas`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `t_komentar`
--
ALTER TABLE `t_komentar`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `t_mahasiswa`
--
ALTER TABLE `t_mahasiswa`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT for table `t_mahasiswa_jabatan`
--
ALTER TABLE `t_mahasiswa_jabatan`
  MODIFY `mahasiswa_jabatan_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT for table `t_pengeluaran`
--
ALTER TABLE `t_pengeluaran`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `t_pengumuman`
--
ALTER TABLE `t_pengumuman`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;
--
-- AUTO_INCREMENT for table `t_privasi`
--
ALTER TABLE `t_privasi`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `t_prodi`
--
ALTER TABLE `t_prodi`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `t_proposal`
--
ALTER TABLE `t_proposal`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `t_transaksi`
--
ALTER TABLE `t_transaksi`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `t_uang_kas`
--
ALTER TABLE `t_uang_kas`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `t_akun`
--
ALTER TABLE `t_akun`
  ADD CONSTRAINT `FK1s41qj97mhhdt61wuc8orqbo2` FOREIGN KEY (`t_mahasiswa_id`) REFERENCES `t_mahasiswa` (`id`);

--
-- Constraints for table `t_aspirasi`
--
ALTER TABLE `t_aspirasi`
  ADD CONSTRAINT `FK9425ae4frbe9e6xcpckv8at67` FOREIGN KEY (`t_mahasiswa_id`) REFERENCES `t_mahasiswa` (`id`);

--
-- Constraints for table `t_diskusi`
--
ALTER TABLE `t_diskusi`
  ADD CONSTRAINT `FK2ofn692q0bdepsemnll5gsdv1` FOREIGN KEY (`t_mahasiswa_id`) REFERENCES `t_mahasiswa` (`id`),
  ADD CONSTRAINT `FKsq5twljmw3h2nljac0wsatrjj` FOREIGN KEY (`t_kategori_id`) REFERENCES `t_kategori_diskusi` (`id`);

--
-- Constraints for table `t_dokumen`
--
ALTER TABLE `t_dokumen`
  ADD CONSTRAINT `FK5h70w77plxsqw66okcx9htu02` FOREIGN KEY (`t_mahasiswa_id`) REFERENCES `t_mahasiswa` (`id`);

--
-- Constraints for table `t_kelas`
--
ALTER TABLE `t_kelas`
  ADD CONSTRAINT `FK2ags1kpeq72jnern8xq93crd6` FOREIGN KEY (`t_prodi_id`) REFERENCES `t_prodi` (`id`);

--
-- Constraints for table `t_komentar`
--
ALTER TABLE `t_komentar`
  ADD CONSTRAINT `FKshmvij6bghf8kuhchvcgv50iu` FOREIGN KEY (`t_mahasiswa_id`) REFERENCES `t_mahasiswa` (`id`),
  ADD CONSTRAINT `FKsywqa1u9drxf5kt0qmocj5yqf` FOREIGN KEY (`t_diskusi_id`) REFERENCES `t_diskusi` (`id`);

--
-- Constraints for table `t_mahasiswa`
--
ALTER TABLE `t_mahasiswa`
  ADD CONSTRAINT `FKgkyl5rntm78ga9j80fm7h11ac` FOREIGN KEY (`t_kelas_id`) REFERENCES `t_kelas` (`id`);

--
-- Constraints for table `t_mahasiswa_jabatan`
--
ALTER TABLE `t_mahasiswa_jabatan`
  ADD CONSTRAINT `FK2hih7po6e37as3bylyna0ypre` FOREIGN KEY (`t_jabatan_id`) REFERENCES `t_jabatan` (`id`),
  ADD CONSTRAINT `FK7r0eogyliastn7gbe1ummrn9m` FOREIGN KEY (`t_mahasiswa_id`) REFERENCES `t_mahasiswa` (`id`);

--
-- Constraints for table `t_pengeluaran`
--
ALTER TABLE `t_pengeluaran`
  ADD CONSTRAINT `FK39i2dhase3jfgeacthgg1chf0` FOREIGN KEY (`t_event_id`) REFERENCES `t_event` (`id`);

--
-- Constraints for table `t_pengumuman`
--
ALTER TABLE `t_pengumuman`
  ADD CONSTRAINT `FK2fs11yr4hd7tsrvlxfphcgq96` FOREIGN KEY (`t_privasi_id`) REFERENCES `t_privasi` (`id`),
  ADD CONSTRAINT `FK2nrfgluvtesbmrco2reqytski` FOREIGN KEY (`t_kategori_pengumuman_id`) REFERENCES `t_kategori_pengumuman` (`id`),
  ADD CONSTRAINT `FK8yj4rrm6yvw31gbv6aknmaj1f` FOREIGN KEY (`t_mahasiswa_id`) REFERENCES `t_mahasiswa` (`id`);

--
-- Constraints for table `t_proposal`
--
ALTER TABLE `t_proposal`
  ADD CONSTRAINT `FKsjabynpnvmu99w3xfo4kmuo51` FOREIGN KEY (`t_mahasiswa_id`) REFERENCES `t_mahasiswa` (`id`);

--
-- Constraints for table `t_transaksi`
--
ALTER TABLE `t_transaksi`
  ADD CONSTRAINT `FKmmn6oqctropc5f4h0bqy4sjcl` FOREIGN KEY (`t_uang_kas_id`) REFERENCES `t_uang_kas` (`id`),
  ADD CONSTRAINT `FKr7ugtlsyis0heivl95fehvusm` FOREIGN KEY (`t_pengeluaran_id`) REFERENCES `t_pengeluaran` (`id`);

--
-- Constraints for table `t_uang_kas`
--
ALTER TABLE `t_uang_kas`
  ADD CONSTRAINT `FKptlslynmqv4ml73008scv22ma` FOREIGN KEY (`t_kelas_id`) REFERENCES `t_kelas` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
