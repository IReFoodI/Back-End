

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
  'https://firebasestorage.googleapis.com/v0/b/refood-storage.appspot.com/o/fcc1c053-8968-4b8d-b631-de119668e145_02paofrances.PNG?alt=media&token=7fb51711-cc42-4bbc-97c3-4e29e8008120'
),
(
  1, 12.0, 14.0, 'Croissant de Chocolate', 50, 'DOCE', TRUE, '2024-11-17', NOW(), 
  'Croissant folhado recheado com delicioso chocolate cremoso.',
  'https://firebasestorage.googleapis.com/v0/b/refood-storage.appspot.com/o/96ff054c-3cd8-4d16-bc69-a1432d73b3ff_croissant.png?alt=media&token=febd3bff-2b6d-4fee-987a-75c124d0f554'
),
(
  1, 10.0, 12.0, 'Esfiha de Carne', 50, 'SALGADO', TRUE, '2024-11-17', NOW(), 
  'Esfiha aberta com recheio temperado de carne bovina.',
  'https://firebasestorage.googleapis.com/v0/b/refood-storage.appspot.com/o/aafac76c-8e5e-4120-80e4-5f83edce68c2_esfiha.png?alt=media&token=b10da209-0e3b-475b-97f1-8e3f46a3b3d0'
),
(
  1, 3.5, 4.0, 'Pao de Queijo', 60, 'SALGADO', TRUE, '2024-11-17', NOW(), 
  'Classico Pao de queijo mineiro, perfeito para o cafe.',
  'https://firebasestorage.googleapis.com/v0/b/refood-storage.appspot.com/o/7b0e2228-2475-4b5a-a693-bf92dd5dc309_paodequeijo.png?alt=media&token=7f9ac869-92c3-4b1a-9e91-4ef2598c5fe9'
),
(
  1, 25.0, 28.0, 'Torta de limao', 15, 'DOCE', TRUE, '2024-11-17', NOW(), 
  'Torta com base crocante, creme de limao e cobertura de merengue.',
  'https://firebasestorage.googleapis.com/v0/b/refood-storage.appspot.com/o/e0b06ec0-b26f-430f-a447-1bbd4e67749b_tortadelimao.png?alt=media&token=cccc037a-d3a7-4bf5-ba2d-bd25ad090589'
),
(
  1, 8.0, 9.5, 'Quiche de Alho-Poro', 20, 'SALGADO', TRUE, '2024-11-17', NOW(), 
  'Quiche com recheio cremoso de alho-poro e massa amanteigada.',
  'https://firebasestorage.googleapis.com/v0/b/refood-storage.appspot.com/o/8b24502b-c456-4de4-8402-8151fcb87f05_quiche.png?alt=media&token=d17a9f71-cdff-4d4d-acd1-b5ea3ba5de6f'
),
(
  1, 7.0, 8.0, 'Coxinha de Frango', 70, 'SALGADO', TRUE, '2024-11-17', NOW(), 
  'Salgado recheado com frango desfiado e temperado, empanado e frito.',
  'https://firebasestorage.googleapis.com/v0/b/refood-storage.appspot.com/o/16f24911-7a0c-4665-ae21-8d423071e513_coxinha.PNG?alt=media&token=7b376e04-fb4c-4b81-859d-31a7a4b8f843'
),
(
  1, 4.5, 5.5, 'Sonho de Creme', 30, 'DOCE', TRUE, '2024-11-17', NOW(), 
  'Pao doce recheado com creme de confeiteiro e polvilhado com acucar.',
  'https://firebasestorage.googleapis.com/v0/b/refood-storage.appspot.com/o/84997703-c28b-40fe-a431-586980634671_sonho.png?alt=media&token=8641fcc8-5123-41fb-9901-6d403f43bfaf'
),
(
  1, 15.0, 17.0, 'Focaccia com Alecrim', 25, 'SALGADO', TRUE, '2024-11-17', NOW(), 
  'Pao artesanal italiano com azeite extra virgem, sal grosso e alecrim.',
  'https://firebasestorage.googleapis.com/v0/b/refood-storage.appspot.com/o/685c223e-b0a5-4f5e-a535-85bc0cde870d_focaccia.png?alt=media&token=02a62528-3638-4bdf-aa41-3ee7894c97ff'
),
(
  1, 20.0, 22.0, 'Brioche com Geleia de Frutas Vermelhas', 20, 'DOCE', TRUE, '2024-11-17', NOW(), 
  'Pao brioche macio com recheio de geleia caseira de frutas vermelhas.',
  'https://firebasestorage.googleapis.com/v0/b/refood-storage.appspot.com/o/f86c29ba-ce96-4b56-8210-0af63d7f59a0_briochedoce.png?alt=media&token=ede07537-e68f-4dbf-b100-93c081158220'
),

