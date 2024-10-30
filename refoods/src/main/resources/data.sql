





-- Inserindo dados na tabela tb_users
INSERT INTO tb_users (date_creation, email, last_login, name, password, phone)
VALUES -- -- as senhas são 123456Bb*
    (NOW(), 'user1@example.com', NOW(), 'User One', '$2a$10$neEHRrvLQ5COJvr8rgWxiubCTD19fGjKto88fvlDSO.r2AFkqUp9q', '1112223333' ),
    (NOW(), 'user2@example.com', NOW(), 'User Two', '$2a$10$neEHRrvLQ5COJvr8rgWxiubCTD19fGjKto88fvlDSO.r2AFkqUp9q', '4445556666' );

-- Inserindo dados na tabela tb_restaurants
-- as senhas são 123456Bb*
INSERT INTO tb_restaurants (cnpj, fantasy, email, password, date_creation, last_login, category, url_banner, url_logo, quantity_evaluations, total_evaluations, phone, description, average_rating) 
VALUES ('12345678000195', 'Restaurante A', 'restaurant1@example.com', '$2a$10$neEHRrvLQ5COJvr8rgWxiubCTD19fGjKto88fvlDSO.r2AFkqUp9q', NOW(), NULL, 'RESTAURANTE', 'https://example.com/bannerA.jpg', 'https://example.com/logoA.jpg', 0, 0, '1234567890', 'Descrição do Restaurante A com mais de 20 caracteres.', 0.0);
-- as senhas são 123456Bb*
INSERT INTO tb_restaurants (cnpj, fantasy, email, password, date_creation, last_login, category, url_banner, url_logo, quantity_evaluations, total_evaluations, phone, description, average_rating) 
VALUES ('98765432000100', 'Restaurante B', 'restaurant2@example.com', '$2a$10$neEHRrvLQ5COJvr8rgWxiubCTD19fGjKto88fvlDSO.r2AFkqUp9q', NOW(), NOW(), 'RESTAURANTE', 'https://example.com/bannerB.jpg', 'https://example.com/logoB.jpg', 5, 15, '0987654321', 'Descrição do Restaurante B com mais de 20 caracteres.', 4.5);

-- Inserindo dados na tabela tb_addresses
INSERT INTO tb_addresses (address_type, cep, complement, district, is_standard, number, state, street, city, type, restaurant_id, user_id)
VALUES
    ('RESTAURANT', '12345678', 'Apto 101', 'Centro', TRUE, '123', 'SP', 'Rua A', 'Aurora do Pará', 'Casa', 1, NULL ),
    ('USER', '87654321', 'Apto 202', 'Jardins', TRUE, '456', 'SP', 'Rua B', 'Capanema', 'Trabalho', NULL, 2);

-- Inserindo dados na tabela tb_cards
INSERT INTO tb_cards (cpf, cvv, number, validity, holder_name, user_id) VALUES 
('40002050000', '123', '4111111111111111', '12/25', 'Nome do Titular 1', 1), 
('11102050110', '456', '5500000000000004', '01/24', 'Nome do Titular 2', 2);

-- Inserindo dados na tabela tb_contacts
INSERT INTO tb_contacts (description, phone, restaurant_id)
VALUES 
    ('Contato Principal', '1112223333', 1),
    ('Contato Alternativo', '4445556666', 2);

-- Inserindo dados na tabela tb_products
INSERT INTO tb_products (active, addition_date, description_product, sell_price, name_product, category, url_img_product, original_price, expiration_date, quantity, restaurant_id)
VALUES 
    (TRUE, NOW(), 'Delicious sweet product', 10.0, 'Product One', 'DOCE', 'http://localhost:8080/images/banner.png', 20.0, '2024-11-17', 100, 1),
    (TRUE, NOW(), 'Tasty savory product', 5.0, 'Product Two', 'SALGADO', 'product2.jpg', 30.0, '2024-11-17', 200, 2);

-- Inserindo dados na tabela tb_cart
INSERT INTO tb_cart (status, total_value, user_id)
VALUES
    ('ABERTO', 0.0, 1),
    ('ABERTO', 0.0, 2);

-- Inserindo dados na tabela tb_cart_items
INSERT INTO tb_cart_items (cart_id, product_id, quantity, unit_value, subtotal)
VALUES 
    (1, 1, 2, 20.0, 40.0),
    (1, 2, 1, 30.0, 30.0),
    (2, 1, 1, 20.0, 20.0),
    (2, 2, 2, 30.0, 60.0);


-- Inserindo dados na tabela tb_orders
INSERT INTO tb_orders (order_date, order_status, total_value, address_id, restaurant_id, user_id)
VALUES 
    (NOW(), 1, 100.0, 1, 1, 1),
    (NOW(), 2, 50.0, 2, 2, 2);

-- Inserindo dados na tabela tb_order_items
INSERT INTO tb_order_items (order_id, product_id, quantity, unit_value, subtotal)
VALUES 
    (1, 1, 2, 20.0, 40.0), -- 2 unidades do Product One no pedido 1
    (1, 2, 1, 30.0, 30.0), -- 1 unidade do Product Two no pedido 1
    (2, 1, 1, 20.0, 20.0), -- 1 unidade do Product One no pedido 2
    (2, 2, 2, 30.0, 60.0); -- 2 unidades do Product Two no pedido 2


-- Inserindo dados na tabela tb_reviews
INSERT INTO tb_reviews (rating_comment, rating_date, rating_note, restaurant_id, user_id)
VALUES 
    ('Great food!', NOW(), 5, 1, 1),
    ('Nice service', NOW(), 4, 2, 2);

-- Inserindo dados na tabela tb_favorites
INSERT INTO tb_favorites (restaurant_id, user_id)
VALUES 
    (1, 1),
    (2, 2);

-- Inserindo dados na tabela tb_historical_orders
INSERT INTO tb_historical_orders (date_mod, order_status, order_id, restaurant_id, user_id) 
VALUES 
(NOW(), 'EMPRODUCAO', 1, 1, 1), 
(NOW(), 'ENVIADO', 2, 2, 2); 



-- Inserindo dados na tabela tb_notifications
INSERT INTO tb_notifications (msg_notification, msg_read, send_date, restaurant_id, user_id)
VALUES 
    ('Your order has been delivered.', FALSE, NOW(), 1, 1),
    ('New products available!', TRUE, NOW(), 2, 2);

-- Inserindo dados na tabela tb_transactions
INSERT INTO tb_transactions (transaction_date, transaction_status, transaction_value, order_id, card_id) 
VALUES 
(NOW(), 'PENDENTE', 100.0, 1, 1), 
(NOW(), 'APROVADA', 50.0, 2, 2); 

