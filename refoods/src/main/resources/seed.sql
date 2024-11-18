

-- -- seeds TB_PRODUCTS
INSERT INTO tb_products (
  restaurant_id, sell_price, original_price, name_product, quantity, category, active, addition_date, expiration_date,
  description_product,
  url_img_product 
) VALUES 
  ------------ BAKERY SHOP
( 
  1, 18.0, 20.0, 'Bolo de Cenoura', 24, 'DOCE', TRUE, '2024-11-17', NOW(), 
  'Bolo de cenoura com cobertura de chocolate',
  'https://firebasestorage.googleapis.com/v0/b/refood-storage.appspot.com/o/0adb4f31-5ad7-4b14-9378-61f88a73278e_bolodecenoura.png?alt=media&token=ce95a8cc-4894-4571-bf37-0597c9d2bbbb'
),
(
  1, 5.0, 6.0, 'Pao Frances', 100, 'SALGADO', TRUE, '2024-11-17', NOW(), 
  'Pao frances fresquinho, crocante por fora e macio por dentro.',
  'https://firebasestorage.googleapis.com/v0/b/refood-storage.appspot.com/o/Default_Product_Images.png?alt=media&token=7b5f5565-c02b-4b7b-9cde-9f5170ce8e14'
),
(
  1, 12.0, 14.0, 'Croissant de Chocolate', 50, 'DOCE', TRUE, '2024-11-17', NOW(), 
  'Croissant folhado recheado com delicioso chocolate cremoso.',
  'https://firebasestorage.googleapis.com/v0/b/refood-storage.appspot.com/o/Default_Product_Images.png?alt=media&token=7b5f5565-c02b-4b7b-9cde-9f5170ce8e14'
),
(
  1, 10.0, 12.0, 'Esfiha de Carne', 50, 'SALGADO', TRUE, '2024-11-17', NOW(), 
  'Esfiha aberta com recheio temperado de carne bovina.',
  'https://firebasestorage.googleapis.com/v0/b/refood-storage.appspot.com/o/Default_Product_Images.png?alt=media&token=7b5f5565-c02b-4b7b-9cde-9f5170ce8e14'
),
(
  1, 3.5, 4.0, 'Pao de Queijo', 60, 'SALGADO', TRUE, '2024-11-17', NOW(), 
  'Classico Pao de queijo mineiro, perfeito para o cafe.',
  'https://firebasestorage.googleapis.com/v0/b/refood-storage.appspot.com/o/Default_Product_Images.png?alt=media&token=7b5f5565-c02b-4b7b-9cde-9f5170ce8e14'
),
(
  1, 25.0, 28.0, 'Torta de Limão', 15, 'DOCE', TRUE, '2024-11-17', NOW(), 
  'Torta com base crocante, creme de limao e cobertura de merengue.',
  'https://firebasestorage.googleapis.com/v0/b/refood-storage.appspot.com/o/Default_Product_Images.png?alt=media&token=7b5f5565-c02b-4b7b-9cde-9f5170ce8e14'
),
(
  1, 8.0, 9.5, 'Quiche de Alho-Poro', 20, 'SALGADO', TRUE, '2024-11-17', NOW(), 
  'Quiche com recheio cremoso de alho-poro e massa amanteigada.',
  'https://firebasestorage.googleapis.com/v0/b/refood-storage.appspot.com/o/Default_Product_Images.png?alt=media&token=7b5f5565-c02b-4b7b-9cde-9f5170ce8e14'
),
(
  1, 7.0, 8.0, 'Coxinha de Frango', 70, 'SALGADO', TRUE, '2024-11-17', NOW(), 
  'Salgado recheado com frango desfiado e temperado, empanado e frito.',
  'https://firebasestorage.googleapis.com/v0/b/refood-storage.appspot.com/o/Default_Product_Images.png?alt=media&token=7b5f5565-c02b-4b7b-9cde-9f5170ce8e14'
),
(
  1, 4.5, 5.5, 'Sonho de Creme', 30, 'DOCE', TRUE, '2024-11-17', NOW(), 
  'Pao doce recheado com creme de confeiteiro e polvilhado com acucar.',
  'https://firebasestorage.googleapis.com/v0/b/refood-storage.appspot.com/o/Default_Product_Images.png?alt=media&token=7b5f5565-c02b-4b7b-9cde-9f5170ce8e14'
),
(
  1, 15.0, 17.0, 'Focaccia com Alecrim', 25, 'SALGADO', TRUE, '2024-11-17', NOW(), 
  'Pao artesanal italiano com azeite extra virgem, sal grosso e alecrim.',
  'https://firebasestorage.googleapis.com/v0/b/refood-storage.appspot.com/o/Default_Product_Images.png?alt=media&token=7b5f5565-c02b-4b7b-9cde-9f5170ce8e14'
),
(
  1, 20.0, 22.0, 'Brioche com Geleia de Frutas Vermelhas', 20, 'DOCE', TRUE, '2024-11-17', NOW(), 
  'Pao brioche macio com recheio de geleia caseira de frutas vermelhas.',
  'https://firebasestorage.googleapis.com/v0/b/refood-storage.appspot.com/o/Default_Product_Images.png?alt=media&token=7b5f5565-c02b-4b7b-9cde-9f5170ce8e14'
),