------------ SANDERSON

(
  2, 22.0, 25.0, 'Feijao Tropeiro', 15, 'SALGADO', TRUE, '2024-11-17', NOW(), 
  'Feijao tropeiro com arroz, linguica, bacon e ovos',
  'https://firebasestorage.googleapis.com/v0/b/refood-storage.appspot.com/o/419dfe5a-fffb-4634-9f6c-831ddfa53a58_feijaotropeiro.png?alt=media&token=fa34f0c5-9363-44b4-acef-ebc34f2dfae2'
),
(
  2, 19.0, 21.0, 'Frango Assado com Farofa', 20, 'SALGADO', TRUE, '2024-11-17', NOW(), 
  'Frango assado temperado com ervas e acompanhado de farofa',
  'https://firebasestorage.googleapis.com/v0/b/refood-storage.appspot.com/o/0fd07a53-86a6-4c59-99c8-c14d2fbe06d4_frangoassadocomfarofa.png?alt=media&token=1e63f19f-f173-4c0b-9886-2bf9bee602e7'
),
(
  2, 15.0, 18.0, 'Macarronada a Bolonhesa', 30, 'SALGADO', TRUE, '2024-11-17', NOW(), 
  'Macarrao com molho bolonhesa caseiro, carne moida e queijo ralado',
  'https://firebasestorage.googleapis.com/v0/b/refood-storage.appspot.com/o/a4b04e40-12da-4b42-96d3-3f5771968f3c_macarronadabolonhesa.PNG?alt=media&token=4edaa083-3f72-4481-8150-fddd3b5db237'
),
(
  2, 10.0, 12.0, 'Pudim de Leite Condensado', 25, 'DOCE', TRUE, '2024-11-17', NOW(), 
  'Pudim cremoso de leite condensado com calda de caramelo',
  'https://firebasestorage.googleapis.com/v0/b/refood-storage.appspot.com/o/0baef109-6abc-4a92-8d0f-760b4b282dcf_pudim.png?alt=media&token=c5a469b2-5763-4ecb-af43-5b7ab96e4e44'
),
(
  2, 14.0, 16.0, 'Feijoada Completa', 18, 'SALGADO', TRUE, '2024-11-17', NOW(), 
  'Feijoada tradicional com arroz, couve, farofa e laranja',
  'https://firebasestorage.googleapis.com/v0/b/refood-storage.appspot.com/o/352a5686-6b93-4f4e-8fb7-3f42658d3123_feijoada.png?alt=media&token=5c9ebd36-c3b2-47cb-8f28-3fc67bf9f1d3'
),
(
  2, 12.0, 14.0, 'Escondidinho de Carne Seca', 22, 'SALGADO', TRUE, '2024-11-17', NOW(), 
  'Pure de mandioca com carne seca desfiada por cima',
  'https://firebasestorage.googleapis.com/v0/b/refood-storage.appspot.com/o/fe00a658-8777-44fa-8bb5-29b5ce264683_escondidinho.png?alt=media&token=13e7938c-80db-437b-a434-f8805d9e9c22'
),
(
  2, 9.0, 11.0, 'Arroz de Carreteiro', 20, 'SALGADO', TRUE, '2024-11-17', NOW(), 
  'Arroz refogado com carne de sol desfiada e temperos',
  'https://firebasestorage.googleapis.com/v0/b/refood-storage.appspot.com/o/1b21e905-aca7-41ab-a28a-1db73126df4a_arrozcarreteiro.png?alt=media&token=08a02752-f85d-4856-954b-4a2f269448cf'
),

