CREATE TABLE "users" (
  "id_user" INT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY NOT NULL,
  "name" varchar(255) NOT NULL,
  "surname" varchar(255) NOT NULL,
  "cpf" varchar(11) NOT NULL,
  "email" varchar(255) NOT NULL,
  "password" varchar(255) NOT NULL,
  "phone" varchar(15) NOT NULL,
  "date_creation" date NOT NULL,
  "last_login" date NOT NULL
);

CREATE TABLE "restaurants" (
  "id_restaurant" INT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY NOT NULL,
  "cnpj" varchar(14) NOT NULL,
  "fantasy" varchar(255) NOT NULL,
  "email" varchar(255) NOT NULL,
  "password" varchar(255) NOT NULL,
  "date_creation" date NOT NULL,
  "url_banner" varchar(255),
  "url_logo" varchar(255),
  "quantity_evaluations" int DEFAULT 0,
  "total_evaluations" int DEFAULT 0,
  "average_rating" decimal(1,1) DEFAULT 0
);

CREATE TABLE "contacts" (
  "id_contact" INT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY NOT NULL,
  "description" varchar(255) NOT NULL,
  "phone" varchar(255) NOT NULL,
  "fk_id_restaurant" int NOT NULL
);

CREATE TABLE "addresses" (
  "id_address" INT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY NOT NULL,
  "cep" varchar(9) NOT NULL,
  "state" varchar(2) NOT NULL,
  "district" varchar(255) NOT NULL,
  "street" varchar(255) NOT NULL,
  "number" varchar(255) NOT NULL,
  "complement" text,
  "address_type" varchar(255) NOT NULL,
  "standard" boolean DEFAULT false,
  "fk_id_user" int,
  "fk_id_restaurant" int
);

CREATE TABLE "reviews" (
  "id_reviews" INT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY NOT NULL,
  "fk_id_user" int NOT NULL,
  "fk_id_restaurant" int NOT NULL,
  "rating_note" int NOT NULL,
  "rating_date" date NOT NULL,
  "rating_comment" text
);

CREATE TABLE "favorites" (
  "id_favorite" INT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY NOT NULL,
  "addition_date" date NOT NULL
  "fk_id_user" int NOT NULL,
  "fk_id_restaurant" int NOT NULL,
);

CREATE TABLE "notifications" (
  "id_notification" INT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY NOT NULL,
  "fk_id_user" int NOT NULL,
  "msg_notification" text,
  "msg_read" boolean,
  "send_date" timestamp NOT NULL
);

CREATE TABLE "products" (
  "id_product" INT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY NOT NULL,
  "fk_id_restaurant" int,
  "name_prod" varchar(255) NOT NULL,
  "description_prod" varchar(255),
  "url_img_prod" varchar(255),
  "value_prod" decimal(19,2) NOT NULL,
  "discount" int,
  "addition_date" date,
  "active" boolean DEFAULT true
);

CREATE TYPE order_status AS ENUM ('EmProducao','Enviado','Entregue');

CREATE TABLE "orders" (
  "id_order" INT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY NOT NULL,
  "fk_id_user" int,
  "fk_id_restaurant" int,
  "fk_id_address" int,
  "order_date" timestamp,
  "order_status" order_status NOT NULL,
  "total_value" decimal(19,2) NOT NULL
);

CREATE TABLE "itemsOrders" (
  "id_items_orders" INT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY NOT NULL,
  "fk_id_order" int NOT NULL,
  "fk_id_product" int,
  "amount" int NOT NULL,
  "unit_value" decimal(19,2) NOT NULL,
  "subtotal" decimal(19,2) NOT NULL
);

CREATE TABLE "historicalOrders" (
  "id_history" INT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY NOT NULL,
  "fk_id_order" int NOT NULL,
  "fk_id_restaurant" int NOT NULL,
  "fk_id_user" int NOT NULL,
  "order_status" order_status NOT NULL,
  "date_mod" timestamp NOT NULL
);


CREATE TABLE "cards" (
  "id_card" INT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY NOT NULL,
  "number" varchar(16) NOT NULL,
  "validity" varchar(5) NOT NULL,
  "cvv" varchar(3) NOT NULL,
  "fk_id_user" int NOT NULL
);

CREATE TYPE transaction_status AS ENUM ('Aprovada','Negada','Pendente');

CREATE TABLE "transactions" (
  "id_transaction" INT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY NOT NULL,
  "transaction_date" timestamp NOT NULL,
  "transaction_value" decimal(19,2) NOT NULL,
  "transaction_status" transaction_status NOT NULL,
  "fk_id_card" int NOT NULL,
  "fk_id_order" int NOT NULL
);

-- Tabela 'contacts' - chave estrangeira para 'restaurants'
ALTER TABLE "contacts"
ADD CONSTRAINT fk_contacts_restaurants
FOREIGN KEY ("fk_id_restaurant") REFERENCES "restaurants"("id_restaurant");

-- Tabela 'addresses' - chave estrangeira para 'users' e 'restaurants'
ALTER TABLE "addresses"
ADD CONSTRAINT fk_addresses_users
FOREIGN KEY ("fk_id_user") REFERENCES "users"("id_user");

