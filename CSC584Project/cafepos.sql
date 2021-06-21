-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 21, 2021 at 05:52 AM
-- Server version: 10.4.19-MariaDB
-- PHP Version: 8.0.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `cafepos`
--

-- --------------------------------------------------------

--
-- Table structure for table `outlet`
--

CREATE TABLE `outlet` (
  `outlet_ID` varchar(10) NOT NULL,
  `outlet_Name` varchar(50) NOT NULL,
  `outlet_Details` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `outlet`
--

INSERT INTO `outlet` (`outlet_ID`, `outlet_Name`, `outlet_Details`) VALUES
('JPN01', 'JAPAN', '03356948'),
('PHG02', 'Pahang ', '033265447,lot 371 ,abc'),
('SAC01', 'Shah alam', '033265447,lot 37');

-- --------------------------------------------------------

--
-- Table structure for table `price`
--

CREATE TABLE `price` (
  `price_ID` varchar(10) NOT NULL,
  `price_Value` double NOT NULL,
  `price_Discount` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `price`
--

INSERT INTO `price` (`price_ID`, `price_Value`, `price_Discount`) VALUES
('STD001', 7.3, 0),
('STD002', 5, 0),
('STD003', 8.5, 0.1);

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `product_ID` varchar(10) NOT NULL,
  `product_Name` varchar(50) NOT NULL,
  `product_Details` varchar(200) NOT NULL,
  `product_Stocks` int(11) NOT NULL,
  `price_ID` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`product_ID`, `product_Name`, `product_Details`, `product_Stocks`, `price_ID`) VALUES
('CFE001', 'Mocha', 'Coffee with chocolate', 10, 'STD001'),
('CFE002', 'Americano', 'Coffee with sugar ', 10, 'STD002'),
('FDB001', 'Tiramisu cake', 'sponge Cake', 6, 'STD003');

-- --------------------------------------------------------

--
-- Table structure for table `product_sale`
--

CREATE TABLE `product_sale` (
  `product_ID` varchar(10) NOT NULL,
  `sales_ID` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `sales`
--

CREATE TABLE `sales` (
  `sales_ID` varchar(10) NOT NULL,
  `staff_ID` varchar(10) NOT NULL,
  `sales_Total` double NOT NULL,
  `sales_date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `staff`
--

CREATE TABLE `staff` (
  `staff_ID` varchar(12) NOT NULL,
  `staff_Name` varchar(100) NOT NULL,
  `staff_Phone` varchar(12) NOT NULL,
  `staff_Password` varchar(10) NOT NULL,
  `outlet_ID` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `staff`
--

INSERT INTO `staff` (`staff_ID`, `staff_Name`, `staff_Phone`, `staff_Password`, `outlet_ID`) VALUES
('1234567890', 'Abu', '011151500013', '1234', 'SAC01'),
('2019630822', 'Muhamad Afiq Faiz', '011151500013', '1234', 'PHG02');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `outlet`
--
ALTER TABLE `outlet`
  ADD PRIMARY KEY (`outlet_ID`);

--
-- Indexes for table `price`
--
ALTER TABLE `price`
  ADD PRIMARY KEY (`price_ID`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`product_ID`);

--
-- Indexes for table `sales`
--
ALTER TABLE `sales`
  ADD PRIMARY KEY (`sales_ID`);

--
-- Indexes for table `staff`
--
ALTER TABLE `staff`
  ADD PRIMARY KEY (`staff_ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