------------ SUSHI

( 
  4, 15.0, 18.0, 'Sushi de Salmao', 30, 'SALGADO', TRUE, '2024-11-17', NOW(), 
  'Sushi classico de arroz com fatia de salmao fresco por cima',
  'https://firebasestorage.googleapis.com/v0/b/refood-storage.appspot.com/o/789cc146-0e4c-4b8f-8cfb-c106cabe7a07_sushisalmao.PNG?alt=media&token=d99bec9c-3c60-4dfb-81fa-2d5e9defeb57'
),
(
  4, 18.0, 20.0, 'Sashimi de Atum', 25, 'SALGADO', TRUE, '2024-11-17', NOW(), 
  'Fatias de atum fresco cortadas com precisao',
  'https://firebasestorage.googleapis.com/v0/b/refood-storage.appspot.com/o/6c6b844d-8505-4e39-8117-da509393a410_atum.png?alt=media&token=d358238c-e6bb-4e53-8749-934fe2a2aeed'
),
(
  4, 20.0, 22.0, 'Temaki de Salmao com Cream Cheese', 15, 'SALGADO', TRUE, '2024-11-17', NOW(), 
  'Cone de alga recheado com arroz, salmao e cream cheese',
  'https://firebasestorage.googleapis.com/v0/b/refood-storage.appspot.com/o/0f152d9d-cb32-4250-89c9-076bc7f2a26a_temaki.png?alt=media&token=89082fcc-34da-4465-bc3d-c3bf64a858d0'
),
(
  4, 25.0, 28.0, 'Combinado de Sushi e Sashimi', 10, 'SALGADO', TRUE, '2024-11-17', NOW(), 
  'Combinado com variedade de sushis e sashimis frescos',
  'https://firebasestorage.googleapis.com/v0/b/refood-storage.appspot.com/o/7b1b2163-a39b-44ae-b7fa-511959733f6f_combinado.png?alt=media&token=bee1da72-6a2b-459d-982c-019e92ba9d9f'
),
(
  4, 12.0, 14.0, 'Hot Roll', 20, 'SALGADO', TRUE, '2024-11-17', NOW(), 
  'Sushi empanado recheado com salmao e cream cheese, servido quente',
  'https://firebasestorage.googleapis.com/v0/b/refood-storage.appspot.com/o/cb350245-cd2e-4cd0-83ce-f90ada25202b_hotroll.png?alt=media&token=2fee55ae-efe1-4c19-aedc-14980623e474'
),
(
  4, 10.0, 12.0, 'Gyoza', 18, 'SALGADO', TRUE, '2024-11-17', NOW(), 
  'Pasteis japoneses recheados com carne de porco e vegetais',
  'https://firebasestorage.googleapis.com/v0/b/refood-storage.appspot.com/o/361880ea-894f-4e22-913c-31030db70f58_gyoza.png?alt=media&token=787825c0-3f5a-4814-9335-696ee0526dc6'
),
(
  4, 40.0, 35.0, 'Yakissoba de Camarao', 22, 'SALGADO', TRUE, '2024-11-17', NOW(), 
  'Macarrao japones com camarao, vegetais e molho especial',
  'https://firebasestorage.googleapis.com/v0/b/refood-storage.appspot.com/o/c545a83b-9519-4396-a1fd-77f53d0c0dca_yakissobacamarao.png?alt=media&token=0606c0f3-549e-4f4d-9642-0c38e108298a'
),

--------- PIZZARIA

