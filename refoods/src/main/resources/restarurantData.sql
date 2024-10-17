INSERT INTO tb_restaurants (
    average_rating, category, cnpj, date_creation, email, fantasy,
    last_login, password, quantity_evaluations, total_evaluations,
    url_banner, url_logo
)
VALUES
    (4.8, 'RESTAURANTE', '74125896000144', NOW(), 'cafe1@example.com', 'Cafe Gourmet',
     NOW(), '$2y$10$p1IXPiQ29t1mUit/msZV3OY7Dpz2voS6pK4TBQzPEcVC6QbG6cWhe', 15, 75,
     'banner3.jpg', 'logo3.jpg'),

    (4.3, 'SUPERMERCADO', '85236974000122', NOW(), 'market1@example.com', 'Supermercado Tudo',
     NOW(), '$2y$10$p1IXPiQ29t1mUit/msZV3OY7Dpz2voS6pK4TBQzPEcVC6QbG6cWhe', 25, 120,
     'banner4.jpg', 'logo4.jpg'),

    (4.9, 'PADARIA', '96385247000166', NOW(), 'padaria1@example.com', 'Padaria Delícia',
     NOW(), '$2y$10$p1IXPiQ29t1mUit/msZV3OY7Dpz2voS6pK4TBQzPEcVC6QbG6cWhe', 18, 85,
     'banner5.jpg', 'logo5.jpg'),

    (4.7, 'PADARIA', '15975328000111', NOW(), 'farmacia1@example.com', 'Farmácia Vida',
     NOW(), '$2y$10$p1IXPiQ29t1mUit/msZV3OY7Dpz2voS6pK4TBQzPEcVC6QbG6cWhe', 12, 60,
     'banner6.jpg', 'logo6.jpg'),

    (4.2, 'PADARIA', '74196385000177', NOW(), 'sorveteria1@example.com', 'Sorveteria Tropical',
     NOW(), '$2y$10$p1IXPiQ29t1mUit/msZV3OY7Dpz2voS6pK4TBQzPEcVC6QbG6cWhe', 8, 45,
     'banner7.jpg', 'logo7.jpg');
