--INSERT INTO tb_user (username, password, email) VALUES
--('usuario01', 'Senha123', 'user01@email.com'),
--('usuario02', 'Senha123', 'user02@email.com'),
--('usuario03', 'Senha123', 'user03@email.com'),
--('usuario04', 'Senha123', 'user04@email.com'),
--('usuario05', 'Senha123', 'user05@email.com');
--
--
--INSERT INTO tb_person (name, cpf, cnpj, rg, ie, phone, user_id) VALUES
--('Ana Silva', '12345678909', NULL, 'MG1234567', NULL, '(11)90000-0001', 1),
--('Carlos Souza', '98765432100', NULL, 'MG1234568', NULL, '(11)90000-0002', 2),
--('Beatriz Lima', '11144477735', NULL, 'MG1234569', NULL, '(11)90000-0003', 3),
--('Empresa A LTDA', NULL, '12345678000195', NULL, 'IE1234561', '(11)90000-0016', 4),
--('Empresa B ME', NULL, '23456789000188', NULL, 'IE1234562', '(11)90000-0017', 5);
--
--INSERT INTO tb_address (city, street, number, cep, user_id) VALUES
--('São Paulo', 'Rua A', 101, '01001-000', 1),
--('Rio de Janeiro', 'Rua B', 102, '20001-000', 2),
--('Belo Horizonte', 'Rua C', 103, '30001-000', 3),
--('Curitiba', 'Rua D', 104, '80001-000', 4),
--('Porto Alegre', 'Rua E', 105, '90001-000', 5);


INSERT INTO tb_category (name) VALUES
('Motor'),
('Suspensão'),
('Freios');

INSERT INTO tb_product (
    sku, name, description, retail_value, wholesale_value,
    wholesale_min_quantity, stock, free_freight, is_active,
    url_image, product_category
) VALUES
('MTR-001', 'Filtro de Óleo', 'Filtro de óleo para motores 1.0 a 2.0.', 29.90, 19.90, 10, 200, false, true, 'https://exemplo.com/img1.jpg', 1),
('MTR-002', 'Correia Dentada', 'Correia dentada para linha Fiat/GM.', 89.90, 69.90, 5, 150, true, true, 'https://exemplo.com/img2.jpg', 1),
('MTR-003', 'Vela de Ignição', 'Jogo com 4 velas de ignição NGK.', 99.90, 79.90, 8, 100, false, true, 'https://exemplo.com/img3.jpg', 1),

('SUS-001', 'Amortecedor Dianteiro', 'Amortecedor dianteiro para Gol/Voyage.', 239.90, 199.90, 4, 50, true, true, 'https://exemplo.com/img4.jpg', 2),
('SUS-002', 'Mola Helicoidal', 'Mola para suspensão traseira Uno.', 119.90, 99.90, 6, 60, false, true, 'https://exemplo.com/img5.jpg', 2),
('SUS-003', 'Coxim de Motor', 'Coxim superior dianteiro para Palio.', 69.90, 59.90, 5, 70, false, true, 'https://exemplo.com/img6.jpg', 2),

('FR-001', 'Pastilha de Freio', 'Jogo de pastilhas para Corsa/Celta.', 89.90, 74.90, 10, 80, true, true, 'https://exemplo.com/img7.jpg', 3),
('FR-002', 'Disco de Freio Ventilado', 'Disco dianteiro ventilado linha VW.', 149.90, 129.90, 6, 60, false, true, 'https://exemplo.com/img8.jpg', 3),
('FR-003', 'Fluido de Freio DOT4', 'Fluido de freio 500ml DOT4.', 24.90, 19.90, 12, 100, true, true, 'https://exemplo.com/img9.jpg', 3),
('FR-004', 'Servo Freio', 'Servo freio para veículos 1.0 e 1.6.', 299.90, 259.90, 3, 30, false, true, 'https://exemplo.com/img10.jpg', 3);

--INSERT INTO tb_sale (buyer, address, total_value, data) VALUES
--(1, 1, 459.70, CURRENT_TIMESTAMP),
--(2, 2, 319.80, CURRENT_TIMESTAMP),
--(3, 3, 239.80, CURRENT_TIMESTAMP),
--(4, 4, 279.80, CURRENT_TIMESTAMP),
--(5, 5, 174.90, CURRENT_TIMESTAMP);
--
--INSERT INTO tb_product_sale (sale_id, product_id, quantity, price) VALUES
--(1, 1, 2, 29.90),
--(1, 2, 1, 89.90),
--(2, 4, 1, 239.90),
--(2, 5, 2, 39.95),
--(3, 7, 2, 89.90),
--(3, 9, 1, 59.90),
--(4, 3, 1, 99.90),
--(4, 6, 2, 89.95),
--(5, 8, 1, 149.90),
--(5, 10, 1, 24.90);