( 
  5, 25.0, 28.0, 'Pizza Margherita', 10, 'SALGADO', TRUE, '2024-11-17', NOW(), 
  'Classica pizza com molho de tomate, mussarela, manjericão fresco e azeite de oliva',
  'https://firebasestorage.googleapis.com/v0/b/refood-storage.appspot.com/o/8ec9e17d-5c50-41fd-b5dd-d3c9fab9f167_marguerita.png?alt=media&token=4237203f-9fc8-4b5d-9ba0-00a1c6bec165'
),
(
  5, 30.0, 33.0, 'Pizza Calabresa', 12, 'SALGADO', TRUE, '2024-11-17', NOW(), 
  'Pizza com fatias de calabresa, cebola e queijo mussarela',
  'https://firebasestorage.googleapis.com/v0/b/refood-storage.appspot.com/o/397e1081-5978-4c5b-86a5-1324dba03697_calabresa.png?alt=media&token=cd01f769-10e7-4e4e-9748-7f10c50baf5a'
),
(
  5, 28.0, 32.0, 'Pizza Quatro Queijos', 8, 'SALGADO', TRUE, '2024-11-17', NOW(), 
  'Pizza com uma combinacao de mussarela, gorgonzola, parmesao e provolone',
  'https://firebasestorage.googleapis.com/v0/b/refood-storage.appspot.com/o/f64b6395-bce7-46f5-bf2b-e6e95e1e33cb_4queijos.png?alt=media&token=ee374dc9-0b88-4296-b3bd-8c76f11f9976'
),
(
  5, 35.0, 38.0, 'Pizza Portuguesa', 15, 'SALGADO', TRUE, '2024-11-17', NOW(), 
  'Pizza com mussarela, presunto, ovos, cebola, azeitonas e pimentao',
  'https://firebasestorage.googleapis.com/v0/b/refood-storage.appspot.com/o/a4c18bf7-f35a-4115-9e40-fc0af6226e17_portugues.png?alt=media&token=6ba09501-ebf6-4064-bfc6-1e3a2be8003d'
),
(
  5, 27.0, 30.0, 'Pizza Pepperoni', 18, 'SALGADO', TRUE, '2024-11-17', NOW(), 
  'Pizza com molho de tomate, mussarela e fatias generosas de pepperoni',
  'https://firebasestorage.googleapis.com/v0/b/refood-storage.appspot.com/o/781344b9-ea95-4932-b7e7-adf546f408c1_pepperoni.png?alt=media&token=6b25efe2-850f-4bfb-b8e4-fe2be3555bb9'
),
(
  5, 32.0, 36.0, 'Pizza Frango com Catupiry', 12, 'SALGADO', TRUE, '2024-11-17', NOW(), 
  'Pizza de frango desfiado, catupiry e mussarela',
  'https://firebasestorage.googleapis.com/v0/b/refood-storage.appspot.com/o/b0073fa1-4ae9-419f-b7fa-3ee2389642b2_frangocatupiry.png?alt=media&token=1bcf12ef-c51b-47e8-9efe-3097c25c9893'
),
(
  5, 29.0, 34.0, 'Pizza Vegetariana', 14, 'SALGADO', TRUE, '2024-11-17', NOW(), 
  'Pizza com cogumelos, abobrinha, pimentões e queijo mussarela',
  'https://firebasestorage.googleapis.com/v0/b/refood-storage.appspot.com/o/6dc40af5-3830-42c2-bee0-b4ee172d1e23_vegetariana.png?alt=media&token=13a04fbb-592d-4150-9455-4f5ac67b1343'
),

---------- CONFEITARIA