------------ SANDERSON

(
  2, 22.0, 25.0, 'Feijão Tropeiro', 15, 'SALGADO', TRUE, '2024-11-17', NOW(), 
  'Feijao tropeiro com arroz, linguica, bacon e ovos',
  'feijao_tropeiro.jpg'
),
(
  2, 19.0, 21.0, 'Frango Assado com Farofa', 20, 'SALGADO', TRUE, '2024-11-17', NOW(), 
  'Frango assado temperado com ervas e acompanhado de farofa',
  'frango_assado.jpg'
),
(
  2, 15.0, 18.0, 'Macarronada à Bolonhesa', 30, 'SALGADO', TRUE, '2024-11-17', NOW(), 
  'Macarrao com molho bolonhesa caseiro, carne moida e queijo ralado',
  'macarronada_bolonhesa.jpg'
),
(
  2, 10.0, 12.0, 'Pudim de Leite Condensado', 25, 'DOCE', TRUE, '2024-11-17', NOW(), 
  'Pudim cremoso de leite condensado com calda de caramelo',
  'pudim_leite.jpg'
),
(
  2, 14.0, 16.0, 'Feijoada Completa', 18, 'SALGADO', TRUE, '2024-11-17', NOW(), 
  'Feijoada tradicional com arroz, couve, farofa e laranja',
  'feijoada_completa.jpg'
),
(
  2, 12.0, 14.0, 'Escondidinho de Carne Seca', 22, 'SALGADO', TRUE, '2024-11-17', NOW(), 
  'Pure de mandioca com carne seca desfiada por cima',
  'escondidinho_carne_seca.jpg'
),
(
  2, 9.0, 11.0, 'Arroz de Carreteiro', 20, 'SALGADO', TRUE, '2024-11-17', NOW(), 
  'Arroz refogado com carne de sol desfiada e temperos',
  'arroz_carreteiro.jpg'
),

------------ SUSHI

