-- phpMyAdmin SQL Dump
-- version 4.3.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Oct 07, 2016 at 05:30 PM
-- Server version: 5.6.24
-- PHP Version: 5.6.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `nbgardens`
--

-- --------------------------------------------------------

--
-- Table structure for table `cart`
--

CREATE TABLE IF NOT EXISTS `cart` (
  `cart_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `catalogue`
--

CREATE TABLE IF NOT EXISTS `catalogue` (
  `product_id` int(11) NOT NULL,
  `product_name` varchar(55) NOT NULL,
  `product_type` varchar(55) NOT NULL,
  `product_price` int(11) NOT NULL,
  `product_desc` text NOT NULL,
  `product_img` text NOT NULL,
  `price_group` int(11) NOT NULL,
  `porous_ware` varchar(5) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `catalogue`
--

INSERT INTO `catalogue` (`product_id`, `product_name`, `product_type`, `product_price`, `product_desc`, `product_img`, `price_group`, `porous_ware`) VALUES
(1, 'Gnome one', 'cute', 5000, 'Cute gnome.', 'gnome.jpg', 1, 'no'),
(2, 'Gnome two', 'scary', 9000, 'Scary gnome.', 'gnome.jpg', 4, 'yes'),
(3, 'Gnome three', 'cute', 7300, 'Cute gnome.', 'gnome.jpg', 3, 'yes'),
(4, 'Gnome four', 'family', 8500, 'Family gnome.', 'gnome.jpg', 4, 'yes'),
(5, 'Gnome five', 'scary', 6500, 'Scary gnome.', 'gnome.jpg', 2, 'no'),
(6, 'Gnome six', 'family', 5000, 'Family gnome.', 'gnome.jpg', 1, 'no'),
(7, 'Gnome seven', 'scary', 6700, 'Scary gnome.', 'gnome.jpg', 2, 'yes'),
(8, 'Gnome eight', 'scary', 3000, 'Scary gnome.', 'gnome.jpg', 1, 'yes'),
(9, 'Gnome nine', 'cute', 10000, 'Cute gnome.', 'gnome.jpg', 4, 'no'),
(10, 'Gnome ten', 'cute', 7400, 'Cute gnome.', 'gnome.jpg', 3, 'yes');

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

CREATE TABLE IF NOT EXISTS `products` (
  `product_id` int(8) NOT NULL,
  `product_title` varchar(55) NOT NULL,
  `product_price` int(10) NOT NULL,
  `product_type` varchar(55) NOT NULL,
  `product_desc` text NOT NULL,
  `product_image` varchar(55) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `products`
--

INSERT INTO `products` (`product_id`, `product_title`, `product_price`, `product_type`, `product_desc`, `product_image`) VALUES
(1, 'First Gnome', 6499, 'Cute', 'This is a gnome.', 'images/gnomefest.jpg'),
(2, 'Second Gnome', 3999, 'Funny', 'This is a gnome.', 'images/gnomefest.jpg'),
(3, 'Third Gnome', 12399, 'Funny', 'This is a gnome.', 'images/gnomefest.jpg'),
(4, 'Fourth Gnome', 5999, 'Seasonal', 'This is a gnome.', 'images/gnomefest.jpg'),
(5, 'Fifth Gnome', 7999, 'Horror', 'This is a gnome.', 'images/gnomefest.jpg'),
(6, 'Sixth Gnome', 2799, 'Funny', 'This is a gnome.', 'images/gnomefest.jpg'),
(7, 'Seventh Gnome', 9999, 'Seasonal', 'This is a gnome.', 'images/gnomefest.jpg'),
(8, ' Eighth Gnome', 9999, 'Cute', 'This is a gnome.', 'images/gnomefest.jpg'),
(9, 'Ninth Gnome', 4499, 'Cute', 'This is a gnome.', 'images/gnomefest.jpg'),
(10, 'Tenth Gnome', 14599, 'Seasonal', 'This is a gnome.', 'images/gnomefest.jpg'),
(11, 'Eleventh Gnome', 10999, 'Horror', 'This is a gnome.', 'images/gnomefest.jpg'),
(12, 'Twelth Gnome', 10999, 'Funny', 'This is a gnome.', 'images/gnomefest.jpg'),
(13, 'Thirteenth Gnome', 5999, 'Funny', 'This is a gnome.', 'images/gnomefest.jpg'),
(14, 'Fourteenth Gnome', 7199, 'Cute', 'This is a gnome.', 'images/gnomefest.jpg'),
(15, 'Fiftheenth Gnome', 8679, 'Cute', 'This is a gnome.', 'images/gnomefest.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `user_id` int(8) NOT NULL,
  `first_name` varchar(55) NOT NULL,
  `surname` varchar(55) NOT NULL,
  `email_address` varchar(55) NOT NULL,
  `password` varchar(55) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`user_id`, `first_name`, `surname`, `email_address`, `password`) VALUES
(9, 'Matthew', 'Carter', 'Matt_carter18@live.co.uk', 'a94a8fe5ccb19ba61c4c0873d391e987982fbbd3'),
(10, '', '', '', '');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cart`
--
ALTER TABLE `cart`
  ADD PRIMARY KEY (`cart_id`);

--
-- Indexes for table `catalogue`
--
ALTER TABLE `catalogue`
  ADD PRIMARY KEY (`product_id`);

--
-- Indexes for table `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`product_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`user_id`), ADD UNIQUE KEY `email_address` (`email_address`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `cart`
--
ALTER TABLE `cart`
  MODIFY `cart_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `catalogue`
--
ALTER TABLE `catalogue`
  MODIFY `product_id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT for table `products`
--
ALTER TABLE `products`
  MODIFY `product_id` int(8) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=16;
--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `user_id` int(8) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=12;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
