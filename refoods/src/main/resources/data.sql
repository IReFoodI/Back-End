

-- Inserindo dados na tabela tb_users
INSERT INTO tb_users (date_creation, email, last_login, name, password, phone)
VALUES -- -- as senhas são 123456Bb*
    (NOW(), 'hortencia@email.com', NOW(), 'Hortencia Flores', '$2a$10$neEHRrvLQ5COJvr8rgWxiubCTD19fGjKto88fvlDSO.r2AFkqUp9q', '1399998888' ),
    (NOW(), 'isaaclovehortencia@email.com', NOW(), 'Isaac Bezerra', '$2a$10$neEHRrvLQ5COJvr8rgWxiubCTD19fGjKto88fvlDSO.r2AFkqUp9q', '1399997777' ),
    (NOW(), 'user1@example.com', NOW(), 'Samilis Brito', '$2a$10$neEHRrvLQ5COJvr8rgWxiubCTD19fGjKto88fvlDSO.r2AFkqUp9q', '91912345678' );




-- -- Inserindo dados na tabela tb_cards
INSERT INTO tb_cards (cpf, cvv, number, validity, holder_name, user_id) VALUES 
('42302050000', '123', '3333111122223333', '12/25', 'Hortencia Flores', 1), 
('42302050000', '244', '3000111122223000', '10/26', 'Hortencia Flores', 1), 
('42402050110', '456', '5173000033335173', '01/26', 'Isaac Bezerra', 2),
('40002050000', '123', '4111111111111111', '12/25', 'Hortencia F.', 1), 
('11102050110', '456', '5500000000000004', '01/24', 'Isaac B.', 2);