ALTER TABLE "addresses"
ADD CONSTRAINT fk_addresses_restaurants
FOREIGN KEY ("fk_id_restaurant") REFERENCES "restaurants"("id_restaurant");

-- Tabela 'reviews' - chave estrangeira para 'users' e 'restaurants'
ALTER TABLE "reviews"
ADD CONSTRAINT fk_reviews_users
FOREIGN KEY ("fk_id_user") REFERENCES "users"("id_user");

ALTER TABLE "reviews"
ADD CONSTRAINT fk_reviews_restaurants
FOREIGN KEY ("fk_id_restaurant") REFERENCES "restaurants"("id_restaurant");

-- Tabela 'favorites' - chave estrangeira para 'users' e 'restaurants'
ALTER TABLE "favorites"
ADD CONSTRAINT fk_favorites_users
FOREIGN KEY ("fk_id_user") REFERENCES "users"("id_user");

ALTER TABLE "favorites"
ADD CONSTRAINT fk_favorites_restaurants
FOREIGN KEY ("fk_id_restaurant") REFERENCES "restaurants"("id_restaurant");

-- Tabela 'notifications' - chave estrangeira para 'users'
ALTER TABLE "notifications"
ADD CONSTRAINT fk_notifications_users
FOREIGN KEY ("fk_id_user") REFERENCES "users"("id_user");

-- Tabela 'products' - chave estrangeira para 'restaurants'
ALTER TABLE "products"
ADD CONSTRAINT fk_products_restaurants
FOREIGN KEY ("fk_id_restaurant") REFERENCES "restaurants"("id_restaurant");

-- Tabela 'orders' - chave estrangeira para 'users', 'restaurants' e 'addresses'
ALTER TABLE "orders"
ADD CONSTRAINT fk_orders_users
FOREIGN KEY ("fk_id_user") REFERENCES "users"("id_user");

ALTER TABLE "orders"
ADD CONSTRAINT fk_orders_restaurants
FOREIGN KEY ("fk_id_restaurant") REFERENCES "restaurants"("id_restaurant");

ALTER TABLE "orders"
ADD CONSTRAINT fk_orders_addresses
FOREIGN KEY ("fk_id_address") REFERENCES "addresses"("id_address");

-- Tabela 'itemsOrders' - chave estrangeira para 'orders' e 'products'
ALTER TABLE "itemsOrders"
ADD CONSTRAINT fk_itemsOrders_orders
FOREIGN KEY ("fk_id_order") REFERENCES "orders"("id_order");

ALTER TABLE "itemsOrders"
ADD CONSTRAINT fk_itemsOrders_products
FOREIGN KEY ("fk_id_product") REFERENCES "products"("id_product");

-- Tabela 'historicalOrders' - chave estrangeira para 'orders', 'restaurants' e 'users'
ALTER TABLE "historicalOrders"
ADD CONSTRAINT fk_historicalOrders_orders
FOREIGN KEY ("fk_id_order") REFERENCES "orders"("id_order");

ALTER TABLE "historicalOrders"
ADD CONSTRAINT fk_historicalOrders_restaurants
FOREIGN KEY ("fk_id_restaurant") REFERENCES "restaurants"("id_restaurant");

ALTER TABLE "historicalOrders"
ADD CONSTRAINT fk_historicalOrders_users
FOREIGN KEY ("fk_id_user") REFERENCES "users"("id_user");

-- Tabela 'cards' - chave estrangeira para 'users'
ALTER TABLE "cards"
ADD CONSTRAINT fk_cards_users
FOREIGN KEY ("fk_id_user") REFERENCES "users"("id_user");

-- Tabela 'transactions' - chave estrangeira para 'cards' e 'orders'
ALTER TABLE "transactions"
ADD CONSTRAINT fk_transactions_cards
FOREIGN KEY ("fk_id_card") REFERENCES "cards"("id_card");

ALTER TABLE "transactions"
ADD CONSTRAINT fk_transactions_orders
FOREIGN KEY ("fk_id_order") REFERENCES "orders"("id_order");

-- Tabela 'users_notifications' - chave estrangeira para 'users' e 'notifications'
ALTER TABLE "users_notifications" 
ADD FOREIGN KEY ("usuarios_id_usuario") REFERENCES "users" ("id_user");

ALTER TABLE "users_notifications" 
ADD FOREIGN KEY ("notificacoes_id_notificacoes") REFERENCES "notifications" ("id_notification");

CREATE TABLE "users_notifications" (
  "fk_id_user" int,
  "fk_id_notification" int,
  PRIMARY KEY ("fk_id_user", "fk_id_notification")
);

-- Adicionando a chave estrangeira para a tabela "users"
ALTER TABLE "users_notifications" 
ADD FOREIGN KEY ("fk_id_user") REFERENCES "users" ("id_user");

-- Adicionando a chave estrangeira para a tabela "notifications"
ALTER TABLE "users_notifications" 
ADD FOREIGN KEY ("fk_id_notification") REFERENCES "notifications" ("id_notification");

CREATE INDEX idx_users_cpf ON users(cpf);

CREATE INDEX idx_users_email ON users(email);

CREATE INDEX idx_restaurants_cnpj ON restaurants(cnpj);

CREATE INDEX idx_users_email_lower ON users(LOWER(email));

CREATE INDEX idx_users_cpf_email ON users(cpf, email);
