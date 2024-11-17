

    -- SEED para tabela tb_orders
INSERT INTO tb_orders (order_date, delivery_date, order_status, delivery_type, total_value, user_id, restaurant_id, address_id, review_id, transaction_id)
VALUES 
('2024-10-31', '2024-11-01', 'CONCLUIDO', 'RETIRADA', 200.00, 1, 1, 4, NULL, NULL),
('2024-11-01', '2024-11-03', 'PREPARANDO', 'RETIRADA', 0, 1, 1, 4, NULL, NULL),
('2024-11-02', NULL, 'AGUARDANDO_RETIRADA', 'RETIRADA', 0, 1, 1, 4, NULL, NULL),
('2024-11-03', '2024-11-04', 'CONCLUIDO', 'RETIRADA', 0, 1, 1, 4, NULL, NULL),
('2024-11-04', NULL, 'PENDENTE', 'RETIRADA', 0, 2, 2, 4, NULL, NULL),
('2024-11-05', '2024-11-07', 'CANCELADO', 'RETIRADA', 0, 2, 1, 4, NULL, NULL);


-- SEED para tabela tb_order_items
INSERT INTO tb_order_items (order_id, product_id, quantity, unit_value, subtotal)
VALUES 
(1, 2, 3, 50.00, 150.00),
(1, 1, 1, 40.00, 40.00),
(1, 4, 3, 25.00, 75.00),

(2, 3, 2, 30.00, 60.00),
(2, 4, 1, 25.00, 25.00),
(2, 5, 2, 12.50, 25.00),

(3, 6, 4, 8.00, 32.00),
(3, 7, 1, 50.00, 50.00),

(4, 8, 2, 17.50, 35.00),
(4, 9, 3, 10.00, 30.00),

(5, 1, 2, 15.50, 31.00),
(5, 2, 1, 20.00, 20.00),
(5, 3, 3, 10.00, 30.00),

(6, 10, 1, 40.00, 40.00),
(6, 11, 5, 5.00, 25.00);

-- Atualizar os valores totais das Orders
UPDATE tb_orders SET total_value = (
    SELECT SUM(subtotal)
    FROM tb_order_items
    WHERE tb_order_items.order_id = tb_orders.order_id
);

-- -- Inserindo dados na tabela tb_reviews
INSERT INTO tb_reviews (rating_comment, rating_date, rating_note, order_id, restaurant_id, user_id)
VALUES 
    ('Ótimo serviço.', NOW(), 4, 1, 1, 1);
