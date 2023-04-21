--liquibase formatted sql
--changeset <serge>:<add-data-table-recipes_instructions>
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (1, 'Картоплю чистимо й натираємо на дрібній терці. Я використовувала не колючу сторону терки. Цибулину й зубки часнику можна також натерти, а можна дуже дрібно накришити.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (1, 'Натерту картопляну масу злегка віджимаємо, щоб прибрати частину вологи. Ви можете або просто стискати масу в долонях, або перекласти натерту картоплю в сито, і притискаючи масу до сита, дати стекти волозі. Тільки дуже не захоплюйтеся, щоб кремзлики не були сухими.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (1, 'Далі перекладаємо картопляну масу в глибоку ємність, додаємо цибулю, часник, сметану, яйце, все перемішуємо до однорідності. Далі додаємо борошно, а також сіль і перець на смак і знову все перемішуємо до однорідності. Рекомендую дати масі постояти хвилин 10, потім перемішати й перейти до смаження. Розігріваємо пательню, наливаємо олію (смажитимемо на невеликому вогні). Робимо кремзлики. Маса виходить досить густа, тож я просто брала її столовою ложкою, перекладала на долоню, відтак робила кульку, а потім долонями розплескувала на круглу котлетку. Після цього рукою викладала кремзлик на пательню. Таким способом робила стільки кремзликів, скільки вміщує пательня.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (1, 'Смажити кремзлики треба з обох боків до золотавої скоринки. Але також важливо, щоб сира картопля встигла приготуватися, тому це не справа 1–2 хв. Кожну партію кремзликів я смажу на мінімальному вогні приблизно по 8–10 хв, час від часу перевертаючи, щоб і скоринка була, і серединка приготувалася. І щоб жодна зі сторін кремзлика не пригоріла.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (1, 'Так смажимо всі кремзлики (партіями). За потреби доливаємо олії. Готові кремзлики перекладаємо з пательні на тарілку, застелену паперовими рушниками, щоб прибрати зайвий жир.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (1, 'Подання кремзликів у мене вийшло ультрасучасним – на подушці з мікрогріну. Але взагалі кремзлики можна подавати просто зі сметаною . А ще я вичитала, що страва дуже смакує з грибною підливою.');

INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (2, 'В невелику кількість киплячої води (не більше літра) вкидаємо листя м\'яти, хай покипить 3-4 хвилини.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (2, 'Додаємо горошок і відварюємо його до м\'якості, але не до втрати кольору. Цей займе хвилин 5-10 активного булькання. Стоїмо над ним і куштуємо, як пом\'як - одразу вимкнули.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (2, 'Зцідили відвар в окремий посуд (він нам знадобиться), і горошок разом з олією протерли крізь сито або добре збили в блендері.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (2, ' Додали сіль, перець, відвар - і збили ще раз.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (2, 'Наливаємо в тарілки, збризкуємо оливковою олією, додаємо сметану і кілька листків свіжого базиліку. Ням.');

INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (3, 'В кружці з\'єднати меншу частинку борошна, теплу воду (350 мл) і дріжджі, дати їм постояти 10 хвилин');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (3, 'В мисці з\'єднати 2 чашки борошна, сіль, влити дріжджову суміш і замісити тісто. Якщо тісто виходить дуже сухим, додати трохи теплої води.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (3, 'Місити тісто, поки не стане гладким і еластичним. Накрити рушником, помістити в тепле місце і залишити підніматися.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (3, 'Тісто розділити на 2 рівних частини, і розкатати на кола. Покласти в деко з бортиками, змащене олією, накрити рушником, дати піднятися протягом 30 хвилин.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (3, 'На великій пательні на маленькому вогні на олії обсмажити всю нарізану кільцями цибулю протягом 30 хвилин, періодично помішуючи. Додати потовчений часник, оцет, добре присмачити перцем і сіллю. Дати начинці трохи вистигнути.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (3, 'Потім викласти її на тісто, розкласти філе риби, і половинки оливок. зверху накрити другим колом, защепити краї. Легенько змастити верхнє коло олією. Пекти в заздалегідь розігрітій печі на середньому вогні, доки не підрум’яниться.');

INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (4, 'Буряк відварюємо у 1 літрі води з 1 ч ложкою оцту до м\'якості (провіряємо вилкою, якщо протикається - готова)');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (4, 'Грецькі горіхи товчемо у ступці або січемо ножем.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (4, 'Чорнослив замочуємо в окріп на 10 хвилин, зціджуємо і подрібнюємо ножем або в комбайні, що дрібніше то краще. Він додає салату потрібної кислинки, тому мусить бути розподілений більш-менш рівномірно.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (4, 'Часник пропускаємо через часничницю, змішуємо з олією, сіллю і перцем. Настоюємо хвилин 5.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (4, 'Тим часом чистимо буряк і нарізаємо його на тонку соломку (або натираємо на тертці).');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (4, 'Змішуємо його з горіхами та чорносливом, заправляємо часничною олією і даємо салату трохи настоятися - хвилин 15.');

INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (5, 'Сметану або вершки залити у чавунний казан і довести до кипіння. При потребі розвести водою.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (5, 'Кукурудзяне борошно засипати тоненькою цівкою, помішуючи, в сметану й готувати на повільному вогні до загустіння (тістоподібної консистенції схожої на манну кашу). Банош в жодному разі не має бути такий густий, як токан.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (5, 'Тим часом порізати бекон чи сало на смужки і обсмажити на сковороді до шкварочок.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (5, 'Зменшити вогонь на мінімум, і розтирати дерев’яною ложкою, доки на поверхні не виступлять крапельки масла. Як заблистить, знімаємо з вогню. Цей етап дуже важливий, банош треба добре збити, аби сметана в чи вершки в ньому перетворилися на масло.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (5, 'Викласти на простору тарілку, до баноша бекон і покришену бринзу, не шкодуючи.Їсти банош гарячим. Дуже добре до нього пасують також малосольні огірочки.');

INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (6, 'Просіюємо борошно через сито. Половину просіяного борошна відсипаємо в ємність.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (6, 'В окріп додаємо сіль і рослинне масло, швидко перемішуємо. В половину борошна додаємо окріп і швидко замішуємо тісто ложкою.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (6, 'Потроху додаємо борошно і продовжуємо вимішувати тісто, але вже рукою. Перекладаємо тісто в харчовий пакет і залишаємо відпочити на 30 хвилин, а потім його дістаємо з пакету і приступаємо до ліпки вареників.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (6, 'Це заварне тісто цінують за відмінні робочі властивості, воно податливе, тонко розкочується, майже не сохне. Вона підійде для вареників з різними начинками, а особливо з ягодами і фруктами.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (6, 'Зараз приготуємо вареники з полуницею. Дрібні ягоди полуниці розрізати не потрібно.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (6, 'Тісто ділимо на дві частини. 1 частину тіста тонко розкочуємо і вирізаємо чашкою кружечки. На середину кружечка викладаємо трохи цукру і шматочок полуниці, а потім з''єднуємо краї тіста.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (6, 'Спочатку варимо вареники з однієї частини тіста, так як полуниця пускає сік і тісто може розбухнути і рватися під час варіння. Киплячу воду підсолюємо, мішаємо і викладаємо вареники. Чекаємо поки вода закипить і вареники спливуть. Варимо вареники ще 3 хвилини.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (6, 'Викладаємо вареники на блюдо. За бажанням їх можна полити розтопленим вершковим маслом.');

INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (7, 'На великій тертці натираємо очищену та вимиту середню моркву.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (7, 'Середніми кубиками нарізаємо 5-6 картоплин.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (7, 'У киплячу воду висипаємо моркву та картоплю. За смаком солимо та перемішуємо вміст каструлі. Накриваємо кришкою та варимо овочі.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (7, 'Тим часом гриби з цибулею обсмажуємо до напівготовності. Додаємо 20 г вершкового масла. Коли вершкове масло повністю розтопиться, всипати 1 ст. л. борошна. Добре перемішуємо вміст сковорідки.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (7, 'Потім до грибів виливаємо 1 скляну вершків 10 відсотків жирності. Залишаємо засмажку на вогні, щоб вона прокипіла. Десь 5 хвилин буде достатньо.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (7, 'Якщо картопля відварилася до готовності, тоді у каструлю висипаємо грибну засмажку. Добре перемішуємо вміст каструлі.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (7, 'Після закипання, ставимо потужність плити на мінімальне положення. Даємо супу трохи прокипіти. 5-10 хвилин буде достатньо.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (7, 'Каструлю накриваємо кришкою. Даємо грибному супу настоятися приблизно 15-20 хвилин. Після закінчення часу грибний суп можна подавати до столу.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (7, 'За бажанням суп можна посипати дрібно нарізаною зеленню. Також можна додати сухарики.');

INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (8, 'Всі інгредієнти повинні бути кімнатної температури! Дістаньте їх з холодильника принаймні за 2 години. Яйця (3 шт.) змішуємо з цукром до легкої і пишної яєчної маси.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (8, 'Перемішувати бажано не менше 5 хвилин.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (8, 'Влийте олію (1/2 склянки) і недовго перемішайте. Додайте натуральний йогурт (330 г, обов''язково кімнатної температури), пшеничне борошно (340 г), розпушувач (1 ч. л. без гірки).');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (8, 'Акуратно перемішайте ложкою або віночком, поки інгредієнти не з’єднаються.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (8, 'Вилийте тісто у форму розміром 18×30 см. Рівномірно розкладіть чорницю. Випікати приблизно 40-45 хвилин при 180 градусах (до так званої сухої палички).');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (8, 'Після випічки злегка посипати цукровою пудрою.');

INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (9, 'Болгарський перець добре вимити. Акуратно зрізати плодоніжку, прибрати все насіння і за бажанням перегородки. Знову добре вимити перці і просушити їх. Також можна використовувати і заморожений болгарський перець.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (9, 'У глибоку миску висипаємо 1 склянку рису. Декілька раз його промиваємо. Заливаємо рис окропом з розрахунком 1 стакан рису на 1,5 стакана води. Накриваємо тарілкою і відставляємо в сторону приблизно на 25 хвилин.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (9, '2-3 моркви добре миємо і очищаємо від шкірки. Далі її натираємо на крупній терці.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (9, 'Очищаємо і добре миємо 3-4 цибулини. Нарізаємо її середнім кубиком.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (9, 'На гарячу сковороду наливаємо олію. Висипаємо нарізану цибулю. Смажимо її на середньому вогні, при цьому періодично помішуючи протягом 2-3 хвилин. Коли цибуля стане м’якою і почне ставати золотистого кольору, тоді додаємо натерту моркву. Час від часу перемішуйте вміст сковорідки, щоб овочі рівномірно просмажилися. Смажимо до напівготовності.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (9, 'Рис вже ввібрав в себе всю воду. Якщо ж все-таки залишилася вода, тоді її зливаємо. Рис повинен бути напівготовим. У глибоку миску висипаємо підготовлений рис. Далі додаємо фарш. Ми використовували суміш свинячого і телячого фаршу. Також можна готувати, наприклад, тільки із фаршу свинини. Трохи перемішуємо рис з фаршем.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (9, 'У миску висипаємо цибулево-морквяну засмажку. Також трохи перемішуємо. Потім солимо. Перчимо. Тепер потрібно добре перемішати всі інгредієнти. Найкраще це робити рукою попередньо одівши кулінарну рукавичку.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (9, 'Тепер приготуємо соусну заливку. В сковорідку наливаємо олію. Обсмажуємо цибулю до золотистого кольору, час від часу перемішуючи її. Додаємо 1 склянку будь-якого кисло-солодкого соусу. Додаємо 3-4 ст. л. сметани. Добре перемішуємо нашу майбутню соусну заливку. Після закипання смажимо ще приблизно 2-3 хвилини, при цьому постійно помішуючи, щоб не пригоріло.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (9, 'Далі беремо очищені перці і начиняємо їх підготовленою начинкою. Заповнювати їх потрібно досить щільно. Стараємось начиняти їх так, щоб не залишалися пустоти.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (9, 'У каструлю з товстим дном викладаємо начинені фаршировані перці. Викладаємо їх досить щільно, щоб не залишалося пустот.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (9, 'Зверху заливаємо їх підготовленою соусною заливкою. За бажанням посолити. Також вливаємо воду, бажано окріп. Накриваємо кришкою. На великому вогні доводимо до кипіння.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (9, 'Далі прикручуємо вогонь на мінімальну потужність і тушкуємо перці під кришкою приблизно 40-50 хвилин. Після закінчення часу вимикаємо вогонь і залишаємо фаршировані перці настоюватися під кришкою приблизно 30-40 хвилин.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (9, 'Тепер можна приступити і до трапези. Фаршировані перці виходять неймовірно смачними, ароматними та ситними.');

INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (10, 'Щоб приготувати начинку, спочатку замочіть 200 г гороху у холодній воді на ніч. Вранці злийте воду, залийте нову і варіть до готовності на середньому вогні протягом 20-30 хвилин. Процідіть і потім пропустіть горох через мʼясорубку чи перебийте у блендері.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (10, 'Обсмажте на 1 ст. л. смальцю 2 дрібно порізані цибулини до золотавого кольору, додайте їх до гороху. Посоліть і додайте у масу дрібку цукру.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (10, 'Для тіста відваріть 5 середніх картоплин у мундирах, очистьте, пропустіть через мʼясорубку, додайте 2 яйця, 3 ст. л. борошна, посоліть. Замісіть тісто. Увімкніть духовку на 180 градусів.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (10, 'З тіста сформуйте коржики розміром з долоню, у кожен викладіть начинку з гороху і защипніть у формі човників, так, щоби середина пиріжка залишилась відкритою.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (10, 'Викладіть пиріжки на деко застелене пергаментом, можна змастити його смальцем за бажання. Потім змастіть картопляники зверху збитим яйцем. Випікайте картопляники у духовці протягом 50-60 хвилин.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (10, 'А тим часом приготуйте маштарку. Посічіть дрібно 2 цибулини, обсмажте їх на 1 ст. л. олії до золотавого кольору. Покладіть до макітри чи ступи 100 г ядер волоського горіха, 2 ст.л. насіння льону, 100 г насіння гарбуза, смажену цибулю, цукор, сіль, мелений перець та добре перетріть до однорідної маси. Додайте до неї 2 ст.л. сметани 20% і ще раз добре перемішайте.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (10, 'Дістаньте з духовки пиріжки з горохом, викладіть на миску. Подавайте їх гарячими, з соусом маштаркою.');

INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (11, 'Підготуйте малину. Візьміть 1 кг ягід та переберіть. Гнилі використовувати не можна, бо вони стануть причиною бродіння варення. Перекладіть малину в каструлю, засипте 500 г цукру та дайте постояти 20-30 хвилин, щоб ягода пустила сік. За бажанням, перебийте блендером.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (11, 'Поставте каструлю на середній вогонь і доведіть до кипіння, періодично помішуючи ложкою. Варіть варення 5-10 хвилин після закипання. Воно може збігати, тому радимо обрати велику каструлю. Банки стерилізуйте зручним для вас способом. Важливо, щоб вони були готові до використання одночасно з варенням.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (11, 'Виріжте філе апельсина, нам знадобиться 100 г. Поріжте його на середні шматочки та додайте до малини. Натріть на дрібній тертці цедру половини апельсина, не зачіпляючи білу частину та додайте теж до каструлі. Також цедру за бажанням можна не терти, а акуратно зрізати та подрібнити.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (11, 'Слідом за цедрою влийте 30 мл бальзамічного оцту. Варіть варення ще 5 хвилин. У процесі на поверхні суміші буде з’являтися піна. Її потрібно прибрати ложкою.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (11, 'Розкладіть варення по стерильним банкам і закрийте кришками. Залиште остигати за кімнатної температури, а потім зберігайте в прохолодному місці до року.');

INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (12, 'Наріжте свинину на невеликі шматочки та обсмажте на розігрітій олії до золотистого кольору.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (12, 'Додайте нарізану цибулю та моркву та смажте ще 5-7 хвилин.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (12, 'Додайте томатну пасту та квашену капусту та змішайте добре. Додайте води так, щоб вона закрила всі інгредієнти.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (12, 'Доведіть до кипіння та зменшіть вогонь. Готуйте на маленькому вогні протягом 1 години, періодично помішуючи.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (12, 'Під час готування додавайте сіль, перець.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (12, 'Після того, як капуста та м’ясо добре проготуються, заберіть з вогню та насолоджуйтеся традиційною стравою Волині!');

INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (13, 'Видаліть кісточки з вишень і наріжте їх на шматочки.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (13, 'В каструлю додайте воду, цукор та ванільний екстракт. Доведіть до кипіння, потім додайте вишні і готуйте на помірному вогні протягом 10-15 хвилин.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (13, 'Розбавте крохмаль у 2 столових ложках води, додайте до супу та перемішайте. Готуйте ще 2-3 хвилини, доки суп не загустіє.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (13, 'Відстудіть суп у холодильнику.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (13, 'Додайте сметану і перемішайте.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (13, 'Подавайте десерт у чашках зі свіжою м''ятою для прикраси.');

INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (14, 'Промийте добре всі овочі. Після цього наріжте капусту.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (14, 'Цибулю нарізати кубиками, моркву натерти на тертці. Обсмажити на розпеченій олії до м''якості.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (14, 'Додати до овочів сіль. Викласти на сковороду до цибулі і моркви капусту.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (14, 'Влити в сковороду до овочів теплу воду. Необхідно тушкувати овочі близько 20 хвилин під закритою кришкою, періодично помішуючи.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (14, 'Свинину нарізати на шматочки. Після цього відбити кожен шматочок по черзі. Змастити кожен шматочок відбитого м\'яса спеціями.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (14, 'На кожен шматочок відбитого м\'яса викласти тушковані овочі.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (14, 'Перев\'язати м\'ясні рулети лляною ниткою, щоб вони не розпадалися. Після цього обсмажити на сковороді до золотавої скоринки. Коли рулети зарум\'яняться, необхідно обережно зняти нитки, після чого додати в сковороду сметану і півсклянки води. Тушкувати вміст сковороди близько 30 хвилин на мінімальному вогні.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (14, 'Подавати волинські крученики гарячими або теплими, з картоплею, крупами або макаронними виробами!');

INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (15, 'Почистіть картоплю, наріжте на кубики та варіть до готовності. Потім слід розтерти картоплю в пюре, додати сіль та перець.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (15, 'На сковороді розігріти олію та обсмажити на ній нарізану цибулю та часник доки вони стануть м\'якими.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (15, 'Додайте у сковороду томатну пасту та воду. Доведіть до кипіння та зменшіть вогонь. Готуйте на середньому вогні приблизно 5 хвилин.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (15, 'Покладіть приготовлену картоплю на листок капусти та скрутіть його, немов рулет. Зробіть так із усіма листками (10-12 шт).');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (15, 'Покладіть скручені голубці в каструлю, залийте їх томатним соусом та додайте трішки води.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (15, 'Готуйте на середньому вогні приблизно 30-40 хвилин, доки голубці не стануть м''якими та соковитими.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (15, 'Подаємо на стіл гарячими, можна додати зелень та сметану за смаком.');

INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (16, 'Наріжте свинину на невеликі кусочки і обсмажте в олії до золотистого кольору.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (16, 'Додайте нарізану цибулю і обсмажте до м\'якості.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (16, 'Додайте томатну пасту і готуйте ще 1-2 хвилини.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (16, 'Додайте нарізані огірки, сіль, перець, цукор, оцет та воду. Перемішайте і доведіть до кипіння.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (16, 'Зменшіть вогонь і готуйте огірочник на помірному вогні протягом 30-40 хвилин.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (16, 'Подавайте огірочник гарячим або холодним, прикрасивши зеленню.');

INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (17, 'Промийте пшоно у холодній воді.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (17, 'Додайте 2 склянки води до каструлі та доведіть до кипіння.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (17, 'Додайте пшоно до води та дайте відваритися на середньому вогні протягом 10-15 хвилин.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (17, 'Після цього зменште вогонь, прикрийте каструлю кришкою та дайте каші протушкуватися на слабкому вогні ще 10-15 хвилин, поки вона не стане м\'якою та готовою.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (17, 'Поки каша вариться, очистіть та наріжте моркву, цибулину та перець на кубики.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (17, 'Розігрійте олію на сковороді та обсмажте овочі на середньому вогні до м\'якості та золотистого кольору.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (17, 'Додайте обсмажені овочі до каші, приправте сіллю та перцем за смаком та дайте всьому прогрітися разом ще 5-10 хвилин.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (17, 'Після цього готову пшоняну кашу з овочами можна подавати до столу. Смачного!');

INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (18, 'Наріжте м\'ясо на кубики і покладіть у казан або каструлю з водою. Додайте сіль та чорний перець за смаком та варіть на середньому вогні протягом 1-2 годин, доки м\'ясо не буде м\'яким.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (18, 'Покладіть муку в миску, зробіть у неї улоговину і вбийте яйця в середину. Додайте сіль та воду, потім замішайте тісто на стілі протягом 10-15 хвилин.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (18, 'Покладіть тісто в пластиковий пакет та залиште його на 30 хвилин, щоб воно відпочило.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (18, 'Для підсмаження овочів, наріжте цибулю на кільця, моркву на кубики та картоплину на круги. Покладіть олію в сковороду та обсмажте овочі на середньому вогні до золотистого кольору.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (18, 'Після відпочинку тісто розкатайте на столі на товщину близько 2-3 мм та виріжте на смужки завширшки близько 2 см. Кожну смужку наріжте на кусочки довжиною близько 5-7 см.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (18, 'Додайте нарізані кусочки тіста в киплячий бульйон та варіть на середньому вогні протягом 5-7 хвилин.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (18, 'Покладіть овочі у казан разом з м\'ясом та зберіть весь бульйон.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (18, 'Подавайте бешбармак зі свіжою зеленню.');

INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (19, 'Розірвіть м\'ясо на невеликі кусочки та піджарте його на розігрітій олії до золотистого кольору.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (19, 'Додайте нарізану цибулю, моркву, селеру та картоплю до м\'яса та смажте доки овочі стануть м\'якими.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (19, 'Додайте томатну пасту, помідори, зілля тим\'яну та розмарину та продовжуйте смажити ще 5-7 хвилин.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (19, 'Додайте воду та доведіть до кипіння. Зменшіть вогонь та додайте рис та нарізаний часник.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (19, 'Доведіть до готовності на середньому вогні протягом близько 30-40 хвилин.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (19, 'Спробуйте та додайте сіль та перець за смаком.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (19, 'Подаємо гарячим зі свіжою зеленню та хлібом.');

INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (20, 'У каструлю на середньому вогні розігріти олію. Додати цибулю, моркву, перець чилі і часник. Обсмажити 3-4 хвилини до м\'якості овочів.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (20, 'Додати нарізану яловичину (або баранину) і обсмажити, поки вона не змінить колір. Додати томатну пасту, куркуму, кмин і сіль, перемішати.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (20, 'Додати м\'ясний бульйон і довести до кипіння. Зменшити вогонь і варити на малому вогні протягом 30-40 хвилин, поки м\'ясо не стане м\'яким.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (20, 'У другій каструлі окропити макаронні вироби до готовності за інструкцією на упаковці.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (20, 'Подавати лагман, кладучи в глибоку тарілку варені макарони, на них - м\'ясний соус з овочами. Прикрасити свіжою зеленню.');

INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (21, 'Наріжте яловичину невеликими шматочками і підсмажте в глибокій каструлі на середньому вогні до золотистого кольору.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (21, 'Додайте дрібно нарізану цибулю, моркву, картоплю та перець чилі, посоліть і поперчіть за смаком.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (21, 'Додайте томатну пасту, паприку та нарізаний часник і смажте все разом протягом 1-2 хвилин.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (21, 'Додайте гарячу воду до каструлі і доведіть до кипіння.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (21, 'Зменшіть вогонь і варіть шурпу під кришкою протягом близько 1 години, додавши сіль та перець за смаком.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (21, 'Готову шурпу подавайте з нарізаною зеленню, свіжим хлібом або нарізаними вершками.');

INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (22, 'Просійте борошно в миску і зробіть в ньому ямку.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (22, 'У іншій мисці розітріть яйце з медом до однорідної маси.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (22, 'Додайте до яєчної маси олію і воду. Ретельно перемішати.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (22, 'Додайте соду до миски з борошном і добре перемішайте.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (22, 'Додайте яєчно-медову суміш до миски з борошном і змішайте до однорідної м\'якої тісто.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (22, 'Розділіть тісто на декілька частин і розкатайте їх на товщину близько 0,5 см.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (22, 'Наріжте тісто на невеликі шматочки ромбовидної форми.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (22, 'Розігрійте олію у глибокій сковороді або казані і обсмажте шматочки тіста з обох боків до золотисто-коричневого кольору.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (22, 'Підніміть шматочки чак-чаку з олії за допомогою дерев\'яного шампура або шумовки і покладіть на дренажний папір, щоб зняти надмірну олію.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (22, 'Приготуйте сироп, змішавши 150 мл води з цукром і довести до кипіння.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (22, 'Облийте сиропом шматочки чак-чаку і дайте їм трохи охолонути.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (22, 'Подаємо гарячим або холодним з чаєм.');

INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (23, 'Приготуйте тісто. Для цього змішайте муку, яйце, сіль і воду в мисці та замісіть м\'яке тісто. Покрийте його і залиште на 30 хвилин.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (23, 'Приготуйте начинку. Очистіть картоплю, наріжте на дрібні кубики та варіть в легко солоній воді до м\'якості. Додайте дрібно нарізану цибулю, сіль та перець, обсмажити у сковороді з олією до золотистої корочки.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (23, 'Розігрійте олію в глибокій сковороді.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (23, 'Розділіть тісто на 12-15 рівних частин.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (23, 'Розкатайте кожен шматочок тіста в коло товщиною близько 2 мм. На половину круга розкладіть приготовлену картопляну начинку.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (23, 'Згорніть круг, щоб отримати півмісяць, і затягніть краї, щоб утворити сомсу.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (23, 'Посипте стіл мукою та розкатайте сомсу до товщини близько 1 см.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (23, 'Обсмажте сомсу на розігрітій олії з обох сторін до золотистого кольору.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (23, 'Подайте гарячими зі свіжими овочами або сметаною.');

INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (24, 'Запечіть буряк в духовці, попередньо його завивши у фольгу із додаванням невеличкої гілочки чебрецю, оливкової олії, солі і перцю. Або відваріть у воді до готовності. Обирайте для страви невеликі буряки.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (24, 'Охолодіть готовий буряк, зніміть з нього шкірку та натріть на дрібній тертці.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (24, 'Почистьте корінь хрону та натріть його на дрібній тертці. Пропорції буряків і хрону давайте на смак, щоб не був дуже гострим.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (24, 'Заправте цвіклі яблучним оцтом або лимонним соком, цукром, сіллю і перцем. Перемішайте бурячки з хроном та спеціями. Зберігайте у скляній банці, щільно закритій кришкою, щоб хрін не втратив свою гостроту.');

INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (25, 'Приготуйте тісто. Для цього змішайте муку, яйця, олію, оцет та сіль в гладке тісто. Заверніть тісто в плівку та залиште на 30 хвилин, щоб воно настоялося.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (25, 'Розкатайте тісто на тонкі шматочки та наріжте на невеликі кусочки.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (25, 'Вилийте м\'ясний бульйон у каструлю та доведіть до кипіння. Додайте томатний соус та дайте постояти на середньому вогні, поки змішаються смаки.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (25, 'Додайте нарізаний лук та часник до соусу, дайте їм протушкуватися.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (25, 'Додайте до соусу кусочки тіста та готуйте на середньому вогні до готовності (близько 10 хвилин).');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (25, 'Подайте журек гарячим, прикрасивши зеленню.');

INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (26, 'Нарізати баранину або телятину на кубики. Підсмажити на олії в казанку до золотистої корочки. Додати нарізану цибулю та смажити до золотистого кольору.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (26, 'Додати нарізані картоплину, моркву та перець. Підсмажити 5-7 хвилин.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (26, 'Додати томатну пасту та смажити ще 1-2 хвилини.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (26, 'Додати воду та довести до кипіння. Додати сіль та перець за смаком. Зменшити вогонь та варити 20 хвилин.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (26, 'Додати галушки та готувати ще 10 хвилин до м''якості галушок.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (26, 'Подавати гарячим зі свіжою зеленню.');

INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (27, 'Наріжте м''ясо на кубики і зваріть у 2 літрах води до готовності (приблизно 1-1,5 години).');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (27, 'Наріжте капусту, моркву, картоплю та цибулю. Додайте їх до зупи та варіть ще 20-30 хвилин.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (27, 'Додайте томатну пасту та збиті вершки у зупу та доведіть до кипіння.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (27, 'Після цього додайте нарізаний часник, сіль та перець за смаком.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (27, 'Подавайте гарячо зі свіжою зеленню.');

INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (28, 'Вибити яйця з цукром та сіллю до білого кольору.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (28, 'Додати манну крупу та крохмаль, добре перемішати.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (28, 'Додати творог та розтерти його з яєчною сумішшю.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (28, 'Додати вершкове масло та соду. Знову добре перемішати.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (28, 'Залишити на 20-30 хвилин.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (28, 'Скласти у сирник і обсипати борошном.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (28, 'Смажити на розігрітій сковороді на помірному вогні до золотистого кольору з обох боків.');

INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (29, 'Селедку відчистити від шкіри і кісток та нарізати на дрібні кубики.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (29, 'Цибулю нарізати дрібними кубиками.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (29, 'Яблука зібрати із шкіркою, видалити середину та нарізати на дрібні кубики.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (29, 'Варені картоплини також нарізати на кубики.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (29, 'На розігрітій сковороді розігріти рослинне масло і обсмажити цибулю до золотистого кольору.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (29, 'Додати до цибулі яблука та картоплю і продовжувати смажити ще кілька хвилин.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (29, 'Додати селедку, оцет та цукор і змішати все докупи.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (29, 'Дати страві підігрітися на сковороді протягом 5-7 хвилин, періодично помішуючи.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (29, 'Додати сіль та перець за смаком.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (29, 'Подавати форшмак в прохолодному вигляді з чорним хлібом.');

INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (30, 'Добре промийте мідії в холодній воді та викиньте ті, які відкрилися. Залиште їх у воді на кілька хвилин.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (30, 'На середньому вогні розігрійте олію в глибокій сковороді або каструлі та додайте порізану цибулю та часник. Смажте, поки овочі стануть м''якими та золотистими.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (30, 'Додайте томатну пасту та перемішайте.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (30, 'Додайте мідії та вилийте вино. Посипте свіжою петрушкою, сіллю та перцем.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (30, 'Покрийте сковороду або каструлю кришкою та готуйте на середньому вогні протягом 5-7 хвилин, доки мідії повністю не відкриються. Викиньте ті, які залишилися закритими.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (30, 'Подаємо гарячим із свіжою петрушкою та хлібом.');

INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (31, 'Почистіть і наріжте цибулю та часник.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (31, 'Наріжте моркву та картоплю на кубики.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (31, 'В глибокій каструлі розігрійте олію та обсмажте цибулю та часник до золотистого кольору.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (31, 'Додайте нарізану моркву та картоплю та обсмажте кілька хвилин.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (31, 'Додайте томатну пасту та продовжуйте смажити ще 1-2 хвилини.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (31, 'Додайте куркуму, гарячий перець та лаврові листки.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (31, 'Додайте рибу та воду, залиште на вогні протягом 15-20 хвилин до готовності риби.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (31, 'Додайте сіль за смаком та зелень петрушки для прикрашання.');

INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (32, 'Почистіть яблука, видаліть серцевину та наріжте їх на кубики. Полийте їх соком лимона, щоб уникнути пожовклості.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (32, 'В сумішці цукру, кориці та мускатного горіха перемішайте нарізані яблука та крупку хлібної крихти.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (32, 'Розігрійте духовку до 190°C. Розтопіть вершкове масло в мікрохвильовці або на плиті.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (32, 'Розгорніть один аркуш філо тіста та посипте його цукром і розтопленим маслом. Повторіть з кожним аркушем філо тіста.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (32, 'На останньому аркуші рівномірно розподіліть суміш яблук та крупки по центру тіста, залишаючи приблизно 5 см з обох боків.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (32, 'Зберіть боки тіста, щоб вони перекрили частину суміші з яблуками. Почніть скручувати тісто в густий рулон, прибираючи до середини яблучну начинку.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (32, 'Розташуйте штрудель на покриту пальмирою або папером для пічного листа. Поставте його в духовку на 35-40 хвилин, поки тісто не стане золотистим.');
INSERT INTO recipe_instructions (`recipe_id`, instructions) VALUES (32, 'Подавайте теплим зі збитим вершком або ванільним морозивом.');


