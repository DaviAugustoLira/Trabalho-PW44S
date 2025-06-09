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


INSERT INTO tb_category (name, top) VALUES
('Motor', true),
('Suspensão', true),
('Sistema Elétrico', false),
('Sistema Hidráulico', false),
('Acessórios Internos', false),
('Acessórios Externos', false),
('Lataria e Estrutura', false),
('Rodas', false),
('Pneus', false),
('Direção', false),
('Transmissão', false),
('Iluminação', false),
('Arrefecimento', false),
('Escapamento', false),
('Filtros', false),
('Alarme e Segurança', false),
('Sensores', false),
('Som e Vídeo', false),
('Lubrificantes e Aditivos', false),
('Ferramentas e Equipamentos', false),
('Freios', true);

INSERT INTO tb_product (
    sku, name, description, retail_value, wholesale_value,
    wholesale_min_quantity, stock, free_freight, is_active,
    url_image, product_category, top
) VALUES
('MTR-002', 'Correia Dentada', 'Correia dentada para linha Fiat/GM.', 89.90, 69.90, 5, 150, true, true, 'https://static.dvautopecas.com.br/public/dvautopecas/imagens/produtos/kit-correia-dentada-fiat-gm-65afaa5ccc0ee.png', 1, false),
('MTR-003', 'Vela de Ignição', 'Jogo com 4 velas de ignição NGK.', 99.90, 79.90, 8, 100, false, true, 'https://a-static.mlcdn.com.br/800x560/jogo-kit-4-velas-ignicao-grand-siena-1-6-16v-ngk-iridium-ix/boxonlineoficial/kit4bkr7eixngk2/e8dd303345715f15bcee8de4461f8c7d.jpeg', 1, false),

('SUS-001', 'Amortecedor Dianteiro', 'Amortecedor dianteiro para Gol/Voyage.', 239.90, 199.90, 4, 50, true, true, 'https://altese.vtexassets.com/arquivos/ids/182344/SP320-amortecedor-dianteiro-monroe-gol-voyage-g5-g6-g7-2008-2009-2010-2011-2012-2013-2014-2015-2016-2017-2018-2019-2020.jpg?v=637588668881530000', 2, false),
('SUS-002', 'Mola Helicoidal', 'Mola para suspensão traseira Uno.', 119.90, 99.90, 6, 60, false, true, 'https://images.tcdn.com.br/img/img_prod/809212/par_mola_suspensao_traseira_novo_uno_1_0_1_4_6501_1_1a0070a473d9830fcd5c76e7bceec770.jpg', 2, false),
('SUS-003', 'Coxim de Motor', 'Coxim superior dianteiro para Palio.', 69.90, 59.90, 5, 70, false, true, 'https://fortbras.vteximg.com.br/arquivos/ids/269725-460-460/coxim-amortecedor-fiat-palio-96-a-2011-dianteiro-motorista-mobensani-hipervarejo-1.jpg?v=638718309787070000', 2, true),

('FR-001', 'Pastilha de Freio', 'Jogo de pastilhas para Corsa/Celta.', 89.90, 74.90, 10, 80, true, true, 'https://images.tcdn.com.br/img/img_prod/1232696/jogo_pastilha_gm_corsa_celta_1_0_1_4_1_6_tigra_1_4_16v_ate_2002_cobreq_n324_239_1_3fc683c898d7434c907002edfa97d2e0.jpg', 3, true),
('FR-002', 'Disco de Freio Ventilado', 'Disco dianteiro ventilado linha VW.', 149.90, 129.90, 6, 60, false, true, 'https://a-static.mlcdn.com.br/1500x1500/par-de-disco-dianteiro-ventilado-vw-nivus-1-0-12v-tsi-60107-hf81c-volkswagen/umecuniversodomecanico/96507/ff80679560255f15de9a05c95b65ff36.jpeg', 3, true),
('FR-003', 'Fluido de Freio DOT4', 'Fluido de freio 500ml DOT4.', 24.90, 19.90, 12, 100, true, true, 'https://images.tcdn.com.br/img/img_prod/806292/fluido_de_freio_dot4_plus_500ml_rclf00054_29_1_2c1ddaa1b78a0dfc31e9928e109e682f.png', 3,true),
('FR-004', 'Servo Freio', 'Servo freio para veículos 1.0 e 1.6.', 299.90, 259.90, 3, 30, false, true, 'https://http2.mlstatic.com/D_NQ_NP_915315-MLB31730983748_082019-O-servo-freio-hidrovacuo-gol-saveiro-parati-g3-g4-10-16-18.webp', 3, true);

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