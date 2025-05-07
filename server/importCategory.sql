INSERT INTO tb_category (id, name, dad) VALUES
(1, 'Motor', NULL),
(2, 'Suspensão', NULL),
(3, 'Freios', NULL),
(4, 'Transmissão', NULL),
(5, 'Elétrica', NULL);

INSERT INTO tb_category (id, name, dad) VALUES
(6, 'Cabeçote', 1),
(7, 'Pistões', 1),
(8, 'Amortecedores', 2),
(9, 'Molas', 2),
(10, 'Pastilhas de Freio', 3),
(11, 'Discos de Freio', 3),
(12, 'Embreagem', 4),
(13, 'Câmbio Manual', 4),
(14, 'Bateria', 5),
(15, 'Alternador', 5),
(16, 'Sensor de Velocidade', 5),
(17, 'Coxins do Motor', 1),
(18, 'Buchas da Suspensão', 2),
(19, 'Cilindro Mestre', 3),
(20, 'Cabo de Embreagem', 4);