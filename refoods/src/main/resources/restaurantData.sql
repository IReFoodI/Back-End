INSERT INTO tb_restaurants (
    average_rating, category, cnpj, date_creation, email, fantasy,
    last_login, password, quantity_evaluations, total_evaluations,
    url_banner, url_logo
)
VALUES
    (4.8, 'RESTAURANTE', '74125896000144', NOW(), 'cafe1@example.com', 'Cafe Gourmet',
     NOW(), '$2y$10$p1IXPiQ29t1mUit/msZV3OY7Dpz2voS6pK4TBQzPEcVC6QbG6cWhe', 15, 75,
     'http://localhost:8080/images/banner.png', 'http://localhost:8080/images/logo.png'),

    (4.3, 'SUPERMERCADO', '85236974000122', NOW(), 'market1@example.com', 'Supermercado Tudo',
     NOW(), '$2y$10$p1IXPiQ29t1mUit/msZV3OY7Dpz2voS6pK4TBQzPEcVC6QbG6cWhe', 25, 120,
     'banner4.jpg', 'logo4.jpg'),

    (4.9, 'PADARIA', '96385247000166', NOW(), 'padaria1@example.com', 'Padaria Delícia',
     NOW(), '$2y$10$p1IXPiQ29t1mUit/msZV3OY7Dpz2voS6pK4TBQzPEcVC6QbG6cWhe', 18, 85,
     'banner5.jpg', 'logo5.jpg'),

    (4.7, 'PADARIA', '15975328000111', NOW(), 'farmacia1@example.com', 'Padaria Vida',
     NOW(), '$2y$10$p1IXPiQ29t1mUit/msZV3OY7Dpz2voS6pK4TBQzPEcVC6QbG6cWhe', 12, 60,
     'banner6.jpg', 'logo6.jpg'),

    (4.2, 'PADARIA', '74196385000177', NOW(), 'sorveteria1@example.com', 'Sorveteria Tropical',
     NOW(), '$2y$10$p1IXPiQ29t1mUit/msZV3OY7Dpz2voS6pK4TBQzPEcVC6QbG6cWhe', 8, 45,
     'banner7.jpg', 'logo7.jpg');

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
