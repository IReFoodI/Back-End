INSERT INTO tb_restaurants (
    average_rating, category, cnpj, date_creation, email, fantasy,
    last_login, password, quantity_evaluations, total_evaluations, phone, description,
    url_banner, url_logo
)
VALUES
    (4.8, 'RESTAURANTE', '74125896000144', NOW(), 'cafe1@example.com', 'Cafe Gourmet',
     NOW(), '$2y$10$p1IXPiQ29t1mUit/msZV3OY7Dpz2voS6pK4TBQzPEcVC6QbG6cWhe', 15, 75,'91993559449', 'teste aqui é 1',
     'banner3.jpg', 'logo3.jpg'),

    (4.3, 'SUPERMERCADO', '85236974000122', NOW(), 'market1@example.com', 'Supermercado Tudo',
     NOW(), '$2y$10$p1IXPiQ29t1mUit/msZV3OY7Dpz2voS6pK4TBQzPEcVC6QbG6cWhe', 25, 120,'91993559449', 'teste aqui é 1',
     'banner4.jpg', 'logo4.jpg'),

    (4.9, 'PADARIA', '96385247000166', NOW(), 'padaria1@example.com', 'Padaria Delícia',
     NOW(), '$2y$10$p1IXPiQ29t1mUit/msZV3OY7Dpz2voS6pK4TBQzPEcVC6QbG6cWhe', 18, 85,'91993559449', 'teste aqui é 1',
     'banner5.jpg', 'logo5.jpg'),

    (4.7, 'PADARIA', '15975328000111', NOW(), 'farmacia1@example.com', 'Padaria Vida',
     NOW(), '$2y$10$p1IXPiQ29t1mUit/msZV3OY7Dpz2voS6pK4TBQzPEcVC6QbG6cWhe', 12, 60,'91993559449', 'teste aqui é 1',
     'banner6.jpg', 'logo6.jpg'),

    (4.2, 'PADARIA', '74196385000177', NOW(), 'sorveteria1@example.com', 'Sorveteria Tropical',
     NOW(), '$2y$10$p1IXPiQ29t1mUit/msZV3OY7Dpz2voS6pK4TBQzPEcVC6QbG6cWhe', 8, 45,'91993559449', 'teste aqui é 1',
     'banner7.jpg', 'logo7.jpg');

