-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 29, 2021 at 09:26 AM
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
('PHG02', 'Pahang ', '033265447,lot 371 ,');

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
('STD001', 5, 0),
('STD002', 5, 0),
('STD004', 6.5, 0);

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
('CFE001', 'Mocha', 'Coffee with chocolate', 0, 'STD001');

-- --------------------------------------------------------

--
-- Table structure for table `product_sale`
--

CREATE TABLE `product_sale` (
  `id` int(11) NOT NULL,
  `product_ID` varchar(10) NOT NULL,
  `sales_ID` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `product_sale`
--

INSERT INTO `product_sale` (`id`, `product_ID`, `sales_ID`) VALUES
(1, 'CFE001', 1),
(4, 'CFE001', 3),
(9, 'CFE001', 5),
(10, 'CFE001', 5),
(14, 'CFE001', 8),
(20, 'CFE001', 11),
(21, 'CFE001', 11);

-- --------------------------------------------------------

--
-- Table structure for table `sales`
--

CREATE TABLE `sales` (
  `sales_ID` int(11) NOT NULL,
  `staff_ID` varchar(10) NOT NULL,
  `sales_Total` double DEFAULT NULL,
  `sales_date` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `sales`
--

INSERT INTO `sales` (`sales_ID`, `staff_ID`, `sales_Total`, `sales_date`) VALUES
(1, '2019630822', 10, '29/06/2021 05:48:37'),
(2, '2019630822', 5, '29/06/2021 05:50:33'),
(3, '2019630822', 5, '29/06/2021 05:54:20'),
(4, '2019630822', 10, '29/06/2021 06:02:48'),
(5, '2019630822', 10, '29/06/2021 06:03:38'),
(8, '2019630822', 10, '29/06/2021 14:23:21'),
(10, '2019630822', 5, '29/06/2021 15:22:00'),
(11, '2019630822', 10, '29/06/2021 15:22:50');

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
('123456789', 'abu', '123456789', '1234', 'PHG02'),
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
  ADD PRIMARY KEY (`product_ID`),
  ADD KEY `price_ID` (`price_ID`);

--
-- Indexes for table `product_sale`
--
ALTER TABLE `product_sale`
  ADD PRIMARY KEY (`id`),
  ADD KEY `product_ID` (`product_ID`),
  ADD KEY `sales_ID` (`sales_ID`);

--
-- Indexes for table `sales`
--
ALTER TABLE `sales`
  ADD PRIMARY KEY (`sales_ID`),
  ADD KEY `staff_ID` (`staff_ID`);

--
-- Indexes for table `staff`
--
ALTER TABLE `staff`
  ADD PRIMARY KEY (`staff_ID`),
  ADD KEY `outlet_ID` (`outlet_ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `product_sale`
--
ALTER TABLE `product_sale`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT for table `sales`
--
ALTER TABLE `sales`
  MODIFY `sales_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `product`
--
ALTER TABLE `product`
  ADD CONSTRAINT `product_ibfk_1` FOREIGN KEY (`price_ID`) REFERENCES `price` (`price_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `product_sale`
--
ALTER TABLE `product_sale`
  ADD CONSTRAINT `product_sale_ibfk_1` FOREIGN KEY (`product_ID`) REFERENCES `product` (`product_ID`) ON DELETE CASCADE ON UPDATE NO ACTION,
  ADD CONSTRAINT `product_sale_ibfk_2` FOREIGN KEY (`sales_ID`) REFERENCES `sales` (`sales_ID`) ON DELETE CASCADE ON UPDATE NO ACTION;

--
-- Constraints for table `sales`
--
ALTER TABLE `sales`
  ADD CONSTRAINT `sales_ibfk_1` FOREIGN KEY (`staff_ID`) REFERENCES `staff` (`staff_ID`) ON DELETE CASCADE ON UPDATE NO ACTION;

--
-- Constraints for table `staff`
--
ALTER TABLE `staff`
  ADD CONSTRAINT `staff_ibfk_1` FOREIGN KEY (`outlet_ID`) REFERENCES `outlet` (`outlet_ID`) ON DELETE CASCADE ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
