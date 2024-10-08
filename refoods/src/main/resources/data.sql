
-- Inserir usuários
INSERT INTO users (cpf, date_creation, email, last_login, name, password, phone, surname) VALUES 
('12345678901', CURRENT_TIMESTAMP, 'user1@example.com', CURRENT_TIMESTAMP, 'John', 'pass123', '1111111111', 'Doe'),
('10987654321', CURRENT_TIMESTAMP, 'user2@example.com', CURRENT_TIMESTAMP, 'Jane', 'pass456', '2222222222', 'Smith');

-- Inserir restaurantes
INSERT INTO restaurants (average_rating, cnpj, date_creation, email, fantasy, password, quantity_evaluations, total_evaluations, url_banner, url_logo) VALUES 
(4.5, '12345678000195', CURRENT_TIMESTAMP, 'restaurant1@example.com', 'Fancy Food', 'pass789', 10, 100, 'banner1.jpg', 'logo1.jpg'),
(4.0, '98765432000196', CURRENT_TIMESTAMP, 'restaurant2@example.com', 'Quick Bites', 'pass321', 5, 50, 'banner2.jpg', 'logo2.jpg');

-- Inserir cartões
INSERT INTO cards (cvv, number, validity, fk_id_user) VALUES 
('123', '4111111111111111', '12/25', 1),
('456', '5500000000000004', '11/24', 2);

-- Inserir endereços
INSERT INTO addresses (address_type, cep, complement, district, number, standard, state, street, fk_id_restaurant, fk_id_user) VALUES 
('Residencial', '12345678', 'Apto 101', 'Downtown', '123', true, 'SP', 'Main St', 1, 1),
('Comercial', '87654321', 'Loja 1', 'Uptown', '456', true, 'RJ', 'Second St', 2, 2);

-- Inserir contatos
INSERT INTO contacts (description, phone, fk_id_restaurant) VALUES 
('Contato Principal', '11999999999', 1),
('Contato Secundário', '11988888888', 2);

-- Inserir favoritos
INSERT INTO favorites (addition_date, fk_id_restaurant, fk_id_user) VALUES 
(CURRENT_TIMESTAMP, 1, 1),
(CURRENT_TIMESTAMP, 2, 2);

-- Inserir produtos
INSERT INTO products (active, addition_date, description_prod, discount, name_prod, url_img_prod, value_prod, id_restaurant) VALUES 
(true, CURRENT_TIMESTAMP, 'Pizza Margherita', 10, 'Pizza', 'pizza.jpg', 20.0, 1),
(true, CURRENT_TIMESTAMP, 'Sushi Combo', 5, 'Sushi', 'sushi.jpg', 50.0, 2);

-- Inserir pedidos
INSERT INTO orders (order_date, order_status, total_value, fk_id_address, fk_id_restaurant, fk_id_user) VALUES 
(CURRENT_TIMESTAMP, 1, 100.0, 1, 1, 1),
(CURRENT_TIMESTAMP, 2, 75.0, 2, 2, 2);

-- Inserir itens de pedidos
INSERT INTO items_orders (amount, subtotal, unit_value, fk_id_order, id_product) VALUES 
(2, 40.0, 20.0, 1, 1),
(1, 50.0, 50.0, 2, 2);

-- Inserir transações
INSERT INTO transactions (transaction_date, transaction_status, transaction_value, fk_id_card, fk_id_order) VALUES 
(CURRENT_TIMESTAMP, 1, 100.0, 1, 1),
(CURRENT_TIMESTAMP, 2, 75.0, 2, 2);

-- Inserir avaliações
INSERT INTO reviews (rating_comment, rating_date, rating_note, fk_id_restaurant, fk_id_user) VALUES 
('Ótimo serviço!', CURRENT_TIMESTAMP, 5, 1, 1),
('Comida excelente!', CURRENT_TIMESTAMP, 4, 2, 2);

-- Inserir histórico de pedidos
INSERT INTO historical_orders (date_mod, order_status, fk_id_order, fk_id_restaurant, fk_id_user) VALUES 
(CURRENT_TIMESTAMP, 1, 1, 1, 1),
(CURRENT_TIMESTAMP, 2, 2, 2, 2);

-- Inserir notificações
INSERT INTO notifications (msg_notification, msg_read, send_date) VALUES 
('Pedido recebido', false, CURRENT_TIMESTAMP),
('Avaliação solicitada', true, CURRENT_TIMESTAMP);

-- Inserir notificações de usuários
INSERT INTO users_notifications (fk_id_notification, fk_id_user) VALUES 
(1, 1),
(2, 2);