( 
  4, 15.0, 18.0, 'Sushi de Salmão', 30, 'SALGADO', TRUE, '2024-11-17', NOW(), 
  'Sushi clássico de arroz com fatia de salmão fresco por cima',
  'sushi_salmao.jpg'
),
(
  4, 18.0, 20.0, 'Sashimi de Atum', 25, 'SALGADO', TRUE, '2024-11-17', NOW(), 
  'Fatias de atum fresco cortadas com precisão',
  'sashimi_atum.jpg'
),
(
  4, 20.0, 22.0, 'Temaki de Salmão com Cream Cheese', 15, 'SALGADO', TRUE, '2024-11-17', NOW(), 
  'Cone de alga recheado com arroz, salmão e cream cheese',
  'temaki_salmao.jpg'
),
(
  4, 25.0, 28.0, 'Combinado de Sushi e Sashimi', 10, 'SALGADO', TRUE, '2024-11-17', NOW(), 
  'Combinado com variedade de sushis e sashimis frescos',
  'combinado_sushi_sashimi.jpg'
),
(
  4, 12.0, 14.0, 'Hot Roll', 20, 'SALGADO', TRUE, '2024-11-17', NOW(), 
  'Sushi empanado recheado com salmão e cream cheese, servido quente',
  'hot_roll.jpg'
),
(
  4, 10.0, 12.0, 'Gyoza', 18, 'SALGADO', TRUE, '2024-11-17', NOW(), 
  'Pastéis japoneses recheados com carne de porco e vegetais',
  'gyoza.jpg'
),
(
  4, 16.0, 18.0, 'Yakissoba de Frango', 22, 'SALGADO', TRUE, '2024-11-17', NOW(), 
  'Macarrão japonês com frango, vegetais e molho especial',
  'yakissoba_frango.jpg'
),

--------- PIZZARIA

( 
  5, 25.0, 28.0, 'Pizza Margherita', 10, 'SALGADO', TRUE, '2024-11-17', NOW(), 
  'Clássica pizza com molho de tomate, mussarela, manjericão fresco e azeite de oliva',
  'pizza_margherita.jpg'
),
(
  5, 30.0, 33.0, 'Pizza Calabresa', 12, 'SALGADO', TRUE, '2024-11-17', NOW(), 
  'Pizza com fatias de calabresa, cebola e queijo mussarela',
  'pizza_calabresa.jpg'
),
(
  5, 28.0, 32.0, 'Pizza Quatro Queijos', 8, 'SALGADO', TRUE, '2024-11-17', NOW(), 
  'Pizza com uma combinação de mussarela, gorgonzola, parmesão e provolone',
  'pizza_quatro_queijos.jpg'
),
(
  5, 35.0, 38.0, 'Pizza Portuguesa', 15, 'SALGADO', TRUE, '2024-11-17', NOW(), 
  'Pizza com mussarela, presunto, ovos, cebola, azeitonas e pimentão',
  'pizza_portuguesa.jpg'
),
(
  5, 27.0, 30.0, 'Pizza Pepperoni', 18, 'SALGADO', TRUE, '2024-11-17', NOW(), 
  'Pizza com molho de tomate, mussarela e fatias generosas de pepperoni',
  'pizza_pepperoni.jpg'
),
(
  5, 32.0, 36.0, 'Pizza Frango com Catupiry', 12, 'SALGADO', TRUE, '2024-11-17', NOW(), 
  'Pizza de frango desfiado, catupiry e mussarela',
  'pizza_frango_catupiry.jpg'
),
(
  5, 29.0, 34.0, 'Pizza Vegetariana', 14, 'SALGADO', TRUE, '2024-11-17', NOW(), 
  'Pizza com cogumelos, abobrinha, pimentões e queijo mussarela',
  'pizza_vegetariana.jpg'
),

---------- CONFEITARIA

( 
  8, 8.0, 10.0, 'Bolo de Chocolate', 20, 'DOCE', TRUE, '2024-11-17', NOW(), 
  'Delicioso bolo de chocolate com cobertura cremosa',
  'bolo_chocolate.jpg'
),
(
  8, 7.0, 9.0, 'Torta de Limão', 15, 'DOCE', TRUE, '2024-11-17', NOW(), 
  'Torta com base crocante, recheio cremoso de limão e merengue',
  'torta_limao.jpg'
),
(
  8, 6.0, 8.0, 'Brigadeiro Gourmet', 30, 'DOCE', TRUE, '2024-11-17', NOW(), 
  'Clássico doce brasileiro com chocolate belga e granulados finos',
  'brigadeiro_gourmet.jpg'
),
(
  8, 12.0, 14.0, 'Cheesecake de Frutas Vermelhas', 12, 'DOCE', TRUE, '2024-11-17', NOW(), 
  'Cheesecake cremoso com calda de frutas vermelhas',
  'cheesecake_frutas_vermelhas.jpg'
),
(
  8, 4.0, 6.0, 'Cupcake Red Velvet', 25, 'DOCE', TRUE, '2024-11-17', NOW(), 
  'Cupcake macio de red velvet com cobertura de cream cheese',
  'cupcake_red_velvet.jpg'
),
(
  8, 5.0, 7.0, 'Macarons', 40, 'DOCE', TRUE, '2024-11-17', NOW(), 
  'Delicados macarons franceses com recheios variados',
  'macarons.jpg'
),
(
  8, 15.0, 18.0, 'Pavê de Doce de Leite', 10, 'DOCE', TRUE, '2024-11-17', NOW(), 
  'Camadas de biscoito, creme e doce de leite com cobertura de chantilly',
  'pave_doce_de_leite.jpg'
),

