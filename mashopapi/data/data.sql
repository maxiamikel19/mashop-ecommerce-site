-- CREATE DATABASE IF NOT EXISTS 'mashop';

-- USE 'mashop';

-- DROP TABLE IF EXISTS brands;
-- DROP TABLE IF EXISTS types;
-- DROP TABLE IF EXISTS products;


CREATE TABLE `brands` (
                         `id` INT AUTO_INCREMENT PRIMARY KEY,
                         `name` VARCHAR(255) NOT NULL
);


INSERT INTO brands (name) VALUES
                             ('Adidas'),
                             ('ASICS'),
                             ('Puma'),
                             ('Rebook');


CREATE TABLE `types` (
                        `id` INT AUTO_INCREMENT PRIMARY KEY,
                        `name` VARCHAR(255) NOT NULL
);


INSERT INTO types (name) VALUES
                            ('Shoes'),
                            ('Rackets'),
                            ('Football');

-- Create the Product table
CREATE TABLE `products` (
                           `id` INT AUTO_INCREMENT PRIMARY KEY,
                           `name` VARCHAR(255) NOT NULL,
                           `description` TEXT,
                           `price` DECIMAL(10, 2) NOT NULL,
                           `pictureUrl` VARCHAR(255),
                           `productTypeId` INT NOT NULL,
                           `productBrandId` INT NOT NULL,
                           FOREIGN KEY (`productTypeId`) REFERENCES `types`(`id`),
                           FOREIGN KEY (`productBrandId`) REFERENCES `brands`(`id`)
);

-- Insert data into the Product table
INSERT INTO products (name, description, price, picture_url, product_type_id, product_brand_id) VALUES
                                                                                              ('Adidas Master original', 'Disenhado por professional ', 3500, 'images/product/puma_tenis.png', 1, 1),
                                                                                              ('Adidas Master original 2', 'Disenhado por professional ', 3375, 'images/product/adidas_futbol1.png', 3, 1),
                                                                                              ('Adidas Master original 3', 'Disenhado por professional ', 3375, 'images/product/tenis.png', 1, 1),
                                                                                              ('Asics Gel Super marca', 'Disenhado por professional com paior estabilidade e conforto.', 4200, 'images/product/asics_tenis.png', 1, 2),
                                                                                              ('Asics Gel Super marca', 'Disenhado por professional com paior estabilidade e conforto.', 2399, 'images/product/nuke_futbol.png', 1, 2),
                                                                                              ('Asics Gel Super marca', 'Disenhado por professional com paior estabilidade e conforto.', 1999, 'images/product/nike_futbol1.png', 1, 2),
                                                                                              ('Puma 19 smart e original', 'Disenhado por professional com uma estandar personalizada.', 500, 'images/product/adidas_futbol.png', 1, 3),
                                                                                              ('Puma 19 smart e original', 'Disenhado por professional com uma estandar personalizada.', 5700, 'images/product/asics_tenis.png', 1, 3),                                                                        
                                                                                              ('Rebook LRB05 MSH', 'Rebook, Disenhado por professional ', 1499, 'images/Product/tenis.png', 2, 4);