-- Inserindo dados na tabela tb_restaurants
INSERT INTO tb_restaurants 
(
  category, fantasy, email, cnpj, date_creation, last_login, average_rating,
  quantity_evaluations, total_evaluations, phone, description,
  password, url_banner, url_logo
) 
VALUES  
      (
        'PADARIA', 'Bakery Shop', 'bakeryshop@email.com', '42111342300195', 
        NOW(), NOW(), 4.5, 727, 727, '13908006111', 
        'Paes fresquinhos, doces artesanais e uma atmosfera acolhedora para começar o dia com o pe direito.',
        -- senhas 123456Bb*
        '$2a$10$neEHRrvLQ5COJvr8rgWxiubCTD19fGjKto88fvlDSO.r2AFkqUp9q',
        'https://firebasestorage.googleapis.com/v0/b/refood-storage.appspot.com/o/banner12.jpg?alt=media&token=e4dd1628-a01d-4e81-8d91-09cb2886217a',
        'https://firebasestorage.googleapis.com/v0/b/refood-storage.appspot.com/o/logo12.png?alt=media&token=bacd3db9-56d8-46ca-8af1-1e6292854bf6' 
      ),
      (
        'RESTAURANTE', 'Sanderson Dinner', 'sanderson@email.com', '42222342300195', 
        NOW(), NOW(), 4.5, 456, 456, '13908006222', 
        'Sabores classicos com um toque contemporaneo, perfeitos para todas as ocasioes.',
        -- senhas 123456Bb*
        '$2a$10$neEHRrvLQ5COJvr8rgWxiubCTD19fGjKto88fvlDSO.r2AFkqUp9q',
        'https://firebasestorage.googleapis.com/v0/b/refood-storage.appspot.com/o/4e3e9fb9-d561-4659-aa98-b7dc2a6d999d_banner-sanderson.png?alt=media&token=066a1a85-011f-4ca4-bbee-a7c818b7fa9b',
        'https://firebasestorage.googleapis.com/v0/b/refood-storage.appspot.com/o/0f8b51df-f26b-4352-88a5-1cc7cd07ab77_logo-sanderson.png?alt=media&token=cc912599-91af-41a3-9da5-5e471325e6a9' 
      ),
      (
        'RESTAURANTE', 'Preston Salad', 'preston@email.com', '42333342300195', 
        NOW(), NOW(), 3.0, 327, 327, '13908006333', 
        'Deliciosas saladas frescas, ingredientes selecionados e opções leves para uma refeicao saudavel.',
        -- senhas 123456Bb*
        '$2a$10$neEHRrvLQ5COJvr8rgWxiubCTD19fGjKto88fvlDSO.r2AFkqUp9q',
        'https://firebasestorage.googleapis.com/v0/b/refood-storage.appspot.com/o/81a927c4-67e7-4d96-a942-003bac94c609_banner-preston.png?alt=media&token=639f9704-13bd-42b8-b9e5-9eead6b41800',
        'https://firebasestorage.googleapis.com/v0/b/refood-storage.appspot.com/o/c83e1372-9e9b-457e-8ab2-9fd416947981_logo-preston.png?alt=media&token=9925df4e-c21e-47a3-8777-5a9213efff6b' 
      ),
      (
        'RESTAURANTE', 'Nagoya', 'nagoya@email.com', '42444342300195', 
        NOW(), NOW(), 5.0, 1327, 1327, '13908006444', 
        'Autentica culinaria japonesa com sushis, sashimis e pratos quentes feitos na hora.',
        -- senhas 123456Bb*
        '$2a$10$neEHRrvLQ5COJvr8rgWxiubCTD19fGjKto88fvlDSO.r2AFkqUp9q',
        'https://firebasestorage.googleapis.com/v0/b/refood-storage.appspot.com/o/11f644fa-6a23-4ece-9b27-246aedec0ad1_banner-nagoya.jpg?alt=media&token=31a1ddf7-fa78-4add-a6a6-343db6708d26',
        'https://firebasestorage.googleapis.com/v0/b/refood-storage.appspot.com/o/7e8aca56-bbde-425e-a28d-d09bd9492411_logo-nagoya.png?alt=media&token=fdf90c8a-d021-49d1-a61e-531ff1fcbff9' 
      ),
      (
        'PIZZARIA', 'PizzGo', 'pizzgo@email.com', '42555342300195', 
        NOW(), NOW(), 4.5, 623, 623, '13908006555', 
        'Pizzas artesanais com massa leve e crocante, preparadas com ingredientes de alta qualidade.',
        -- senhas 123456Bb*
        '$2a$10$neEHRrvLQ5COJvr8rgWxiubCTD19fGjKto88fvlDSO.r2AFkqUp9q',
        'https://firebasestorage.googleapis.com/v0/b/refood-storage.appspot.com/o/9e41710d-8fd6-4c85-a627-2ad09ee9ede2_banner-pizza.png?alt=media&token=9a5c4d4a-8637-4d82-b541-4e22b9763158',
        'https://firebasestorage.googleapis.com/v0/b/refood-storage.appspot.com/o/66d2c733-d4f8-4819-b828-a4df7e0ca83f_logo-pizza.png?alt=media&token=1f40a1ae-0fb8-40af-bf8d-c8eb398082fd' 
      ),
      (
        'LANCHONETE', 'Seven Kings', 'sevenkings@email.com', '42666342300195', 
        NOW(), NOW(), 5.0, 1007, 1007, '13908006666', 
        'Burgers suculentos, porCOes generosas e bebidas refrescantes para acompanhar momentos descontraIdos',
        -- senhas 123456Bb*
        '$2a$10$neEHRrvLQ5COJvr8rgWxiubCTD19fGjKto88fvlDSO.r2AFkqUp9q',
        'https://firebasestorage.googleapis.com/v0/b/refood-storage.appspot.com/o/7bf7a11f-bec0-44bb-a933-66a0e51f4d7c_banner-burguer.png?alt=media&token=d27781c8-4d9b-46e8-b1f1-4cdfd61c3540',
        'https://firebasestorage.googleapis.com/v0/b/refood-storage.appspot.com/o/7cac0054-e0b7-4cd7-b280-c7f4c3b232e2_logo-burguer.png?alt=media&token=d1247359-e57a-4ae2-89f4-c97e4711d7a4' 
      ),
      (
        'SUPERMERCADO', 'Farmers Market', 'farmersmarket@email.com', '42777342300195', 
        NOW(), NOW(), 3.5, 927, 927, '13908006777', 
        'Tudo o que você precisa em um sO lugar: alimentos frescos, produtos de limpeza e itens essenciais.',
        -- senhas 123456Bb*
        '$2a$10$neEHRrvLQ5COJvr8rgWxiubCTD19fGjKto88fvlDSO.r2AFkqUp9q',
        'https://firebasestorage.googleapis.com/v0/b/refood-storage.appspot.com/o/26b04c08-6659-4b66-90d2-969bedfdaf6a_banner-market.png?alt=media&token=3a39bb3f-0f9b-4346-b817-3447bcebefab',
        'https://firebasestorage.googleapis.com/v0/b/refood-storage.appspot.com/o/6319886f-276a-471c-83b0-a94e21fe9504_logo-market.png?alt=media&token=25a1348b-470e-4c5a-aab5-a8954fdaf0b4' 
      ),
      (
        'CONFEITARIA', 'Sodie Doces', 'sodie@email.com', '42888342300195', 
        NOW(), NOW(), 3.5, 132, 132, '13908006888', 
        'Bolos e tortas feitos com amor, perfeitos para celebrar momentos especiais ou adoCar o seu dia.',
        -- senhas 123456Bb*
        '$2a$10$neEHRrvLQ5COJvr8rgWxiubCTD19fGjKto88fvlDSO.r2AFkqUp9q',
        'https://firebasestorage.googleapis.com/v0/b/refood-storage.appspot.com/o/475487c3-e83a-423b-b9b7-f66d4a49d67f_banner-bake.png?alt=media&token=93e412a7-cb80-4211-92ae-1323c1275383',
        'https://firebasestorage.googleapis.com/v0/b/refood-storage.appspot.com/o/8edc871c-9012-49f0-8a0b-4e8bd5110fa8_logo-bake.png?alt=media&token=419f664f-ac2d-4a0a-8bae-2be244261bc5' 
      );