( 
  8, 8.0, 10.0, 'Bolo de Chocolate', 20, 'DOCE', TRUE, '2024-11-17', NOW(), 
  'Delicioso bolo de chocolate com cobertura cremosa',
  'https://firebasestorage.googleapis.com/v0/b/refood-storage.appspot.com/o/a2e52b99-4a0f-49ff-91d1-7e8e02e0eff7_bolochocolate.PNG?alt=media&token=c05f21aa-41e1-4fbe-8696-0e21071075a1'
),
(
  8, 7.0, 9.0, 'Torta de limao', 15, 'DOCE', TRUE, '2024-11-17', NOW(), 
  'Torta com base crocante, recheio cremoso de limao e merengue',
  'https://firebasestorage.googleapis.com/v0/b/refood-storage.appspot.com/o/e36e2992-6993-4e23-8cff-dd4840f28615_tortadelimao.png?alt=media&token=3c8f6f1c-d359-445c-abb0-5e26529ff6dd'
),
(
  8, 6.0, 8.0, 'Brigadeiro Gourmet', 30, 'DOCE', TRUE, '2024-11-17', NOW(), 
  'Classico doce brasileiro com chocolate belga e granulados finos',
  'https://firebasestorage.googleapis.com/v0/b/refood-storage.appspot.com/o/8a9cf61f-586a-49e1-afd7-a8dfc0994f9b_brigadeiro.png?alt=media&token=0369ed8d-dc5f-43f9-a85f-d95633031c12'
),
(
  8, 12.0, 14.0, 'Cheesecake de Frutas Vermelhas', 12, 'DOCE', TRUE, '2024-11-17', NOW(), 
  'Cheesecake cremoso com calda de frutas vermelhas',
  'https://firebasestorage.googleapis.com/v0/b/refood-storage.appspot.com/o/f653b054-2760-4eb3-ab47-dbba334c7407_cheesecake.png?alt=media&token=9980d479-2981-497d-a625-0479aaa75c3a'
),
(
  8, 4.0, 6.0, 'Cupcake Red Velvet', 25, 'DOCE', TRUE, '2024-11-17', NOW(), 
  'Cupcake macio de red velvet com cobertura de cream cheese',
  'https://firebasestorage.googleapis.com/v0/b/refood-storage.appspot.com/o/9e150a11-1542-448e-90e0-7e79a5c3cada_cupcakeredvelvet.png?alt=media&token=9d9347ad-2d00-43d3-8e46-fb1454bc2315'
),
(
  8, 5.0, 7.0, 'Macarons', 40, 'DOCE', TRUE, '2024-11-17', NOW(), 
  'Delicados macarons franceses com recheios variados',
  'https://firebasestorage.googleapis.com/v0/b/refood-storage.appspot.com/o/1b02c269-1cff-4443-911c-76a02b1e2a47_macarons.png?alt=media&token=71901821-7ef0-4c69-a6f9-09605b3582c0'
),
(
  8, 15.0, 18.0, 'Pave de Doce de Leite', 10, 'DOCE', TRUE, '2024-11-17', NOW(), 
  'Camadas de biscoito, creme e doce de leite com cobertura de chantilly',
  'https://firebasestorage.googleapis.com/v0/b/refood-storage.appspot.com/o/b75d58da-13c3-4dd5-8e0c-71e9ec29a932_pavedocedeleite.png?alt=media&token=7dc0a235-59c9-4faa-9186-ed9c301f5b15'
),

-------- HAMBUGUER