-------- HAMBUGUER

( 
  6, 15.0, 18.0, 'Classic Burger', 25, 'SALGADO', TRUE, '2024-11-17', NOW(), 
  'Hambúrguer clássico com carne bovina, queijo cheddar, alface, tomate e maionese especial',
  'classic_burger.jpg'
),
(
  6, 18.0, 22.0, 'Cheddar Bacon Burger', 20, 'SALGADO', TRUE, '2024-11-17', NOW(), 
  'Hambúrguer com carne suculenta, queijo cheddar derretido e tiras crocantes de bacon',
  'cheddar_bacon_burger.jpg'
),
(
  6, 20.0, 24.0, 'Double Smash Burger', 15, 'SALGADO', TRUE, '2024-11-17', NOW(), 
  'Dois hambúrgueres smash com queijo cheddar, cebola caramelizada e molho especial',
  'double_smash_burger.jpg'
),
(
  6, 12.0, 15.0, 'Veggie Burger', 18, 'SALGADO', TRUE, '2024-11-17', NOW(), 
  'Hambúrguer vegetariano feito com grão-de-bico, legumes, alface e maionese de ervas',
  'veggie_burger.jpg'
),
(
  6, 22.0, 25.0, 'BBQ Pulled Pork Burger', 12, 'SALGADO', TRUE, '2024-11-17', NOW(), 
  'Hambúrguer com carne de porco desfiada, molho barbecue, cebola roxa e coleslaw',
  'bbq_pulled_pork_burger.jpg'
),
(
  6, 16.0, 20.0, 'Chicken Crispy Burger', 22, 'SALGADO', TRUE, '2024-11-17', NOW(), 
  'Hambúrguer com filé de frango empanado crocante, maionese de pimenta e salada',
  'chicken_crispy_burger.jpg'
),
(
  6, 19.0, 23.0, 'Bacon Lover Burger', 18, 'SALGADO', TRUE, '2024-11-17', NOW(), 
  'Hambúrguer com duas camadas de bacon crocante, queijo prato e molho de alho',
  'bacon_lover_burger.jpg'
),
(
  6, 14.0, 17.0, 'Swiss Mushroom Burger', 20, 'SALGADO', TRUE, '2024-11-17', NOW(), 
  'Hambúrguer com cogumelos salteados, queijo suíço e molho cremoso',
  'swiss_mushroom_burger.jpg'
),
(
  6, 11.0, 14.0, 'Spicy Jalapeño Burger', 18, 'SALGADO', TRUE, '2024-11-17', NOW(), 
  'Hambúrguer apimentado com jalapeños, queijo cheddar e molho chipotle',
  'spicy_jalapeno_burger.jpg'
),
(
  6, 20.0, 25.0, 'Truffle Burger', 10, 'SALGADO', TRUE, '2024-11-17', NOW(), 
  'Hambúrguer premium com queijo gouda, cebolas caramelizadas e molho trufado',
  'truffle_burger.jpg'
),

--------- PRESTON SALAD