INSERT INTO tb_restaurant_hours (day_of_week, opening_time, closing_time, restaurant_id)
VALUES
-- Horários para o restaurante com ID 1
('MONDAY', '08:00', '18:00', 1),
('TUESDAY', '08:00', '18:00', 1),
('WEDNESDAY', '08:00', '18:00', 1),
('THURSDAY', '08:00', '20:00', 1),
('FRIDAY', '08:00', '22:00', 1),
('SATURDAY', '10:00', '22:00', 1),
('SUNDAY', '10:00', '16:00', 1),

-- Horários para o restaurante com ID 2
('MONDAY', '09:00', '17:00', 2),
('TUESDAY', '09:00', '17:00', 2),
('WEDNESDAY', '09:00', '17:00', 2),
('THURSDAY', '09:00', '19:00', 2),
('FRIDAY', '09:00', '21:00', 2),
('SATURDAY', '11:00', '21:00', 2),

-- Horários para o restaurante com ID 3
('MONDAY', '07:00', '15:00', 3),
('TUESDAY', '07:00', '15:00', 3),
('WEDNESDAY', '07:00', '15:00', 3),
('THURSDAY', '07:00', '18:00', 3),
('FRIDAY', '07:00', '20:00', 3),
('SATURDAY', '08:00', '20:00', 3),
('SUNDAY', '08:00', '14:00', 3),

-- Horários para o restaurante com ID 4
('MONDAY', '06:00', '14:00', 4),
('TUESDAY', '06:00', '14:00', 4),
('WEDNESDAY', '06:00', '14:00', 4),
('THURSDAY', '06:00', '17:00', 4),
('FRIDAY', '06:00', '19:00', 4),
('SATURDAY', '07:00', '19:00', 4),
('SUNDAY', '07:00', '13:00', 4),

-- Horários para o restaurante com ID 5
('MONDAY', '05:00', '13:00', 5),
('TUESDAY', '05:00', '13:00', 5),
('WEDNESDAY', '05:00', '13:00', 5),
('THURSDAY', '05:00', '16:00', 5),
('FRIDAY', '05:00', '18:00', 5),
('SATURDAY', '06:00', '18:00', 5),
('SUNDAY', '06:00', '12:00', 5),

-- Horários para o restaurante com ID 6
('MONDAY', '04:00', '12:00', 6),
('TUESDAY', '04:00', '12:00', 6),
('WEDNESDAY', '04:00', '12:00', 6),
('THURSDAY', '04:00', '15:00', 6),
('FRIDAY', '04:00', '17:00', 6),
('SATURDAY', '05:00', '17:00', 6),
('SUNDAY', '05:00', '11:00', 6),

-- Horários para o restaurante com ID 7
('MONDAY', '03:00', '11:00', 7),
('TUESDAY', '03:00', '11:00', 7),
('WEDNESDAY', '03:00', '11:00', 7),
('THURSDAY', '03:00', '14:00', 7),
('FRIDAY', '03:00', '16:00', 7),
('SATURDAY', '04:00', '16:00', 7),
('SUNDAY', '04:00', '10:00', 7),

-- Horários para o restaurante com ID 8
('MONDAY', '02:00', '10:00', 8),
('TUESDAY', '02:00', '10:00', 8),
('WEDNESDAY', '02:00', '10:00', 8),
('THURSDAY', '02:00', '13:00', 8),
('FRIDAY', '02:00', '15:00', 8),
('SATURDAY', '03:00', '15:00', 8),
('SUNDAY', '03:00', '09:00', 8);




-- -- Inserindo dados na tabela tb_addresses
INSERT INTO tb_addresses (address_type, cep, complement, district, is_standard, number, state, street, city, type, restaurant_id, user_id)
VALUES
    ('RESTAURANT', '11060470', 'Rua Gastronômica', 'Gonzaga', TRUE, '55', 'SP', 'Rua Tolentino Filgueiras', 'Santos', 'Filial Santos', 1, NULL),
    ('USER', '11045123', 'Apto 101', 'Jardins', TRUE, '12', 'SP', 'Rua Dom', 'Santos', 'Casa', NULL, 1 ),
    ('USER', '11045321', 'Apto 202', 'Centro', FALSE, '45', 'SP', 'Av Pedro Pessoa', 'Santos', 'Trabalho', NULL, 1),
    ('USER', '11045456', 'Apto 103', 'Jardins', TRUE, '56', 'SP', 'Rua Pinheiros', 'Sao Vicente', 'Casa', NULL, 2),
    ('USER', '11045654', 'Apto 203', 'Jardins', FALSE, '03', 'SP', 'Rua Boeto', 'Sao Vicente', 'Casa da Mamae', NULL, 2),
    ('USER', '11045654', 'Apto 203', 'Jardins', FALSE, '03', 'SP', 'Rua Boeto', 'Sao Vicente', 'Casa da Mamae', NULL, 2);





-- -- Inserindo dados na tabela tb_contacts
INSERT INTO tb_contacts (description, phone, restaurant_id)
VALUES 
    ('Contato Principal', '1308006633', 1),
    ('Contato Alternativo', '1308006645', 1),
    ('Contato Principal', '1112223333', 3),
    ('Contato Alternativo', '4445556666', 3);