( 
  6, 15.0, 18.0, 'Classic Burger', 25, 'SALGADO', TRUE, '2024-11-17', NOW(), 
  'Hamburguer classico com carne bovina, queijo cheddar, alface, tomate e maionese especial',
  'https://firebasestorage.googleapis.com/v0/b/refood-storage.appspot.com/o/ed849570-d5c3-47ce-9b82-6ecb26b30400_classico.PNG?alt=media&token=9b5d28f6-d05b-4dc8-87ae-454ffb3955d4'
),
(
  6, 18.0, 22.0, 'Cheddar Burger', 20, 'SALGADO', TRUE, '2024-11-17', NOW(), 
  'Hamburguer com carne suculenta, queijo cheddar derretido e tiras crocantes de bacon',
  'https://firebasestorage.googleapis.com/v0/b/refood-storage.appspot.com/o/38516b68-e3be-402b-8aaf-6b768bc99b1b_cheddar.png?alt=media&token=2da78e2f-9c04-4d73-b263-58463afdc7c5'
),
(
  6, 20.0, 24.0, 'Double Smash Burger', 15, 'SALGADO', TRUE, '2024-11-17', NOW(), 
  'Dois hamburgueres smash com queijo cheddar, cebola caramelizada e molho especial',
  'https://firebasestorage.googleapis.com/v0/b/refood-storage.appspot.com/o/9078882e-c5d3-4ec9-8fc7-5c7d2b80932c_smash.png?alt=media&token=3d9e24ad-f254-4f29-bfcb-bb26a3fc36dd'
),
(
  6, 12.0, 15.0, 'Veggie Burger', 18, 'SALGADO', TRUE, '2024-11-17', NOW(), 
  'Hamburguer vegetariano feito com grao de bico, legumes, alface e maionese de ervas',
  'https://firebasestorage.googleapis.com/v0/b/refood-storage.appspot.com/o/7c79164f-3a7b-4a67-bb40-1c659ce136fe_vegano.png?alt=media&token=f5e1317b-4cb5-46d2-a9db-1f067f7f86d9'
),
(
  6, 22.0, 25.0, 'BBQ Pulled Pork Burger', 12, 'SALGADO', TRUE, '2024-11-17', NOW(), 
  'Hamburguer com carne de porco desfiada, molho barbecue, cebola roxa e coleslaw',
  'https://firebasestorage.googleapis.com/v0/b/refood-storage.appspot.com/o/618f801b-735c-4fec-9ae4-e94718e4a163_BBQpork.png?alt=media&token=6b29e2e1-cefc-4a67-952f-7a5b378542a7'
),
(
  6, 16.0, 20.0, 'Chicken Crispy Burger', 22, 'SALGADO', TRUE, '2024-11-17', NOW(), 
  'Hamburguer com file de frango empanado crocante, maionese de pimenta e salada',
  'https://firebasestorage.googleapis.com/v0/b/refood-storage.appspot.com/o/0fbc14f6-c5d5-479b-a237-2e278cce3e6d_frango.png?alt=media&token=99f5b410-cc71-42ec-8170-add8759b2f33'
),
(
  6, 19.0, 23.0, 'Bacon Lover Burger', 18, 'SALGADO', TRUE, '2024-11-17', NOW(), 
  'Hamburguer com duas camadas de bacon crocante, queijo prato e molho de alho',
  'https://firebasestorage.googleapis.com/v0/b/refood-storage.appspot.com/o/dcb620e4-7281-4ee8-a566-fe6483f1ea56_bacon.png?alt=media&token=68132a23-faa5-4dec-bd07-873f980830a5'
),
(
  6, 14.0, 17.0, 'Swiss Mushroom Burger', 20, 'SALGADO', TRUE, '2024-11-17', NOW(), 
  'Hamburguer com cogumelos salteados, queijo suíço e molho cremoso',
  'https://firebasestorage.googleapis.com/v0/b/refood-storage.appspot.com/o/2e687889-3ac7-4539-ba0d-2d03f5056f04_cogumelo.png?alt=media&token=8a094aea-0059-4cb2-88af-8abbe9effd62'
),
(
  6, 11.0, 14.0, 'Spicy Jalapeno Burger', 18, 'SALGADO', TRUE, '2024-11-17', NOW(), 
  'Hamburguer apimentado com jalapenos, queijo cheddar e molho chipotle',
  'https://firebasestorage.googleapis.com/v0/b/refood-storage.appspot.com/o/1d0cc600-1fd9-4948-a81f-5aad05741914_spicy.png?alt=media&token=037e1a99-5e36-4231-a3d3-998d2dd75afd'
),
(
  6, 20.0, 25.0, 'Truffle Burger', 10, 'SALGADO', TRUE, '2024-11-17', NOW(), 
  'Hamburguer premium com queijo gouda, cebolas caramelizadas e molho trufado',
  'https://firebasestorage.googleapis.com/v0/b/refood-storage.appspot.com/o/254228dc-2ed4-45ce-a5c1-d994b519e8fc_trufas.png?alt=media&token=0184db1e-b761-451c-a456-2222a3ecc675'
),