( 
  3, 14.0, 16.0, 'Caesar Salad', 20, 'MISTO', TRUE, '2024-11-17', NOW(), 
  'Salada clássica com alface romana, croutons crocantes, queijo parmesão e molho Caesar',
  'caesar_salad.jpg'
),
(
  3, 16.0, 18.0, 'Salada de Quinoa', 18, 'MISTO', TRUE, '2024-11-17', NOW(), 
  'Quinoa com tomate cereja, pepino, cebola roxa, salsinha e azeite de oliva',
  'salada_quinoa.jpg'
),
(
  3, 18.0, 20.0, 'Salada Caprese', 15, 'MISTO', TRUE, '2024-11-17', NOW(), 
  'Tomate fresco, mussarela de búfala, manjericão e azeite de oliva',
  'salada_caprese.jpg'
),
(
  3, 20.0, 24.0, 'Salada Tropical', 12, 'MISTO', TRUE, '2024-11-17', NOW(), 
  'Alface americana, manga, abacaxi, cenoura ralada e molho de iogurte',
  'salada_tropical.jpg'
),
(
  3, 18.0, 22.0, 'Salada de Frango Grelhado', 22, 'MISTO', TRUE, '2024-11-17', NOW(), 
  'Mix de folhas verdes, frango grelhado, tomate cereja e molho mostarda e mel',
  'salada_frango_grelhado.jpg'
),
(
  3, 16.0, 20.0, 'Salada Grega', 18, 'MISTO', TRUE, '2024-11-17', NOW(), 
  'Pepino, tomate, cebola roxa, azeitonas, queijo feta e azeite de oliva',
  'salada_grega.jpg'
),
(
  3, 12.0, 15.0, 'Salada de Lentilha', 20, 'MISTO', TRUE, '2024-11-17', NOW(), 
  'Lentilha cozida, cenoura, salsinha, cebola roxa e limão siciliano',
  'salada_lentilha.jpg'
),

--------- MERCADO

( 
  7, 5.0, 6.5, 'Arroz Branco 1kg', 50, 'MISTO', TRUE, '2024-11-17', NOW(), 
  'Arroz branco tipo 1, ideal para todas as refeições',
  'arroz_branco.jpg'
),
(
  7, 7.0, 8.5, 'Feijão Carioca 1kg', 40, 'MISTO', TRUE, '2024-11-17', NOW(), 
  'Feijão carioca selecionado, rico em sabor e nutrientes',
  'feijao_carioca.jpg'
),
(
  7, 3.0, 4.0, 'Macarrão Espaguete 500g', 60, 'MISTO', TRUE, '2024-11-17', NOW(), 
  'Macarrão espaguete de alta qualidade, perfeito para pratos italianos',
  'macarrao_espaguete.jpg'
),
(
  7, 4.5, 6.0, 'Azeite de Oliva 500ml', 30, 'MISTO', TRUE, '2024-11-17', NOW(), 
  'Azeite de oliva extra virgem, ideal para temperos e finalizações',
  'azeite_oliva.jpg'
),
(
  7, 2.0, 2.5, 'Açúcar Cristal 1kg', 70, 'MISTO', TRUE, '2024-11-17', NOW(), 
  'Açúcar cristal de alta pureza, perfeito para receitas e bebidas',
  'acucar_cristal.jpg'
),
(
  7, 3.5, 4.0, 'Café Torrado e Moído 500g', 45, 'MISTO', TRUE, '2024-11-17', NOW(), 
  'Café torrado e moído com sabor encorpado, ideal para começar o dia',
  'cafe_torrado.jpg'
),
(
  7, 1.5, 2.0, 'Leite Integral 1L', 80, 'MISTO', TRUE, '2024-11-17', NOW(), 
  'Leite integral pasteurizado, rico em nutrientes',
  'leite_integral.jpg'
);



-- -- Inserindo dados na tabela tb_cart
INSERT INTO tb_cart (total_value, user_id)
VALUES
    (0, 1),
    (0, 2);


