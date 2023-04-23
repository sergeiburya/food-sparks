--liquibase formatted sql
--changeset <Serhii Buria>:<add-data-table-recipes>
insert into recipes (complexity_id, cooking_time, cuisine_region_id, dish_type_id, image_url, portions, spiced, subtitle, dish_name)
values (1, 30, 10, 3, 'https://i.ibb.co/vVw7kSW/kremzlyky.jpg', 4, 1, 'Кремзлики, гуглі, деруни. Опановуємо й далі закарпатський діалект та готуємо локальну їжу.', 'Кремзлики');
insert into recipes (complexity_id, cooking_time, cuisine_region_id, dish_type_id, image_url, portions, spiced, subtitle, dish_name)
values (1, 30, 10, 5, 'https://i.ibb.co/sy1Fx1g/Soupe-cream.jpg', 1, 1, 'Крем-суп з зеленого горошку з м\'ятою: крок за кроком', 'Крем-суп з зеленого горошку з м\'ятою');
insert into recipes (complexity_id, cooking_time, cuisine_region_id, dish_type_id, image_url, portions, spiced, subtitle, dish_name)
values (3, 60, 10, 4, 'https://i.ibb.co/zXtGcDy/pirog.jpg', 8, 0, 'Як приготувати цибульний смачний пиріг зі шпротами: крок за кроком', 'Цибульний пиріг зі шпротами');
insert into recipes (complexity_id, cooking_time, cuisine_region_id, dish_type_id, image_url, portions, spiced, subtitle, dish_name)
values (1, 60, 10, 1, 'https://i.ibb.co/ZzTdtmc/Salad.jpg', 4, 0, 'Як приготувати салат з буряка, чорнослива та горіхів: крок за кроком', 'Салат з чорносливом і буряком пісний');
insert into recipes (complexity_id, cooking_time, cuisine_region_id, dish_type_id, image_url, portions, spiced, subtitle, dish_name)
values (3, 45, 10, 3, 'https://i.ibb.co/f24r67h/banosh.jpg', 2, 0, 'Банош – частина гуцульської душі', 'Банош');
insert into recipes (complexity_id, cooking_time, cuisine_region_id, dish_type_id, image_url, portions, spiced, subtitle, dish_name)
values (3, 55, 6, 2, 'https://i.ibb.co/71HVQbY/image.jpg', 4, 0, 'В сезон полуниці можна поласувати ароматною свіжою ягідкою, а також приготувати страви з полуницею.', 'Вареники з полуницею');
insert into recipes (complexity_id, cooking_time, cuisine_region_id, dish_type_id, image_url, portions, spiced, subtitle, dish_name)
values (2, 110, 6, 5, 'https://i.ibb.co/ZxhCG1J/image.jpg', 6, 0, 'Давайте приготуємо дуже простий і швидкий, але неймовірно смачний грибний суп з вершками. В цьому рецепті ми використовували шампіньйони, але можна взяти будь-які інші лісові гриби. Від цього смак супу стане ще кращим', 'Грибний суп');
insert into recipes (complexity_id, cooking_time, cuisine_region_id, dish_type_id, image_url, portions, spiced, subtitle, dish_name)
values (3, 45, 6, 4, 'https://i.ibb.co/txvgvq0/image.jpg', 8, 0, 'Швидкий пиріг з чорницею справді дуже смачний! Він виходить вологим і чудово ріжеться. Цей простий у приготуванні чорничний пиріг зникає з тарілок в одну мить.', 'Пиріг з чорницею');
insert into recipes (complexity_id, cooking_time, cuisine_region_id, dish_type_id, image_url, portions, spiced, subtitle, dish_name)
values (3, 50, 6, 3, 'https://i.ibb.co/hDBchS7/image.jpg', 12, 1, 'Сьогодні будемо готувати надзвичайно смачні та апетитні фаршировані перці з м’ясом та рисом. Така страва буде ідеальним варіантом вечері, її обожнюють як дорослі так і діти. Готувати такі фаршировані перці зовсім нескладно.', 'Фарширований перець');
insert into recipes (complexity_id, cooking_time, cuisine_region_id, dish_type_id, image_url, portions, spiced, subtitle, dish_name)
values (2, 90, 6, 1, 'https://i.ibb.co/xJQtTVr/image.jpg', 6, 0, 'Розрепанці – це невеликі картопляні пиріжки, скріплені тільки по краях. Найчастіше їх готували з гороховою чи квасолевою начинкою та подавали з “маштаркою” – соусом з горіхів, гарбузового та лляного насіння та сметани, з яким традиційно подають картопляники.', 'Картопляні пиріжки з горохом, або подільські розрепанці');
insert into recipes (complexity_id, cooking_time, cuisine_region_id, dish_type_id, image_url, portions, spiced, subtitle, dish_name)
values (1, 45, 6, 2, 'https://ibb.co/fGBK56N', 1, 0, 'Важко уявити зиму без ароматного малинового варення. Воно смачне та неймовірно корисне, бо полегшує стан здоров’я при сезонній застуді. Ми захотіли урізноманітнити класичний смак малинового варення та додали до нього м’якуш апельсина, адже цитрусові добре поєднуються з ягодами.', 'Варення з малини та апельсина');

