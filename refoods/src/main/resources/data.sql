-- Inserindo dados na tabela addresses
INSERT INTO addresses (address_type, cep, complement, district, number, standard, state, street)
VALUES ('Residencial', '12345-678', 'Apto 101', 'Centro', '10', TRUE, 'SP', 'Rua A');

INSERT INTO addresses (address_type, cep, complement, district, number, standard, state, street)
VALUES ('Comercial', '23456-789', '', 'Jardins', '20', FALSE, 'SP', 'Avenida B');

INSERT INTO addresses (address_type, cep, complement, district, number, standard, state, street)
VALUES ('Residencial', '34567-890', 'Bloco 3', 'Vila Nova', '30', TRUE, 'RJ', 'Rua C');

-- Inserindo dados na tabela cards
INSERT INTO cards (cvv, number, validity)
VALUES ('123', '4111-1111-1111-1111', '12/25');

INSERT INTO cards (cvv, number, validity)
VALUES ('456', '4222-2222-2222-2222', '11/24');

-- Inserindo dados na tabela contacts
INSERT INTO contacts (description, phone)
VALUES ('Contato Principal', '1198765-4321');

INSERT INTO contacts (description, phone)
VALUES ('Suporte', '1123456-7890');

-- Inserindo dados na tabela favorites
INSERT INTO favorites (addition_date)
VALUES (CURRENT_TIMESTAMP);

INSERT INTO favorites (addition_date)
VALUES (CURRENT_TIMESTAMP);

-- Inserindo dados na tabela historical_orders
INSERT INTO historical_orders (date_mod, order_status)
VALUES (CURRENT_TIMESTAMP, 1);

INSERT INTO historical_orders (date_mod, order_status)
VALUES (CURRENT_TIMESTAMP, 0);

-- Inserindo dados na tabela items_orders
INSERT INTO items_orders (amount, subtotal, unit_value)
VALUES (2, 19.90, 9.95);

INSERT INTO items_orders (amount, subtotal, unit_value)
VALUES (3, 29.85, 9.95);

-- Inserindo dados na tabela notifications
INSERT INTO notifications (msg_notification, msg_read, send_date)
VALUES ('Promoção de 50% em pizzas!', FALSE, CURRENT_TIMESTAMP);

INSERT INTO notifications (msg_notification, msg_read, send_date)
VALUES ('Seu pedido foi enviado!', TRUE, CURRENT_TIMESTAMP);

-- Inserindo dados na tabela orders
INSERT INTO orders (order_date, order_status, total_value)
VALUES (CURRENT_TIMESTAMP, 1, 59.70);

INSERT INTO orders (order_date, order_status, total_value)
VALUES (CURRENT_TIMESTAMP, 0, 19.90);

-- Inserindo dados na tabela products
INSERT INTO products (active, addition_date, description_prod, discount, name_prod, url_img_prod, value_prod)
VALUES (TRUE, CURRENT_TIMESTAMP, 'Pizza Margherita', 10, 'Margherita', 'http://example.com/margherita.jpg', 29.90);

INSERT INTO products (active, addition_date, description_prod, discount, name_prod, url_img_prod, value_prod)
VALUES (TRUE, CURRENT_TIMESTAMP, 'Pizza Calabresa', 5, 'Calabresa', 'http://example.com/calabresa.jpg', 39.90);

-- Inserindo dados na tabela restaurants
INSERT INTO restaurants (average_rating, cnpj, date_creation, email, fantasy, password, quantity_evaluations, total_evaluations, url_banner, url_logo)
VALUES (4.5, '12.345.678/0001-90', CURRENT_TIMESTAMP, 'contato@restaurant1.com', 'Restaurante 1', 'senha123', 100, 150, 'http://example.com/banner1.jpg', 'http://example.com/logo1.jpg');

-- Inserindo dados na tabela reviews
INSERT INTO reviews (rating_comment, rating_date, rating_note)
VALUES ('Ótima pizza!', CURRENT_TIMESTAMP, 5);

INSERT INTO reviews (rating_comment, rating_date, rating_note)
VALUES ('Delivery rápido.', CURRENT_TIMESTAMP, 4);

-- Inserindo dados na tabela transactions
INSERT INTO transactions (transaction_date, transaction_status, transaction_value)
VALUES (CURRENT_TIMESTAMP, 1, 59.70);

INSERT INTO transactions (transaction_date, transaction_status, transaction_value)
VALUES (CURRENT_TIMESTAMP, 0, 19.90);

-- Inserindo dados na tabela users
INSERT INTO users (cpf, date_creation, email, last_login, name, password, phone, surname)
VALUES ('123.456.789-00', CURRENT_TIMESTAMP, 'user1@example.com', CURRENT_TIMESTAMP, 'João', 'senha123', '1198765-4321', 'Silva');

INSERT INTO users (cpf, date_creation, email, last_login, name, password, phone, surname)
VALUES ('987.654.321-00', CURRENT_TIMESTAMP, 'user2@example.com', CURRENT_TIMESTAMP, 'Maria', 'senha456', '1123456-7890', 'Oliveira');

-- Inserindo dados na tabela users_notifications
INSERT INTO users_notifications (fk_id_notification, fk_id_user)
VALUES (1, 1);

INSERT INTO users_notifications (fk_id_notification, fk_id_user)
VALUES (2, 2);