INSERT INTO tb_restaurants (
    average_rating, category, cnpj, date_creation, email, fantasy,
    last_login, password, quantity_evaluations, total_evaluations, phone, description,
    url_banner, url_logo
)
VALUES
     (4.8, 'RESTAURANTE', '12312312000100', NOW(), 'restaurante2@example.com', 'Sabor do Brasil', NOW(), '$2y$10$QWErtyUI1234567890/asdfg', 5, 30, '91993556677', 'Comida caseira e aconchegante', 'banner13.jpg', 'logo13.jpg'),
     (4.9, 'PADARIA', '45645678000111', NOW(), 'padaria25@example.com', 'Pão Quente', NOW(), '$2y$10$QWErtyUI1234567890/qwerty', 1, 10, '91993557788', 'Pães e bolos fresquinhos todos os dias', 'banner14.jpg', 'logo14.jpg'),
     (4.10, 'SUPERMERCADO', '78978965000122', NOW(), 'supermercado1@example.com', 'Supermercado São João', NOW(), '$2y$10$QWErtyUI1234567890/zxcvbn', 3, 20, '91993558899', 'Tudo para sua casa em um só lugar', 'banner15.jpg', 'logo15.jpg'),
     (4.11, 'CAFETERIA', '14725836000133', NOW(), 'cafeteria2@example.com', 'Café Gourmet', NOW(), '$2y$10$QWErtyUI1234567890/asdfgh', 7, 15, '91993559900', 'Cafés especiais e tortas caseiras', 'banner16.jpg', 'logo16.jpg'),
     (4.12, 'PASTELARIA', '25896374000144', NOW(), 'pastelaria1@example.com', 'Pastéis da Praça', NOW(), '$2y$10$QWErtyUI1234567890/qwertyu', 2, 25, '91993560011', 'Pastéis fritos na hora', 'banner17.jpg', 'logo17.jpg'),
     (4.13, 'SUSHI_BAR', '36985214000155', NOW(), 'sushi1@example.com', 'Sushi Zen', NOW(), '$2y$10$QWErtyUI1234567890/zxcvbnm', 8, 40, '91993561122', 'Sushi fresco e saboroso', 'banner18.jpg', 'logo18.jpg'),
     (4.14, 'FAST_FOOD', '45678932000166', NOW(), 'fastfood1@example.com', 'Burger Mania', NOW(), '$2y$10$QWErtyUI1234567890/poiuy', 4, 10, '91993562233', 'Hamburgers e batatas fritas rápidas', 'banner19.jpg', 'logo19.jpg'),
     (4.15, 'LANCHONETE', '98765432000177', NOW(), 'lanchonete2@example.com', 'Lanchonete do Bairro', NOW(), '$2y$10$QWErtyUI1234567890/ghjkl', 6, 15, '91993563344', 'Lanches variados e bebidas geladas', 'banner20.jpg', 'logo20.jpg'),
     (4.16, 'AÇOUGUE', '65432109800188', NOW(), 'acougue1@example.com', 'Açougue do Zé', NOW(), '$2y$10$QWErtyUI1234567890/fdsa', 9, 30, '91993564455', 'Carnes frescas e de qualidade', 'banner21.jpg', 'logo21.jpg'),
     (4.17, 'EMPORIO', '32145698700199', NOW(), 'emporio1@example.com', 'Empório da Esquina', NOW(), '$2y$10$QWErtyUI1234567890/qazws', 10, 40, '91993565566', 'Produtos selecionados para seu dia a dia', 'banner22.jpg', 'logo22.jpg'),
     (4.18, 'PEIXARIA', '12345678900101', NOW(), 'peixaria1@example.com', 'Peixaria do Mar', NOW(), '$2y$10$QWErtyUI1234567890/xrtyu', 8, 50, '91993566677', 'Peixes e frutos do mar frescos', 'banner23.jpg', 'logo23.jpg'),
     (4.19, 'CHURRASCARIA', '23456789000112', NOW(), 'churrascaria1@example.com', 'Churrasco do Sul', NOW(), '$2y$10$QWErtyUI1234567890/tyuiop', 7, 45, '91993567788', 'Carnes nobres e acompanhamentos', 'banner24.jpg', 'logo24.jpg'),
     (4.20, 'CONFEITARIA', '34567890100123', NOW(), 'confeitaria1@example.com', 'Doces e Delícias', NOW(), '$2y$10$QWErtyUI1234567890/123456', 6, 30, '91993568899', 'Bolachas, bolos e doces finos', 'banner25.jpg', 'logo25.jpg'),
     (4.21, 'HORTIFRUTI', '45678901200134', NOW(), 'hortifruti1@example.com', 'Hortifrúti Verde', NOW(), '$2y$10$QWErtyUI1234567890/789123', 5, 20, '91993569900', 'Frutas e verduras frescas', 'banner26.jpg', 'logo26.jpg'),
     (4.22, 'OUTROS', '56789012300145', NOW(), 'outros1@example.com', 'Bistrô do Chef', NOW(), '$2y$10$QWErtyUI1234567890/456789', 4, 35, '91993570011', 'Bistrô com opções diferenciadas', 'banner27.jpg', 'logo27.jpg'),
     (4.23, 'RESTAURANTE', '67890123400156', NOW(), 'restaurante3@example.com', 'Restaurante Mediterrâneo', NOW(), '$2y$10$QWErtyUI1234567890/qweqwe', 3, 30, '91993571122', 'Pratos típicos do Mediterrâneo', 'banner28.jpg', 'logo28.jpg'),
     (4.24, 'FAST_FOOD', '78901234500167', NOW(), 'fastfood2@example.com', 'Pizzaria Rápida', NOW(), '$2y$10$QWErtyUI1234567890/rtyrty', 2, 15, '91993572233', 'Pizzas e massas em poucos minutos', 'banner29.jpg', 'logo29.jpg'),
     (4.25, 'PADARIA', '89012345600178', NOW(), 'padaria2@example.com', 'Padaria da Vovó', NOW(), '$2y$10$QWErtyUI1234567890/ewrew', 1, 10, '91993573344', 'Pães e doces de receita antiga', 'banner30.jpg', 'logo30.jpg'),
     (4.26, 'RESTAURANTE', '11111111000100', NOW(), 'restaurante4@example.com', 'Cozinha Tradicional', NOW(), '$2y$10$abcdefgh1234567890/qwert', 5, 35, '91993574455', 'Pratos caseiros e tradicionais', 'banner31.jpg', 'logo31.jpg'),
     (4.27, 'PADARIA', '22222222000111', NOW(), 'padaria3@example.com', 'Pães Artesanais', NOW(), '$2y$10$abcdefgh1234567890/asdfg', 1, 15, '91993575566', 'Pães feitos com ingredientes naturais', 'banner32.jpg', 'logo32.jpg'),
     (4.28, 'SUPERMERCADO', '33333333000122', NOW(), 'supermercado2@example.com', 'Supermercado do Povo', NOW(), '$2y$10$abcdefgh1234567890/zxcvbn', 3, 25, '91993576677', 'Variedade de produtos para a sua casa', 'banner33.jpg', 'logo33.jpg'),
     (4.29, 'CAFETERIA', '44444444000133', NOW(), 'cafeteria3@example.com', 'Café do Centro', NOW(), '$2y$10$abcdefgh1234567890/tyuio', 7, 20, '91993577788', 'Cafés e lanches especiais', 'banner34.jpg', 'logo34.jpg'),
     (4.30, 'PASTELARIA', '55555555000144', NOW(), 'pastelaria2@example.com', 'Pastéis do Mercado', NOW(), '$2y$10$abcdefgh1234567890/fghjkl', 2, 20, '91993578899', 'Deliciosos pastéis variados', 'banner35.jpg', 'logo35.jpg'),
     (4.31, 'SUSHI_BAR', '66666666000155', NOW(), 'sushi2@example.com', 'Sushi da Praça', NOW(), '$2y$10$abcdefgh1234567890/qwerty', 8, 30, '91993579900', 'Sushi fresquinho com opções vegetarianas', 'banner36.jpg', 'logo36.jpg'),
     (4.32, 'FAST_FOOD', '77777777000166', NOW(), 'fastfood3@example.com', 'Frango no Ponto', NOW(), '$2y$10$abcdefgh1234567890/asdfgh', 4, 15, '91993580011', 'Frango frito e lanches rápidos', 'banner37.jpg', 'logo37.jpg'),
     (4.33, 'LANCHONETE', '88888888000177', NOW(), 'lanchonete3@example.com', 'Lanches Rápidos', NOW(), '$2y$10$abcdefgh1234567890/zxcvbn', 6, 25, '91993581122', 'Lanches prontos para viagem', 'banner38.jpg', 'logo38.jpg'),
     (4.34, 'AÇOUGUE', '99999999000188', NOW(), 'acougue2@example.com', 'Açougue do Bairro', NOW(), '$2y$10$abcdefgh1234567890/qwerty', 9, 40, '91993582233', 'Carnes selecionadas e frescas', 'banner39.jpg', 'logo39.jpg'),
     (4.35, 'EMPORIO', '10101010100199', NOW(), 'emporio2@example.com', 'Empório da Família', NOW(), '$2y$10$abcdefgh1234567890/ytrewq', 10, 45, '91993583344', 'Produtos de qualidade para sua casa', 'banner40.jpg', 'logo40.jpg'),
     (4.36, 'PEIXARIA', '20202020200110', NOW(), 'peixaria2@example.com', 'Peixaria do Porto', NOW(), '$2y$10$abcdefgh1234567890/edcvfr', 8, 50, '91993584455', 'Peixes e mariscos frescos', 'banner41.jpg', 'logo41.jpg'),
     (4.37, 'CHURRASCARIA', '30303030300121', NOW(), 'churrascaria2@example.com', 'Churrascaria do Sul', NOW(), '$2y$10$abcdefgh1234567890/nhyujm', 7, 60, '91993585566', 'Churrasco com cortes nobres', 'banner42.jpg', 'logo42.jpg'),
     (4.38, 'CONFEITARIA', '40404040400132', NOW(), 'confeitaria2@example.com', 'Confeitaria da Lu', NOW(), '$2y$10$abcdefgh1234567890/123456', 6, 30, '91993586677', 'Doces e bolos para todas as ocasiões', 'banner43.jpg', 'logo43.jpg'),
     (4.39, 'HORTIFRUTI', '50505050500143', NOW(), 'hortifruti2@example.com', 'Hortifruti da Terra', NOW(), '$2y$10$abcdefgh1234567890/qwerty', 5, 20, '91993587788', 'Frutas e verduras frescas do campo', 'banner44.jpg', 'logo44.jpg'),
     (4.40, 'OUTROS', '60606060600154', NOW(), 'outros2@example.com', 'Bistrô Gourmet', NOW(), '$2y$10$abcdefgh1234567890/asdfgh', 4, 35, '91993588899', 'Experiências gastronômicas únicas', 'banner45.jpg', 'logo45.jpg'),
     (4.41, 'RESTAURANTE', '70707070700165', NOW(), 'restaurante5@example.com', 'Restaurante Fusion', NOW(), '$2y$10$abcdefgh1234567890/qweqwe', 5, 30, '91993589900', 'Mistura de sabores de diferentes culturas', 'banner46.jpg', 'logo46.jpg'),
     (4.42, 'FAST_FOOD', '80808080800176', NOW(), 'fastfood4@example.com', 'Sanduíches Express', NOW(), '$2y$10$abcdefgh1234567890/rtyrty', 2, 10, '91993590011', 'Sanduíches feitos na hora', 'banner47.jpg', 'logo47.jpg'),
     (4.43, 'PADARIA', '90909090900187', NOW(), 'padaria4@example.com', 'Padaria do Dia', NOW(), '$2y$10$abcdefgh1234567890/nhyujm', 1, 12, '91993591122', 'Pães frescos e crocantes', 'banner48.jpg', 'logo48.jpg'),
     (4.44, 'SUPERMERCADO', '01010101000198', NOW(), 'supermercado3@example.com', 'Hipermercado Família', NOW(), '$2y$10$abcdefgh1234567890/123456', 3, 20, '91993592233', 'Tudo para o seu dia a dia', 'banner49.jpg', 'logo49.jpg'),
     (4.45, 'CAFETERIA', '12121212100109', NOW(), 'cafeteria4@example.com', 'Café da Manhã', NOW(), '$2y$10$abcdefgh1234567890/qwerty', 7, 15, '91993593344', 'Cafés e quitutes matinais', 'banner50.jpg', 'logo50.jpg'),
     (4.46, 'PASTELARIA', '23232323200110', NOW(), 'pastelaria3@example.com', 'Pastéis do Bairro', NOW(), '$2y$10$abcdefgh1234567890/asdfgh', 2, 25, '91993594455', 'Deliciosos pastéis de diversos sabores', 'banner51.jpg', 'logo51.jpg'),
     (4.47, 'SUSHI_BAR', '34343434300121', NOW(), 'sushi3@example.com', 'Sushi e Ceviche', NOW(), '$2y$10$abcdefgh1234567890/qwerty', 8, 30, '91993595566', 'Sushi e ceviche frescos', 'banner52.jpg', 'logo52.jpg'),
     (4.48, 'FAST_FOOD', '45454545400132', NOW(), 'fastfood5@example.com', 'Pizzaria do Rodízio', NOW(), '$2y$10$abcdefgh1234567890/zxcvbn', 4, 12, '91993596677', 'Rodízio de pizzas e lanches', 'banner53.jpg', 'logo53.jpg'),
     (4.49, 'LANCHONETE', '56565656500143', NOW(), 'lanchonete4@example.com', 'Lanchonete do João', NOW(), '$2y$10$abcdefgh1234567890/qazws', 6, 20, '91993597788', 'Lanches rápidos e saborosos', 'banner54.jpg', 'logo54.jpg'),
     (4.50, 'AÇOUGUE', '67676767600154', NOW(), 'acougue3@example.com', 'Açougue do Chefe', NOW(), '$2y$10$abcdefgh1234567890/edcvfr', 9, 40, '91993598899', 'Carnes de alta qualidade', 'banner55.jpg', 'logo55.jpg'),
     (4.51, 'EMPORIO', '78787878700165', NOW(), 'emporio3@example.com', 'Empório Natural', NOW(), '$2y$10$abcdefgh1234567890/qwerty', 10, 35, '91993599900', 'Produtos orgânicos e naturais', 'banner56.jpg', 'logo56.jpg'),
     (4.52, 'PEIXARIA', '89898989800176', NOW(), 'peixaria3@example.com', 'Peixes e Frutos do Mar', NOW(), '$2y$10$abcdefgh1234567890/tyuio', 8, 50, '91993600011', 'Frutos do mar frescos', 'banner57.jpg', 'logo57.jpg'),
     (4.53, 'CHURRASCARIA', '90909090900182', NOW(), 'churrascaria3@example.com', 'Churrasco do Pampa', NOW(), '$2y$10$abcdefgh1234567890/ujmnhy', 7, 60, '91993601122', 'Churrasco com cortes especiais', 'banner58.jpg', 'logo58.jpg'),
     (4.54, 'CONFEITARIA', '01010101000192', NOW(), 'confeitaria3@example.com', 'Confeitaria da Rainha', NOW(), '$2y$10$abcdefgh1234567890/rtyrty', 6, 30, '91993602233', 'Bolos e doces para festas', 'banner59.jpg', 'logo59.jpg'),
     (4.55, 'HORTIFRUTI', '12121212100102', NOW(), 'hortifruti3@example.com', 'Hortifruti Orgânico', NOW(), '$2y$10$abcdefgh1234567890/qwerty', 5, 20, '91993603344', 'Frutas e verduras frescas', 'banner60.jpg', 'logo60.jpg'),
     (4.56, 'OUTROS', '23232323200112', NOW(), 'outros3@example.com', 'Cozinha Internacional', NOW(), '$2y$10$abcdefgh1234567890/qazwsx', 4, 35, '91993604455', 'Pratos de diferentes países', 'banner61.jpg', 'logo61.jpg');



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
('SUNDAY', '08:00', '14:00', 3);