insert into recipes (complexity_id, cooking_time, cuisine_region_id, dish_type_id, image_url, portions, spiced, subtitle, dish_name)
values (3, 60, 9, 3, 'https://i.ibb.co/KzRQk4s/image.jpg', 6, 0, 'Як приготувати капусту по-волинськи з квашеної капусти, свинини, моркви, цибулі', 'Капуста по-волинськи');
insert into recipes (complexity_id, cooking_time, cuisine_region_id, dish_type_id, image_url, portions, spiced, subtitle, dish_name)
values (3, 40, 9, 2, 'https://i.ibb.co/PQS19N3/1.jpg', 4, 0, 'Як приготувати хамулу з вишні, сметани, цукру, крохмалю', 'Хамула');
insert into recipes (complexity_id, cooking_time, cuisine_region_id, dish_type_id, image_url, portions, spiced, subtitle, dish_name)
values (3, 60, 9, 3, 'https://i.ibb.co/9rZf1ms/image.jpg', 6, 0, 'Як приготувати крученики волинські зі свинини, капусти, моркви, цибулі, сметани', 'Крученики волинські');
insert into recipes (complexity_id, cooking_time, cuisine_region_id, dish_type_id, image_url, portions, spiced, subtitle, dish_name)
values (3, 60, 9, 3, 'https://i.ibb.co/7VvR0Gv/golubczi.jpg', 4, 0, 'Як приготувати Волинські голубці з картоплею з картоплі, капусти, часнику, цибулі, томатної пасти', 'Волинські голубці з картоплею');
insert into recipes (complexity_id, cooking_time, cuisine_region_id, dish_type_id, image_url, portions, spiced, subtitle, dish_name)
values (3, 60, 9, 5, 'https://i.ibb.co/PjYHv9G/image.jpg', 6, 0, 'Як приготувати Огірочник з огірків, свинини, цибулі, томатної пасти', 'Огірочник');
insert into recipes (complexity_id, cooking_time, cuisine_region_id, dish_type_id, image_url, portions, spiced, subtitle, dish_name)
values (3, 45, 9, 3, 'https://i.ibb.co/LnpQYZ4/image.jpg', 3, 0, 'Як приготувати клекуцьоху зі пшона, моркви, цибулі, перцю', 'Клекуцьоха');

insert into recipes (complexity_id, cooking_time, cuisine_region_id, dish_type_id, image_url, portions, spiced, subtitle, dish_name)
values (2, 180, 3, 3, 'https://i.ibb.co/9b51NSn/image.jpg', 10, 0, 'Традиційна страва кримськотатарської кухні, яка складається з м\'яса, овочів та тіста, звичайно в формі широких локшино-подібних смужок, варених у бульйоні.', 'Бешбармак');
insert into recipes (complexity_id, cooking_time, cuisine_region_id, dish_type_id, image_url, portions, spiced, subtitle, dish_name)
values (2, 60, 3, 5, 'https://i.ibb.co/jw5FM7G/image.jpg', 6, 0, 'Чорба - це густий суп з м''ясом та овочами, який часто має насичений смак і аромат завдяки спеціям та зелені.', 'Чорба');
insert into recipes (complexity_id, cooking_time, cuisine_region_id, dish_type_id, image_url, portions, spiced, subtitle, dish_name)
values (2, 90, 3, 3, 'https://i.ibb.co/NW5qV89/image.jpg', 6, 0, 'Це традиційна страва кримськотатарської кухні, яка складається з м''ясного соусу на основі яловичини або баранини та довгих макаронних виробів.  Це смачна і насичена страва, яка ідеально підходить для холодних осінніх і зимових днів.', 'Лагман');
insert into recipes (complexity_id, cooking_time, cuisine_region_id, dish_type_id, image_url, portions, spiced, subtitle, dish_name)
values (2, 60, 3, 5, 'https://i.ibb.co/VVnwwZg/image.jpg', 6, 1, 'Шурпа - це традиційна страва кримськотатарської кухні, в основі якої лежить бульйон на основі м''яса, овочів та спецій. Вона може бути дуже густою або ж, навпаки, водянистою, в залежності від рецепту і традицій регіону.', 'Шурпа');
insert into recipes (complexity_id, cooking_time, cuisine_region_id, dish_type_id, image_url, portions, spiced, subtitle, dish_name)
values (3, 60, 3, 2, 'https://i.ibb.co/2Fq7gGX/image.jpg', 10, 0, 'Це медові шматочки тіста, які спочатку фритюрюються в олії, а потім заливають медовою сиропом. Вони можуть мати різний розмір та форму, а також прикрашаються маком або іншими насіннями. Чак-чак зазвичай подається на святковій та урочистій татарській вечері разом з іншими національними стравами.', 'Чак-чак');
insert into recipes (complexity_id, cooking_time, cuisine_region_id, dish_type_id, image_url, portions, spiced, subtitle, dish_name)
values (3, 40, 3, 4, 'https://i.ibb.co/RPWRnmY/image.jpg', 8, 0, 'Сомси - це популярна кримськотатарська випічка з начинкою. Ось простий рецепт, який можна спробувати приготувати вдома.', 'Сомси');