--------- PRESTON SALAD

( 
  3, 14.0, 16.0, 'Caesar Salad', 20, 'MISTO', TRUE, '2024-11-17', NOW(), 
  'Salada classica com alface romana, croutons crocantes, queijo parmesao e molho Caesar',
  'https://firebasestorage.googleapis.com/v0/b/refood-storage.appspot.com/o/9368f24c-8a90-44f9-8dc7-0bcfe741694d_cesarsalad.png?alt=media&token=0c2682b4-f2c6-4047-b7e7-a202d16964ee'
),
(
  3, 16.0, 18.0, 'Salada de Quinoa', 18, 'MISTO', TRUE, '2024-11-17', NOW(), 
  'Quinoa com tomate cereja, pepino, cebola roxa, salsinha e azeite de oliva',
  'https://firebasestorage.googleapis.com/v0/b/refood-storage.appspot.com/o/721c1832-8cf6-4434-a3c3-f2540527cd54_saladaquinoa.png?alt=media&token=310fae5d-d4d5-4d62-9895-823a90f48677'
),
(
  3, 18.0, 20.0, 'Salada Caprese', 15, 'MISTO', TRUE, '2024-11-17', NOW(), 
  'Tomate fresco, mussarela de bufala, manjericao e azeite de oliva',
  'https://firebasestorage.googleapis.com/v0/b/refood-storage.appspot.com/o/02b6ccd6-d448-4dfb-bb4c-0160dd40cffc_saladacaprese.png?alt=media&token=ba10fbb5-6b62-4770-b4b1-102a0cffd19c'
),
(
  3, 20.0, 24.0, 'Salada Tropical', 12, 'MISTO', TRUE, '2024-11-17', NOW(), 
  'Alface americana, manga, abacaxi, cenoura ralada e molho de iogurte',
  'https://firebasestorage.googleapis.com/v0/b/refood-storage.appspot.com/o/29b4319e-3a65-48c1-a7ec-51458b41e6df_saladatropical.png?alt=media&token=26306213-1041-442f-83b9-5e674484da49'
),
(
  3, 18.0, 22.0, 'Salada de Frango Grelhado', 22, 'MISTO', TRUE, '2024-11-17', NOW(), 
  'Mix de folhas verdes, frango grelhado, tomate cereja e molho mostarda e mel',
  'https://firebasestorage.googleapis.com/v0/b/refood-storage.appspot.com/o/eeaa097b-a0d6-4778-9263-8c1f6feeae95_saladafrango.png?alt=media&token=c5c5fefd-b28a-44ad-9e6f-1496b52e71d4'
),
(
  3, 16.0, 20.0, 'Salada Grega', 18, 'MISTO', TRUE, '2024-11-17', NOW(), 
  'Pepino, tomate, cebola roxa, azeitonas, queijo feta e azeite de oliva',
  'https://firebasestorage.googleapis.com/v0/b/refood-storage.appspot.com/o/5b10218b-2707-41d6-ab9d-0aa9ef5cb7ce_saladagrega.png?alt=media&token=082533e7-37cd-4b9b-8497-09ba10775465'
),
(
  3, 12.0, 15.0, 'Salada de Lentilha', 20, 'MISTO', TRUE, '2024-11-17', NOW(), 
  'Lentilha cozida, cenoura, salsinha, cebola roxa e limao siciliano',
  'https://firebasestorage.googleapis.com/v0/b/refood-storage.appspot.com/o/f46f53e0-d5d4-439f-a6d6-c080a0a93149_saladalentilha.png?alt=media&token=6d63bb68-cd13-4206-87af-a5c6a4b6f898'
),

--------- MERCADO