-- -- Inserindo dados na tabela tb_cart_items
INSERT INTO tb_cart_items (cart_id, product_id, quantity, unit_value, subtotal, added_at, restaurant_id)
VALUES 
    (2, 1, 1, 0, 0, NOW(), 1),
    (2, 2, 2, 0, 0, NOW(), 1),
    (2, 3, 2, 0, 0, NOW(), 1),
    (2, 4, 1, 0, 0, NOW(), 1),
    (1, 5, 1, 0, 0, NOW(), 1),
    (1, 6, 2, 0, 0, NOW(), 1),
    (1, 7, 3, 0, 0, NOW(), 1),
    (1, 8, 6, 0, 0, NOW(), 1),
    (1, 9, 2, 0, 0, NOW(), 1),
    (1, 10, 1, 0, 0, NOW(), 1),
    (1, 11, 3, 0, 0, NOW(), 1);

-- Atualizar os valores unitários e subtotais dos itens do carrinho
UPDATE tb_cart_items
SET 
    unit_value = (
        SELECT sell_price 
        FROM tb_products 
        WHERE tb_products.product_id = tb_cart_items.product_id
    ),
    subtotal = (
        SELECT sell_price * tb_cart_items.quantity
        FROM tb_products 
        WHERE tb_products.product_id = tb_cart_items.product_id
    );


-- Atualizar os valores totais do Cart
UPDATE tb_cart SET total_value = (
    SELECT SUM(subtotal)
    FROM tb_cart_items
    WHERE tb_cart_items.cart_id = tb_cart.cart_id
);




    -- SEED para tabela tb_orders
INSERT INTO tb_orders (order_date, delivery_date, order_status, delivery_type, user_id, restaurant_id, address_id, total_value, review_id, transaction_id)
VALUES 
('2024-10-31', '2024-11-01', 'CONCLUIDO', 'RETIRADA', 1, 1, 1, 0, NULL, NULL),
('2024-11-03', '2024-11-04', 'CONCLUIDO', 'RETIRADA', 1, 3, 1, 0, NULL, NULL),
('2024-11-04', '2024-11-04', 'PENDENTE', 'RETIRADA', 1, 1, 1, 0, NULL, NULL),
('2024-11-01', '2024-11-03', 'PREPARANDO', 'RETIRADA', 2, 1, 1, 0, NULL, NULL),
('2024-11-05', '2024-11-07', 'CANCELADO', 'RETIRADA',1, 2, 1, 0, NULL, NULL),
('2024-11-02', '2024-11-04', 'AGUARDANDO_RETIRADA', 'RETIRADA', 1, 3, 1, 0, NULL, NULL);

-- SEED para tabela tb_order_items
INSERT INTO tb_order_items (order_id, product_id, quantity, unit_value, subtotal)
VALUES 
(1, 2, 3, 0, 0),
(1, 1, 1, 0, 0),
(1, 4, 3, 0, 0),

(2, 3, 2, 0, 0),
(2, 4, 1, 0, 0),
(2, 5, 2, 0, 0),

(3, 6, 4, 0, 0),
(3, 7, 1, 0, 0),

(4, 8, 2, 0, 0),
(4, 9, 3, 0, 0),

(5, 1, 2, 0, 0),
(5, 2, 1, 0, 0),
(5, 3, 3, 0, 0),

(6, 10, 1, 0, 0),
(6, 11, 5, 0, 0);

-- Atualizar os valores unitários e subtotais dos itens da Order
UPDATE tb_order_items
SET 
    unit_value = (
        SELECT sell_price 
        FROM tb_products 
        WHERE tb_products.product_id = tb_order_items.product_id
    ),
    subtotal = (
        SELECT sell_price * tb_order_items.quantity
        FROM tb_products 
        WHERE tb_products.product_id = tb_order_items.product_id
    );


-- Atualizar os valores totais das Orders
UPDATE tb_orders SET total_value = (
    SELECT SUM(subtotal)
    FROM tb_order_items
    WHERE tb_order_items.order_id = tb_orders.order_id
);




-- -- Inserindo dados na tabela tb_reviews
INSERT INTO tb_reviews (rating_comment, rating_date, rating_note, order_id, restaurant_id, user_id)
VALUES 
    ('Otimo servico.', NOW(), 4, 1, 1, 1);