INSERT INTO tb_restaurant_hours (day_of_week, opening_time, closing_time, restaurant_id)
VALUES
('MONDAY', '08:00', '14:00', 4),
('MONDAY', '08:00', '14:00', 5),
('MONDAY', '08:00', '14:00', 6),
('MONDAY', '08:00', '14:00', 7),
('MONDAY', '08:00', '14:00', 9),
('MONDAY', '08:00', '14:00', 8),
('MONDAY', '08:00', '14:00', 10),
('MONDAY', '08:00', '14:00', 11),
('MONDAY', '08:00', '14:00', 12),
('MONDAY', '08:00', '14:00', 13),
('MONDAY', '08:00', '14:00', 14),
('MONDAY', '08:00', '14:00', 15),
('MONDAY', '08:00', '14:00', 16),
('MONDAY', '08:00', '14:00', 17),
('MONDAY', '08:00', '14:00', 18),
('MONDAY', '08:00', '14:00', 19),
('MONDAY', '08:00', '14:00', 20),
('MONDAY', '08:00', '14:00', 21),
('MONDAY', '08:00', '14:00', 22),
('MONDAY', '08:00', '14:00', 23),
('MONDAY', '08:00', '14:00', 24),
('MONDAY', '08:00', '14:00', 25),
('MONDAY', '08:00', '14:00', 26),
('MONDAY', '08:00', '14:00', 27),
('MONDAY', '08:00', '14:00', 28),
('MONDAY', '08:00', '14:00', 29),
('MONDAY', '08:00', '14:00', 31),
('MONDAY', '08:00', '14:00', 32),
('MONDAY', '08:00', '14:00', 33),
('MONDAY', '08:00', '14:00', 34),
('MONDAY', '08:00', '14:00', 35),
('MONDAY', '08:00', '14:00', 36),
('MONDAY', '08:00', '14:00', 37),
('MONDAY', '08:00', '14:00', 38),
('MONDAY', '08:00', '14:00', 39),
('MONDAY', '08:00', '14:00', 40),
('MONDAY', '08:00', '14:00', 41),
('MONDAY', '08:00', '14:00', 42),
('MONDAY', '08:00', '14:00', 43),
('MONDAY', '08:00', '14:00', 44),
('MONDAY', '08:00', '14:00', 45),
('MONDAY', '08:00', '14:00', 46),
('MONDAY', '08:00', '14:00', 47);