insert into recipes (complexity_id, cooking_time, cuisine_region_id, dish_type_id, image_url, portions, spiced, subtitle, dish_name)
values (1, 20, 2, 1, 'https://i.ibb.co/v1dmqn2/image.jpg', 4, 0, 'Бурячки з хроном або цвіклі – одна із найулюбленіших страв Галицької кухні та на теренах західної України. Зазвичай цю страву подають до холодцю, копченого м’яса.', 'Цвіклі');
insert into recipes (complexity_id, cooking_time, cuisine_region_id, dish_type_id, image_url, portions, spiced, subtitle, dish_name)
values (2, 90, 2, 5, 'https://i.ibb.co/RDNXt1D/image.jpg', 6, 0, 'Журек - це страва галицької кухні, яка складається з кислого тіста та густого соусу на основі м\'ясного бульйону.', 'Журек');
insert into recipes (complexity_id, cooking_time, cuisine_region_id, dish_type_id, image_url, portions, spiced, subtitle, dish_name)
values (2, 120, 2, 3, 'https://i.ibb.co/swQN0fc/image.jpg', 8, 0, 'Чанахи - це чудова м''ясна страва галицької кухні, яка зазвичай готується з баранини або телятини та овочів. М''ясо та овочі смажаться зі спеціями та запікаються в глиняному горщику, що надає страві особливого смаку та аромату.', 'Чанахи');
insert into recipes (complexity_id, cooking_time, cuisine_region_id, dish_type_id, image_url, portions, spiced, subtitle, dish_name)
values (2, 120, 2, 5, 'https://i.ibb.co/ssbJ1yT/image.jpg', 6, 1, 'Гарний варіант зупи - галицька зупа, яка має насичений смак завдяки домашньому бульйону та різноманітним інгредієнтам. Вона здатна зігріти у холодну пору року, а також надасть відчуття повноцінного обіду.', 'Зупа');
insert into recipes (complexity_id, cooking_time, cuisine_region_id, dish_type_id, image_url, portions, spiced, subtitle, dish_name)
values (3, 40, 2, 4, 'https://i.ibb.co/DzFWdDk/image.jpg', 6, 0, 'Львівський сирник - це смачна галицька випічка, яка має круглу форму, золотисту скоринку і м''яку начинку.Вона зроблена з творогу, яєць, манної крупи, цукру та вершків, і має неповторний смак та аромат.', 'Львівський сирник');

insert into recipes (complexity_id, cooking_time, cuisine_region_id, dish_type_id, image_url, portions, spiced, subtitle, dish_name)
values (3, 30, 5, 1, 'https://i.ibb.co/7p3d7Y5/image.jpg', 6, 0, 'Форшмак - це традиційна страва єврейської кухні, популярна в Одеському регіоні. Форшмак подається в прохолодному вигляді з чорним хлібом, і має незвичайний, але смачний смак, який відмінно поєднується зі свіжим хлібом.', 'Форшмак');
insert into recipes (complexity_id, cooking_time, cuisine_region_id, dish_type_id, image_url, portions, spiced, subtitle, dish_name)
values (1, 20, 5, 1, 'https://i.ibb.co/nf4rs47/image.jpg', 6, 0, 'Мідії по-одеськи - це одна з найвідоміших страв одеської кухні, яка здивує вас своєю смаковою насиченістю та ароматом. Це дуже простий рецепт, який з легкістю можна приготувати вдома.', 'Мідії по-Одеськи');
insert into recipes (complexity_id, cooking_time, cuisine_region_id, dish_type_id, image_url, portions, spiced, subtitle, dish_name)
values (3, 30, 5, 5, 'https://i.ibb.co/FxpvtLD/image.jpg', 6, 0, 'Рибна юшка - це смачна страва, приготована на основі риби, овочів та спецій. Її основний інгредієнт - свіжа риба. Це відмінний вибір для тих, хто любить рибні страви та шукає простий та смачний рецепт', 'Рибна юшка');
insert into recipes (complexity_id, cooking_time, cuisine_region_id, dish_type_id, image_url, portions, spiced, subtitle, dish_name)
values (3, 60, 5, 4, 'https://i.ibb.co/Y7sS2G8/image.jpg', 6, 0, 'Штрудель з яблуками це ніжні шари тоненької тіста, просочені маслом, заповнені солодкими яблуками, горіхами та спеціями.', 'Штрудель з яблуками');