( 
  7, 5.0, 6.5, 'Arroz Branco 1kg', 50, 'MISTO', TRUE, '2024-11-17', NOW(), 
  'Arroz branco tipo 1, ideal para todas as refeicoes',
  'https://firebasestorage.googleapis.com/v0/b/refood-storage.appspot.com/o/d881de75-bfdf-42c6-b117-87fae995facc_arroz.png?alt=media&token=9fda49a3-82c0-4b60-a15a-c5e78942f77a'
),
(
  7, 7.0, 8.5, 'Feijao Carioca 1kg', 40, 'MISTO', TRUE, '2024-11-17', NOW(), 
  'Feijao carioca selecionado, rico em sabor e nutrientes',
  'https://firebasestorage.googleapis.com/v0/b/refood-storage.appspot.com/o/97c343ef-95f4-4c85-8264-8de375d7d34a_feijao.png?alt=media&token=27965f7c-bdb1-451e-ba22-02b34121d7f7'
),
(
  7, 3.0, 4.0, 'Macarrao Espaguete 500g', 60, 'MISTO', TRUE, '2024-11-17', NOW(), 
  'Macarrao espaguete de alta qualidade, perfeito para pratos italianos',
  'https://firebasestorage.googleapis.com/v0/b/refood-storage.appspot.com/o/a6b01f6b-99f4-4cfc-af7d-2f0e4cab99e9_macarrao.png?alt=media&token=dde77108-1c76-4f92-b1be-5a97a2c38318'
),
(
  7, 4.5, 6.0, 'Azeite de Oliva 500ml', 30, 'MISTO', TRUE, '2024-11-17', NOW(), 
  'Azeite de oliva extra virgem, ideal para temperos e finalizacoes',
  'https://firebasestorage.googleapis.com/v0/b/refood-storage.appspot.com/o/7ad6ad4c-22b5-413d-be08-11848d15927f_azeite.png?alt=media&token=062ecc0b-c75e-4177-895b-93b1b26a81ce'
),
(
  7, 2.0, 2.5, 'Acucar Cristal 1kg', 70, 'MISTO', TRUE, '2024-11-17', NOW(), 
  'Acucar cristal de alta pureza, perfeito para receitas e bebidas',
  'https://firebasestorage.googleapis.com/v0/b/refood-storage.appspot.com/o/2d661339-a97d-4b80-9add-2bac21c834f2_acucar.png?alt=media&token=b7e00e05-c8bb-4fe0-bf26-5d72b33b3da6'
),
(
  7, 3.5, 4.0, 'Cafe Torrado e moido 500g', 45, 'MISTO', TRUE, '2024-11-17', NOW(), 
  'Cafe torrado e moido com sabor encorpado, ideal para começar o dia',
  'https://firebasestorage.googleapis.com/v0/b/refood-storage.appspot.com/o/2108db1f-e55f-43b8-92db-317f1c804236_cafe.png?alt=media&token=b76b4bc2-e1a9-4370-8b83-7d8aaae6d8f9'
),
(
  7, 1.5, 2.0, 'Leite Integral 1L', 80, 'MISTO', TRUE, '2024-11-17', NOW(), 
  'Leite integral pasteurizado, rico em nutrientes',
  'https://firebasestorage.googleapis.com/v0/b/refood-storage.appspot.com/o/7bc14590-04be-4264-99e2-3bfa96e8fc73_leite.png?alt=media&token=96876baa-b78a-4a63-8064-f82e869a79d1'
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

(2, 13, 2, 0, 0),
(2, 14, 1, 0, 0),
(2, 15, 2, 0, 0),

(3, 36, 4, 0, 0),
(3, 37, 1, 0, 0),

(4, 48, 2, 0, 0),
(4, 49, 3, 0, 0),

(5, 51, 2, 0, 0),
(5, 52, 1, 0, 0),
(5, 53, 3, 0, 0),

(6, 60, 1, 0, 0),
(6, 61, 5, 0, 0);

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
